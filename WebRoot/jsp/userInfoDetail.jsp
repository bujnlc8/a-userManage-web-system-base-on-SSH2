<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="resource/validform/validform.css" rel="stylesheet"
	media="screen">
<script type="text/javascript" src="resource/jquery/jquery-1.7.1.min.js"></script>
</head>
<body>
	<div>
		<form id="userInfoDetail" name="userInfoDetail" class="userInfo"
			method="post">
			<table>
				<tr>
					<td>人员Id</td>
					<td><input type="text" name="qqId" readonly
						value="<s:property value='userObject[0]'/>"></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="qqName"
						value="<s:property value='userObject[1]'/>"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" name="qqAge"
						value="<s:property value='userObject[2]'/>"></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input type="text" name="qqSex"
						value="<s:property value='userObject[3]'/>" /></td>
				</tr>
				<tr>
					<td>生日</td>
					<td><input type="text" name="qqBirthday"  id="qqBirthday"
						value="<s:property value='userObject[4]'/> " /></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="qqAddress"
						value="<s:property value='userObject[5]'/>" /></td>
				</tr>
				<tr style="display:none">
					<td>工作</td>
					<td><input type="text" name="qqJob"
						value="<s:property value='userObject[6]'/>" /></td>
				</tr>
				<tr>
					<td>角色</td>
					<td><input type="text" name="qqRole"
						value="<s:property value='userObject[7]'/>" /></td>
				</tr>
			</table>
			<input type="button" id="back" onclick="goback();" value="返回" class="btn btn-primary"/>
		</form>
	</div>
	<script type="text/javascript">
		function goback() {
			window.location = "user/userInfoList.do";
		}
		window.onload = function() {
			var mytime = $("#qqBirthday").val();
			$("#qqBirthday").val(mytime.substr(0,7));
		}
	</script>
</body>
</html>
