package com.eshop.base;

import java.util.LinkedHashMap;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.base.bean.QueryResult;


@Transactional
public abstract class BaseDaoSupport implements BaseDao {

	@PersistenceContext
	protected EntityManager em;
	
	
	@Override
	public void save(Object entity) {
		em.persist(entity);
	}

	@Override
	public <T> void delete(Class<T> entityClass, Object entityid) {
		delete(entityClass, new Object[]{entityid});
	}

	@Override
	public <T> void delete(Class<T> entityClass, Object[] entityids) {
		for (Object entityid : entityids) {
			em.remove(em.getReference(entityClass, entityid));
		}
	}

	@Override
	public <T> void update(Object entity) {
		em.merge(entity);
	}
 
	@Override
	public <T> T query(Class<T> entityClass, Object entityid) {
		return em.find(entityClass, entityid);
	}
	
	
	

	@Override
	public <T> QueryResult<T> getPagination(Class<T> entityClass) {
		return getPagination(entityClass,-1,-1);
	}

	@Override
	public <T> QueryResult<T> getPagination(Class<T> entityClass,
			int fristIndex, int maxResult) {
		return getPagination(entityClass,fristIndex,maxResult,null,null,null);

	}

	@Override
	public <T> QueryResult<T> getPagination(Class<T> entityClass,
			int fristIndex, int maxResult, Object[] params, String wherejpql) {
		return getPagination(entityClass,fristIndex,maxResult,params,wherejpql,null);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public <T> QueryResult<T> getPagination(Class<T> entityClass,int fristIndex,
			int maxResult,Object[] params,String wherejpql,LinkedHashMap<String, String> orderby) {
		QueryResult<T> queryResult = new QueryResult<T>();
		String entityName = getEntityName(entityClass);
		Query query = 
				em.createQuery("select o from "+ entityName+ " o "+(wherejpql==null?"":"where "+wherejpql)+ bulidorderby(orderby));
		setQueryParams(query, params);
		if (fristIndex!=-1&& maxResult!=-1)
			query.setFirstResult(fristIndex).setMaxResults(maxResult);
		queryResult.setResultList(query.getResultList());
		query = 
				em.createQuery("select count(o) from "+ entityName+ " o "+(wherejpql==null?"":"where "+wherejpql) );
		setQueryParams(query, params);
		queryResult.setTotalRecoder((Long) query.getSingleResult());
		return queryResult;
		
	}
	
	protected void setQueryParams(Query query,Object[] queryParams) {
		if (queryParams!=null && queryParams.length>0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(i+1, queryParams[i]);
			}
		}
	}
	
	private String bulidorderby(LinkedHashMap<String, String> orderby) {
		StringBuffer orderbyjpql = new StringBuffer("");
		if (orderby!=null && orderby.size()>0) {
			orderbyjpql.append(" order by ");
			for (String key : orderby.keySet()) {
				orderbyjpql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
			}
			orderbyjpql.deleteCharAt(orderbyjpql.length()-1);
		}
		return orderbyjpql.toString();
	}

	protected <T> String getEntityName(Class<T> entityClass) {
		String entityName = entityClass.getSimpleName();
		Entity entity = entityClass.getAnnotation(Entity.class);
		if (entity.name()!=null && !"".equals(entity.name())) {
			entityName = entity.name();
		}
		return entityName;
	}
	

	
}
