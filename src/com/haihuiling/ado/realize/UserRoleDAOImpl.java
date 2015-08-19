package com.haihuiling.ado.realize;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.haihuiling.ado.impl.IUserRoleDAO;
import com.haihuiling.beans.UserRole;

/**
 * 角色接口实现
 * 
 * @author haihuiling
 * @date 2015-8-17 上午9:35:55
 */
public class UserRoleDAOImpl implements IUserRoleDAO {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 增加角色
	 */
	public void addRole(UserRole userRole) {
		getSession().save(userRole);

	}

	/**
	 * 删除角色
	 */
	public void deleteRole(String[] pk) {
		if(pk == null || pk.length ==0)
		{
			return;
		}else{
			for(int index = 0;index < pk.length;index++)
			{
				getSession().delete(pk[index], getById(pk[index]));
			}
		}

	}

	/**
	 * 更新角色信息
	 */
	public void updateRole(UserRole userRole) {
		getSession().update(userRole);

	}

	/**
	 * 获取角色列表
	 */
	public List<Object> getRoleList() {
		List<Object> userRoleList;
		String sql = "select role_id,role_name,role_description,role_create_time from user_role";
		Query query = getSession().createSQLQuery(sql);
		userRoleList = query.list();	
		return userRoleList;
	}

	/**
	 * 通过ID获得角色
	 */
	public Object getById(String pk) {
		Object object = null;
		try {
			object = getSession().get(UserRole.class, pk);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return object;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
