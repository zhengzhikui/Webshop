package com.shop.dao;

import com.shop.model.Admin;

public interface AdminDao extends BaseDao<Admin>{
	public Admin findByAdminnameAndPassword(String username,String password);
}
