package com.haihuiling.model.impl;

import com.haihuiling.beans.UserRoleRelationship;

public interface IUserRoleReService {
	public void addUserRoleRe(UserRoleRelationship userRoleRelationship);
	public void deleteUserRoleRe(String pk);
	public void modifyUserRoleRe(UserRoleRelationship userRoleRelationship);
	public Object getById(String pk);
	public void doSubmitRoles(String qqId,String[] userSelectedRoles);

}
