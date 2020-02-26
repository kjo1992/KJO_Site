package com.KJO.model;

import java.util.Date;

public class FreeBoardVO {
	Date date = new Date();
	
	private String boardNum;
	private String boardCategory;
	private String writerNum;
	private String writerName;
	private String boardSubject;
	private String boardContent;
	private Date boardWriteDate;
	//private SimpleDateFormat FB_writeDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Date boardUpdateDate;
	//private SimpleDateFormat FB_updateDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int boardReadCnt;
	private int replyCount;
	
	public String getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}
	public String getWriterNum() {
		return writerNum;
	}
	public void setWriterNum(String writerNum) {
		this.writerNum = writerNum;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getBoardWriteDate() {
		return boardWriteDate;
	}
	public void setBoardWriteDate(Date boardWriteDate) {
		this.boardWriteDate = boardWriteDate;
	}
	public Date getBoardUpdateDate() {
		return boardUpdateDate;
	}
	public void setBoardUpdateDate(Date boardUpdateDate) {
		this.boardUpdateDate = boardUpdateDate;
	}
	public int getBoardReadCnt() {
		return boardReadCnt;
	}
	public void setBoardReadCnt(int boardReadCnt) {
		this.boardReadCnt = boardReadCnt;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	@Override
	public String toString() {
		return "FreeBoardVO [boardNum=" + boardNum + ", boardCategory=" + boardCategory + ", writerNum=" + writerNum
				+ ", writerName=" + writerName + ", boardSubject=" + boardSubject + ", boardContent=" + boardContent
				+ ", boardWriteDate=" + boardWriteDate + ", boardUpdateDate=" + boardUpdateDate + ", boardReadCnt="
				+ boardReadCnt + ", replyCount=" + replyCount + "]";
	}
	
	
}
