package com.haihuiling.beans;

/**
 * Useradmin entity. @author MyEclipse Persistence Tools
 */

public class Useradmin implements java.io.Serializable {

	// Fields

	private String admindid;
	private String adminpassword;
	private String adminvalid;

	// Constructors

	/** default constructor */
	public Useradmin() {
	}

	/** full constructor */
	public Useradmin(String admindid,String adminpassword,
			String adminvalid) {
		this.admindid = admindid;
		this.adminpassword = adminpassword;
		this.adminvalid = adminvalid;
	}

	// Property accessors

	public String getAdmindid() {
		return this.admindid;
	}

	public void setAdmindid(String admindid) {
		this.admindid = admindid;
	}
	public String getAdminpassword() {
		return this.adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	public String getAdminvalid() {
		return this.adminvalid;
	}

	public void setAdminvalid(String adminvalid) {
		this.adminvalid = adminvalid;
	}

}