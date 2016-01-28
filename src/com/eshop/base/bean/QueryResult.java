package com.eshop.base.bean;

import java.util.List;

public class QueryResult<T> {

	private List<T> resultList;
	private Integer totalRecoder;
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	public Integer getTotalRecoder() {
		return totalRecoder;
	}
	public void setTotalRecoder(Integer totalRecoder) {
		this.totalRecoder = totalRecoder;
	}
	
	
}
