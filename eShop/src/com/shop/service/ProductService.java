package com.shop.service;

import java.util.List;

import com.shop.model.Product;

public interface ProductService {
	
	//���ݶ��������ѯ��Ʒ
	public List<Product> findByCsid(Integer csid, Integer page);

	//����һ�������ѯ��Ʒ
	public List<Product> findByCid(Integer cid,Integer page);
	
	//�������ȵ���Ʒ10��
	public List<Product> findHot();
	
	//�������µ���Ʒ10��
	public List<Product> findNew();

	//������Ʒ��pid��ֵ��ѯ��Ʒ
	public Product findByPid(Integer pid);
	
	//����һ���ж���ҳ������
	public Integer CountPageProductFromCategory(Integer cid);

	//���ض����������ζ��ٵ�����
	public Integer CountPageProductFromCategorySecond(Integer csid);

}
