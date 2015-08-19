<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/common.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<link href="resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="resource/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="resource/layer/layer.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
  <body>
  <div>
		<form id="roleUserAdd" name="roleUserAdd"
			action="user/addUserRole.do" method="post">
			<table>
				<tr>
					<td>角色id</td>
					<td><input type="text" name="qqId" readonly value='<s:property value="qqId_"/>'>
					</td>
				</tr>
				<tr>
					<td>人员</td>
					<td><select name="qqUserId">
					<s:iterator value="objects" status="stat">
					<option value="<s:property value='objects[#stat.index][0]'/>"><s:property value='objects[#stat.index][1]'/></option>
					</s:iterator>
					</select>
					</td>
				</tr>
				<tr>
					<td>状态</td>
					<td><select name="qqState">
					<option value="1">启用</option>
					<option value="0">禁用</option>
					</select>
					</td>
				</tr>
			</table>
			<input type="button" id="saveInfo" value="保存" class="btn btn-primary"/>
		</form>
	</div>
	<script>
	$("#saveInfo").click(function(){
		roleUserAdd.submit();
	});
	</script>
  </body>
</html>
