package com.KJO.mapper;

import java.util.List;
import java.util.Map;

import com.KJO.model.Criteria;
import com.KJO.model.FreeBoardVO;
import com.KJO.model.LoginVO;
import com.KJO.model.UserVO;

public interface MyPageMapper {
	
	//마이페이지 이동
	public UserVO UserInfoGet(LoginVO LoginUser) throws Exception;
	
	//내가 작성한 게시글, 댓글 목록 가져오기
	public Map<String, List> MyFBListGet(Map<String, Object> map) throws Exception;
	
	//회원탈퇴
	public void UserDelete(LoginVO LoginUser) throws Exception;
	
	//회원정보수정
	public int UserUpdate(Map<String, Object> map) throws Exception;
	
	//프로필 이미지 변경
	public int imgUpdate(LoginVO LoginUser) throws Exception;
	
	//비밀번호 재확인
	public int pwChk(Map<String, String> map) throws Exception;
}