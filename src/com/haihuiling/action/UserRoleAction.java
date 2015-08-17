package com.haihuiling.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.haihuiling.beans.Useradmin;
import com.haihuiling.model.impl.IUserRoleService;
import com.opensymphony.xwork2.ActionSupport;

public class UserRoleAction  extends ActionSupport{

	private static final long serialVersionUID = -392114692519601821L;
	private static final Logger log = Logger.getLogger(Useradmin.class);
	private String erroMsg;
	private String qqId;
	private String[] qqIds;
	List<Object> object;
	private IUserRoleService userRoleService;
	
	public  String getRoleInfoList(){
		try {
			object = userRoleService.getRoleList();
			return SUCCESS;
		} catch (Exception e) {
			erroMsg ="获取角色列表失败！";
			log.error(erroMsg, e);
		}
	  return ERROR; 
	}
/********************************************setter and getter*********************/
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
	

}
