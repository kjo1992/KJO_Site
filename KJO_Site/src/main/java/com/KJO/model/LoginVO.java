package com.KJO.model;

public class LoginVO {
	private String userNum;
	private String userName;
	private String authority;
	private String profileImg;
	private boolean userCookie;
	
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isUserCookie() {
		return userCookie;
	}
	public void setUserCookie(boolean userCookie) {
		this.userCookie = userCookie;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	
	@Override
	public String toString() {
		return "LoginVO [userNum=" + userNum + ", userName=" + userName + ", authority=" + authority + ", profileImg="
				+ profileImg + ", userCookie=" + userCookie + "]";
	}
	
	
	
	
}
