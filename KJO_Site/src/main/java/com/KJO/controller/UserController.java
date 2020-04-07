package com.KJO.controller;

import java.io.PrintWriter;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UrlPathHelper;

import com.KJO.model.LoginVO;
import com.KJO.model.UserVO;
import com.KJO.service.UserService;
import com.KJO.utils.CheckUtils;

//user에 관련된것을 처리하는 controller
@Controller
@RequestMapping("/User")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService US;
	
	CheckUtils LoginCheck = new CheckUtils();
	
	// 회원가입 페이지-이동
	@RequestMapping(value = "AddUser", method = RequestMethod.GET)
	public void MemberPage() {
		logger.info("AddMember Connect");
	}
	
	// 회원가입
	@RequestMapping(value = "AddComp", method = RequestMethod.POST)
	public void MemberAdd(UserVO UV) throws Exception {
		logger.info("AddComp Connect");
		US.MemberAdd(UV);
	}

	// 로그인 처리
	@RequestMapping(value = "Login", method = RequestMethod.POST)
	public void LoginSet(UserVO UV, Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("Login Connect");
		
		LoginVO user = US.Login(UV);

		// 로그인 성공시
		if (user != null) {
			logger.info("LoginSuccess : "+user);
			// 유저정보를 세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("LoginUser", user);
			
			// 로그인한 페이지로 반환
			logger.info(LoginCheck.PathChk(request, response));
			response.sendRedirect(LoginCheck.PathChk(request, response));
		} else {
			logger.error("LoginFailed : "+user);
			LoginCheck.backPage(request, response, "ID와 비밀번호를 다시 확인해주세요.");
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>alert('계정과 비밀번호를 다시 확인해주세요.'); window.history.back();</script>");
//			out.flush();
			//response.sendRedirect(redirectPath);
		}
	}

	// 로그아웃
	@RequestMapping(value = "Logout")
	public void Logout(LoginVO login, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Logout Connect");
		HttpSession session = request.getSession();
		session.removeAttribute("LoginUser");
		logger.info("session clear");
		
		// 로그아웃한 페이지로 반환
		response.sendRedirect(LoginCheck.PathChk(request, response));
	}

	// ID중복체크
	@RequestMapping(value = "IDChk", method = RequestMethod.POST)
	public @ResponseBody int IDChk(@RequestParam("ChkValue") String ChkValue) throws Exception {
		// ResponseEntity<Integer> entity = null;
		logger.info("IDChk Connect");
		int result = 0;
		try {
			result = US.IDChk(ChkValue);
			logger.info("IDChk result : " + result);
			// entity = new ResponseEntity<Integer>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}

		return result;
	}

	// 닉네임중복체크
	@RequestMapping(value = "NameChk", method = RequestMethod.POST)
	public @ResponseBody int NameChk(@RequestParam("ChkValue") String ChkValue) throws Exception {
		logger.info("NameChk Connect");
		int result = 0;
		try {
			result = US.NameChk(ChkValue);
			logger.info("NameChk result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 이메일중복체크
	@RequestMapping(value = "EmailChk", method = RequestMethod.POST)
	public @ResponseBody int EmailChk(@RequestParam("ChkValue") String ChkValue) throws Exception {
		logger.info("EmailChk Connect");
		int result = 0;
		try {
			result = US.EmailChk(ChkValue);
			logger.info("EmailChk result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
