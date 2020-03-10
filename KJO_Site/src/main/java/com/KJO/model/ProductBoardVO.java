package com.KJO.model;

import java.util.Date;

public class ProductBoardVO {
	private Integer productListNum;
	private String typeNum;
	private String typeName;
	private String productName;
	private int productPrice;
	private String productImgPath_0;
	private String productImgPath_1;
	private String productImgPath_2;
	private String productImgPath_3;
	private Date regDate;
	private int rating;
	private int amount;
	
	public Integer getproductListNum() {
		return productListNum;
	}



	public void setproductListNum(Integer productListNum) {
		this.productListNum = productListNum;
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



	public String getProductImgPath_0() {
		return productImgPath_0;
	}



	public void setProductImgPath_0(String productImgPath_0) {
		this.productImgPath_0 = productImgPath_0;
	}



	public String getProductImgPath_1() {
		return productImgPath_1;
	}



	public void setProductImgPath_1(String productImgPath_1) {
		this.productImgPath_1 = productImgPath_1;
	}



	public String getProductImgPath_2() {
		return productImgPath_2;
	}



	public void setProductImgPath_2(String productImgPath_2) {
		this.productImgPath_2 = productImgPath_2;
	}



	public String getProductImgPath_3() {
		return productImgPath_3;
	}



	public void setProductImgPath_3(String productImgPath_3) {
		this.productImgPath_3 = productImgPath_3;
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



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	@Override
	public String toString() {
		return "ProductBoardVO [productListNum=" + productListNum + ", typeNum=" + typeNum + ", typeName=" + typeName
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", productImgPath_0="
				+ productImgPath_0 + ", productImgPath_1=" + productImgPath_1 + ", productImgPath_2=" + productImgPath_2
				+ ", productImgPath_3=" + productImgPath_3 + ", regDate=" + regDate + ", rating=" + rating + "]";
	}
	
	
	
}
