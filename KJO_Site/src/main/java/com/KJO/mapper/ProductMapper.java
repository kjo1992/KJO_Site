package com.KJO.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.KJO.model.Criteria;
import com.KJO.model.ProductBoardVO;
import com.KJO.model.productReplyVO;

public interface ProductMapper {
	//상품 타입코드 > 이름
	public String productTypeName(String typeNum) throws Exception;
	
	//상품 목록 타입별 보기(페이징)
	public Map<String, List> ProductListMain(Map<String, Object> map) throws Exception;
		
	//상품 갯수 구하기
	public int ProductCount(String typeNum) throws Exception;
	
	//상품 전체 이름 가져오기
	public List<ProductBoardVO> ProductTypeList() throws Exception;
	
	//상품 게시판, 상숨 스펙 글쓰기
	public void productBoardWrite(Map<String, Object> map) throws Exception;
	
	//상품 Detail
	public Map<String, Object> productDetail(Map<String, String> map) throws Exception;
	
	//상품평 중복값 체크
	public int productReplyChk(productReplyVO PRV) throws Exception;
	
	//상품평 작성
	public int addProductReply(productReplyVO PRV) throws Exception;
	
	//상품별 상품평 가져오기
//	public List<productReplyVO> productReplyGet(Map<String, Object> criMap) throws Exception;
	public List<Map> productReplyGet(Map<String, Object> map) throws Exception;
	
	//상품별 상품 댓글수
	public int replyCount(int productListNum) throws Exception;
	
	//상품평 삭제
	public int deleteReply(productReplyVO PRV) throws Exception;
}
