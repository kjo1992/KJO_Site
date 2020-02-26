package com.KJO.model;

public class PageVO {
	//페이지별 이동버튼을 위한 클래스
	
	private int startPage;
	private int endPage;
	private int realEnd;
	
	//이전,다음페이징 목록 활성화 버튼을 위한 변수
	private boolean prev;
	private boolean next;
	
	//조건에 부합한 게시글 총 갯수
	private int total;
	private Criteria cri;
	
	public PageVO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage=(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage=this.endPage-9;
		
		this.realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage>1;
		this.next = this.endPage<realEnd;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRealEnd() {
		return realEnd;
	}

	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageVO [startPage=" + startPage + ", endPage=" + endPage + ", realEnd=" + realEnd + ", prev=" + prev
				+ ", next=" + next + ", total=" + total + ", cri=" + cri + "]";
	}

	
}
