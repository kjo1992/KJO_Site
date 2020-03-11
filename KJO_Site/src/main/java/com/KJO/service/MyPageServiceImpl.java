package com.KJO.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KJO.mapper.MyPageMapper;
import com.KJO.model.Criteria;
import com.KJO.model.LoginVO;
import com.KJO.model.UserVO;
import com.KJO.model.orderBoardVO;

@Service
public class MyPageServiceImpl implements MyPageService{
	@Autowired
	private MyPageMapper MM;

	//마이페이지 로드
	@Override
	public UserVO UserInfoGet(LoginVO LoginUser) throws Exception {
		return MM.UserInfoGet(LoginUser);
	}
	
	//내가 작성한 게시글, 댓글 가져오기
	@Override
	public Map<String, List> MyFBListGet(Map<String, Object> map) throws Exception {
		return MM.MyFBListGet(map);
	}
	
	//주문목록 가져오기
	@Override
	public List<orderBoardVO> myOrderList(LoginVO LoginUser) throws Exception {
		return MM.myOrderList(LoginUser);
	}
	
	//회원탈퇴
	@Override
	public void UserDelete(LoginVO LoginUser) throws Exception {
		MM.UserDelete(LoginUser);
	}
	
	//회원정보 변경
	@Override
	public int UserUpdate(Map<String, Object> map) throws Exception {
		return MM.UserUpdate(map);
	}

	//프로필 사진 변경
	@Override
	public int imgUpdate(LoginVO LoginUser) throws Exception {
		return MM.imgUpdate(LoginUser);
	}
	
	//비밀번호 확인
	@Override
	public int pwChk(Map<String, String> map) throws Exception {
		return MM.pwChk(map);
	}

	@Override
	public List<Map> myProductReply(Map<String, Object> map) throws Exception {
		return MM.myProductReply(map);
	}

}
