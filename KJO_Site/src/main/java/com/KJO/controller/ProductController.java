package com.KJO.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.KJO.model.ProductBoardVO;
import com.KJO.service.ProductService;

@Controller
@RequestMapping("/Product")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService PS;
	
	//상품목록 메인페이지
	@RequestMapping(value="Main", method=RequestMethod.GET)
	public void ProductMainPage() {
		logger.info("PDmain");
	}
	
	//상품목록 추가 페이지 이동
	@RequestMapping(value="AddProduct", method=RequestMethod.GET)
	public void AddProductPage(Model model) throws Exception {
		logger.info("AddProduct Page...");
		model.addAttribute("ProductTypeList", PS.ProductTypeList());
	}
	
	//상품목록 추가 및 상세 스펙 추가
	@RequestMapping(value="AddProduct/Add", method=RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String AddProduct(MultipartHttpServletRequest file
//			, @RequestParam String typeNum
			, @RequestParam Map<String,Object> map) throws Exception{
		List<MultipartFile> fileList = file.getFiles("productImg");
//		logger.info("typeNum : "+typeNum);
		logger.info("Add Product : "+map);
		for (int i=0; i<fileList.size(); i++) {
			logger.info("filename : "+fileList.get(i).getOriginalFilename());
			logger.info("bytes[] : "+fileList.get(i).getBytes());
		}
		
		//form 입력값을 map으로 전달, 테스트동안 주석처리
//		PS.productBoardWrite(map);
		
		return "redirect:/Product/Main";
	}
	
	//모듈화된 input창 불러오는 Ajax
	@ResponseBody
	@RequestMapping(value="inputData/{productType}", method=RequestMethod.GET)
	public ModelAndView inputData(@PathVariable("productType") String productType)  throws Exception {
		logger.info("inputData..");
		logger.info("productType : "+productType);
		ModelAndView mv = new ModelAndView("/Product/inputData/"+productType);
		logger.info("mv : "+mv);
		return mv;
	}

	//해쉬맵 반환 테스트
	@RequestMapping(value="test", method=RequestMethod.GET)
	public void testPage(Model model) throws Exception {
		logger.info("AddProduct Page...");
		model.addAttribute("test", PS.testPage());
	}
		
}
