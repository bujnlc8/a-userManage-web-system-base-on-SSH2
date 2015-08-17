package com.haihuiling.model.realize;

import java.util.List;

import com.haihuiling.ado.impl.IUserAdminDAO;
import com.haihuiling.beans.Useradmin;
import com.haihuiling.model.impl.IUserAdminService;
/**
 * 
 * @author haihuiling
 * @date 2015-8-12 下午4:18:07
 */
public class UserAdminServiceImpl implements IUserAdminService{
	private IUserAdminDAO userAdminDAO;
/**
 * 增加管理员信息
 */
	public void addUserAdmin(Useradmin useradmin) {
		userAdminDAO.addUserAdmin(useradmin);
		
	}

	/**
	 * 删除管理员信息
	 */
	public void deleteUserAdmin(String[] pks) {
		userAdminDAO.deleteUserAdmin(pks);
		
	}

	/**
	 * 更新管理员信息
	 */
	public void updateUserAdmin(Useradmin useradmin) {
		userAdminDAO.updateUserAdmin(useradmin);
		
	}

	/**
	 * 获取管理员信息列表
	 */
	public List<Object> getUserAdminInfoList() {
		return userAdminDAO.getUserAdminInfoList();
	}

	/**
	 * 判断输入的管理员用户名和密码是否有效
	 * 
	 */
	public String isUserAdminValid(String UserAdminName,
			String UserAdminPassword) {
		return userAdminDAO.isUserAdminValid(UserAdminName, UserAdminPassword);
	}
	/**
	 * 通过id获取admin对象
	 */
	public Object getById(String pk) {
		
		return userAdminDAO.getById(pk);
	}
/************************************setter and getter**********************************/
	public IUserAdminDAO getUserAdminDAO() {
		return userAdminDAO;
	}

	public void setUserAdminDAO(IUserAdminDAO userAdminDAO) {
		this.userAdminDAO = userAdminDAO;
	}
}
