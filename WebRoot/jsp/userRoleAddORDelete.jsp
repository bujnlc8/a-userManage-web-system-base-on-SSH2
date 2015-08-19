<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script type="text/javascript" src="resource/jquery/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="resource/layer/layer.js"></script>
</head>
<body>
	<div>
		<form id="RoleUserinfoList" name="RoleUserinfoList" method="post">
			<table width="70%" align="center" class="table  table-hover">
				<tr>
					<th width="10%"><input type="checkbox"
						id="checkAll" onclick="javascript:selectAll();" title="全部选中">
					</th>
					<th width="20%" align="center">角色名</th>
					<th width="20%" align="center">人员</th>
					<th width="20%" align="center">角色状态</th>
					<th width="20%" align="center">操作</th>
				</tr>
				<s:iterator value="objects" status="stat" id="id">
					<tr>
						<td align="center"><input type="checkbox" name="qqIds"
							value="<s:property value='objects[#stat.index][0]'/>"
						</td>
						<td align="center"><s:property
								value="objects[#stat.index][1]" /></td>
						<td align="center"><s:property
								value="objects[#stat.index][2]" /></td>
						<td align="center" class="roleState"><s:property
								value="objects[#stat.index][3]" /></td>
						<td align="center">
						<s:if test="objects[#stat.index][3]=='0'">
						<a
							href="javascript:openIt('<s:property value="objects[#stat.index][0]"/>')"><font
								size="2">启用</font>
						</a></s:if><s:elseif test="objects[#stat.index][3]=='1'"><a
							href="javascript:forbidIt('<s:property value="objects[#stat.index][0]"/>')"><font
								size="2">禁用</font>
						</a></s:elseif></td>
					</tr>
				</s:iterator>
			</table>
			<div align="center">
				<input type="button" id="todelete" value="删除"
					style="width:100px;height:30px;margin-top:15px;"
					onclick="javascript:toDelete();" class="btn btn-primary"/><input type="button" id="add"
					value="增加"
					style="width:100px;height:30px;margin-top:15px;margin-left:300px"
					onclick="toAdd('<s:property value="qqId_"/>')" class="btn btn-primary"/>
			</div>
			<input type="hidden" name="qqId" value='<s:property value="qqId_"/>' />
		</form>
	</div>
	<script type="text/javascript">
		function openIt(id) {
			$.ajax({
				type : 'POST',
				url : "user/openUserRole.do?qqId=" + id,
				data : {},
				success : function() {
					window.location.reload();
				}
			});
		}
		function forbidIt(id) {
			$.ajax({
				type : 'POST',
				url : "user/forbidUserRole.do?qqId=" + id,
				data : {},
				success : function() {
					window.location.reload();
				}
			});
		}
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
		function toDelete(){
			if ($(":checked").length == 0) {
				layer.alert("请至少选择一个删除项！");
			} else {
				if (confirm("确定删除所选吗？")) {
					
					var frm = document.RoleUserinfoList;
					frm.action = "user/deleteUserRole.do";
					frm.submit();
				}
			}		
		}
		function toAdd(id){
			var frm = document.RoleUserinfoList;
			frm.qqId.value= id;
			frm.action = "user/goAddUserRole.do";
			frm.submit();		
		}
	</script>
</body>
</html>
