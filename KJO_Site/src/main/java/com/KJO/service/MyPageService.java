package com.KJO.service;

import java.util.List;
import java.util.Map;

import com.KJO.model.Criteria;
import com.KJO.model.LoginVO;
import com.KJO.model.UserVO;
import com.KJO.model.orderBoardVO;

public interface MyPageService {
	//마이페이지 로드
	public UserVO UserInfoGet(LoginVO LoginUser) throws Exception;
	
	//내가쓴 게시판 글, 댓글 가져오기
	public Map<String, List> MyFBListGet(Map<String, Object> map) throws Exception;
	
	//주문목록 가져오기
	public List<orderBoardVO> myOrderList(LoginVO LoginUser) throws Exception;
	
	//회원탈퇴
	public void UserDelete(LoginVO LoginUser) throws Exception;
	
	//회원정보 수정
	public int UserUpdate(Map<String, Object> map) throws Exception;
	
	//프로필 사진 변경
	public int imgUpdate(LoginVO LoginUser) throws Exception;
	
	//비밀번호 재확인
	public int pwChk(Map<String, String> map) throws Exception;
}
