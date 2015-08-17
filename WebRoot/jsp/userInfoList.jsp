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
</head>
<body>
	<div style="float:right">
		<s:if test='#session.quanxian=="2"'>
			<a href="admin/userAdminInfoList.do">管理员</a>
			&nbsp;&nbsp;<a href="admin/userAdminLogout.do">注销</a>
		</s:if>
	</div>
	<div id="selectOption">
		<form id="userInfoList" name="userInfoList"
			action="${ctx}user/userInfoList.do" method="post">
			<table align="center" width="40%">
				<tr>
					<td>用户名：</td>
					<td align="center"><input id="qqName" name="qqName"
						type="text"></td>
					<td>年龄:</td>
					<td align="center"><input name="qqAge" id="qqAge" type="text">
					</td>
				</tr>
				<tr>
					<td>性别:</td>
					<td align="center"><input name="qqSex" id="qqSex" type="text">
					</td>

					<td></font>生日：</td>
					<td align="center"><input name="qqBirthday" type="text"
						id="datepicker"></td>
				</tr>
				<tr>
					<td style="display:none">工作:</td>
					<td align="center" style="display:none"><input name="qqJob" id="qqJob" type="text">
					</td>
					<td>角色:</td>
					<td align="center"><input name="qqRole" id="qqRole" type="text">
					</td>

					<td>地址:</td>
					<td align="center"><input name="qqAddress" id="qqAddress"
						type="text"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button"
						id="btn_submit" onclick="javascript:toSearch();" value="查询" /></td>
					<td colspan="2" align="center"><input type="button"
						id="bbtn_reset" onclick="javascript:toReset()" value="重置" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="userInfo">
		<form id="infoList" name="infoList" method="post">
			<table width="70%" align="center" border="1">
				<tr>
					<th width="6%"><input type="checkbox" class="user_cb"
						id="checkAll" onclick="javascript:selectAll();" title="全部选中">
					</th>
					<th width="14%" align="center">姓名</th>
					<th width="14%" align="center">年龄</th>
					<th width="14%" align="center">性别</th>
					<th width="14%" align="center">生日</th>
					<th width="14%" align="center">地址</th>
					<th width="14%" align="center" style="display:none">工作</th>
					<th width="14%" align="center">角色</th>
					<th width="10%" align="center">操作</th>
				</tr>
				<s:iterator value="object" status="stat" id="id">
					<tr>
						<td align="center"><input type="checkbox" name="qqIds"
							value="<s:property value='object[#stat.index][0]'/>"
						</td>
						<td align="center"><s:property value="object[#stat.index][1]" />
						</td>
						<td align="center"><s:property value="object[#stat.index][2]" />
						</td>
						<td align="center"><s:property value="object[#stat.index][3]" />
						</td>
						<td align="center"><s:property value="object[#stat.index][4]" />
						</td>
						<td align="center"><s:property value="object[#stat.index][5]" />
						</td>
						<td align="center" style="display:none"><s:property value="object[#stat.index][6]" />
						</td>
						<td align="center"><s:property value="object[#stat.index][7]" />
						</td>
						<td align="center"><a
							href="javascript:userInfoDetail('<s:property value="object[#stat.index][0]"/>')"><font size="2">查看</font></a>
							&nbsp;<a
							href="javascript:goUserInfoEdit('<s:property value="object[#stat.index][0]"/>')"><font size="2">编辑</font></a>
							&nbsp;<a
							href="javascript:goUserRoleEdit('<s:property value="object[#stat.index][0]"/>')"><font size="2">角色管理</font></a>
						</td>
					</tr>
				</s:iterator>
			</table>
			<div align="center">
				<input type="button" id="todelete" value="删除"
					style="width:100px;height:30px;margin-top:15px;"
					onclick="javascript:toDelete();" /><input type="button" id="add"
					value="增加"
					style="width:100px;height:30px;margin-top:15px;margin-left:50px"
					onclick="toAdd()">
			</div>
			<input type="hidden" name="qqId" />
		</form>
	</div>
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
		function toSearch() {
			var frm = document.userInfoList;
			frm.submit();
		}
		function toReset() {
			var inputs = document.getElementsByTagName("input");
			for ( var i = 0; i < 6; i++) {
				inputs[i].value = "";
			}
		}
		$("#datepicker").datepicker({
			dateFormat: "yymmdd",
			maxDate: "+0d",
			gotoCurrent: true,
			yearRange: "1970:2015",
			showAnim: "fold"
		});		
		function toDelete() {
			if ($(":checked").length == 0) {
				alert("please select one at least!");
			} else {
				if (confirm("确定删除所选吗？")) {
					var frm = document.infoList;
					frm.action = "user/deleteUserInfo.do";
					frm.submit();
				}
			}
		}
		function toAdd() {
			window.location = "user/goAddUserInfo.do";
		}
		function goUserInfoEdit(id)
		{
			infoList.qqId.value=id;
			infoList.action="user/goUserInfoEdit.do";
			infoList.submit();
		}
		function goUserRoleEdit(id)
		{
			infoList.qqId.value=id;
			infoList.action="user/goUserRoleEdit.do";
			infoList.submit();
		}
		function userInfoDetail(id)
		{
			infoList.qqId.value=id;
			infoList.action="user/userInfoDetail.do";
			infoList.submit();
		}
	</script>
</body>
</html>
