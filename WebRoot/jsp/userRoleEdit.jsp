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
	<div>
	<s:form action="user/doSubmitRoles.do">
		<s:optiontransferselect doubleList="userSelectedRolesList"
			list="userUnSelectedRolesList" doubleName="userSelectedRoles" name="userUnSelectedRoles"
			addAllToLeftLabel="全部左移" addAllToRightLabel="全部右移"
			doubleMultiple="true" selectAllLabel="全部选择" emptyOption="true"
			doubleEmptyOption="true"  headerValue="未选择角色"
		     doubleHeaderValue="已选择角色" />
			<input type="hidden" name="qqId" readonly
						value="<s:property value='userObject[0]'/>">
		<s:submit value="提交" onclick="selectElement()">
		</s:submit>
	</s:form>
	</div>
	<a href="role/getRoleInfoList.do">角色详情</a>
</body>
<script type="text/javascript">

function selectElement()
{
	    var right = document.forms[0].userSelectedRoles;  
	    for(var i=1;i<right.length;i++) 
	    	if(right[i].value=="无"){
	    		right[i].selected = false;
	    	}else{
	        right[i].selected = true; } 
	} 
</script>
</html>
