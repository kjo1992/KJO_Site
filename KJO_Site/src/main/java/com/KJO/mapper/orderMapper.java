package com.KJO.mapper;

import java.util.HashMap;
import java.util.List;

import com.KJO.model.orderBoardVO;

public interface orderMapper {
	//주문 상세보기
	public HashMap<String, List> orderDetail(orderBoardVO OBV) throws Exception;
}
