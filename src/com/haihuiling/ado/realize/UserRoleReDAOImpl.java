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
	public void modifyUserRoleRe(UserRoleRelationship userRoleRelationship) {
		getSession().update(userRoleRelationship);
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
		if (userSelectedRoles.length!=0 && roleStored.size()!=0) {
			for (int index = 0; index < roleStored.size(); index++) {
				for (int i = 0; i < userSelectedRoles.length; i++) {
					if (roleStored.get(index).toString()
							.equals(userSelectedRoles[i])) {
						break;
					} else {
						if (i == userSelectedRoles.length -1) {
							roleToDelete.add(roleStored.get(index).toString());
						}else{
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
					} else { if(k==roleStored.size()-1){
						roleToAdd.add(userSelectedRoles[j]);}else{
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
									.uniqueResult().toString(), null);
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
								.uniqueResult().toString(), null);
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

	/********************************************* setter and getter *****************************************/
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
