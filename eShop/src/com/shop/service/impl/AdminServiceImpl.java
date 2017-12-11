package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.AdminDao;
import com.shop.dao.UserDao;
import com.shop.model.Admin;
import com.shop.model.User;
import com.shop.service.AdminService;

@Transactional
@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Resource
	private AdminDao adminDao;
	@Resource
	private UserDao userDao;

	//�����û�
	public void updateUser(User user){
		userDao.update(user);
	}
	// �����Ñ������ܴa��ԃ
	public Admin checkUser(Admin adminUser) {
		return adminDao.findByAdminnameAndPassword(
				adminUser.getUsername(), adminUser.getPassword());
	}

	// �����û���uidɾ���û�
	public void deleteUser(Integer uid) {
		userDao.delete(uid);
	}

	// ��ѯ���е��û�
	public List<User> findUser(Integer page){
		return userDao.findAll(page);
	}

	// ͳ���ж���ҳ���û�
	public Integer countUser() {
		Integer count = userDao.countUser();
		return (count % 20 == 0 ? (count / 20) : (count / 20 + 1));
	}

	// �����û���uid��ѯ�û���Ϣ
	public User findUserByUid(Integer uid) {
		return userDao.findOne(uid);
	}
}
