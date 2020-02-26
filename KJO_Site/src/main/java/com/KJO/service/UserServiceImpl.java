package com.KJO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KJO.mapper.UserMapper;
import com.KJO.model.LoginVO;
import com.KJO.model.UserVO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper UM;

	@Override
	public LoginVO Login(UserVO UV) throws Exception {
		return UM.Login(UV);
	}

	@Override
	public void MemberAdd(UserVO UV) throws Exception {
		UM.MemberAdd(UV);
	}

	@Override
	public int IDChk(String ChkValue) throws Exception {
		return UM.IDChk(ChkValue);
	}

	@Override
	public int NameChk(String ChkValue) throws Exception {
		return UM.NameChk(ChkValue);
	}

	@Override
	public int EmailChk(String ChkValue) throws Exception {
		return UM.EmailChk(ChkValue);
	}
	


}
