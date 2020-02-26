package com.KJO.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KJO.mapper.FreeBoardMapper;
import com.KJO.model.Criteria;
import com.KJO.model.FreeBoardReplyVO;
import com.KJO.model.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	@Autowired
	private FreeBoardMapper BM;
	
	@Override //게시글 작성
	public void FreeBoardWrite(FreeBoardVO FBV) throws Exception {
		System.out.println("BoardWrite Service Connect : "+FBV);
		BM.FreeBoardWrite(FBV);
	}

	@Override //게시글 리스트
	public List<FreeBoardVO> FreeBoardList() throws Exception {
		return BM.FreeBoardList();
	}

	@Override //게시글 총 갯수 확인
	public int FreeBoardCount(Criteria cri) throws Exception {
		return BM.FreeBoardCount(cri);
	}

	@Override //게시글 리스트 페이징 처리
	public List<FreeBoardVO> FreeBoardListPaging(Criteria cri) throws Exception {
		return BM.FreeBoardListPaging(cri);
	}

	@Override //게시글 내용 상세 확인
	public FreeBoardVO FreeBoardDetail(int bnum) throws Exception {
		return BM.FreeBoardDetail(bnum);
	}

	@Override //게시글 내용 수정
	public void FreeBoardUpdate(FreeBoardVO FBV) throws Exception {
		BM.FreeBoardUpdate(FBV);
	}
	
	@Override //게시글 삭제
	public void FreeBoardDelete(int bnum) throws Exception {
		BM.FreeBoardDelete(bnum);
	}

	@Override //게시글 댓글 확인
	public List<FreeBoardReplyVO> FreeBoardReplyList(int bnum) throws Exception {
		return BM.FreeBoardReplyList(bnum);
	}

	@Override
	public void FreeBoardReplyWrite(FreeBoardReplyVO FBReply) throws Exception {
		BM.FreeBoardReplyWrite(FBReply);
	}

	@Override // 게시글 댓글 삭제
	public void FreeBoardDeleteReply(int rnum) throws Exception {
		BM.FreeBoardDeleteReply(rnum);
	}

	@Override
	public int FreeBoardReplyCount(int boardNum) throws Exception {
		return BM.FreeBoardReplyCount(boardNum);
	}



}
