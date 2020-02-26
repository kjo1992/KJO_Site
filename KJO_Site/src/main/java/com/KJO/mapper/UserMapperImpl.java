package com.KJO.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.KJO.model.LoginVO;
import com.KJO.model.UserVO;

@Repository
public class UserMapperImpl implements UserMapper{
	@Autowired
	private SqlSession SQL;
	private static final String path="com.KJO.mapper.UserMapper";
	
	@Override
	public LoginVO Login(UserVO UV) throws Exception {
		LoginVO LoginUser = SQL.selectOne(path+".Login",UV);
		SQL.update(path+".LastLoginDate", UV);
		return LoginUser;
	}

	@Override
	public void MemberAdd(UserVO UV) throws Exception {
		SQL.insert(path+".MemberAdd", UV);
	}

	@Override
	public int IDChk(String ChkValue) throws Exception {
		return SQL.selectOne(path+".IDChk", ChkValue);
	}

	@Override
	public int NameChk(String ChkValue) throws Exception {
		return SQL.selectOne(path+".NameChk", ChkValue);
	}

	@Override
	public int EmailChk(String ChkValue) throws Exception {
		return SQL.selectOne(path+".EmailChk", ChkValue);
	}


	
}
