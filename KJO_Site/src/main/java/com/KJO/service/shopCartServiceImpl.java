package com.KJO.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KJO.mapper.shopCartMapper;
import com.KJO.model.LoginVO;
import com.KJO.model.orderBoardVO;
import com.KJO.model.shopCartVO;

@Service
public class shopCartServiceImpl implements shopCartService{
	
	@Autowired
	private shopCartMapper SCM;
	
	//장바구니 추가
	@Override
	public int addCart(shopCartVO SCV) throws Exception {
		return SCM.addCart(SCV);
	}
	
	//장바구니 리스트
	@Override
	public List<shopCartVO> cartList(LoginVO LoginUser) throws Exception {
		return SCM.cartList(LoginUser);
	}
	
	//장바구니 삭제
	@Override
	public int deleteCart(shopCartVO SCV) throws Exception {
		return SCM.deleteCart(SCV);
	}
	
	//장바구니 수량 변경
	@Override
	public int changeAmount(shopCartVO SCV) throws Exception {
		return SCM.changeAmount(SCV);
	}

	//주문목록 추가
	@Override
	public void addOrderList(orderBoardVO OBV) throws Exception {
		SCM.addOrderList(OBV);
	}

	//주문목록 상세 추가
	@Override
	public void addOrderListDetail(orderBoardVO OBV) throws Exception {
		SCM.addOrderListDetail(OBV);
	}

}
