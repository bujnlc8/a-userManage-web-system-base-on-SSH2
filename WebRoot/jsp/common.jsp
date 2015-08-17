<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	StringBuffer basePath = new StringBuffer();
	/*basePath.append(request.getScheme());
	basePath.append("://");
	basePath.append(request.getServerName());
	basePath.append(":");
	basePath.append(request.getServerPort());*/
	basePath.append(request.getContextPath());
	basePath.append("/");
	String sBase = basePath.toString();
	// 内网
		String sftp = ""; //"http://172.18.8.57:81/";
	// 外网
	// 	String sftp = "http://113.108.137.85:5181";
	// 移动外网
	//String sftp = "http://120.197.27.52:8082/";
	
	request.setAttribute("sBase", sBase);
	request.setAttribute("sftp", sftp);
%>
<s:set name="ctx" value="#request.sBase"/>
<s:set name="ftp" value="#request.sftp"/>
