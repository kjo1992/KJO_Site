package com.KJO.mapper;

import com.KJO.model.LoginVO;
import com.KJO.model.UserVO;

public interface UserMapper { //유저등록,로그인 등에 관련된 것들 처리
	public LoginVO Login(UserVO UV) throws Exception; 
	
	public void MemberAdd(UserVO UV) throws Exception;
	
	public int IDChk(String ChkValue) throws Exception;
	
	public int NameChk(String ChkValue) throws Exception;
	
	public int EmailChk(String ChkValue) throws Exception;
}
