package com.KJO.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.KJO.model.LoginVO;
import com.KJO.model.orderBoardVO;
import com.KJO.model.shopCartVO;

@Repository
public class shopCartMapperImpl implements shopCartMapper{
	
	@Autowired
	private SqlSession SQL;
	private static final String path="com.KJO.mapper.shopCartMapper";
	
	//장바구니 추가
	@Override
	public int addCart(shopCartVO SCV) throws Exception {
		return SQL.insert(path+".addCart", SCV);
	}
	
	//장바구니 리스트
	@Override
	public List<shopCartVO> cartList(LoginVO LoginUser) throws Exception {
		return SQL.selectList(path+".cartList", LoginUser);
	}
	
	//장바구니 삭제
	@Override
	public int deleteCart(shopCartVO SCV) throws Exception {
		return SQL.delete(path+".deleteCart", SCV);
	}
	
	//장바구니 수량 변경
	@Override
	public int changeAmount(shopCartVO SCV) throws Exception {
		return SQL.update(path+".changeAmount", SCV);
	}
	
	//주문목록 추가
	@Override
	public void addOrderList(orderBoardVO OBV) throws Exception {
		SQL.insert(path+".addOrder", OBV);
	}
	
	//주문목록 상세 추가
	@Override
	public void addOrderListDetail(orderBoardVO OBV) throws Exception {
		SQL.insert(path+".addOrderDetail", OBV);
	}

}
