package com.eshop.base;

import java.io.Serializable;


public interface BaseDao<T> {

	public  void save(T entity);

	public void delete(Serializable entityid);

	public void update(T entity);
	
	public void query(Serializable entityid);
	
	public Integer getCount();
}
