package com.KJO.model;

import java.util.Date;

public class orderBoardVO {
	//orderBoardVO
	private String orderNum;
	private String userNum;
	private String recipient;
	private String recipientAdrress;
	private String recipientContact;
	private int totalPrice;
	private Date orderDate;
	
	//orderBoardDetailVO
	private int orderDetailNum;
	private int productListNum;
	private int amount;
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getRecipientAdrress() {
		return recipientAdrress;
	}
	public void setRecipientAdrress(String recipientAdrress) {
		this.recipientAdrress = recipientAdrress;
	}
	public String getRecipientContact() {
		return recipientContact;
	}
	public void setRecipientContact(String recipientContact) {
		this.recipientContact = recipientContact;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderDetailNum() {
		return orderDetailNum;
	}
	public void setOrderDetailNum(int orderDetailNum) {
		this.orderDetailNum = orderDetailNum;
	}
	public int getProductListNum() {
		return productListNum;
	}
	public void setProductListNum(int productListNum) {
		this.productListNum = productListNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "orderBoardVO [orderNum=" + orderNum + ", userNum=" + userNum + ", recipient=" + recipient
				+ ", recipientAdrress=" + recipientAdrress + ", recipientContact=" + recipientContact + ", totalPrice="
				+ totalPrice + ", orderDate=" + orderDate + ", orderDetailNum=" + orderDetailNum + ", productListNum="
				+ productListNum + ", amount=" + amount + "]";
	}
	
	
	
}
