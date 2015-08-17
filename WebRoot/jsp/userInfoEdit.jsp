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
		<form id="userInfoEdit" name="userInfoEdit" class="userInfo"
			action="user/userInfoEdit.do" method="post">
			<table>
				<tr>
					<td><font color="red">*</font>姓名</td>
					<td><input type="text" name="qqName" value="<s:property value='userObject.username'/>">
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>年龄</td>
					<td><input type="text" name="qqAge" value="<s:property value='userObject.userage'/>">
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>性别</td>
					<td><input type="text" name="qqSex" value="<s:property value='userObject.usersex'/>"/>
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>生日</td>
					<td><input type="text" name="qqBirthday"  id="datepicker"
						 value="<s:property value='userObject.userbirthday'/> "/>
					</td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="qqAddress" value="<s:property value='userObject.useraddress'/>"/>
					</td>
				</tr>
				<tr style="display:none">
					<td>工作</td>
					<td><input type="text" name="qqJob"value="<s:property value='userObject.userjob'/>"/>
					</td>
				</tr>
			</table>
			<input type="button" id="saveInfo" onclick="saveUserEdit();" value="保存" />
			<input type="hidden" name="qqId" value="<s:property value='userObject.userid'/>"/>
		</form>
	</div>
	<script type="text/javascript">
	$(function(){
		$("#userInfoEdit #datepicker").datepicker({
			dateFormat: "yy-mm-dd",
			maxDate: "+0d",
			gotoCurrent: true,
			yearRange: "1970:2015",
			showAnim: "fold"
		});	
	});
	function  saveUserEdit()
	{
		userInfoEdit.submit();
	}
	window.onload=function(){
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
