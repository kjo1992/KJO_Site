package com.KJO.controller;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.KJO.model.Criteria;
import com.KJO.model.LoginVO;
import com.KJO.model.UserVO;
import com.KJO.service.MyPageService;
import com.KJO.utils.CheckUtils;
import com.KJO.utils.FileUploadUtils;

@Controller
@RequestMapping("/MyPage")
public class MyPageController {
	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
	private CheckUtils check = new CheckUtils();
	private FileUploadUtils FileUpload = new FileUploadUtils();
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@Autowired
	private MyPageService MPS;
	
	CheckUtils PathCheck = new CheckUtils();
	
	//마이페이지 이동-게시판에 작성한 본인글, 댓글 가져오기
	@RequestMapping(value="Main", method=RequestMethod.GET)
	public String MainMove(HttpServletRequest request, HttpServletResponse response
			, ModelMap model, Map<String, Object> map) throws Exception {
		HttpSession session = request.getSession();
		LoginVO LoginUser = (LoginVO)session.getAttribute("LoginUser");
		logger.info("MyPage connect userNum : "+LoginUser.getUserNum());
		Criteria cri = new Criteria(1, 5);
		
		map.put("LoginUser", LoginUser);
		map.put("Cri", cri);
		
		logger.info("map : "+map);
		
		model.addAttribute("UserInfoGet", MPS.UserInfoGet(LoginUser));
		model.addAttribute("FreeBoard", MPS.MyFBListGet(map));
		return "MyPage/Main";
	}
	
	//개인정보 수정 페이지 이동
	@RequestMapping(value="UpdatePage", method=RequestMethod.POST)
	public String updatePage(HttpServletRequest request, HttpServletResponse response
		, Model model) throws Exception {
		HttpSession session = request.getSession();
		LoginVO LoginUser = (LoginVO)session.getAttribute("LoginUser");
		logger.info("Update set userNum : "+LoginUser.getUserNum());
//		logger.info(inputPw);
		
		model.addAttribute("UserInfo", MPS.UserInfoGet(LoginUser));
		return "MyPage/UpdatePage";
	}
	
	@RequestMapping(value="InfoUpdate", method=RequestMethod.POST)
	public String UserUpdate(HttpServletRequest request, HttpServletResponse response,
			 Map<String, Object> map, UserVO USV) throws Exception {
		HttpSession session = request.getSession();
		LoginVO LoginUser = (LoginVO)session.getAttribute("LoginUser");
		map.put("LoginUser", LoginUser);
		map.put("input", USV);
		
		if(MPS.UserUpdate(map) == 1) {
			logger.info("UserUpdate Success");
			session.removeAttribute("LoginUser");
			PathCheck.redirectMain(request, response, "다시 로그인해주세요.");
		};
		return "redirect:/Main/HomePage";
	}
	
	
	//회원 탈퇴
	@RequestMapping(value="Delete", method=RequestMethod.POST)
	public String UserOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		LoginVO LoginUser = (LoginVO)session.getAttribute("LoginUser");
		logger.info("Delete userNum: "+LoginUser.getUserNum());
		
		MPS.UserDelete(LoginUser);
		
		session.removeAttribute("LoginUser");
		return "redirect:/Main/HomePage";
	}
	
	//비밀번호 체크
	@ResponseBody
	@RequestMapping(value = "pwChk", method = RequestMethod.POST)
	public int pwChk(HttpServletRequest request, HttpServletResponse response
			, @RequestParam("inputPw") String inputPw) throws Exception {
		logger.info("pwChk..");
		int result=0;
		HttpSession session = request.getSession();
    	LoginVO LoginID = (LoginVO)session.getAttribute("LoginUser");
    	
    	Map<String, String> map = new HashMap<>();
    	map.put("userNum", LoginID.getUserNum());
    	map.put("userPw", inputPw);
    	
    	try {
    		result = MPS.pwChk(map);
    		logger.info("map : "+map);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return result;
	}
	
	//프로필 사진 변경
	@ResponseBody
	@RequestMapping(value="imgChange", method=RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> profileImgChange(HttpServletRequest request, HttpServletResponse response
			, @RequestParam MultipartFile upload) throws Exception{
		logger.info("imgChange");
		
        // 한글 깨짐을 방지하기 위한 문자 셋 설정
        //response.setCharacterEncoding("utf-8");
        // 파라미터로 전달되는 response 객체의 한글 설정
        //response.setContentType("text/html;charset=utf-8");
        
        // 로그인값 불러오기
        HttpSession session = request.getSession();
    	LoginVO LoginID = (LoginVO)session.getAttribute("LoginUser");
    	String LoginNum = LoginID.getUserNum();
		
		// 파일 확장자 추출 및 확인
		int typeIndex = upload.getContentType().lastIndexOf("/");
		String fileType = upload.getContentType().substring(typeIndex+1);
		byte[] fileData = upload.getBytes();
//      String fileType = upload.getContentType();
		String checkType = "^(?!)(jpg)|(jpeg)|(png)|(bmp)|(gif)$";

		// 파일 최대 업로드 용량(2mb)
		int maxSize = 1024*1024*2;
		
		
		logger.info("fileOriginalName : "+upload.getOriginalFilename());
		logger.info("fileType : "+fileType);
		logger.info(upload.getContentType());
		logger.info("fileSize : "+upload.getSize());
		
		try {
			// 한글 깨짐을 방지하기 위한 문자 셋 설정
			response.setCharacterEncoding("utf-8");
	        // 파라미터로 전달되는 response 객체의 한글 설정
	        response.setContentType("text/html;charset=utf-8");
			// 업로드된 이미지 확장자 확인
			if (fileType.matches(checkType)) {
				logger.info("Type matches");
				
				// 업로드된 이미지 파일크기 확인
				if(upload.getSize() < maxSize) {
					logger.info("size check.. file upload");
					
					// 파일을 경로에 저장
//					String filePath = FileUpload.imgChange(uploadPath+"MyPage\\", LoginID.getUserNum(), fileType, upload.getBytes());
					String filePath = FileUpload.imgUpload(fileType, fileData, uploadPath+"MyPage\\", LoginNum);
					logger.info("filePath : "+filePath);
					
					// DB에 바뀐 이미지경로 저장
					LoginID.setProfileImg(filePath);
					MPS.imgUpdate(LoginID);
					
					// 호출한 ajax로 바뀐 이미지경로 반환
					return new ResponseEntity<>(filePath, HttpStatus.CREATED);
				} else { // 업로드 이미지가 클 경우
					logger.info("size to large");
				}
			} else { // 업로드 파일타입이 아닌 경우
				logger.info("Type not matches");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return null;
	}

}

