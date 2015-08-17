package com.haihuiling.ado.impl;

import java.util.List;

import com.haihuiling.beans.UserRole;

/**
 * 
 * @author haihuiling
 * @date 2015-8-17 上午9:25:22
 */
public interface IUserRoleDAO {
	public void addRole(UserRole userRole);
	public void deleteRole(String[] pk);
	public void updateRole(UserRole userRole);
	public List<Object> getRoleList();
	public Object getById(String pk);
}
