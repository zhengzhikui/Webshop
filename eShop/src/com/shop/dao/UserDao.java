package com.shop.dao;

import java.util.List;
import com.shop.model.User;

public interface UserDao extends BaseDao<User>{
	
    //�����û�����ѯ�û�
	public User findByUsername(String userName);
	//�����û����������ѯ�û�
	public User findByUsernameAndPassword(String username,String password);
	//���ݼ������ѯ�û�
	public User findByCode(String code);
	//��ѯ�ж��ٸ��û�
	public Integer countUser();
	//��ҳ���������û�
	public List<User> findAll(Integer page);
	//���ҵ����û�
	public User findOne(Integer uid);
	
}
