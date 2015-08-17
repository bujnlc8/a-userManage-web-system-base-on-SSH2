<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登陆</title>
	<meta http-equiv="expires" content="0">    
<script type="text/javascript" src="resource/jquery/jquery-1.8.3.min.js"></script>
  </head>
  <body>
   <form>
  <table>
  <tr>
  <td>用户名</td><td><input type="text" name="qName" id ="qName" ></td>
  </tr>
  <tr>
  <td>密码</td><td><input type="password" name="qPassword" id ="qPassword" ></td>
  </tr>
  <tr><td colspan="2"><input id="btn_sub" type="button" value="登陆" onclick="javascript:checkValid();"></td></tr>
  <label id="tip" style="display:none"></label>
  </table> 
   </form>
   <script>
   function checkValid()
   {
	  $.ajax({
		  type:"post",
		  url:"admin/isAdminValid.do",
		  data:{name:$("#qName").val(),password:$("#qPassword").val()
			  },
		  success : function(data) {
				var result = data;
				if ("valid" == result) {
					$("#tip").hide();
					$("#btn_sub").removeAttr("disabled");
					window.location ="user/userInfoList.do";
				} else if ("invalid" == result) {
					document.getElementById('tip').innerHTML = "用户名或密码错误！";
					$("#tip").show();
					$("#btn_sub").attr("disabled", "disabled");
				}else if("isBlank"==result)
					{
					document.getElementById('tip').innerHTML ="请输入用户名和密码！";
					$("#tip").show();
					$("#btn_sub").attr("disabled", "disabled");
					}
			}
		});
   } 
   </script>
  </body>
</html>
