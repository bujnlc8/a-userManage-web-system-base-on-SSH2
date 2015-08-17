package com.haihuiling.ado.realize;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.haihuiling.ado.impl.IUserInfoDAO;
import com.haihuiling.beans.Userinfo;
import com.raq.dm.Where;
import com.raq.expression.function.New;

/**
 * 
 * @author haihuiling
 * @date 2015-8-12
 */
public class UserInfoDAOImpl implements IUserInfoDAO {

	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 删除user
	 */
	public void deleteUser(String[] pks) {
		try {
			if (pks == null || pks.length == 0) {
				return;
			} else {
				for (int index = 0; index < pks.length; index++) {
					getSession().createSQLQuery(
							"delete from Userinfo where userId='" + pks[index]
									+ "'").executeUpdate();

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 更新user
	 */
	public void updateUser(Userinfo user) {
		getSession().update(user);

	}

	/**
	 * 增加user
	 */
	public void addUser(Userinfo user) {
		getSession().save(user);

	}

	/**
	 * 通过id获取User
	 */
	public Object getById(String pk) {
		Object object = null;
		try {
			object = getSession().get(Userinfo.class, pk);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return object;
	}

	/**
	 * 根据条件获取user列表
	 */
	public List<Object> getUserInfoList(String userName, String userAge,
			String userBirthday, String userSex, String userAddress,
			String userRole) {
		List<Object> userInfoList = null;
		/*
		 * StringBuffer sql_info = new StringBuffer(); StringBuffer sql_where =
		 * new StringBuffer(); sql_info.append(
		 * "select ui.userid,ui.username,ui.userage,ui.usersex,to_char(ui.userbirthday,'yyyy-mm-dd'),ui.useraddress,ui.userjob from userinfo ui "
		 * ); sql_where.append(" where 1=1 "); if (userAddress != null &&
		 * !userAddress.equals("")) {
		 * sql_where.append(" and  useraddress like '%" + userAddress + "%'"); }
		 * if (userAge != null && !userAge.equals("")) {
		 * sql_where.append(" and userage = '" + userAge + "'"); } if
		 * (userBirthday != null && !userBirthday.equals("")) {
		 * System.out.println(userBirthday);
		 * sql_where.append(" and userbirthday = to_date(" + userBirthday +
		 * ", 'YYYY-MM-DD hh24:mi:ss')"); } if (userName != null &&
		 * !userName.equals("")) { sql_where.append(" and username = '" +
		 * userName + "'"); } if (userSex != null && !userSex.equals("")) {
		 * sql_where.append(" and usersex ='" + userSex + "'"); } if (userJob !=
		 * null && !userJob.equals("")) {
		 * sql_where.append(" and userjob like '%" + userJob + "%'"); } Query
		 * query = getSession().createSQLQuery(
		 * sql_info.append(sql_where).toString()); userInfoList = query.list();
		 */
		StringBuffer sql_select = new StringBuffer(
				"select ui.userid, ui.username,ui.userage,ui.usersex,to_char(ui.userbirthday,'yyyy-mm-dd'),ui.useraddress,ui.userjob,WMSYS.WM_CONCAT(ur.role_name)role_name  from userinfo ui "
						+ "left join user_role_relationship urr  on ui.userid=urr.user_id  "
						+ "left join user_role ur on urr.role_id = ur.role_id");
		StringBuffer sql_where = new StringBuffer(" where 1=1");
		if (userAddress != null && !userAddress.equals("")) {
			sql_where.append(" and  ui.useraddress like '%" + userAddress
					+ "%'");
		}
		if (userAge != null && !userAge.equals("")) {
			sql_where.append(" and ui.userage = '" + userAge + "'");
		}
		if (userBirthday != null && !userBirthday.equals("")) {
			System.out.println(userBirthday);
			sql_where.append(" and ui.userbirthday = to_date(" + userBirthday
					+ ", 'YYYY-MM-DD hh24:mi:ss')");
		}
		if (userName != null && !userName.equals("")) {
			sql_where.append(" and ui.username = '" + userName + "'");
		}
		if (userSex != null && !userSex.equals("")) {
			sql_where.append(" and ui.usersex ='" + userSex + "'");
		}
		if (userRole != null && !userRole.equals("")) {
			sql_where.append(" and  ur.role_name like '%" + userRole + "%'");
		}
		Query query = getSession().createSQLQuery(
				sql_select.append(sql_where).append(" group by ui.userid,ui.username,ui.userage,ui.userbirthday,ui.useraddress,ui.usersex,ui.userjob").toString());
		userInfoList = query.list();
		return userInfoList;
	}

	/**
	 * 获取所有的user
	 */
	public List<Object> getUserInfoList() {
		List<Object> objects = null;
		String sql_queryString = "select * from userinfo";
		Query query = getSession().createSQLQuery(sql_queryString);
		objects = query.list();
		return objects;
	}

	/**
	 * 获取除去admin的所有user
	 */
	@SuppressWarnings("null")
	public List<Object> getUserInfoSubAdmin() {
		List<Object> objects = new ArrayList<Object>();
		List<String> idsList = new ArrayList<String>();
		String sql1 = "select userid as id from userinfo minus select admindid as id from useradmin";
		Query query = getSession().createSQLQuery(sql1);
		idsList = query.list();
		if (idsList != null || idsList.size() != 0) {
			StringBuffer sql2 = new StringBuffer("select * from userinfo ");
			StringBuffer sql_Where = new StringBuffer();
			for (int index = 0; index < idsList.size(); index++) {
				Object object = null;
				System.out.println(sql_Where.toString());
				sql_Where.append("where 1=1 and userid ='"
						+ idsList.get(index).toString() + "'");
				sql2.append(sql_Where).toString();
				System.out.print(sql2.toString());
				object = getSession().createSQLQuery(sql2.toString())
						.uniqueResult();
				objects.add(index, object);
				sql_Where.delete(0, sql_Where.length());
				sql2.delete(0, sql2.length());
				sql2.append("select * from userinfo ");
			}
		}
		return objects;
	}

	/**
	 * 
	 */
	public boolean checkValid(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 获取具有角色的人员信息列表
	 */
	public List<Object> getUserInfoWithRole() {

		List<Object> userInfoList = null;
		String sql = "select ui.userid, ui.username,ui.userage,ui.usersex,ui.userbirthday,ui.useraddress,ui.userjob,WMSYS.WM_CONCAT(ur.role_name)role_name  from userinfo ui "
				+ "left join user_role_relationship urr  on ui.userid=urr.user_id  "
				+ "left join user_role ur on urr.role_id = ur.role_id group by ui.userid,ui.username,ui.userage,ui.userbirthday,ui.useraddress,ui.usersex,ui.userjob";
		Query query = getSession().createSQLQuery(sql);
		userInfoList = query.list();
		return userInfoList;
	}

	/**
	 * 根据ID获取某个人员的详细信息 包括角色信息
	 */
	public Object getUserInfoWithRoleById(String pk) {
		Object object = null;
		String sql = "select ui.userid, ui.username,ui.userage,ui.usersex,ui.userbirthday,ui.useraddress,ui.userjob,WMSYS.WM_CONCAT(ur.role_name)role_name  from userinfo ui "
				+ "left join user_role_relationship urr  on ui.userid=urr.user_id  "
				+ "left join user_role ur on urr.role_id = ur.role_id where ui.userid = '"
				+ pk
				+ "' "
				+ "group by ui.userid,ui.username,ui.userage,ui.userbirthday,ui.useraddress,ui.usersex,ui.userjob";
		Query query = getSession().createSQLQuery(sql);
		object = query.uniqueResult();
		return object;
	}

	/**
	 * 获取某个人员已经被赋予的角色
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getUserSelectedRole(String pk) {
		List<Object> objects = null;
		String sql = "select ur.role_name from userinfo ui "
				+ "left join user_role_relationship urr  on ui.userid=urr.user_id  "
				+ "left join user_role ur on urr.role_id = ur.role_id where ui.userid = '"
				+ pk + "'";
		objects = getSession().createSQLQuery(sql).list();
		return objects;
	}

	/**
	 * 获取某个人员未被赋予的角色
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getUserUnSelectedRole(String pk) {
		List<Object> objects = null;
		List<Object> objects2 = getUserSelectedRole(pk);
		String sql = "select role_name from user_role";
		objects = getSession().createSQLQuery(sql).list();
		if (objects2 != null || objects2.size() != 0) {
			objects.removeAll(objects2);
		}

		return objects;
	}

	/************************************* setter and getter ******************************/

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
