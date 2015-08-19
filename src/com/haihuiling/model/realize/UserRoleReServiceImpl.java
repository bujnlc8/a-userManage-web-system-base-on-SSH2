package com.haihuiling.model.realize;

import java.util.List;

import org.apache.poi2.hssf.record.formula.functions.Index;

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
	 * 删除人员-角色关系
	 */
	public void deleteUserRoleRe(String[] pk) {
		if(pk!=null&&pk.length!=0){
			for(int index =0;index<pk.length;index++){
				userRoleReDAO.deleteUserRoleRe(pk[index]);
			}
		}
	}

	/**
	 * 为人员修改一个角色
	 */
	public void modifyUserRoleRe(String pk,UserRoleRelationship userRoleRelationship) {
		userRoleReDAO.modifyUserRoleRe(pk,userRoleRelationship);
		
	}

	/**
	 * 通过id获取人员-角色关系
	 */
	public Object getById(String pk) {
		return userRoleReDAO.getById(pk);
	}

	/**
	 * 处理提交上来的人员角色信息
	 */
	public void doSubmitRoles(String qqId, String[] userSelectedRoles) {
		userRoleReDAO.doSubmitRoles(qqId, userSelectedRoles);
		
	}
	/**
	 * 通过角色id获得角色-人员列表
	 */
	public List<Object> getUserRoleInfoByRoleId(String roleId) {
		return userRoleReDAO.getUserRoleInfoByRoleId(roleId);
	}
	/**
	 * 开启人员角色状态
	 */
	public void openUserRole(String pk) {
		userRoleReDAO.openUserRole(pk);
		
	}
	/**
	 * 禁用人员角色状态
	 */
	public void forbidUserRole(String pk) {
		userRoleReDAO.forbidUserRole(pk);	
	}
	/**
	 * 获取未被赋予id为roleid角色的人员列表
	 */
	public List<Object> getUserListHavaNoTheRole(String roleid) {
		return userRoleReDAO.getUserListHavaNoTheRole(roleid);
	}
/*****************************************************setter and getter*****************************************************/
	public IUserRoleReDAO getUserRoleReDAO() {
		return userRoleReDAO;
	}

	public void setUserRoleReDAO(IUserRoleReDAO userRoleReDAO) {
		this.userRoleReDAO = userRoleReDAO;
	}
}
