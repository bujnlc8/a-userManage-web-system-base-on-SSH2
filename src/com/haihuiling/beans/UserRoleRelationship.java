package com.haihuiling.beans;

/**
 * UserRoleRelationship entity. @author MyEclipse Persistence Tools
 */

public class UserRoleRelationship implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3542941952782498936L;
	private String userRoleReId;
	private String userId;
	private String roleId;
	private String roleState;
	
	/** default constructor */
    public UserRoleRelationship() {
		
	}
	public UserRoleRelationship(String userRoleReId, String userId,
			String roleId, String roleState) {
		super();
		this.userRoleReId = userRoleReId;
		this.userId = userId;
		this.roleId = roleId;
		this.roleState = roleState;
	}
	public String getUserRoleReId() {
		return userRoleReId;
	}
	public void setUserRoleReId(String userRoleReId) {
		this.userRoleReId = userRoleReId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleState() {
		return roleState;
	}
	public void setRoleState(String roleState) {
		this.roleState = roleState;
	}
	
}