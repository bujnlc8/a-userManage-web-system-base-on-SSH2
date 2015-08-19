package com.haihuiling.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;

import com.haihuiling.beans.UserRole;
import com.haihuiling.beans.Useradmin;
import com.haihuiling.model.impl.IUserRoleService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author haihuiling
 * @date 2015-8-18 下午2:52:51
 */
public class UserRoleAction extends ActionSupport {

	private static final long serialVersionUID = -392114692519601821L;
	private static final Logger log = Logger.getLogger(Useradmin.class);
	private String erroMsg;
	private String qqId;
	private String[] qqIds;
	private String qqName;
	private String qqDescription;
	private String qqCreateTime;
	List<Object> object;
	private Object roleObject;
	private IUserRoleService userRoleService;

	public String getRoleInfoList() {
		try {
			object = userRoleService.getRoleList();
			return SUCCESS;
		} catch (Exception e) {
			erroMsg = "获取角色列表失败！";
			log.error(erroMsg, e);
		}
		return ERROR;
	}

	/**
	 * 增加角色
	 * 
	 * @return
	 */
	public String addRole() {
		try {
			Date nowTime = new Date(System.currentTimeMillis());
			SimpleDateFormat sdFormatter = new SimpleDateFormat(
					"yyyy-MM-dd");
			String retStrFormatNowDate = sdFormatter.format(nowTime);
			UserRole userRole = new UserRole(null, qqName, qqDescription,
					Date.valueOf(retStrFormatNowDate));
			userRoleService.addRole(userRole);
			return SUCCESS;
		} catch (Exception e) {
			erroMsg = "增加角色失败！";
			log.error(erroMsg, e);
		}
		return ERROR;
	}

	/**
	 * 删除角色
	 */
	public String deleteRole() {
		try {
			userRoleService.deleteRole(qqIds);
			return SUCCESS;
		} catch (Exception e) {
			erroMsg = "删除角色失败！";
			log.error(erroMsg, e);
		}
		return ERROR;
	}

	/**
	 * 跳转到角色编辑页面
	 */
	public String goRoleEdit() {
		String flag = null;
		try {
			roleObject = userRoleService.getById(qqId);
			flag = SUCCESS;
		} catch (Exception e) {
			erroMsg = "跳转角色编辑页面失败！";
			log.error(erroMsg, e);
			flag = ERROR;
		}
		return flag;
	}

	/**
	 * 修改角色信息
	 */
	public String roleEdit() {
		String flag = null;
		try {
			SimpleDateFormat sdFormatter = new SimpleDateFormat(
					"yyyy-MM-dd");
			String retStrFormatNowDate = sdFormatter.format(Date.valueOf(qqCreateTime));
			UserRole userRole = (UserRole) userRoleService.getById(qqId);
			userRole.setRoleName(qqName);
			userRole.setRoleCreateTime(Date.valueOf(retStrFormatNowDate));
			userRole.setRoleDescription(qqDescription);
			userRoleService.updateRole(userRole);
			flag = SUCCESS;
		} catch (Exception e) {
			erroMsg = "角色编辑失败！";
			log.error(erroMsg, e);
			flag = ERROR;
		}
		return flag;

	}

	/******************************************** setter and getter *********************/
	public String getQqId() {
		return qqId;
	}

	public void setQqId(String qqId) {
		this.qqId = qqId;
	}

	public String[] getQqIds() {
		return qqIds;
	}

	public void setQqIds(String[] qqIds) {
		this.qqIds = qqIds;
	}

	public List<Object> getObject() {
		return object;
	}

	public void setObject(List<Object> object) {
		this.object = object;
	}

	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public String getErroMsg() {
		return erroMsg;
	}

	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}

	public static Logger getLog() {
		return log;
	}

	public String getQqName() {
		return qqName;
	}

	public void setQqName(String qqName) {
		this.qqName = qqName;
	}

	public String getQqDescription() {
		return qqDescription;
	}

	public void setQqDescription(String qqDescription) {
		this.qqDescription = qqDescription;
	}

	public Object getRoleObject() {
		return roleObject;
	}

	public void setRoleObject(Object roleObject) {
		this.roleObject = roleObject;
	}

	public String getQqCreateTime() {
		return qqCreateTime;
	}

	public void setQqCreateTime(String qqCreateTime) {
		this.qqCreateTime = qqCreateTime;
	}

}
