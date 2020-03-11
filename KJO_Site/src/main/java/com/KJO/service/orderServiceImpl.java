package com.KJO.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KJO.mapper.orderMapper;
import com.KJO.model.orderBoardVO;

@Service
public class orderServiceImpl implements orderService{
	
	@Autowired
	private orderMapper OM;
	
	//주문 상세보기
	@Override
	public HashMap<String, List> orderDetail(orderBoardVO OBV) throws Exception {
		return OM.orderDetail(OBV); 
	}

}
