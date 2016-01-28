package com.eshop.base;




public interface BaseDao{

	public void save(Object entity);

	public <T> void delete(Class<T> entityClass, Object entityid);
	
	public <T> void delete(Class<T> entityClass, Object[] entityids);

	public <T> void update( Object entity);
	
	public <T> T query(Class<T> entityClass,Object entityid);
	
}
