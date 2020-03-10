package com.KJO.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KJO.model.LoginVO;
import com.KJO.model.orderBoardVO;
import com.KJO.model.shopCartVO;
import com.KJO.service.shopCartService;
import com.KJO.utils.CheckUtils;
import com.KJO.utils.FileUploadUtils;

@Controller
@RequestMapping("/cart")
public class shopCartController {
	private static final Logger logger = LoggerFactory.getLogger(shopCartController.class);
	
	@Autowired
	private shopCartService SCS;
	
	private FileUploadUtils FileUpload = new FileUploadUtils();
	private CheckUtils chk = new CheckUtils();
	
	//카트 담기
	@RequestMapping(value="addCart", method=RequestMethod.POST)
	@ResponseBody
	public int addCart(HttpServletRequest request, HttpServletResponse response, shopCartVO SCV) throws Exception {
		int result = 0;
		boolean check = false;
		
		//로그인한 유저정보 가져오기
		HttpSession session = request.getSession();
		LoginVO LoginUser = (LoginVO)session.getAttribute("LoginUser");
		SCV.setUserNum(LoginUser.getUserNum());
		
		//로그인 여부 확인
		if(LoginUser != null) {
			check = true;
		} else {check = false;}
		
		//입력된 수량 수 확인
		if(SCV.getAmount() >= 1) {
			check = true;
		} else {check = false;}
		
		if (check) {
			logger.info("addCart Connect : "+SCV);
			result = SCS.addCart(SCV);
		}

		return result;
	}
	
	//장바구니 리스트
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String cartList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		//로그인한 유저정보 가져오기
		HttpSession session = request.getSession();
		LoginVO LoginUser = (LoginVO)session.getAttribute("LoginUser");
		
		logger.info("cartList");
		
		model.addAttribute("cartList", SCS.cartList(LoginUser));
		
		return "cart/listMain";
	}
	
	//장바구니 삭제
	@RequestMapping(value="delete", method=RequestMethod.POST)
	@ResponseBody
	public int deleteCart(HttpServletRequest request, HttpServletResponse response
			, @RequestParam("chkBox[]") String[] chkBox, shopCartVO SCV) throws Exception{
		int result=0;
		
		HttpSession session = request.getSession();
		LoginVO LoginUser = (LoginVO)session.getAttribute("LoginUser");
		
		if (LoginUser != null) {
			SCV.setUserNum(LoginUser.getUserNum());
			
			for (String value : chkBox) {		
				int cartNum = Integer.parseInt(value);
				SCV.setCartNum(cartNum);
				
				logger.info("cartList delete : " +SCV);
				
				SCS.deleteCart(SCV);
			}
			result = 1;
		}
		return result;
	}
	
	//장바구니 수량 변경(JSON 이용)
	@RequestMapping(value="changeAmount", method=RequestMethod.POST)
	@ResponseBody
	public int changeAmount(HttpServletRequest request, HttpServletResponse response
			, @RequestBody shopCartVO SCV) throws Exception{
		int result=0;
		
		HttpSession session = request.getSession();
		LoginVO LoginUser = (LoginVO)session.getAttribute("LoginUser");
		
		if (LoginUser != null) {
			SCV.setUserNum(LoginUser.getUserNum());
			
			logger.info("changeAmout : " +SCV);
				
			result = SCS.changeAmount(SCV);
		}
		
		return result;
	}
	
	@RequestMapping(value="addOrder", method=RequestMethod.POST)
	public void addOrderList(HttpServletRequest request, HttpServletResponse response
			, @RequestParam(value="productListNum") int[] productListNum
			, @RequestParam(value="cartNum") int[] cartNum
			, orderBoardVO OBV) throws Exception {
		
		shopCartVO SCV = new shopCartVO();

		HttpSession session = request.getSession();
		LoginVO LoginUser = (LoginVO)session.getAttribute("LoginUser");
		
		
		if (LoginUser != null) {
			OBV.setUserNum(LoginUser.getUserNum());
			SCV.setUserNum(LoginUser.getUserNum());
			
			OBV.setOrderNum(FileUpload.calcPath().replace("\\", "")+"_"+UUID.randomUUID().toString().replace("-","").substring(1, 7));
			logger.info("addOrderList OBV : "+OBV);
			logger.info("productListNum length : "+productListNum.length);
			
			if(productListNum.length > 0) {
				SCS.addOrderList(OBV);
				for (int value : productListNum) {
					OBV.setProductListNum(value);
					logger.info("addOrderListDetail : "+OBV);
					SCS.addOrderListDetail(OBV);
				}
				for (int value : cartNum) {
					SCV.setCartNum(value);
					logger.info("deleteCart : "+SCV);
					SCS.deleteCart(SCV);
				}
				chk.redirectPage(request, response, "주문하기 성공, 주문목록은 마이페이지에서 확인 가능합니다.", "/cart/list");
			}
		}
	}
}
