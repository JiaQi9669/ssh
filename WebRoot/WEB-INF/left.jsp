<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    <meta http-equiv=“X-UA-Compatible” content=“chrome=1″ />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- basic styles -->
	<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="assets/css/font-awesome.min.css" />

	<!--[if IE 7]>
	  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
	<![endif]-->

	<!-- page specific plugin styles -->


	<!-- ace styles -->

	<link rel="stylesheet" href="assets/css/ace.min.css" />
	<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="assets/css/ace-skins.min.css" />

	<!--[if lte IE 8]>
	  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
	<![endif]-->

	<!-- inline styles related to this page -->

	<!-- ace settings handler -->

	<script src="assets/js/ace-extra.min.js"></script>

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->

  </head>
  
  <body>
    <div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					

					<ul class="nav nav-list">
						<li class="active open">
							<a>
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 信息统计 </span>
							</a>
							<ul class="submenu">
							<li>
									<a href="Baseindex2">
										<i class="icon-double-angle-right"></i>
										首页
									</a>
								</li>
								<li>
									<a href="Baseindex">
										<i class="icon-double-angle-right"></i>
										部门统计
									</a>
								</li>
								<li>
									<a href="Basetype">
										<i class="icon-double-angle-right"></i>
										类型统计
									</a>
								</li>

								<li>
									<a href="Basearea">
										<i class="icon-double-angle-right"></i>
										区域统计
									</a>
								</li>
								<!-- <li>
									<a href="Basecusttom">
										<i class="icon-double-angle-right"></i>
										自定义
									</a>
								</li> -->
							</ul>
						</li>
						<li class="active open">
							<a>
								<i class="icon-text-width"></i>
								<span class="menu-text"> 内务查询 </span>
							</a>
							<ul class="submenu">
								<li>
									<a href="Basereader">
										<i class="icon-double-angle-right"></i>
										读者查询
									</a>
								</li>
								
								<li>
									<a href="Basecomprehensive">
										<i class="icon-double-angle-right"></i>
										内务报表
									</a>
								</li>
								
								<li>
									<a href="Basetop">
										<i class="icon-double-angle-right"></i>
										排行榜
									</a>
								</li>

 								<li>
									<!-- <a href="Basereport">
										<i class="icon-double-angle-right"></i>
										内务报表
									</a> -->
								</li>
								
							
							</ul>
						</li>

					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

  </body>
</html>
