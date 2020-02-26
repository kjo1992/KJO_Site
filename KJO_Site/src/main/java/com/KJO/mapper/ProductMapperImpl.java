package com.KJO.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.KJO.model.ProductBoardVO;
import com.KJO.model.ProductSpecVO;

@Repository
public class ProductMapperImpl implements ProductMapper {
	@Autowired
	private SqlSession SQL;
	private static final String path="com.KJO.mapper.ProductMapper";
	
	//상품 전체 이름 가져오기
	@Override
	public List<ProductBoardVO> ProductTypeList() throws Exception {
		List list = SQL.selectList(path+".ProductTypeList");
		return list;
	}

	@Override
	public List<ProductSpecVO> ProductSpec(ProductBoardVO PBVO) throws Exception {
		return SQL.selectList(path+".ProductSpec", PBVO);
	}
	
	//상품 게시판, 상숨 스펙 글쓰기
	@Override
	public void productBoardWrite(Map<String, Object> map) throws Exception {
		SQL.insert(path+".productBoardInsert",map);
		SQL.insert(path+".productSpecInsert",map);
	}
	
	
	//해쉬맵 반환 테스트
	@Override
	public List<HashMap> testPage() throws Exception {
		return SQL.selectList(path+".test");
	}
}
