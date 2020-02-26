package com.KJO.mapper;

import java.util.HashMap;
import java.util.List;

import com.KJO.model.Criteria;
import com.KJO.model.FreeBoardReplyVO;
import com.KJO.model.FreeBoardVO;

public interface FreeBoardMapper {
	
	//자유게시판 글 작성
	public void FreeBoardWrite(FreeBoardVO FBV) throws Exception;
	
	//자유게시판 글 리스트
	public List<FreeBoardVO> FreeBoardList() throws Exception;
	
	//자유게시판 글 갯수 확인
	public int FreeBoardCount(Criteria cri) throws Exception;
	
	//자유게시판 리스트 페이징 처리
	public List<FreeBoardVO> FreeBoardListPaging(Criteria cri) throws Exception;
	
	//자유게시판 내용 확인
	public FreeBoardVO FreeBoardDetail(int bnum) throws Exception;
	
	//자유게시판 글 수정
	public void FreeBoardUpdate(FreeBoardVO FBV) throws Exception;
	
	//자유게시판 글 삭제
	public void FreeBoardDelete(int bnum) throws Exception;
	
	//자유게시판 게시글 댓글 확인
	public List<FreeBoardReplyVO> FreeBoardReplyList(int bnum) throws Exception;
	
	//자유게시판 댓글 작성
	public void FreeBoardReplyWrite(FreeBoardReplyVO FBReply) throws Exception;
	
	//게시판 댓글 삭제
	public void FreeBoardDeleteReply(int rnum) throws Exception;
	
	//게시판 댓글 갯수 확인
	public int FreeBoardReplyCount(int boardNum) throws Exception;
}
