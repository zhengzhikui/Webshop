package com.shop.service;

import java.util.List;

import com.shop.model.Category;

public interface AdminCategoryService {
	
	// ��ҳ��ѯһ������
	public List<Category> listCategory(Integer page);
	
	// ��ѯһ�������ҳ��
	public Integer countCategory();
	
	//��Ӷ�������
	public void addCategory(Category category);
	
	//ɾ����������
	public void deleteCategory(Integer cid);

	//��ѯĳ�������һ������
	public Category findCategory(Integer cid);

	//����һ������
	public void updateCategory(Category category);

	public List<Category> findCategory();
}
