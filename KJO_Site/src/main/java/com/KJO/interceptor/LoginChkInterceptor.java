package com.KJO.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.KJO.utils.CheckUtils;

public class LoginChkInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(LoginChkInterceptor.class);
	
	CheckUtils PathCheck = new CheckUtils();
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {
		logger.info("AuthInterceptor");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("LoginUser") != null) {
			logger.info("Login Chk");
			return true;
		} else {
			logger.info("Not Login");
			PathCheck.redirectMain(request, response, "로그인이 필요합니다.");
			return false;
		}
		
	}	
}
