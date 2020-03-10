package com.KJO.service;

import java.util.List;
import java.util.Map;

import com.KJO.model.LoginVO;
import com.KJO.model.orderBoardVO;
import com.KJO.model.shopCartVO;

public interface shopCartService {
	//장바구니 추가
	public int addCart(shopCartVO SCV) throws Exception;
	
	//장바구니 리스트
	public List<shopCartVO> cartList(LoginVO LoginUser) throws Exception;
	
	//장바구니 삭제
	public int deleteCart(shopCartVO SCV) throws Exception;
	
	//장바구니 수량 변경
	public int changeAmount(shopCartVO SCV) throws Exception;
	
	//주문목록 추가
	public void addOrderList(orderBoardVO OBV) throws Exception;
	
	//주문목록 상세 추가
	public void addOrderListDetail(orderBoardVO OBV) throws Exception;
}
