package com.haihuiling.ado.impl;

import com.haihuiling.beans.UserRoleRelationship;

/**
 * 
 * @author haihuiling
 * @date 2015-8-17 上午9:27:10
 */
public interface IUserRoleReDAO {
	public void addUserRoleRe(UserRoleRelationship userRoleRelationship);
	public void deleteUserRoleRe(String pk);
	public void modifyUserRoleRe(UserRoleRelationship userRoleRelationship);
	public Object getById(String pk);
	public void doSubmitRoles(String qqId,String[] userSelectedRoles);
}
