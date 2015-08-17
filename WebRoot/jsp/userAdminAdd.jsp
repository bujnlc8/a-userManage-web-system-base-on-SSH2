<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>增加管理员</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="resource/passwordStrength/style/main.css" rel="stylesheet"
	media="screen">
<script type="text/javascript" src="resource/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript"
	src="resource/passwordStrength/jquery.passwordStrength.js"
	charset="UTF-8"></script>
<body>
</head><body>
	<div>
		<form name="addAdminUser" method="post">
			<table>
				<tr>
					<td><label>用户ID:</label></td>
					<td><select id="selectId" name="qqIds">
							<s:iterator value="objects" status="stat">
								<option value="<s:property value='objects[#stat.index][0]'/>"
									id="<s:property value='#stat.count'/>">
									<s:property value='objects[#stat.index][0]' />
								</option>
							</s:iterator>
					</select></td>
				</tr>
				<tr>
					<td><label>用户名:</label></td>
					<td><select id="selectUser" name="qqName">
							<s:iterator value="objects" status="stat">
								<option value="<s:property value='objects[#stat.index][1]'/>"
									id="<s:property value='#stat.count'/>">
									<s:property value='objects[#stat.index][1]' />
								</option>
							</s:iterator>
					</select></td>
				</tr>
				<tr>
					<td><label>用户密码</label></td>
					<td><input type="password" id="pass" name="qqPassword"><div id="passwordStrengthDiv" class="is0"></div> 
					</td>
				</tr>
				<tr>
					<td><label>用户权限:</label></td>
					<td><select name="qqPrevileges">
							<option value="1">普通管理员</option>
							<option value="2">超级管理员</option>
					</select></td>
				</tr>
			</table>
			<input type="button" value="保存" onclick="toSave();">
		</form>
	</div>
	<script type="text/javascript">
		$("#selectId").change(function() {
			var idSelected = $("#selectId").find("option:selected").attr("id");
			var selectUser = document.getElementById("selectUser");
			var a = selectUser.options;
			for ( var index = 0; index < a.length; index++) {
				if (a[index].id == idSelected) {
					selectUser.options[index].selected = true;
					break;
				}
			}
		});

		function toSave() {
			addAdminUser.action = "admin/addAdminUser.do";
			if (confirm("是否添加新的管理员？")) {
				addAdminUser.submit();

			}

		}
		$(function(){
			$('#pass').passwordStrength();
		});
	</script>
</body>
</html>
