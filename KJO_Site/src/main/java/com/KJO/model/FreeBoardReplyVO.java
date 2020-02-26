package com.KJO.model;

import java.util.Date;

public class FreeBoardReplyVO {
	private String replyNum;
	private String boardNum;
	private String replyerNum;
	private String replyerName;
	private String replyText;
	private Date replyWriteDate;
	private Date replyUpdateDate;
	
	public String getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(String replyNum) {
		this.replyNum = replyNum;
	}
	public String getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}
	public String getReplyerNum() {
		return replyerNum;
	}
	public void setReplyerNum(String replyerNum) {
		this.replyerNum = replyerNum;
	}
	public String getReplyerName() {
		return replyerName;
	}
	public void setReplyerName(String replyerName) {
		this.replyerName = replyerName;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public Date getReplyWriteDate() {
		return replyWriteDate;
	}
	public void setReplyWriteDate(Date replyWriteDate) {
		this.replyWriteDate = replyWriteDate;
	}
	public Date getReplyUpdateDate() {
		return replyUpdateDate;
	}
	public void setReplyUpdateDate(Date replyUpdateDate) {
		this.replyUpdateDate = replyUpdateDate;
	}
	@Override
	public String toString() {
		return "FreeBoardReplyVO [replyNum=" + replyNum + ", boardNum=" + boardNum + ", replyerNum=" + replyerNum
				+ ", replyerName=" + replyerName + ", replyText=" + replyText + ", replyWriteDate=" + replyWriteDate
				+ ", replyUpdateDate=" + replyUpdateDate + "]";
	}
	
	
	
	
}
