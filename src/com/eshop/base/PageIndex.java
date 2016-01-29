package com.eshop.base;


public class PageIndex {
	private Long startIndex;
	private Long endIndex;
	
	
	public Long getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Long startIndex) {
		this.startIndex = startIndex;
	}
	public Long getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(Long endIndex) {
		this.endIndex = endIndex;
	}
	public PageIndex(Long startIndex, Long endIndex) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	public static PageIndex getPageIndex(long viewPageCount, int currentPage, long totalPage){
		long startPage = currentPage-(viewPageCount%2==0? viewPageCount/2-1 : viewPageCount/2);
		long endPage = currentPage+viewPageCount/2;
		if(startPage<1){
			startPage = 1;
			if(totalPage>=viewPageCount) endPage = viewPageCount;
			else endPage = totalPage;
		}
		if(endPage>totalPage){
			endPage = totalPage;
			if((endPage-viewPageCount)>0) startPage = endPage-viewPageCount+1;
			else startPage = 1;
		}
		return new PageIndex(startPage, endPage);			
	}

}
