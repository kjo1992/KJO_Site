package com.KJO.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.KJO.utils.CheckUtils;

public class NotLoginChkInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(NotLoginChkInterceptor.class);
	
	CheckUtils PathCheck = new CheckUtils();
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {
		logger.info("NotLoginChkInterceptor");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("LoginUser") == null) {
			logger.info("Not Login");
			return true;
		} else {
			logger.info("Login Chk");
			PathCheck.redirectMain(request, response, "로그인한 상태로 접근이 불가합니다.");
			return false;
		}
	}
}
