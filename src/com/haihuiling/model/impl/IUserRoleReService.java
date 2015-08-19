package com.haihuiling.model.impl;

import java.util.List;

import com.haihuiling.beans.UserRoleRelationship;
/**
 * 
 * @author haihuiling
 * @date 2015-8-18 上午10:22:48
 */
public interface IUserRoleReService {
	public void addUserRoleRe(UserRoleRelationship userRoleRelationship);
	public void deleteUserRoleRe(String[] pk);
	public void modifyUserRoleRe(String pk,UserRoleRelationship userRoleRelationship);
	public Object getById(String pk);
	public void doSubmitRoles(String qqId,String[] userSelectedRoles);
	public List<Object> getUserRoleInfoByRoleId(String roleId);
	public void openUserRole(String pk);
	public void forbidUserRole(String pk);
	public  List<Object> getUserListHavaNoTheRole(String roleid);
}
