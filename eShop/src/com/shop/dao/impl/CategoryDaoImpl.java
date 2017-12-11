package com.shop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.shop.dao.CategoryDao;
import com.shop.model.Category;

@Repository("categoryDao")
@SuppressWarnings("all")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao{

	public Integer countCategory() {
		String hql = "select count(*) from Category";
		return count(hql);
	}

	public List<Category> findAll() {
		String hql = "from Category";
		return find(hql);
	}

	public Category findOne(Integer cid) {
		String hql = "from Category c where c.cid = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, cid);
		return (Category)query.uniqueResult(); 
	}

	public List<Category> findAll(Integer page) {
		String hql = "from Category";
		int rows = 10;
		int page1 = page;
		return find(hql, page1, rows);
	}

}
