package com.haihuiling.ado.realize;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.haihuiling.ado.impl.IUserRoleReDAO;
import com.haihuiling.beans.UserRoleRelationship;

/**
 * 
 * @author haihuiling
 * @date 2015-8-17 上午9:58:09
 */
public class UserRoleReDAOImpl implements IUserRoleReDAO {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 为人员添加角色
	 */
	public void addUserRoleRe(UserRoleRelationship userRoleRelationship) {
		getSession().save(userRoleRelationship);

	}

	/**
	 * 删除人员的某个角色
	 */
	public void deleteUserRoleRe(String pk) {
		getSession().delete(pk, getById(pk));

	}

	/**
	 * 修改某个人员的角色
	 */
	public void modifyUserRoleRe(String pk,UserRoleRelationship userRoleRelationship) {
		getSession().update(pk,userRoleRelationship);
	}

	/**
	 * 通过ID获得人员角色关系
	 */
	public Object getById(String pk) {
		return getSession().get(UserRoleRelationship.class, pk);
	}

	/**
	 * 处理提交上来的角色信息
	 */
	public void doSubmitRoles(String qqId, String[] userSelectedRoles) {
		List<String> roleStored = new ArrayList<String>();
		List<String> roleToDelete = new ArrayList<String>();
		List<String> roleToAdd = new ArrayList<String>();
		String sql = "select ur.role_name from user_role ur where ur.role_id in (select urr.role_id from user_role_relationship urr where urr.user_id ='"
				+ qqId + "')";
		roleStored = getSession().createSQLQuery(sql).list();
		if (userSelectedRoles.length != 0 && roleStored.size() != 0) {
			for (int index = 0; index < roleStored.size(); index++) {
				for (int i = 0; i < userSelectedRoles.length; i++) {
					if (roleStored.get(index).toString()
							.equals(userSelectedRoles[i])) {
						break;
					} else {
						if (i == userSelectedRoles.length - 1) {
							roleToDelete.add(roleStored.get(index).toString());
						} else {
							continue;
						}
					}
				}
			}
			for (int j = 0; j < userSelectedRoles.length; j++) {
				for (int k = 0; k < roleStored.size(); k++) {
					if (userSelectedRoles[j].equals(roleStored.get(k)
							.toString())) {
						break;
					} else {
						if (k == roleStored.size() - 1) {
							roleToAdd.add(userSelectedRoles[j]);
						} else {
							continue;
						}
					}
				}
			}
			if (roleToAdd != null || roleToAdd.size() != 0) {
				for (int index = 0; index < roleToAdd.size(); index++) {
					String sql1 = "select role_id from user_role where role_name ='"
							+ roleToAdd.get(index) + "'";
					UserRoleRelationship userRoleRelationship = new UserRoleRelationship(
							null, qqId, getSession().createSQLQuery(sql1)
									.uniqueResult().toString(), "1");
					addUserRoleRe(userRoleRelationship);
				}
			}
			if (roleToDelete != null || roleToDelete.size() != 0) {
				for (int index = 0; index < roleToDelete.size(); index++) {
					String sql1 = "select role_id from user_role where role_name ='"
							+ roleToDelete.get(index) + "'";
					String role_id = getSession().createSQLQuery(sql1)
							.uniqueResult().toString();
					String sql2 = "select user_role_re_id from user_role_relationship where user_id='"
							+ qqId + "' and role_id='" + role_id + "'";
					String user_role_re_idString = getSession()
							.createSQLQuery(sql2).uniqueResult().toString();
					getSession().delete(getById(user_role_re_idString));
				}
			}

		} else if (roleStored == null || roleStored.size() == 0) {
			for (int index = 0; index < userSelectedRoles.length; index++) {
				String sql1 = "select role_id from user_role where role_name ='"
						+ userSelectedRoles[index] + "'";
				UserRoleRelationship userRoleRelationship = new UserRoleRelationship(
						null, qqId, getSession().createSQLQuery(sql1)
								.uniqueResult().toString(), "1");
				addUserRoleRe(userRoleRelationship);
			}

		} else if (userSelectedRoles == null || userSelectedRoles.length == 0) {
			if (roleStored == null || roleStored.size() == 0) {
				return;
			} else if (roleStored != null || roleStored.size() != 0) {
				for (int index = 0; index < roleStored.size(); index++) {
					String sql1 = "select role_id from user_role where role_name ='"
							+ roleStored.get(index) + "'";
					String role_id = getSession().createSQLQuery(sql1)
							.uniqueResult().toString();
					String sql2 = "select user_role_re_id from user_role_relationship where user_id='"
							+ qqId + "' and role_id ='" + role_id + "'";
					String user_role_re_idString = getSession()
							.createSQLQuery(sql2).uniqueResult().toString();
					getSession().delete(getById(user_role_re_idString));

				}

			}

		}
	}

	/**
	 * 通过角色id获得人员-角色列表
	 */
	public List<Object> getUserRoleInfoByRoleId(String roleId) {
		List<Object> objects = new ArrayList<Object>();
		String sql = "select user_role_re_id,ur.role_name,ui.username,urr.role_state,ur.role_id from user_role_relationship urr  left join userinfo ui on ui.userid=urr.user_id "
				+ "left join user_role ur on ur.role_id = urr.role_id where urr.role_Id ='"
				+ roleId + "'";
		objects = getSession().createSQLQuery(sql).list();
		return objects;
	}

	/**
	 * 启用人员的角色状态
	 */
	public void openUserRole(String pk) {
		UserRoleRelationship userRoleRelationship = (UserRoleRelationship) getById(pk);
		userRoleRelationship.setRoleState("1");
		modifyUserRoleRe(pk,userRoleRelationship);
	}

	/**
	 * 禁用人员的角色状态
	 */
	public void forbidUserRole(String pk) {
		UserRoleRelationship userRoleRelationship = (UserRoleRelationship) getById(pk);
		userRoleRelationship.setRoleState("0");
		modifyUserRoleRe(pk,userRoleRelationship);
	}
	/**
	 * 获取未被赋予id为roleid角色的人员列表
	 */
	public List<Object> getUserListHavaNoTheRole(String roleid) {
		List<Object> objects = new ArrayList<Object>();
		String sql = "select ui.userid,ui.username from userinfo ui where ui.userid in(select ui.userid from userinfo minus select urr.user_id from user_role_relationship urr where urr.role_id ='"+
		roleid+"')";
		objects = getSession().createSQLQuery(sql).list();
		return objects;
	} 
	/********************************************* setter and getter *****************************************/
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
