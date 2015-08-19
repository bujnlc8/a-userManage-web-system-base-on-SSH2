package com.haihuiling.model.impl;

import java.util.List;

import com.haihuiling.beans.UserRole;

public interface IUserRoleService {
	public void addRole(UserRole userRole);
	public void deleteRole(String[] pk);
	public void updateRole(UserRole userRole);
	public List<Object> getRoleList();
	public Object getById(String pk);
}
