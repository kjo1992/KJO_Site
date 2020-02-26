package com.KJO.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.KJO.model.LoginVO;
import com.KJO.utils.CheckUtils;

public class MasterChkInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(MasterChkInterceptor.class);
	CheckUtils PathCheck = new CheckUtils();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {
		logger.info("AuthChk");
		HttpSession session = request.getSession();
		LoginVO user = (LoginVO) session.getAttribute("LoginUser");
		
		try {
			if(user != null) {
				if(user.getAuthority().equals("master")) {
					return true;
				} else {
					PathCheck.redirectMain(request, response, "권한이 없습니다.");
					return false;
				}
			} else {
				PathCheck.redirectMain(request, response, "로그인이 되어있지 않습니다.");
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
			PathCheck.redirectMain(request, response, "세션이 만료되었거나, 잘못된 접근입니다.");
			return false;
		} 	
	}
}
