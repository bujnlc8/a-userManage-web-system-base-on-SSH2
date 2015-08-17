package com.haihuiling.ado.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.haihuiling.beans.Useradmin;
/**
 * 管理员接口
 * @author haihuiling
 *
 */
public interface IUserAdminDAO{
	public void addUserAdmin(Useradmin useradmin);
	public void deleteUserAdmin(String[] pks);
	public void updateUserAdmin(Useradmin useradmin);
	public List<Object> getUserAdminInfoList();
	public String isUserAdminValid(String UserAdminName,String UserAdminPassword);
	public Object getById(String pk);
}
