<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script type="text/javascript" src="resource/jquery/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript"
	src="resource/validform/Validform_v5.3.2_min.js"></script>
</head>
<body>
	<div>
		<form id="userInfoAdd" name="userInfoAdd" class="userInfo"
			action="user/userInfoAdd.do" method="post">
			<table>
				<tr>
					<td><font color="red">*</font>姓名</td>
					<td><input type="text" name="qqName" datatype="*3-20"
						nullmsg="请输入3-20位的字符">
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>年龄</td>
					<td><input type="text" name="qqAge" datatype="n1-2"
						nullmsg="请输入1-2位的数字">
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>性别</td>
					<td><input type="text" name="qqSex" datatype="/男|女/"
						nullmsg="请输入‘男’或‘女’">
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>生日</td>
					<td><input type="text" name="qqBirthday" id="datepicker" 
						nullmsg="请选择日期" />
					</td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="qqAddress" ignore="ignore">
					</td>
				</tr>
				<tr>
					<td>工作</td>
					<td><input type="text" name="qqJob" ignore="ignore">
					</td>
				</tr>
			</table>
			<input type="button" id="saveInfo" value="保存" />
		</form>
	</div>
<script>
$(function() {
			$(".userInfo").Validform({
				btnSubmit : "#saveInfo",
				tiptype : 3,
				beforeSubmit : function() {
					return confirm("确认新增user吗？");
				}
			});
			$( "#datepicker" ).datepicker({
				dateFormat: "yy-mm-dd",
				maxDate: "+0d",
				gotoCurrent: true,
				yearRange: "1970:2015",
				showAnim: "fold"
			});	
			});
</script>
</body>
</html>
