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
	public String MainPage(ModelMap model) throws Exception {
		logger.info("HomePage Connect");
		Criteria cri = new Criteria(1, 5);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Cri", cri);
		
		//자유게시판 5개
		model.addAttribute("FreeBoard", BS.FreeBoardListPaging(cri));
		//최근 작성된 상품평 5개
		model.addAttribute("productReply", PS.productReplyGet(map));
		//최근추가된 상품목록 5개
		model.addAttribute("productList", PS.ProductListMain(map));
		return "Main/HomePage";
	}
	
}
