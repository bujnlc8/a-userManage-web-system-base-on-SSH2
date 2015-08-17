package com.haihuiling.model.realize;

import java.util.List;

import com.haihuiling.ado.impl.IUserRoleDAO;
import com.haihuiling.beans.UserRole;
import com.haihuiling.model.impl.IUserRoleService;

/**
 * 
 * @author haihuiling
 * @date 2015-8-17 上午10:07:23
 */
public class UserRoleServiceImpl implements IUserRoleService {

	private IUserRoleDAO userRoleDAO;

	/**
	 * 增加一个角色
	 */
	public void addRole(UserRole userRole) {
		userRoleDAO.addRole(userRole);

	}

	/**
	 * 删除角色
	 */
	public void deleteRole(String[] pk) {
		userRoleDAO.deleteRole(pk);

	}

	/**
	 * 更新角色
	 */
	public void updateRole(UserRole userRole) {
		userRoleDAO.updateRole(userRole);

	}

	/**
	 * 获取所有的角色
	 */
	public List<Object> getRoleList() {
		return userRoleDAO.getRoleList();
	}

	/**
	 * 根据Id获得角色
	 */
	public Object getById(String pk) {
		return userRoleDAO.getById(pk);
	}

	public IUserRoleDAO getUserRoleDAO() {
		return userRoleDAO;
	}

	public void setUserRoleDAO(IUserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}

}
