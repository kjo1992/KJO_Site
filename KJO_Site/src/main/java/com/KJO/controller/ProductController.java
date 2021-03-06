package com.KJO.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.KJO.model.Criteria;
import com.KJO.model.LoginVO;
import com.KJO.model.PageVO;
import com.KJO.model.ProductBoardVO;
import com.KJO.model.productReplyVO;
import com.KJO.service.ProductService;
import com.KJO.utils.CheckUtils;
import com.KJO.utils.FileUploadUtils;

@Controller
@RequestMapping("/Product")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService PS;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	private FileUploadUtils FileUpload = new FileUploadUtils();
	private CheckUtils chk = new CheckUtils();
	
	//상품목록 메인페이지
	@RequestMapping(value="Main", method=RequestMethod.GET)
	public void ProductMainPage(Model model, @RequestParam String typeNum, Criteria cri) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		logger.info("Product Main type : "+typeNum);
		map.put("typeNum", typeNum);
		
		//테이블을 불러오기 위한 제품 타입명을 가져오고 맵에 저장
		map.put("typeName", PS.proudctTypeName(typeNum));
		model.addAttribute("typeNum", typeNum);
		
		//페이징처리
		cri.setAmount(5); //페이지당 나타낼수 있는 갯수
		map.put("Cri", cri);
		int total = PS.ProductCount(typeNum);		
		PageVO PV = new PageVO(cri, total);
		model.addAttribute("Page", PV);
		
		
		logger.info("input map : "+map);
		
		model.addAttribute("ProductList", PS.ProductListMain(map));
		
		logger.info("MainPage model : "+model);
	}
	
	//상품목록 추가 페이지 이동
	@RequestMapping(value="AddProduct", method=RequestMethod.GET)
	public void AddProductPage(Model model) throws Exception {
		logger.info("AddProduct Page...");
		model.addAttribute("ProductTypeList", PS.ProductTypeList());
	}
	
	//상품목록, 상품이미지, 상세 스펙 추가
	@RequestMapping(value="AddProduct/Add", method=RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String AddProduct(MultipartHttpServletRequest file
			, @RequestParam Map<String,Object> map) throws Exception{
		List<MultipartFile> fileList = file.getFiles("productImg");
		logger.info("Add Product : "+map);
		logger.info("filesize : "+fileList.size());
					
		// 이미지 파일 유효성 검사
		boolean fileChk = false;	
		// 이미지 파일 갯수 확인
		if(fileList.size() > 4) {
			logger.info("file amount over");
		} else {
			for(MultipartFile upload : fileList) {
				int typeIndex = upload.getContentType().lastIndexOf("/");
				String fileType = upload.getContentType().substring(typeIndex+1);
				String checkType = "^(?!)(jpg)|(jpeg)|(png)|(bmp)$";
				
				// 파일 최대 업로드 용량(2mb)
				int maxSize = 1024*1024*2;
				if(!(fileType.matches(checkType))) {
					logger.info(upload.getOriginalFilename()+" file type dismatch");
					fileChk = false;
				} else {
					if(upload.getSize() > maxSize) {
						logger.info(upload.getOriginalFilename()+" file size over");
						fileChk = false;
					} else {
						fileChk = true;
					}//if size
				}//if type
			}//for
		}//if amount
		
		// 이미지 파일 업로드
		if(fileChk) {
			int forIndex = 0;
			for(MultipartFile upload : fileList) {
				int typeIndex = upload.getContentType().lastIndexOf("/");
				String fileType = upload.getContentType().substring(typeIndex+1);
				String productName = (String) map.get("productName");
				byte[] fileData = upload.getBytes();
				
				//loginNum 대신에 ProductName으로 대체
				String filePath = FileUpload.imgUpload(fileType, fileData, uploadPath+"Product\\", productName);
				logger.info("productImgPath_"+forIndex+" : "+filePath);
				map.put("productImgPath_"+forIndex, filePath);
				forIndex++;
			}
			//form 입력값을 map으로 전달
			PS.productBoardWrite(map);
		}
		
		logger.info("map : "+map);
		
		return "redirect:/Main/HomePage";
	}
	
	//모듈화된 input창 불러오는 Ajax
	@ResponseBody
	@RequestMapping(value="inputData/{productType}", method=RequestMethod.GET)
	public ModelAndView inputData(@PathVariable("productType") String productType)  throws Exception {
		logger.info("inputData..");
		logger.info("productType : "+productType);
		ModelAndView mv = new ModelAndView("/Product/inputData/"+productType);
		logger.info("mv : "+mv);
		return mv;
	}
	
	//상품 상세보기
	@RequestMapping(value="Detail", method=RequestMethod.GET)
	public ModelAndView productDetail(@RequestParam String typeNum, @RequestParam String productName
			, @RequestParam int productListNum, Criteria cri) throws Exception {
		logger.info("product Detail type : "+typeNum);

		String typeName = PS.proudctTypeName(typeNum);
		String loadPage = typeName+".jsp";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("typeName", typeName);
		map.put("productName", productName);
		logger.info("product Detail data map : "+map);
		
		/* ModelAndView mv = new ModelAndView("/Product/detail/"+typeName); */
		ModelAndView mv = new ModelAndView("/Product/detail/DetailMain");
		/* mv.setViewName("/Product/detail/"+typeName); */
		mv.addObject("productDetail", PS.productDetail(map));
		mv.addObject("loadPage", loadPage); // /contextPath/WEB-INF/views/Product/detail/typeName.jsp
		
		//별점
		Map<Integer, String> ratingOptions = new HashMap<Integer, String>();
		ratingOptions.put(0, "☆☆☆☆☆");
		ratingOptions.put(1, "★☆☆☆☆");
		ratingOptions.put(2, "★★☆☆☆");
		ratingOptions.put(3, "★★★☆☆");
		ratingOptions.put(4, "★★★★☆");
		ratingOptions.put(5, "★★★★★");
		mv.addObject("ratingOptions", ratingOptions);
		
		//상품 댓글(페이징처리)
		/* Criteria cri = new Criteria(1, 5); */
		cri.setAmount(5);
		
		int replyCount = PS.replyCount(productListNum);
		PageVO PV = new PageVO(cri, replyCount);
		
		Map<String, Object> criMap = new HashMap<String, Object>();
		criMap.put("productListNum", productListNum);
		criMap.put("Cri", cri);
		
		mv.addObject("productReply", PS.productReplyGet(criMap));
		mv.addObject("replyPage", PV);
		mv.addObject("Page", PV);
		
		logger.info("ModelAndView : "+mv);
		
		return mv;
	}
	
	//상품평 추가
	@RequestMapping(value="addReply", method=RequestMethod.POST)
	public String addProductReply(HttpServletRequest request, HttpServletResponse response
			, productReplyVO PRV
			, @RequestParam String typeNum, @RequestParam String productName
			, @RequestParam int productListNum) throws Exception{
		productName = URLEncoder.encode(productName, "UTF-8");
		String target = "/Product/Detail?typeNum="+typeNum+"&productName="+productName+"&productListNum="+productListNum;
		
		if(PRV.getReplyText() != null) {
			HttpSession session = request.getSession();
			LoginVO LoginUser = (LoginVO)session.getAttribute("LoginUser");
			if(LoginUser != null) {
				PRV.setUserNum(LoginUser.getUserNum());
				
				/* int result = PS.productReplyChk(PRV); */
				/* logger.info("replyChk : "+result); */
				if(PS.productReplyChk(PRV) == 0) {
					logger.info("addReply : "+PRV);
					PS.addProductReply(PRV);
					return "redirect:Detail?typeNum="+typeNum+"&productName="+productName+"&productListNum="+productListNum;
				} else {
					chk.redirectPage(request, response, "상품평은 2개 이상 작성이 불가합니다.", target);
				}//addReply
			} else {
				chk.redirectPage(request, response, "로그인이 필요합니다.", target);
			}
		} else {
			chk.redirectPage(request, response, "상품평이 없습니다.", target);
		}
		return null;
	}
	
	//상품평 삭제
	@RequestMapping(value="deleteReply", method=RequestMethod.POST)
	public String deleteReply(HttpServletRequest request, HttpServletResponse response
			, productReplyVO PRV
			, @RequestParam int productListNum
			, @RequestParam String userNum
			, @RequestParam String typeNum, @RequestParam String productName) throws Exception {
		logger.info("deleteReply : "+PRV);
		productName = URLEncoder.encode(productName, "UTF-8");
		
		HttpSession session = request.getSession();
		LoginVO LoginUser = (LoginVO)session.getAttribute("LoginUser");
		
		if(LoginUser.getUserNum().equals(userNum)) {
			PS.deleteReply(PRV);
			return "redirect:Detail?typeNum="+typeNum+"&productName="+productName+"&productListNum="+productListNum;
		} else {
			chk.redirectMain(request, response, "일치하지 않는 정보입니다.");
		}
		
		return null;
	}
}
