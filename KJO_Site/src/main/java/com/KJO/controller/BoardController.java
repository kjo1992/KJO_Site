package com.KJO.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.KJO.model.Criteria;
import com.KJO.model.FreeBoardReplyVO;
import com.KJO.model.FreeBoardVO;
import com.KJO.model.LoginVO;
import com.KJO.model.PageVO;
import com.KJO.service.FreeBoardService;
import com.KJO.utils.CheckUtils;
import com.KJO.utils.FileUploadUtils;
import com.google.gson.JsonObject;

//자유게시판 글쓰기, 조회, 수정, 삭제 처리 컨트롤러
@Controller
@RequestMapping("/FreeBoard")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private FreeBoardService BS;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	CheckUtils check = new CheckUtils();
	FileUploadUtils FileUpload = new FileUploadUtils();
	
	//자유게시판 글쓰기 버튼 이동
	@RequestMapping(value="WritePage", method=RequestMethod.GET)
	public void FreeBoardWriteGet() throws Exception {
		logger.info("WritePage Connect");
	}
	
	//자유게시판 글 작성
	@RequestMapping(value="Write", method=RequestMethod.POST)
	public String FreeBoardWritePOST(FreeBoardVO FBV) throws Exception{
		logger.info("FreeBoardWrite : "+FBV);
		BS.FreeBoardWrite(FBV);
		return "redirect:List";
	}
	
	//자유게시판 목록 페이징처리
	@RequestMapping(value="List", method=RequestMethod.GET)
	public String FreeBoardListGet(Model model, Criteria cri) throws Exception {
		logger.info("ListPaging");
		/* cri.setAmount(2); */
		int total = BS.FreeBoardCount(cri);
		PageVO PV = new PageVO(cri, total);
		
		model.addAttribute("BoardList", BS.FreeBoardListPaging(cri));
		model.addAttribute("Page", PV);
		return "FreeBoard/Main";
	}
	
	//자유게시판 글 상세 내용 확인
	@RequestMapping(value="DetailPage", method=RequestMethod.GET)
	public String FreeBoardDetail(Model model, @RequestParam int bnum) throws Exception {
		logger.info("DetailPage Connect");
		
		model.addAttribute("FBDetail", BS.FreeBoardDetail(bnum));
		//자유게시판 게시글 댓글 확인
		model.addAttribute("FBReply", BS.FreeBoardReplyList(bnum));
		
		return "FreeBoard/DetailPage";
	}
	
	//자유게시판 글 수정-페이지이동(url로 접근시 다른 id로 수정이 가능하기에 POST로 실행)
	@RequestMapping(value="UpdatePage", method=RequestMethod.POST)
	public String FreeBoardUpdateGet(HttpServletRequest request, HttpServletResponse response, Model model
			, @RequestParam String unum, @RequestParam int bnum, @ModelAttribute("FBDetail") FreeBoardVO FBDetail) throws Exception {
		logger.info("FreeBoard UpdatePage Get");
		logger.info("FreeBoard Model : "+model);
		logger.info("FreeBoardVO : "+FBDetail);
		logger.info("unum : "+unum);
		logger.info("bnum : "+bnum);
		//System.out.println("parameter : " + request.getParameter("replyerNum"));
		
		if(check.UserMappingCheck(request, response, unum)) {
			model.addAttribute("FBDetail", BS.FreeBoardDetail(bnum));
			return "FreeBoard/UpdatePage";
		} else {
			return null;
		}
		
	}
	
	//자유게시판 글 수정-내용변경
	@RequestMapping(value="Update", method=RequestMethod.POST)
	public String FreeBoardUpdatePost(HttpServletRequest request, HttpServletResponse response, FreeBoardVO FBV) throws Exception {
		logger.info("FreeBoard Update Set"+FBV);
		
		if(check.UserMappingCheck(request, response, FBV.getWriterNum())) {
			BS.FreeBoardUpdate(FBV);
			return "redirect:DetailPage?bnum="+FBV.getBoardNum();
		} else {
			return "redirect:List";
		}
	}
	
	//자유게시판 글 삭제
	@RequestMapping(value="Delete", method=RequestMethod.POST)
	public String FreeBoardDelete(HttpServletRequest request, HttpServletResponse response, @RequestParam String unum
			, @RequestParam int bnum) throws Exception {
		logger.info("FreeBoard Delete GET");
		// 글 작성자와 로그인한 사람이 같은지 체크
		if(check.UserMappingCheck(request, response, unum)) {
			BS.FreeBoardDelete(bnum);
			return "redirect:List";
		} else { // false시 이전페이지로
			return null;
		}
	}
	
	//자유게시판 댓글 작성
	@RequestMapping(value="WriteReply", method=RequestMethod.GET)
	public String FreeBoardWriteReply(FreeBoardReplyVO FBReply) throws Exception {
		logger.info("FreeBoard Write Reply"+FBReply);
		BS.FreeBoardReplyWrite(FBReply);
		return "redirect:DetailPage?bnum="+FBReply.getBoardNum();
	}
	
	//자유게시판 댓글 삭제
	@RequestMapping(value="DeleteReply", method=RequestMethod.GET)
	public String FreeBoardDeleteReply(HttpServletRequest request, HttpServletResponse response, @RequestParam String unum
			,@RequestParam int rnum, @RequestParam int bnum) throws Exception {
		logger.info("FreeBoard Delete Reply");
		// 댓글 작성자와 로그인한 사람이 같은지 체크
		if(check.UserMappingCheck(request, response, unum)) {
			BS.FreeBoardDeleteReply(rnum);
			return "redirect:DetailPage?bnum="+bnum;
		}else { // false시 이전페이지로
			return null;
		}
		
	}
	
	//자유게시판 이미지 업로드(ckeditor)
	@ResponseBody
	@RequestMapping(value="ImgUpload", method=RequestMethod.POST)
	public void ImageUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload) throws Exception{
		logger.info("ImgUpload");
		OutputStream out = null;
        PrintWriter printWriter = null;
        
        // 한글 깨짐을 방지하기 위한 문자 셋 설정
        response.setCharacterEncoding("utf-8");
        // 파라미터로 전달되는 response 객체의 한글 설정
        response.setContentType("text/html;charset=utf-8");
        
        // 세션에 저장된 로그인ID 값 불러오기
    	HttpSession session = request.getSession();
    	LoginVO LoginID = (LoginVO)session.getAttribute("LoginUser");
    	String LoginNum = LoginID.getUserNum();
        
    	// 업로드된 이미지 정보
        int typeIndex = upload.getContentType().lastIndexOf("/"); //확장자(/**)
		String fileType = upload.getContentType().substring(typeIndex+1); //확장자 최종
		byte[] fileData = upload.getBytes();
		String checkType = "^(?!)(jpg)|(jpeg)|(png)|(bmp)|(gif)$"; //정규표현식으로 업로드 파일 제한
		int maxSize = 1024*1024*10; // 최대 업로드 제한 10mb
		
		logger.info("fileOriginalName : "+upload.getOriginalFilename());
		logger.info("fileType : "+fileType);
		logger.info("fileSize : "+upload.getSize());
        
        try{
        	// 업로드 파일 확장자 확인
        	if (fileType.matches(checkType)) {
        		logger.info("Type matches");
        		// 업로드 파일 크기 확인
        		if(upload.getSize() < maxSize) {
        			//업로드된 이미지저장을 위한 매개변수 전달 및 저장된 경로, 파일이름 리턴값 저장
//                	String savedFile = FileUpload.uploadFile(uploadPath+"FB\\", LoginID.getUserNum(), fileType, upload.getBytes());
        			String savedFile = FileUpload.imgUpload(fileType, fileData, uploadPath+"FreeBoard\\", LoginNum);
                	logger.info("savedPath : "+savedFile);
                	// /BoardImg/FB/ : 외부저장소 매핑
//                	String fileUrl = "/Boardimg/FB/"+savedFile;//url경로
                    
                    // 서버 -> 클라이언트로 전송(json 형태)
                    printWriter = response.getWriter();

                    JsonObject json = new JsonObject();
                    json.addProperty("uploaded", 1);
                    json.addProperty("filename", upload.getOriginalFilename());
                    json.addProperty("url", savedFile);
                    printWriter.println(json);

                    logger.info("json : "+json);
        		}else { // 업로드 파일크기가 클 경우
        			logger.info("size to large");
        			JsonObject json = new JsonObject();
                    json.addProperty("uploaded", 1);
        		}
        	} else { //확장자 미일치
        		logger.info("Type not matches");
        		JsonObject json = new JsonObject();
                json.addProperty("uploaded", 1);
        	}
  
        }catch(IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
	}
}
