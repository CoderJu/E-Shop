package com.eshop.product.service.impl;


import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.base.BaseDaoSupport;
import com.eshop.product.service.ProductTypeService;


@Service
@Transactional
public class ProductTypeServiceImpl extends BaseDaoSupport implements
		ProductTypeService {
	@Override
	public <T> void delete(Class<T> entityClass, Object[] entityids) {
		StringBuffer jpql = new StringBuffer();
		for (int i = 0; i < entityids.length; i++) {
			jpql.append("?").append(i+2).append(",");
		}
		jpql.deleteCharAt(jpql.length()-1);
		if (entityids != null && entityids.length>0) {
			Query query = 
			em.createQuery("update ProductTypeBean o set o.visible=?1 where o.typeId in (" +(jpql.toString())+ ")")
			.setParameter(1, false);
			for (int i = 0; i < entityids.length; i++) {
				query.setParameter(i+2, entityids[i]);
			}
			query.executeUpdate();
		}
	}

}
