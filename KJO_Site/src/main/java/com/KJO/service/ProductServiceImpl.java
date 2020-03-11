package com.KJO.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KJO.mapper.ProductMapper;
import com.KJO.model.Criteria;
import com.KJO.model.ProductBoardVO;
import com.KJO.model.productReplyVO;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper PM;
	
	//상품 타입코드 > 이름
	@Override
	public String proudctTypeName(String typeNum) throws Exception {
		return PM.productTypeName(typeNum);
	}
	
	//상품 목록 타입별 보기(페이징)
	@Override
	public Map<String, List> ProductListMain(Map<String, Object> map) throws Exception {
		return PM.ProductListMain(map);
	}
	
	//상품 목록 갯수 구하기
	@Override
	public int ProductCount(String typeNum) throws Exception {
		return PM.ProductCount(typeNum);
	}

	//상품 전체 이름 가져오기
	@Override
	public List<ProductBoardVO> ProductTypeList() throws Exception {
		return PM.ProductTypeList();
	}
	
	//상품게시판, 제품스펙 글쓰기
	@Transactional
	@Override
	public void productBoardWrite(Map<String, Object> map) throws Exception {
		PM.productBoardWrite(map);
	}
	
	//상품 상세보기
	@Override
	public Map<String, Object> productDetail(Map<String, String> map) throws Exception {
		return PM.productDetail(map);
	}
	
	//상품평 중복 체크
	@Override
	public int productReplyChk(productReplyVO PRV) throws Exception {
		return PM.productReplyChk(PRV);
	}
	
	//상품평 작성
	@Override
	public int addProductReply(productReplyVO PRV) throws Exception {
		return PM.addProductReply(PRV);
	}
	
	//상품별 상품평 가져오기
	@Override
	public List<Map> productReplyGet(Map<String, Object> map) throws Exception {
		return PM.productReplyGet(map);
	}
	
	//상품별 댓글 수 가져오기
	@Override
	public int replyCount(int productListNum) throws Exception {
		return PM.replyCount(productListNum);
	}
	
	//상품평 삭제
	@Override
	public int deleteReply(productReplyVO PRV) throws Exception {
		return PM.deleteReply(PRV);
	}
	
	
}
