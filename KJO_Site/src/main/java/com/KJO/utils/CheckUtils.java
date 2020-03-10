package com.KJO.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.KJO.model.LoginVO;

public class CheckUtils {
	private static final Logger logger = LoggerFactory.getLogger(CheckUtils.class);
	
	//작성자와 로그인유저가 같은지 체크
	public boolean UserMappingCheck(HttpServletRequest request, HttpServletResponse response, String userNum) throws Exception {
		HttpSession session = request.getSession();
		
		LoginVO LoginUser = (LoginVO)session.getAttribute("LoginUser");
		
		if (userNum.equals(LoginUser.getUserNum())) {
			logger.info("ChkUID : "+userNum+" = SessionUID : "+LoginUser.getUserNum());
			return true;
		} else { //값이 일치하지 않을시 뒤페이지로
			logger.info("ChkUID : "+userNum+" = SessionUID : "+LoginUser.getUserNum());
			redirectMain(request, response, "잘못된 접근입니다.");
			return false;
		}
	}
	
	//이전 페이지 경로를 찾기 위한 메서드(include 된 페이지에서 이동하려고 할시 현재페이지 경로에서 경로가 추가되서 이동됨)
	public String PathChk(HttpServletRequest request, HttpServletResponse response) {
		// include 된 jsp페이지(Login.jsp) uri가 아닌 로그인한 페이지 정보를 불러오고 리다이렉트
		String refererPath = request.getHeader("REFERER"); // Login.jsp include한 페이지
		String contextPath = request.getContextPath(); // /kjo
		int indexNum = refererPath.indexOf(contextPath); // refererPath에서 /kjo 가 시작되는부분 찾기
		String path = refererPath.substring(indexNum, (refererPath.length())); // /kjo 앞부분 제거
		String redirectPath = path.substring(contextPath.length()+1, path.length()); // /**/**
		String FinalPath = contextPath+"/"+redirectPath; // /kjo/**/**
		
		logger.info(FinalPath);

		return FinalPath;
	}
	
	public String getURL(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// http://localhost:7080/kjo/Main/HomePage 에서 /kjo/** 부분 제거
		String urlReturn = request.getRequestURL().toString().replace(request.getRequestURI(), "");
		
		// 추출한 url에서 contextPath 다시 붙임
		String finalPath = urlReturn+request.getContextPath();
		
		return finalPath;
	}
	
	//메인홈페이지로 리다이렉트
	public void redirectMain(HttpServletRequest request, HttpServletResponse response, String msg) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('"+msg+"')");
		out.println("location.href = '"+request.getContextPath()+"/Main/HomePage';");
		out.println("</script>");
		out.flush();
	}
	
	//이전페이지 반환
	public void backPage(HttpServletRequest request, HttpServletResponse response, String msg) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('"+msg+"')");
		out.println("window.history.back();");
		out.println("</script>");
		out.flush();
	}
	
	//path로 리다이렉트
	public void redirectPage(HttpServletRequest request, HttpServletResponse response, String msg, String target) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('"+msg+"')");
		out.println("location.href = '"+request.getContextPath()+target+"';");
		out.println("</script>");
		out.flush();
	}
}
