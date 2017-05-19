<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv=“X-UA-Compatible” content=“chrome=1″ />
<meta charset="UTF-8">
<link rel="stylesheet" href="css/xgxt_login.css" />
<title>用户登录-图书管管理系统</title>
<script type="text/javascript">
function myCheck()  
            {  
               for(var i=0;i<document.myForm.elements.length-1;i++)  
               {  
                  if(document.myForm.elements[i].value=="")  
                  {  
                     alert("输入框不能为空");  
                     document.myForm.elements[i].focus();  
                     return false;  
                  }  
               }  
               return true;      
            }
</script>
</head>
<body>

	<div id="header">
		<div class="header_title">
			<span class="title_con">图书馆管理系统</span>
		</div>
	</div>
	<div id="content">
		<center>
			<div class="con">
				<div class="con_title">
					<span class="con_title_sp">欢迎登录图书馆管理系统</span>
				</div>
				<form action="userLogin" method="post" name="myForm">
					<div class="con_panel">

						<div class="con_input">
							<span>用户名：</span> <input type="text" name="username"
								placeholder="学号/工号" />
						</div>
						<div class="con_input">
							<span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="password"
								name="password" placeholder="密码" />
						</div>
						<input type="submit" value="登    录" class="submit-btn"
							onclick="return myCheck()" />
						<div>
							<%
								if(request.getAttribute("file")=="file"){
				 			%>
							<br> <span style="color:red;">账号或密码错误!</span>
							<%
								}
				 			%>
						</div>
					</div>
				</form>
			</div>
		</center>
	</div>
</body>
</html>