package com.haihuiling.model.realize;

import com.haihuiling.ado.impl.IUserRoleReDAO;
import com.haihuiling.beans.UserRoleRelationship;
import com.haihuiling.model.impl.IUserRoleReService;
/**
 * 
 * @author haihuiling
 * @date 2015-8-17 上午10:15:03
 */
public class UserRoleReServiceImpl implements IUserRoleReService {

	public IUserRoleReDAO userRoleReDAO;
	/**
	 * 为人员增加一个角色
	 */
	public void addUserRoleRe(UserRoleRelationship userRoleRelationship) {
		
		userRoleReDAO.addUserRoleRe(userRoleRelationship);
	}

	/**
	 * 为人员删除一个角色
	 */
	public void deleteUserRoleRe(String pk) {
		
		userRoleReDAO.deleteUserRoleRe(pk);
	}

	/**
	 * 为人员修改一个角色
	 */
	public void modifyUserRoleRe(UserRoleRelationship userRoleRelationship) {
		userRoleReDAO.modifyUserRoleRe(userRoleRelationship);
		
	}

	/**
	 * 通过id获取人员-角色关系
	 */
	public Object getById(String pk) {
		return userRoleReDAO.getById(pk);
	}

	@Override
	public void doSubmitRoles(String qqId, String[] userSelectedRoles) {
		userRoleReDAO.doSubmitRoles(qqId, userSelectedRoles);
		
	}

	public IUserRoleReDAO getUserRoleReDAO() {
		return userRoleReDAO;
	}

	public void setUserRoleReDAO(IUserRoleReDAO userRoleReDAO) {
		this.userRoleReDAO = userRoleReDAO;
	}

}
