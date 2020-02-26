package com.KJO.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KJO.mapper.ProductMapper;
import com.KJO.model.ProductBoardVO;
import com.KJO.model.ProductSpecVO;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper PM;

	//상품 전체 이름 가져오기
	@Override
	public List<ProductBoardVO> ProductTypeList() throws Exception {
		return PM.ProductTypeList();
	}

	@Override
	public List<ProductSpecVO> productSpec(ProductBoardVO PBVO) throws Exception {
		return PM.ProductSpec(PBVO);
	}
	
	//상품게시판, 제품스펙 글쓰기
	@Transactional
	@Override
	public void productBoardWrite(Map<String, Object> map) throws Exception {
		PM.productBoardWrite(map);
	}
	
	//해쉬맵 반환 테스트
	@Override
	public List<HashMap> testPage() throws Exception {
		return PM.testPage();
	}

}
