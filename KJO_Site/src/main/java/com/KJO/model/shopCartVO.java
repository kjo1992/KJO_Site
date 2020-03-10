package com.KJO.model;

import java.util.Date;

public class shopCartVO {
	private Integer cartNum;
	private String userNum;
	private Integer productListNum;
	private Integer amount;
	private Date regDate;
	
	//장바구니 리스트를 위한 변수
	private String productName;
	private Integer productPrice;
	private String typeNum;
	private String productImgPath_0;
	
	public Integer getCartNum() {
		return cartNum;
	}
	public void setCartNum(Integer cartNum) {
		this.cartNum = cartNum;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public Integer getProductListNum() {
		return productListNum;
	}
	public void setProductListNum(Integer productListNum) {
		this.productListNum = productListNum;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public String getTypeNum() {
		return typeNum;
	}
	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}
	public String getProductImgPath_0() {
		return productImgPath_0;
	}
	public void setProductImgPath_0(String productImgPath_0) {
		this.productImgPath_0 = productImgPath_0;
	}
	@Override
	public String toString() {
		return "shopCartVO [cartNum=" + cartNum + ", userNum=" + userNum + ", productListNum=" + productListNum
				+ ", amount=" + amount + ", regDate=" + regDate + ", productName=" + productName + ", productPrice="
				+ productPrice + ", typeNum=" + typeNum + ", productImgPath_0=" + productImgPath_0 + "]";
	}
	
	
}
