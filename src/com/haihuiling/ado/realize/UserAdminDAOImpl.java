package com.haihuiling.ado.realize;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.haihuiling.ado.impl.IUserAdminDAO;
import com.haihuiling.beans.Useradmin;
/**
 * 
 * @author haihuiling
 * @date 2015-8-12 下午4:10:42
 */
public class UserAdminDAOImpl implements IUserAdminDAO{
     private SessionFactory sessionFactory;
     public Session getSession()
     {
    	 return sessionFactory.getCurrentSession();
     }
	/**
	 * 增加管理员
	 */
	public void addUserAdmin(Useradmin useradmin) {
		getSession().save(useradmin);
		
	}

	/**
	 * 删除管理员
	 */
	public void deleteUserAdmin(String[] pks) {
		if(pks==null||pks.length<1)
		{
			return;
		}else {
			for(int index =0;index < pks.length;index++)
			{
				getSession().delete(pks[index], getById(pks[index]));
			}
		}
		
	}

	/**
	 * 更新管理员
	 */
	public void updateUserAdmin(Useradmin useradmin) {
		getSession().update(useradmin);
		
	}

	/**
	 * 获取管理员列表
	 */
	public List<Object> getUserAdminInfoList() {
		List<Object> userAdminList = null;
		String sql_select = "select ad.admindid,ui.username as adminname,ad.adminpassword,ad.adminvalid from useradmin ad left join userinfo ui on  ui.userid =ad.admindid";
		Query query = getSession().createSQLQuery(sql_select);
		userAdminList = query.list();
		return userAdminList;
	}

	/**
	 * 判断输入的管理员名字和密码是否匹配
	 */
	public String isUserAdminValid(String UserAdminName,
			String UserAdminPassword) {
		String flag = "0";
		String sql = "select ad.adminpassword,ad.adminvalid from useradmin ad where ad.admindid in (select userid from userinfo where username = "+"'"+UserAdminName+"')";
		Query query = getSession().createSQLQuery(sql);
		List<Object> infoList = query.list();
		if(infoList == null)
		{
			flag = "0";
		}else {
			for(int i =0;i<infoList.size();i++)
			{
				Object[] objects = (Object[]) infoList.get(i);
				if(objects[0].toString().equals(UserAdminPassword) && Integer.parseInt(objects[1].toString())>0)
				{
					flag = objects[1].toString();
					break;
				}
			}	
		}
		return flag;
	}
	/**
	 * 通过ID获得admin对象
	 */
	public Object getById(String pk) {
		return getSession().get(Useradmin.class, pk);
		
	}
	/*****************************************setter and getter ****************/
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
