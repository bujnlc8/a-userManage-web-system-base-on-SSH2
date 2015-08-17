package com.haihuiling.model.realize;

import java.util.List;

import com.haihuiling.ado.impl.IUserInfoDAO;
import com.haihuiling.beans.Userinfo;
import com.haihuiling.model.impl.IUserInfoService;

/**
 * 
 * @author haihuiling
 * @date 2015-8-12
 */
public class UserInfoService implements IUserInfoService {
	private IUserInfoDAO userInfoDAO;

	/**
	 * 获取user列表
	 */
	public List<Object> getUserInfoList(String userName, String userAge,
			String userBirthday, String userSex, String userAddress,
			String userRole) {
		return userInfoDAO.getUserInfoList(userName, userAge, userBirthday,
				userSex, userAddress, userRole);
	}

	/**
	 * 删除User
	 */
	public void deleteUser(String[] pks) {
		userInfoDAO.deleteUser(pks);

	}

	/**
	 * 更新user
	 */
	public void updateUser(Userinfo user) {
		userInfoDAO.updateUser(user);

	}

	/**
	 * 增加新user
	 */
	public void addUser(Userinfo user) {
		userInfoDAO.addUser(user);
	}
	/**
	 * 获取所有的user
	 */
	public List<Object> getUserInfoList() {
		return userInfoDAO.getUserInfoList();
	}
	/**
	 * get object by id
	 */
	public Object getById(String pk) {
		return userInfoDAO.getById(pk);
	}
	public List<Object> getUserInfoSubAdmin() {
		return userInfoDAO.getUserInfoSubAdmin();
	}
	/**
	 * 根据id获得包括role信息在内的人员信息
	 */
	public Object getUserInfoWithRoleById(String pk) {
		return userInfoDAO.getUserInfoWithRoleById(pk);
	
	}
	/**
	 * 获取某个人员已经被赋予的角色
	 */
	public List<Object> getUserSelectedRole(String pk) {
		return userInfoDAO.getUserSelectedRole(pk);
		
	}
	/**
	 * 获取某个人员未被赋予的角色
	 */
	public List<Object> getUserUnSelectedRole(String pk) {
		return userInfoDAO.getUserUnSelectedRole(pk);
	}
	/********************************************** setter and getter ************************/
	public IUserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	public void setUserInfoDAO(IUserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}
}
