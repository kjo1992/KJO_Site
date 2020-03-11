package com.KJO.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.KJO.model.orderBoardVO;

@Repository
public class orderMapperImpl implements orderMapper{
	@Autowired
	private SqlSession SQL;
	private static final String path="com.KJO.mapper.orderMapper";
	
	@Override
	public HashMap<String, List> orderDetail(orderBoardVO OBV) throws Exception {
		HashMap<String, List> result = new HashMap<String, List>();
		result.put("list", SQL.selectList(path+".orderDetail", OBV));
		return result;
	}
}
