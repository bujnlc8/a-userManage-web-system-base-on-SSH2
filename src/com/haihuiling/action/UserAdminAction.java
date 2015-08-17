package com.haihuiling.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.haihuiling.beans.Useradmin;
import com.haihuiling.model.impl.IUserAdminService;
import com.haihuiling.model.impl.IUserInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author haihuiling
 * @date 2015-8-12 下午4:28:25
 */
public class UserAdminAction extends ActionSupport {
	private static final long serialVersionUID = 5915993960205225224L;
	private static final Logger log = Logger.getLogger(Useradmin.class);
	private String erroMsg;
	private String qqName;
	private String qqPassword;
	private String[] qqIds;
	private String qqPrevileges;
	private IUserAdminService userAdminService;
	private IUserInfoService userInfoService;
	private List<Object> objects;

	@SuppressWarnings("unchecked")
	public void isAdminValid() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = ActionContext.getContext().getSession();
		PrintWriter writer = null;
		try {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			writer = response.getWriter();
			System.out.println(name);
			if (name.equals("") || name == null) {
				writer.print("isBlank");
			} else {
				String result = userAdminService.isUserAdminValid(name,
						password);
				if (result.equals("1") || result.equals("2")) {
					session.put("logined_user", name);
					session.put("quanxian", result);
					writer.print("valid");
				} else {
					writer.print("invalid");
				}
			}
		} catch (Exception e) {
			log.error("判断管理员是否有效失败！");
		} finally {
			writer.flush();
			writer.close();
		}
	}
	public String deleteUserAdmin() {
		String flag = null;
		try {
			Map session = ActionContext.getContext().getSession();
			if(hasQuanxian()) {
				userAdminService.deleteUserAdmin(qqIds);
				flag = SUCCESS;
			} else {
				flag = "noPrevileges";
			}
		} catch (Exception e) {
			erroMsg = "failed to delete adminUser";
			log.error(erroMsg, e);
			flag = ERROR;
		}
		return flag;
	}

	public String getUserAdminInfoList() {
		String flag = null;
		try {
			objects = userAdminService.getUserAdminInfoList();
			/*
			 * for(int index=0;index<objects.size();index++) { Object[] object =
			 * (Object[]) objects.get(index); System.out.print(object[0]);
			 * System.out.print(object[1]); }
			 */
			flag = SUCCESS;

		} catch (Exception e) {
			erroMsg = "failed to get adminUserInfoList";
			log.error(erroMsg, e);
			flag = ERROR;
		}
		return flag;
	}
/**
 * 跳转到添加管理员的界面  先获得可添加的用户列表
 * @return
 */
	public String goAddUserAdmin() {
		String flag = null;
		try {
			if(hasQuanxian()) {
				objects = userInfoService.getUserInfoSubAdmin();
				flag = SUCCESS;
			} else {
				flag = "noPrevileges";
			}
		} catch (Exception e) {
			erroMsg = "跳转添加管理员失败！";
			log.error(erroMsg, e);
			flag = ERROR;

		}
		return flag;
	}
/**
 * 添加管理员
 * @return
 */
	public String addUserAdmin() {
		String flag = null;
		try {
			if(hasQuanxian())
			{
				Useradmin useradmin = new Useradmin(qqIds[0], qqPassword, qqPrevileges);
				userAdminService.addUserAdmin(useradmin);
				flag=SUCCESS;
			}
		} catch (Exception e) {
			erroMsg ="添加管理员失败！";
			log.error(erroMsg,e);
			flag=ERROR;
		}
		return flag;

	}
public boolean hasQuanxian()
{
	boolean admin =false;
	Map session = ActionContext.getContext().getSession();
	if (session.get("quanxian").equals("2")) {
		admin =true;
	}
	return admin;
}

public String userAdminLogout()
{
	String flag = null;
	try {
		Map session = ActionContext.getContext().getSession();
		session.clear();
		flag=SUCCESS;
		
	} catch (Exception e) {
		erroMsg="清除Session失败";
		log.error(erroMsg, e);
		flag = ERROR;
	}
	return flag;
}
	/********************************** setter and getter *************************/
	public String getErroMsg() {
		return erroMsg;
	}

	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}

	public String getQqName() {
		return qqName;
	}

	public void setQqName(String qqName) {
		this.qqName = qqName;
	}

	public String getQqPassword() {
		return qqPassword;
	}

	public void setQqPassword(String qqPassword) {
		this.qqPassword = qqPassword;
	}

	public String[] getQqIds() {
		return qqIds;
	}

	public void setQqIds(String[] qqIds) {
		this.qqIds = qqIds;
	}

	public IUserAdminService getUserAdminService() {
		return userAdminService;
	}

	public void setUserAdminService(IUserAdminService userAdminService) {
		this.userAdminService = userAdminService;
	}

	public List<Object> getObjects() {
		return objects;
	}

	public void setObjects(List<Object> objects) {
		this.objects = objects;
	}

	public static Logger getLog() {
		return log;
	}

	public IUserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public String getQqPrevileges() {
		return qqPrevileges;
	}

	public void setQqPrevileges(String qqPrevileges) {
		this.qqPrevileges = qqPrevileges;
	}
}
