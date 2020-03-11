package com.KJO.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.KJO.model.Criteria;
import com.KJO.service.FreeBoardService;
import com.KJO.service.ProductService;

@Controller
@RequestMapping("/Main")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private FreeBoardService BS;
	@Autowired
	private ProductService PS;

	@RequestMapping(value = "HomePage", method = RequestMethod.GET)
	public ModelAndView MainPage() throws Exception {
		logger.info("HomePage Connect");
		ModelAndView mv = new ModelAndView("Main/HomePage");
		Criteria cri = new Criteria(1, 5);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Cri", cri);
		
		//최근 작성된 상품평 5개
		mv.addObject("productReply", PS.productReplyGet(map));
		//최근추가된 상품목록 5개
		mv.addObject("productList", PS.ProductListMain(map));
		//자유게시판 5개
		mv.addObject("FreeBoard", BS.FreeBoardListPaging(cri));
		
		logger.info("HomePage Model : "+mv);
		
		return mv;
	}
	
}
