package com.KJO.model;

import java.util.Date;

public class ProductBoardVO {
	private Integer productNum;
	private String productName;
	private int productPrice;
	private String typeNum;
	private String typeName;
	private String productImgPath;
	private Date regDate;
	private int rating;
	
	public Integer getProductNum() {
		return productNum;
	}
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getTypeNum() {
		return typeNum;
	}
	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getProductImgPath() {
		return productImgPath;
	}
	public void setProductImgPath(String productImgPath) {
		this.productImgPath = productImgPath;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "ProductBoardVO [productNum=" + productNum + ", productName=" + productName + ", productPrice="
				+ productPrice + ", typeNum=" + typeNum + ", typeName=" + typeName + ", productImgPath="
				+ productImgPath + ", regDate=" + regDate + ", rating=" + rating + "]";
	}
	
	
}
