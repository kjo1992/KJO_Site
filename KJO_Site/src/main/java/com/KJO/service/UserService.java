package com.KJO.service;

import com.KJO.model.LoginVO;
import com.KJO.model.UserVO;

public interface UserService {
	public LoginVO Login(UserVO UV) throws Exception;
	
	public void MemberAdd(UserVO UV) throws Exception;
	
	public int IDChk(String ChkValue) throws Exception;
	
	public int NameChk(String ChkValue) throws Exception;
	
	public int EmailChk(String ChkValue) throws Exception;
}
