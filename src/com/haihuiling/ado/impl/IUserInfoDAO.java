package com.haihuiling.ado.impl;

import java.util.List;

import com.haihuiling.beans.Userinfo;
/**
 * 人员信息管理接口
 * @author haihuiling
 * @date 2015-8-12
 */
public interface IUserInfoDAO {
	public List<Object> getUserInfoList(String userName,String userAge,String userBirthday,String userSex,String userAddress,String userRole);
	public void deleteUser(String[] pks);
	public void updateUser(Userinfo user);
	public void addUser(Userinfo user);
	public Object getById(String pk);
	public List<Object> getUserInfoList();
	public List<Object> getUserInfoSubAdmin();
	public List<Object> getUserInfoWithRole();
	public boolean checkValid(String name);
	public Object getUserInfoWithRoleById(String pk);
	public List<Object> getUserSelectedRole(String pk);
	public List<Object> getUserUnSelectedRole(String pk);
}
