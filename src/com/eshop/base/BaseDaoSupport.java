package com.eshop.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;


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

	
}
