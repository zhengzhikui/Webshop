package com.shop.dao;

import java.util.List;

import com.shop.model.Order;
import com.shop.model.OrderItem;


public interface OrderDao extends BaseDao<Order>{
	

	// Dao���ѯ�ҵĶ�����ҳ��ѯ:ͳ�Ƹ���
	public int findCountByUid(Integer uid);

	// Dao���ѯ�ҵĶ�����ҳ��ѯ:��ѯ����
	public List<Order> findPageByUid(Integer uid, int begin, int limit);

	// DAO����ݶ���id��ѯ����
	public Order findByOid(Integer oid);

	// DAO��ͳ�ƶ��������ķ���
	public int findCount();

	// DAO�з�ҳ��ѯ�����ķ���
	public List<Order> findByPage(int begin, int limit);
	// DAo�и��ݶ���id��ѯ������
	public List<OrderItem> findOrderItem(Integer oid);
}
