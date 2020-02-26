package com.KJO.model;

public class Criteria {
	//페이지 번호
	private int pageNum;
	
	//한 페이지에 출력될 갯수
	private int amount;
	
	//검색할 키워드
	private String keyword=null;
	
	//검색 옵션
	private String searchOption="";
	
	//생성자, 초기페이지를 불러오기 위함
	public Criteria() {
		this(1, 10);
	}
	
	//페이지징 처리를 위한 생성자
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", searchOption="
				+ searchOption + "]";
	}

		
	
}
