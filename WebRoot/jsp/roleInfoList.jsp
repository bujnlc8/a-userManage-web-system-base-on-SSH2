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
    <form id="RoleinfoList" name="RoleinfoList" method="post">
			<table width="70%" align="center" border="1">
				<tr>
					<th width="10%"><input type="checkbox" class="user_cb"
						id="checkAll" onclick="javascript:selectAll();" title="全部选中">
					</th>
					<th width="20%" align="center">角色名</th>
					<th width="20%" align="center">角色描述</th>
					<th width="20%" align="center">创建时间</th>
					<th width="20%" align="center">角色状态</th>
					<th width="20%" align="center">操作</th>
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
						<td align="center"><a
							href="javascript:userInfoDetail('<s:property value="object[#stat.index][0]"/>')"><font size="2">查看</font></a>
							&nbsp;<a
							href="javascript:goUserInfoEdit('<s:property value="object[#stat.index][0]"/>')"><font size="2">编辑</font></a>
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
    <script>
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
    
    </script>
  </body>
</html>
