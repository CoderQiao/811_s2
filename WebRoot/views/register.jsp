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
		$(":input[name=realName]").change(function(){
			var val = $(this).val();
			val = $.trim(val);
			var $this = $(this);
			
			if(val != ""){
				//把当前节点后面的所有 font 兄弟节点删除
				$this.nextAll("font").remove();
				
				var url = "validate";
				var args = {"realName":val};
				$.post(url, args, function(data){
					//表示可用
					if(data == "1"){
						$this.after("<font color='green'>用户名可用!</font>");
					}
					//不可用
					else if(data == "0"){
						$this.after("<font color='red'>用户名不可用!</font>");						
					}
					//服务器错误
					else{
						alert("服务器错误!");
					}
				});
			}else{
				alert("用户名不能为空");
				$(this).val("");
				$this.focus();
			}
		});
	})
  
    </script>
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
 
	<s:form action="register">
	  	<s:textfield name="realName" key="用户名"></s:textfield>
		<s:password name="password" key="密码"></s:password>
		<s:password name="pass" key="确认密码"></s:password>
		<s:textfield name="email" key="邮箱"></s:textfield>
		<s:hidden name="admin" value="1"></s:hidden>
		<s:hidden name="userId"></s:hidden>
		<s:submit value="注册"></s:submit>
		<br><br>
	 </s:form>

  </body>
</html>
