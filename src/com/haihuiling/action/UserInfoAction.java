package com.haihuiling.action;

import java.util.List;

import javax.mail.Flags.Flag;

import org.apache.log4j.Logger;

import com.haihuiling.beans.Userinfo;
import com.haihuiling.model.impl.IUserInfoService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author haihuiling
 * @date 2015-8-12
 */
public class UserInfoAction extends ActionSupport {
	private static final long serialVersionUID = 5049772928179095166L;
	private final Logger log = Logger.getLogger(Userinfo.class);
	private String erroMsg;
	private IUserInfoService userInfoService;
	private String qqName;
	private String qqAge;
	private String qqSex;
	private String qqJob;
	private String qqAddress;
	private String qqBirthday;
	private String qqId;
	private String qqRole;
	private String[] qqIds;
	private List<Object> object;
	private Object userObject;
    private List<Object> userSelectedRolesList;
    private List<Object> userUnSelectedRolesList;
	/**
	 * 获取user列表
	 */
	public String getUserInfoList() {
		String flag = null;
		try {
			// System.out.println(qqName);
			object = userInfoService.getUserInfoList(qqName, qqAge, qqBirthday,
					qqSex, qqAddress, qqRole);
			flag = SUCCESS;
		} catch (Exception e) {
			erroMsg = "获取user列表失败";
			log.error(erroMsg + "原因:", e);
			flag = ERROR;
		}
		return flag;
	}

	/**
	 * 删除user
	 * 
	 * @return
	 */
	public String deleteUserInfo() {
		String flag = null;
		try {
			userInfoService.deleteUser(qqIds);
			// System.out.print(qqIds[0].toString());
			flag = SUCCESS;
		} catch (Exception e) {
			erroMsg = "failed to delete User!";
			log.error(erroMsg, e);
			flag = ERROR;
		}
		return flag;
	}

	/**
	 * 无条件跳转到新增页面
	 * 
	 * @return
	 */
	public String goAddUserInfo() {
		return SUCCESS;

	}

	/**
	 * 增加user
	 * 
	 * @return
	 */
	public String userInfoAdd() {
		String flag = null;
		try {
			// StringBuffer birthdaySb = new StringBuffer();
			// birthdaySb.append(qqBirthday.substring(0, 4));
			System.out.print(qqBirthday);
			java.sql.Date birthdaySql = java.sql.Date.valueOf(qqBirthday);
			Userinfo userinfo = new Userinfo(null, qqName, qqAge, birthdaySql,
					qqAddress, qqSex, qqJob);
			userInfoService.addUser(userinfo);
			flag = SUCCESS;
		} catch (Exception e) {
			erroMsg = "添加user失敗！";
			log.error(erroMsg, e);
			flag = ERROR;
		}
		return flag;

	}

	/**
	 * 跳转到人员信息编辑页面
	 */
	public String goUserInfoEdit() {
		String flag = null;
		try {
			setUserObject(userInfoService.getById(qqId));
			flag = SUCCESS;
		} catch (Exception e) {
			erroMsg = "跳转人员编辑页面失败！";
			log.error(erroMsg, e);
			flag = ERROR;
		}
		return flag;
	}

	/**
	 * 人员信息更新
	 */
	public String userInfoEdit() {
		String flag = null;
		try {
			java.sql.Date birthdaySql = java.sql.Date.valueOf(qqBirthday);
			Userinfo userinfo = new Userinfo(qqId, qqName, qqAge, birthdaySql,
					qqAddress, qqSex, qqJob);
			userInfoService.updateUser(userinfo);
			flag = SUCCESS;
		} catch (Exception e) {
			erroMsg = "更新人员信息失败！";
			log.error(erroMsg, e);
			flag = ERROR;
		}
		return flag;
	}

	/**
	 * 获取人员详细信息
	 */
	public String userInfoDetail() {
		String flag = null;
		try {
			//setUserObject(userInfoService.getById(qqId));
			userObject =userInfoService.getUserInfoWithRoleById(qqId);
			flag = SUCCESS;
		} catch (Exception e) {
			erroMsg = "获取人员详细信息失败！";
			log.error(erroMsg, e);
			flag = ERROR;
		}
		return flag;
	}
public String goUserRoleEdit()
{
	String flag = null;
	try {
		userSelectedRolesList = userInfoService.getUserSelectedRole(qqId);
		userUnSelectedRolesList =userInfoService.getUserUnSelectedRole(qqId);
		if(userSelectedRolesList.get(0) == null){
			userSelectedRolesList.add(0, "无");
			userSelectedRolesList.remove(1);
		}
		userObject =userInfoService.getUserInfoWithRoleById(qqId);
		flag = SUCCESS;
	} catch (Exception e) {
		erroMsg = "获取人员角色信息失败！";
		log.error(erroMsg, e);
		flag = ERROR;
	}
	return flag;
}
	/*********************************************** setter and getter ****************************************/
	public String getErroMsg() {
		return erroMsg;
	}

	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}

	public IUserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public String getQqName() {
		return qqName;
	}

	public void setQqName(String qqName) {
		this.qqName = qqName;
	}

	public String getQqAge() {
		return qqAge;
	}

	public void setQqAge(String qqAge) {
		this.qqAge = qqAge;
	}

	public String getQqSex() {
		return qqSex;
	}

	public void setQqSex(String qqSex) {
		this.qqSex = qqSex;
	}

	public String getQqJob() {
		return qqJob;
	}

	public void setQqJob(String qqJob) {
		this.qqJob = qqJob;
	}

	public String getQqAddress() {
		return qqAddress;
	}

	public void setQqAddress(String qqAddress) {
		this.qqAddress = qqAddress;
	}

	public String getQqBirthday() {
		return qqBirthday;
	}

	public void setQqBirthday(String qqBirthday) {
		this.qqBirthday = qqBirthday;
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

	public Logger getLog() {
		return log;
	}

	public String getQqId() {
		return qqId;
	}

	public void setQqId(String qqId) {
		this.qqId = qqId;
	}

	public Object getUserObject() {
		return userObject;
	}

	public void setUserObject(Object userObject) {
		this.userObject = userObject;
	}

	public String getQqRole() {
		return qqRole;
	}

	public void setQqRole(String qqRole) {
		this.qqRole = qqRole;
	}

	public List<Object> getUserSelectedRolesList() {
		return userSelectedRolesList;
	}

	public void setUserSelectedRolesList(List<Object> userSelectedRolesList) {
		this.userSelectedRolesList = userSelectedRolesList;
	}

	public List<Object> getUserUnSelectedRolesList() {
		return userUnSelectedRolesList;
	}

	public void setUserUnSelectedRolesList(List<Object> userUnSelectedRolesList) {
		this.userUnSelectedRolesList = userUnSelectedRolesList;
	}

}
