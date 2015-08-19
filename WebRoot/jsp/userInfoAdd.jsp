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
	<script type="text/javascript" src="resource/layer/layer.js"></script>
</head>
<body class="bg-info">
	<div>
		<form id="userInfoAdd" name="userInfoAdd" class="userInfo"
			action="user/userInfoAdd.do" method="post">
			<table>
				<tr>
					<td><font color="red">*</font>姓名</td>
					<td><input type="text" name="qqName" datatype="*1-20"
						nullmsg="请输入1-20位的字符" class="qqName">
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>年龄</td>
					<td><input type="text" name="qqAge" datatype="n1-2"
						nullmsg="请输入1-2位的数字" class="qqAge">
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>性别</td>
					<td><input type="text" name="qqSex" datatype="/男|女/"
						nullmsg="请输入‘男’或‘女’" class="qqSex">
					</td>
				</tr>
				<tr>
					<td><font color="red">*</font>生日</td>
					<td><input type="text" name="qqBirthday" id="datepicker" 
						nullmsg="请选择日期" class="qqBirthday"/>
					</td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="qqAddress" ignore="ignore" class="qqAddress">
					</td>
				</tr>
				<!--<tr>
					<td>工作</td>
					<td><input type="text" name="qqJob" ignore="ignore">
					</td>
				</tr>-->
			</table>
			<input type="button" id="saveInfo" value="保存"  class="btn btn-primary" onclick="closeLayer()" class="btn btn-primary"/>
		</form>
	</div>
<script>
$(function() {
			$(".userInfo").Validform({
				tiptype : 3,
			});
			$( "#datepicker" ).datepicker({
				dateFormat: "yy-mm-dd",
				maxDate: "+0d",
				gotoCurrent: true,
				yearRange: "1970:2015",
				showAnim: "fold"
			});	
			});
			function closeLayer(){	
				$.ajax({
					type: "POST",
					url:"user/userInfoAdd.do",
					data:{qqName:$(".qqName").val(),qqAge:$("qqAge").val(),qqSex:$(".qqSex").val(),qqAddress:$(".qqAddress").val(),qqBirthday:$(".qqBirthday").val()},
					success:function(){
						var index = parent.layer.getFrameIndex(window.name);
						parent.layer.close(index);
					}
				});
			}
</script>
</body>
</html>
