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
import com.KJO.model.productReplyVO;

@Repository
public class ProductMapperImpl implements ProductMapper {
	@Autowired
	private SqlSession SQL;
	private static final String path="com.KJO.mapper.ProductMapper";
	
	//상품 타입 코드 > 이름
	@Override
	public String productTypeName(String typeNum) throws Exception {
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

	//상품 Detail
	@Override
	public Map<String, Object> productDetail(Map<String, String> map) throws Exception {
		return SQL.selectOne(path+".productDetail", map);
	}
	
	//상품평 중복체크
	@Override
	public int productReplyChk(productReplyVO PRV) throws Exception {
		return SQL.selectOne(path+".productReplyChk", PRV);
	}
	
	//상품평 작성
	@Override
	public int addProductReply(productReplyVO PRV) throws Exception {
		return SQL.insert(path+".addProductReply", PRV);
	}
	
	//상품별 상품평 가져오기
	@Override
	public List<Map> productReplyGet(Map<String, Object> map) throws Exception {
		List<Map> list = SQL.selectList(path+".productReplyGet", map);
		return list;
	}
	
	//상품별 댓글 수
	@Override
	public int replyCount(int productListNum) throws Exception {
		return SQL.selectOne(path+".replyCount", productListNum);
	}

	@Override
	public int deleteReply(productReplyVO PRV) throws Exception {
		return SQL.delete(path+".deleteReply", PRV);
		
	}
}
