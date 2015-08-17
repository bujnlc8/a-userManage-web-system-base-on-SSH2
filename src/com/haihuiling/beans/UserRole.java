package com.haihuiling.beans;

import java.sql.Date;

/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */

public class UserRole implements java.io.Serializable {
	
	
	private static final long serialVersionUID = -8375797388515025596L;
	//角色ID
	private String roleId;
	private String roleName;
	//角色描述
	private String roleDescription;
	private Date roleCreateTime;

	// Constructors

	/** default constructor */
	public UserRole() {
	}

	/** minimal constructor */
	public UserRole(String roleId, String roleName, Date roleCreateTime) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleCreateTime = roleCreateTime;
	}

	/** full constructor */
	public UserRole(String roleId, String roleName, String roleDescription,
			Date roleCreateTime) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.roleCreateTime = roleCreateTime;
	}

	// Property accessors

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Date getRoleCreateTime() {
		return this.roleCreateTime;
	}

	public void setRoleCreateTime(Date roleCreateTime) {
		this.roleCreateTime = roleCreateTime;
	}

}