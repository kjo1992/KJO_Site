package com.KJO.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.KJO.model.ProductBoardVO;
import com.KJO.model.ProductSpecVO;

public interface ProductService {
	//상품 이름, 타입 가져오기
	public List<ProductBoardVO> ProductTypeList() throws Exception;
	
	//상품 스펙 가져오기
	public List<ProductSpecVO> productSpec(ProductBoardVO PBVO) throws Exception;
	
	//상품 게시판, 상숨 스펙 글쓰기
	public void productBoardWrite(Map<String, Object> map) throws Exception;
	
	//해쉬맵 반환 테스트
	public List<HashMap> testPage() throws Exception;
}
