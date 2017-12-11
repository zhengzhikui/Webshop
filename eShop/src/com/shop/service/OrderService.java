package com.shop.service;

import java.util.List;

import com.shop.model.Order;
import com.shop.model.OrderItem;

public interface OrderService {
	
	// ҵ��㱣�涩���ķ���
	public void save(Order order) ;

	// ҵ�������û�id��ѯ����,����ҳ��ѯ.
	public List<Order> findByUid(Integer uid,Integer page);

	// ���ݶ���id��ѯ����
	public Order findByOid(Integer oid) ;

	// ҵ����޸Ķ����ķ���:
	public void update(Order currOrder) ;

	// ҵ����ѯ���ж�������
	public List<Order> findAll(Integer page) ;

	// ҵ����ѯ������ķ���
	public List<OrderItem> findOrderItem(Integer oid) ;

	public Integer findCountByUid(Integer uid);
	
}
