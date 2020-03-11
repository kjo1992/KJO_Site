package com.KJO.model;

import java.util.Date;

public class productReplyVO {
	private int productListNum;
	private String userNum;
	private String userName;
	private String replyText;
	private double rating;
	private Date regDate;
	
	public int getProductListNum() {
		return productListNum;
	}
	public void setProductListNum(int productListNum) {
		this.productListNum = productListNum;
	}
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
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "productReplyVO [productListNum=" + productListNum + ", userNum=" + userNum + ", userName=" + userName
				+ ", replyText=" + replyText + ", rating=" + rating + ", regDate=" + regDate + "]";
	}
}
