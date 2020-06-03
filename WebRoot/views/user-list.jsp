<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="script/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
    	$(function(){
		//1. 点击 delete 时, 弹出 确定是要删除 xx 的信息吗 ? 若确定, 执行删除, 若不确定, 则取消
		$(".delete").click(function(){
			var realName = $(this).next(":hidden").val();
			var flag = confirm("确定要删除" + realName + "的信息吗?");
			if(flag){
				var $tr = $(this).parent().parent();
				//删除, 使用 ajax 的方式
				var req = {};
				var url = $(this).attr("data");
				$.post(url, req, function(data){
					//若 data 的返回值为 1, 则提示 删除成功, 且把当前行删除
					if(data == "1"){
						alert("删除成功!");
						$tr.remove();
					}else{
						//若 data 的返回值不是 1, 提示删除失败. 
						alert("删除失败!");
					}
				});	
			}
			
			//取消超链接的默认行为
			return false;
		});		
	});
    </script>
    
    <title>My JSP 'user-list.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<br>
    <h4>用户信息管理页面</h4>
    <a href="<%=path%>/views/user-input.jsp">添加用户</a>
    <br><br>
    <s:if test="#request.users == null || #request.users.size() == 0">
    	没有任何用户信息！
    </s:if>
    <s:else>
    	<table border="1" cellpadding="10" cellspacing="0">
    		<tr>
    			<td>用户ID</td>
    			<td>用户密码</td>
    			<td>真实姓名</td>
    			<td>邮箱</td>
    			<td>权限</td>
    			<td>删除</td>
    			<td>修改</td>
    		</tr>
    		<s:iterator value="#request.users">
    			<tr>
    				<td>${userId }</td>
    				<td>${password }</td>
    				<td>${realName }</td>
    				<td>${email }</td>
    				<td>
    					<s:if test='admin == "0"'>管理员</s:if>
						<s:else>普通用户</s:else>			
					</td>
    				<td>
    					<a href="" class="delete" data="<%=path %>/usermanage/user-delete?id=${userId }">删除</a>
    					<input type="hidden" value="${realName }"/>
    				</td>
    				<td>
    					<a href="<%=path %>/usermanage/user-edit?id=${userId }">修改</a>
    				</td>
    			</tr>
    		</s:iterator>
    	</table>
    </s:else>
  </body>
</html>
