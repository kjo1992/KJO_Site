package com.KJO.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.KJO.model.Criteria;
import com.KJO.model.ProductBoardVO;
import com.KJO.model.ProductSpecVO;

public interface ProductService {
	//상품 타입코드 > 타입코드,이름
	public String proudctTypeName(String typeNum) throws Exception;
	
	//상품 목록 타입별 보기(페이징)
	public Map<String, List> ProductListMain(Map<String, Object> map) throws Exception;
	
	//상품 갯수 구하기
	public int ProductCount(String typeNum) throws Exception;
	
	//상품 이름, 타입 가져오기
	public List<ProductBoardVO> ProductTypeList() throws Exception;
	
	//상품 게시판, 상숨 스펙 글쓰기
	public void productBoardWrite(Map<String, Object> map) throws Exception;
	
	//상품 Detail
	public Map<String, Object> productDetail(Map<String, String> map) throws Exception;
}
