package com.KJO.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.KJO.model.Criteria;
import com.KJO.model.ProductBoardVO;
import com.KJO.model.ProductSpecVO;

@Repository
public class ProductMapperImpl implements ProductMapper {
	@Autowired
	private SqlSession SQL;
	private static final String path="com.KJO.mapper.ProductMapper";
	
	//상품 타입 코드 > 이름
	@Override
	public Map<String, Object> productTypeName(String typeNum) throws Exception {
		return SQL.selectOne(path+".returnTypeName",typeNum);
	}
	
	//상품 목록 타입별 보기(페이징)
	@Override
	public Map<String, List> ProductListMain(Map<String, Object> map) throws Exception {
		Map<String, List> resultMap = new HashMap<String, List>();
		resultMap.put("ProductList", SQL.selectList(path+".productList", map));
		return resultMap;
	}
	

	//상품 목록 갯수 구하기
	@Override
	public int ProductCount(String typeNum) throws Exception {
		return SQL.selectOne(path+".ProductCount", typeNum);
	}
	
	//상품 전체 이름 가져오기
	@Override
	public List<ProductBoardVO> ProductTypeList() throws Exception {
		List list = SQL.selectList(path+".ProductTypeList");
		return list;
	}
	
	//상품 게시판, 상숨 스펙 글쓰기
	@Override
	public void productBoardWrite(Map<String, Object> map) throws Exception {
		SQL.insert(path+".productBoardInsert",map);
		SQL.insert(path+".productSpecInsert",map);
	}
}
