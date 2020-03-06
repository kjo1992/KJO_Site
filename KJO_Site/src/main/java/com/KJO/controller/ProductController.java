package com.KJO.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.KJO.model.PageVO;
import com.KJO.model.ProductBoardVO;
import com.KJO.service.ProductService;
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
	
	//상품목록 메인페이지
	@RequestMapping(value="Main", method=RequestMethod.GET)
	public void ProductMainPage(Model model, Map<String, Object> map
			, @RequestParam String typeNum) throws Exception {
		logger.info("Product Main type : "+typeNum);
		
		//테이블을 불러오기 위한 제품 타입명을 가져오고 맵에 저장
		map.put("productType", PS.proudctTypeName(typeNum));

		Criteria cri = new Criteria(1, 5);
		map.put("Cri", cri);
		
		logger.info("input map : "+map);
		
//		int total = PS.ProductCount(typeNum);
//		logger.info("typeNum count : "+total);
//		PageVO PV = new PageVO(cri, total);
		
		model.addAttribute("ProductList", PS.ProductListMain(map));
		
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
		
		//form 입력값을 map으로 전달, 테스트동안 주석처리
//		PS.productBoardWrite(map);
		
		return "redirect:/Product/Main";
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
	
}
