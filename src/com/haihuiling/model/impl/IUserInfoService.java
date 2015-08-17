package com.haihuiling.model.impl;

import java.util.List;

import com.haihuiling.beans.Userinfo;

public interface IUserInfoService {
	public List<Object> getUserInfoList(String userName,String userAge,String userBirthday,String userSex,String userAddress,String userRole);
	public void deleteUser(String[] pks);
	public void updateUser(Userinfo user);
	public void addUser(Userinfo user);
	public List<Object> getUserInfoList();
	public Object getById(String pk);
	public List<Object> getUserInfoSubAdmin();
	public Object getUserInfoWithRoleById(String pk);
	public List<Object> getUserSelectedRole(String pk);
	public List<Object> getUserUnSelectedRole(String pk);
}
