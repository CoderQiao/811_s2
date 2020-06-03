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
    
    <title>My JSP 'user-input.jsp' starting page</title>
    
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
  <s:form action="/usermanage/user-save" method="post">
  	<s:textfield name="realName" label="姓名"></s:textfield>
	<s:password name="password" label="密码"></s:password>
	<s:textfield name="email" label="邮箱"></s:textfield>
	  <s:hidden name="userId"></s:hidden>
    <select name="admin">
    	<s:if test='admin == "0"'>
    		<option value ="0">管理员</option>
    		<option value ="1">普通用户</option>
    	</s:if>
    	<s:else>
    		<option value ="1">普通用户</option>
			<option value ="0">管理员</option>
    	</s:else>
		
	</select>	
	<s:submit value="提交"></s:submit>
  </s:form>
    <!-- 
  
    
     -->
 <br>
  </body>
</html>
