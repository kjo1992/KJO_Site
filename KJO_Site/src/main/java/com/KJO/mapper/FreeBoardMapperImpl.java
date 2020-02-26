package com.KJO.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.KJO.model.Criteria;
import com.KJO.model.FreeBoardReplyVO;
import com.KJO.model.FreeBoardVO;

@Repository
public class FreeBoardMapperImpl implements FreeBoardMapper{
	@Autowired
	private SqlSession SQL;
	private static final String path="com.KJO.mapper.FreeBoardMapper";
	
	@Override //자유게시판 게시글 작성
	public void FreeBoardWrite(FreeBoardVO FBV) throws Exception {
		System.out.println("FreeBoardWrite Mapper : "+FBV);
		SQL.insert(path+".FreeBoardWrite", FBV);
	}

	@Override //자유게시판 목록 가져오기
	public List<FreeBoardVO> FreeBoardList() throws Exception {
		List list = SQL.selectList(path+".FreeBoardList");
		return list;
	}

	@Override //자유게시판 글 갯수 확인
	public int FreeBoardCount(Criteria cri) throws Exception {
		int count = SQL.selectOne(path+".FreeBoardCount", cri);
		return count;
	}

	@Override //자유게시판 목록 페이징처리
	public List<FreeBoardVO> FreeBoardListPaging(Criteria cri) throws Exception {
		List list = SQL.selectList(path+".ListPaging", cri);
		return list;
	}
	

	@Override //자유게시판 게시글 상세보기
	public FreeBoardVO FreeBoardDetail(int bnum) throws Exception {
		//게시글 조회수 증가
		SQL.update(path+".FreeBoardCntUp", bnum);
		FreeBoardVO FBDetail = SQL.selectOne(path+".FreeBoardDetail", bnum);
		return FBDetail;
	}

	@Override //자유게시판 수정
	public void FreeBoardUpdate(FreeBoardVO FBV) throws Exception {
		SQL.update(path+".FreeBoardUpdate", FBV);
	}
	
	@Override //자유게시판 글 삭제 
	public void FreeBoardDelete(int bnum) throws Exception {
		SQL.delete(path+".FreeBoardDelete", bnum);
	}

	@Override //자유게시판 게시글 댓글 보기
	public List<FreeBoardReplyVO> FreeBoardReplyList(int bnum) throws Exception {
		List list = SQL.selectList(path+".FreeBoardReplyList", bnum);
		return list;
	}

	@Override //자유게시판 게시글 댓글 작성
	public void FreeBoardReplyWrite(FreeBoardReplyVO FBReply) throws Exception {
		SQL.insert(path+".FreeBoardReplyWrite", FBReply);
	}

	@Override //자유게시판 댓글 삭제
	public void FreeBoardDeleteReply(int rnum) throws Exception {
		SQL.delete(path+".FreeBoardDeleteReply", rnum);
	}

	@Override //게시글 별 댓글 갯수 확인
	public int FreeBoardReplyCount(int boardNum) throws Exception {
		return SQL.selectOne(path+".FreeBoardReplyCount", boardNum);
	}

	
	
}
