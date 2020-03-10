package com.KJO.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.KJO.model.Criteria;
import com.KJO.model.FreeBoardVO;
import com.KJO.model.LoginVO;
import com.KJO.model.UserVO;
import com.KJO.model.orderBoardVO;

@Repository
public class MyPageMapperImpl implements MyPageMapper{
	
	@Autowired
	private SqlSession SQL;
	private static final String path="com.KJO.mapper.MyPageMapper";
	
	//마이페이지 로드
	@Override
	public UserVO UserInfoGet(LoginVO LoginUser) throws Exception {
		return SQL.selectOne(path+".UserInfoGet", LoginUser);
	}
	
	//내가 작성한 게시글, 댓글 목록 가져오기
	@Override
	public Map<String, List> MyFBListGet(Map<String, Object> map) throws Exception {
		Map<String, List> MyBoard = new HashMap<>();
		MyBoard.put("FreeBoardList", SQL.selectList(path+".FreeBoardList", map));
		MyBoard.put("FreeBoardReply", SQL.selectList(path+".FreeBoardReply", map));
		return MyBoard;
	}
	
	//주문목록 가져오기
	@Override
	public List<orderBoardVO> myOrderList(LoginVO LoginUser) throws Exception {
		List<orderBoardVO> list = SQL.selectList(path+".myOrderList", LoginUser);
		return list;
	}
	
	//회원탈퇴
	@Override
	public void UserDelete(LoginVO LoginUser) throws Exception {
		SQL.delete(path+".UserDelete", LoginUser);
	}
	
	//회원정보 수정
	@Override
	public int UserUpdate(Map<String, Object> map) throws Exception {
		return SQL.update(path+".UserUpdate", map);
	}

	//프로필 이미지 변경
	@Override
	public int imgUpdate(LoginVO LoginUser) throws Exception {
		return SQL.update(path+".imgUpdate", LoginUser);
	}

	//비밀번호 재확인
	public int pwChk(Map<String, String> map) throws Exception {
		return SQL.selectOne(path+".pwChk", map);
	}

}
