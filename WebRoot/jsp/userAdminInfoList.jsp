<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="resource/jquery/jquery-1.8.3.min.js"></script>
<body>
	<div style="float:right">
		<s:if test='#session.quanxian=="2"'>
			<a href="user/userInfoList.do">人员信息管理</a>
			&nbsp;&nbsp;<a href="admin/userAdminLogout.do">注销</a>
		</s:if>
	</div>
	<form action="admin/userAdminInfoDelete.do" id="userAdminInfoDelete"
		name="userAdminInfoDelete">
		<s:if test='#session.quanxian=="2"'>
			<input type="button" id="todelete" value="删除"
				onclick="javascript:toDelete();" />&nbsp;<input type="button"
				id="toAdd" value="增加" onclick="javascript:addAdmin();" class="btn btn-primary"/>
		</s:if>
		<div>
			<table>
				<tr>
					<th><input type="checkbox" name="selectall"
						onclick="selectAll();">
					</th>
					<th>用户名</th>
					<th>密码</th>
					<th>权限</th>
					<th>操作</th>
				</tr>
				<s:iterator value="objects" status="stat" id="id">
					<tr>
						<td><input type="checkbox" id="qqIds" name="qqIds"
							value="<s:property value='objects[#stat.index][0]' />" />
						</td>
						<td><s:property value="objects[#stat.index][1]" />
						</td>
						<td><s:property value="objects[#stat.index][2]" />
						</td>
						<td><s:if test='objects[#stat.index][3]=="2"'>
								<label>超级管理员</label>
							</s:if> <s:elseif test='objects[#stat.index][3]=="1"'>
								<label>普通管理员</label>
							</s:elseif> <s:else>
								<label>禁用</label>
							</s:else>
						</td>
						<td><s:if test="#session.quanxian=='2'.toString()">
								<a href="#">编辑</a>&nbsp;
                                <a href="#">详情</a>
							</s:if>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		var flag = true;
		function selectAll() {
			if (flag) {
				var inputs = document.getElementsByTagName("INPUT");
				for ( var i = 0; i < inputs.length; i++) {
					if (inputs[i].type == "checkbox"
							&& inputs[i].id != "checkAll"
							&& inputs[i].disabled == false) {
						inputs[i].checked = true;
					}
				}
				flag = false;
			} else {
				var inputs = document.getElementsByTagName("INPUT");
				for ( var i = 0; i < inputs.length; i++) {
					if (inputs[i].type == "checkbox"
							&& inputs[i].id != "checkAll") {
						inputs[i].checked = false;
					}
				}
				flag = true;
			}
		}
		function toDelete() {
			var inputs = document.getElementsByTagName("INPUT");
			if (inputs.length == 4) {
				alert("最后一个管理员不能被删除！")
			} else {
				userAdminInfoDelete.submit();
			}
		}
		function addAdmin() {
			window.location = "admin/goAddUserAdmin.do";
		}
	</script>
</body>
</html>
