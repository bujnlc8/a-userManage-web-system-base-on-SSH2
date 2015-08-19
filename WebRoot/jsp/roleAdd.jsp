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
		<form id="roleAdd" name="roleAdd" class="ee"
			action="role/addRole.do" method="post">
			<table>
				<tr>
					<td><font color="red">*</font>角色名</td>
					<td><input type="text" name="qqName" datatype="*1-20"
						nullmsg="请输入3-20位的字符">
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>角色描述</td>
					<td><textarea name="qqDescription" rows="4" cols="100" datatype="*"></textarea>
					</td>
				</tr>
			</table>
			<input type="button" id="saveInfo" value="保存" class="btn btn-primary"/>
		</form>
	</div>
<script>
$(function(){
			$(".ee").Validform({
				btnSubmit : "#saveInfo",
				tiptype : 3,
				beforeSubmit : function() {
					return confirm("确认新增角色吗？");
				}
			});
});
</script>
  </body>
</html>
