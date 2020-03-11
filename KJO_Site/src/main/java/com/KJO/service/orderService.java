package com.KJO.service;

import java.util.HashMap;
import java.util.List;

import com.KJO.model.orderBoardVO;

public interface orderService {
	//주문 상세보기
	public HashMap<String, List> orderDetail(orderBoardVO OBV) throws Exception;
}
