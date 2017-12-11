package com.shop.dao;

import java.util.List;

import com.shop.model.Category;

public interface CategoryDao extends BaseDao<Category>{
	//��ѯһ��������ܵĸ���
	public Integer countCategory();
	//��ҳ���������û�
	public List<Category> findAll(Integer page);
	
	public List<Category> findAll();
	
	public Category findOne(Integer cid);
}
