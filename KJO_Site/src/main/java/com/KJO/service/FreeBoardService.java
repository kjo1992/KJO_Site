package com.KJO.service;

import java.util.HashMap;
import java.util.List;

import com.KJO.model.Criteria;
import com.KJO.model.FreeBoardReplyVO;
import com.KJO.model.FreeBoardVO;

public interface FreeBoardService {
	//게시글 작성
	public void FreeBoardWrite(FreeBoardVO FBV) throws Exception;
	
	//게시글 리스트
	public List<FreeBoardVO> FreeBoardList() throws Exception;
	
	//게시글 글 갯수 확인
	public int FreeBoardCount(Criteria cri) throws Exception;
	
	//게시글 리스트 페이징처리
	public List<FreeBoardVO> FreeBoardListPaging(Criteria cri) throws Exception;
	
	//게시글 내용 확인
	public FreeBoardVO FreeBoardDetail(int bnum) throws Exception;
	
	//게시글 내용 수정
	public void FreeBoardUpdate(FreeBoardVO FBV) throws Exception;
	
	//게시글 삭제(본인것만)
	public void FreeBoardDelete(int bnum) throws Exception;
	
	//게시글 댓글 리스트
	public List<FreeBoardReplyVO> FreeBoardReplyList(int bnum) throws Exception;
	
	//게시글 댓글 작성
	public void FreeBoardReplyWrite(FreeBoardReplyVO FBReply) throws Exception;
	
	//게시글 댓글 삭제
	public void FreeBoardDeleteReply(int rnum) throws Exception;
	
	//게시글 댓글 갯수 확인
	public int FreeBoardReplyCount(int boardNum) throws Exception;
}
