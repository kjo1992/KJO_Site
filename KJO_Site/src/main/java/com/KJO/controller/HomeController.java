package com.KJO.controller;

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

@Controller
@RequestMapping("/Main")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private FreeBoardService BS;

	@RequestMapping(value = "HomePage", method = RequestMethod.GET)
	public String MainPage(ModelMap model) throws Exception {
		logger.info("HomePage Connect");
		Criteria cri = new Criteria(1, 5);
		
		model.addAttribute("FreeBoard", BS.FreeBoardListPaging(cri));
		logger.info("map : "+model);
		return "Main/HomePage";
	}
	
}
