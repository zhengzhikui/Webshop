package com.shop.service;

import java.util.List;

import com.shop.model.CategorySecond;

public interface AdminCategorySecondService {
	
	public List<CategorySecond> listCategorySecond(Integer page);

	//ͳ�ƶ�������ĸ���
	public Integer countCategorySecond();
	
	//�����������
	public void addCategorySecond(CategorySecond categorySecond); 

	//ɾ����������
	public void deleteCategorySecond(Integer csid); 

	//���Ҿ���ĳ����������
	public CategorySecond findCategorySecond(Integer csid); 

	//���¶�������
	public void updateCategorySecond(CategorySecond categorySecond);
	
	//�������еĶ�������
	public List<CategorySecond> listCategorySecond();
}
