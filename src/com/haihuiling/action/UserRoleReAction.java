package com.haihuiling.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.haihuiling.beans.UserRoleRelationship;
import com.haihuiling.beans.Useradmin;
import com.haihuiling.model.impl.IUserRoleReService;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.cache.StringTemplateLoader;

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
	private String qqId_;
	private String[] qqIds;
	private String qqState;
	private String qqUserId;
	private IUserRoleReService userRoleReService;
	private List<Object> objects;

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
	public String goUserRoleAddORDelete() {
		String flag = null;
		try {
			objects=userRoleReService.getUserRoleInfoByRoleId(qqId);
			qqId_ =qqId;
			flag = SUCCESS;
		} catch (Exception e) {
			erroMsg = "获取人员角色列表失败！";
			log.error(erroMsg, e);
			flag = ERROR;
		}
		return flag;
	}
	/**
	 * 启用人员的角色状态
	 */
	public void openUserRole(){
		userRoleReService.openUserRole(qqId);	
	}
	/**
	 * 禁用人员的角色
	 */
	public void forbidUserRole(){
		userRoleReService.forbidUserRole(qqId);
	}
	/**
	 * 删除人员-角色关系
	 */
	public String deleteUserRole(){
		try {
			userRoleReService.deleteUserRoleRe(qqIds);
			qqId_ = qqId;
			return SUCCESS;
		} catch (Exception e) {
			erroMsg="删除人员角色关系失败！";
			log.error(erroMsg, e);
		}
		return ERROR;
	}
/**
 * 跳转到为角色添加人员的页面	
 * @return
 */
	public String goAddUserRole(){
		try {
			objects = userRoleReService.getUserListHavaNoTheRole(qqId);
			qqId_ = qqId;
			//objects.add(qqId);
			return SUCCESS;
		} catch (Exception e) {
			erroMsg="获取没有这个角色的列表失败！";
			log.error(erroMsg, e);
		}
		return ERROR;
	}
	public String addUserRole(){
		try {
			UserRoleRelationship userRoleRelationship = new UserRoleRelationship(null, qqUserId, qqId, qqState);
			userRoleReService.addUserRoleRe(userRoleRelationship);
			return SUCCESS;
		} catch (Exception e) {
			erroMsg="角色添加人员失败";
			log.error(erroMsg, e);
		}
		return ERROR;
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
	public List<Object> getObjects() {
		return objects;
	}
	public void setObjects(List<Object> objects) {
		this.objects = objects;
	}
	public String[] getQqIds() {
		return qqIds;
	}
	public void setQqIds(String[] qqIds) {
		this.qqIds = qqIds;
	}
	public String getQqState() {
		return qqState;
	}
	public void setQqState(String qqState) {
		this.qqState = qqState;
	}
	public String getQqUserId() {
		return qqUserId;
	}
	public void setQqUserId(String qqUserId) {
		this.qqUserId = qqUserId;
	}
	public String getQqId_() {
		return qqId_;
	}
	public void setQqId_(String qqId_) {
		this.qqId_ = qqId_;
	}

}
