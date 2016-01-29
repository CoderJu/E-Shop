package com.eshop.base;

import java.util.LinkedHashMap;

import com.eshop.base.bean.QueryResult;




public interface BaseDao{

	public void save(Object entity);

	public <T> void delete(Class<T> entityClass, Object entityid);
	
	public <T> void delete(Class<T> entityClass, Object[] entityids);

	public <T> void update( Object entity);
	
	public <T> T query(Class<T> entityClass,Object entityid);
	
	public <T> QueryResult<T> getPagination(Class<T> entityClass);
	
	public <T> QueryResult<T> getPagination(Class<T> entityClass, int fristIndex,
			int maxResult);
	
	public <T> QueryResult<T> getPagination(Class<T> entityClass,int fristIndex,
			int maxResult,Object[] params,String wherejpql) ;
	
	public <T> QueryResult<T> getPagination(Class<T> entityClass, int fristIndex,
			int maxResult, Object[] params, String wherejpql,
			LinkedHashMap<String, String> orderby);
	
}
