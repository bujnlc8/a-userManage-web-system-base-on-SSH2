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
<script type="text/javascript"
	src="resource/validform/Validform_v5.3.2_min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
  <body>
<div>
		<form id="roleEdit" name="roleEdit" 
			action="role/roleEdit.do" method="post">
			<table>
				<tr>
					<td><font color="red">*</font>角色名</td>
					<td><input type="text" name="qqName" value="<s:property value='roleObject.roleName'/>">
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>角色描述</td>
					<td><textarea name="qqDescription" id="myDescription"></textarea>
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>创建日期</td>
					<td><input type="text" name="qqCreateTime"  id="datepicker"
						 value="<s:property value='roleObject.roleCreateTime'/> "/>
					</td>
				</tr>
			</table>
			<input type="button" id="saveInfo" onclick="saveRoleEdit();" value="保存" class="btn btn-primary"/>
			<input type="hidden" name="qqId" value="<s:property value='roleObject.roleId'/>"/>
		</form>
	</div>
	<script type="text/javascript">
	$(function(){
		$("#datepicker").datepicker({
			dateFormat: "yy-mm-dd",
			maxDate: "+0d",
			gotoCurrent: true,
			yearRange: "1970:2015",
			showAnim: "fold"
		});	
	});
	function  saveRoleEdit()
	{
		roleEdit.submit();
	}
	window.onload = function(){
		$("#myDescription").text("<s:property value='roleObject.roleDescription'/>");
			var mytime=$("#datepicker").val();
			var strs = new Array();
			strs = mytime.split("-");
		    var str1,str2,str3;
		    str1="20"+strs[0]+"-";
		    if(strs[1].trim().length==1)
		    	{
		    	str2="0"+strs[1]+"-";
		    	}else
		    		{
		    		str2=strs[1]+"-";
		    		}
		    if(strs[2].trim().length==1)
		    	{
		    	str3="0"+strs[2];
		    	}else{
		    		str3=strs[2];
		    	}
			$("#datepicker").val((str1+str2+str3).trim());
	}
	</script>
  </body>
</html>
