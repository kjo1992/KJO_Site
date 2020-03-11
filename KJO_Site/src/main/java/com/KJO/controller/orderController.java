package com.KJO.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.KJO.model.LoginVO;
import com.KJO.model.orderBoardVO;
import com.KJO.service.orderService;

@Controller
@RequestMapping("/order")
public class orderController {
	private static final Logger logger = LoggerFactory.getLogger(orderController.class);
	
	@Autowired
	private orderService OS;
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView orderDetail(HttpServletRequest request, HttpServletResponse response
			, @RequestParam String orderNum) throws Exception{
		//로그인한 유저정보 가져오기
		HttpSession session = request.getSession();
		LoginVO LoginUser = (LoginVO)session.getAttribute("LoginUser");
		
		orderBoardVO OBV = new orderBoardVO();
		OBV.setUserNum(LoginUser.getUserNum());
		OBV.setOrderNum(orderNum);
		logger.info("/order/detail = "+OBV);
		
		ModelAndView mv = new ModelAndView("/order/orderDetail");
		mv.addObject("orderList", OS.orderDetail(OBV));
		logger.info("MV : "+mv);
		
		return mv;
	}
}
