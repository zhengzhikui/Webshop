package com.shop.service;

import java.util.List;

import com.shop.model.Admin;
import com.shop.model.User;

public interface AdminService {
	
	public void updateUser(User user);
	
	public Admin checkUser(Admin admin);
	
	public void deleteUser(Integer uid) ;

	// ��ѯ���е��û�
	public List<User> findUser(Integer page);

	// ͳ���ж���ҳ���û�
	public Integer countUser() ;

	// �����û���uid��ѯ�û���Ϣ
	public User findUserByUid(Integer uid);
}
