package com.haihuiling.model.impl;

import java.util.List;

import com.haihuiling.beans.Useradmin;

public interface IUserAdminService {
	public String isUserAdminValid(String UserAdminName,String UserAdminPassword);
	public void addUserAdmin(Useradmin useradmin);
	public void deleteUserAdmin(String[] pks);
	public void updateUserAdmin(Useradmin useradmin);
	public List<Object> getUserAdminInfoList();
}
