package com.haihuiling.beans;

import java.sql.Date;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {
	private static final long serialVersionUID = 8818462137852811533L;
	private String userid;
	private String username;
	private String userage;
	private Date userbirthday;
	private String useraddress;
	private String usersex;
	private String userjob;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String userid, String username) {
		this.userid = userid;
		this.username = username;
	}

	/** full constructor */
	public Userinfo(String userid, String username, String userage,
			Date userbirthday, String useraddress, String usersex,
			String userjob) {
		this.userid = userid;
		this.username = username;
		this.userage = userage;
		this.userbirthday = userbirthday;
		this.useraddress = useraddress;
		this.usersex = usersex;
		this.userjob = userjob;
	}
	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserage() {
		return this.userage;
	}

	public void setUserage(String userage) {
		this.userage = userage;
	}

	public Date getUserbirthday() {
		return this.userbirthday;
	}

	public void setUserbirthday(Date userbirthday) {
		this.userbirthday = userbirthday;
	}

	public String getUseraddress() {
		return this.useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getUsersex() {
		return this.usersex;
	}

	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}

	public String getUserjob() {
		return this.userjob;
	}

	public void setUserjob(String userjob) {
		this.userjob = userjob;
	}

}