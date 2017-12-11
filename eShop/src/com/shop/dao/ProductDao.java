package com.shop.dao;

import java.util.List;

import com.shop.model.Product;

public interface ProductDao extends BaseDao<Product>{
	
	
	public List<Product> findHot();
	
	public List<Product> findNew();
	//���ݶ��������ѯ��Ʒ
	public List<Product> findByCategorySecondCsid(Integer csid,Integer page);
	
	//����һ�������ѯ��Ʒ
	public List<Product> findByCategorySecondCategoryCid(Integer cid,Integer page);

	public Integer CountPageProductFromCategory(Integer cid);
	
	public Integer CountPageProductFromCategorySecond(Integer csid);
	
	public Integer CountProduct();
	
	public Product findOne(Integer pid);
	
	public List<Product> findAll(Integer page);
}
