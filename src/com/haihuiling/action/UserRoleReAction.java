package com.haihuiling.action;

import org.apache.log4j.Logger;

import com.haihuiling.beans.Useradmin;
import com.haihuiling.model.impl.IUserRoleReService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author haihuiling
 * @date 2015-8-17 下午3:41:17
 */
public class UserRoleReAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -236800207112515016L;
	private static final Logger log = Logger.getLogger(Useradmin.class);
	private String erroMsg;
	private String[] userSelectedRoles;
	private String[] userUnSelectedRoles;
	private String qqId;
	private IUserRoleReService userRoleReService;

	public String doSubmitRoles() {
		String flag = null;
		try {
			userRoleReService.doSubmitRoles(qqId, userSelectedRoles);
			flag = SUCCESS;
		} catch (Exception e) {
			erroMsg = "处理角色失败！";
			log.error(erroMsg, e);
			flag = ERROR;
		}
		return flag;
	}

	/*************************************** setter and getter ***********************************************/
	public String[] getUserSelectedRoles() {
		return userSelectedRoles;
	}

	public void setUserSelectedRoles(String[] userSelectedRoles) {
		this.userSelectedRoles = userSelectedRoles;
	}

	public String[] getUserUnSelectedRoles() {
		return userUnSelectedRoles;
	}

	public void setUserUnSelectedRoles(String[] userUnSelectedRoles) {
		this.userUnSelectedRoles = userUnSelectedRoles;
	}

	public String getQqId() {
		return qqId;
	}

	public void setQqId(String qqId) {
		this.qqId = qqId;
	}

	public String getErroMsg() {
		return erroMsg;
	}

	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}

	public IUserRoleReService getUserRoleReService() {
		return userRoleReService;
	}

	public void setUserRoleReService(IUserRoleReService userRoleReService) {
		this.userRoleReService = userRoleReService;
	}

	public static Logger getLog() {
		return log;
	}

}
