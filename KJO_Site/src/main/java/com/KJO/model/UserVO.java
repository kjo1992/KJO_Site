package com.KJO.model;

import java.util.Date;

public class UserVO {
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private String pwSearchQuestion;
	private String pwSearchAnswer;
	private String authority;
	private Date userRegDate;
	private Date lastLoginDate;
	private String profileImg;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPwSearchAnswer() {
		return pwSearchAnswer;
	}
	public void setPwSearchAnswer(String pwSearchAnswer) {
		this.pwSearchAnswer = pwSearchAnswer;
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
	public String getPwSearchQuestion() {
		return pwSearchQuestion;
	}
	public void setPwSearchQuestion(String pwSearchQuestion) {
		this.pwSearchQuestion = pwSearchQuestion;
	}
	public Date getUserRegDate() {
		return userRegDate;
	}
	public void setUserRegDate(Date userRegDate) {
		this.userRegDate = userRegDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", pwSearchQuestion=" + pwSearchQuestion + ", pwSearchAnswer=" + pwSearchAnswer + ", authority="
				+ authority + ", userRegDate=" + userRegDate + ", lastLoginDate=" + lastLoginDate + ", profileImg="
				+ profileImg + "]";
	}
	
	
}
