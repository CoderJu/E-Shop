package com.eshop.base.bean;

import java.util.List;

public class QueryResult<T> {

	private List<T> resultList;
	private Long totalRecoder;
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	public Long getTotalRecoder() {
		return totalRecoder;
	}
	public void setTotalRecoder(long totalRecoder) {
		this.totalRecoder = totalRecoder;
	}
	
	
}
