<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<base href="<%=basePath%>">

<title>郑州轻工业学院图书馆人流量统计系统</title>
<meta http-equiv=“X-UA-Compatible” content=“chrome=1″ />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- basic styles -->
<!-- <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" /> -->
<style>

table {
	border-collapse: collapse;
	border-spacing: 0;
	padding: 20px;
	width: 100%;
}

.div-inline {
	display: inline
}

.zebra td,.zebra th {
	padding: 10px;
	border-bottom: 1px solid #f2f2f2;
}
.zebra tbody tr:nth-child(even) {
	background: #f5f5f5;
	-webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	-moz-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
}

.zebra th {
	text-align: left;
	text-shadow: 0 1px 0 rgba(255, 255, 255, .5);
	border-bottom: 1px solid #ccc;
	background-color: #eee;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#f5f5f5),
		to(#eee) );
	background-image: -webkit-linear-gradient(top, #f5f5f5, #eee);
	background-image: -moz-linear-gradient(top, #f5f5f5, #eee);
	background-image: -ms-linear-gradient(top, #f5f5f5, #eee);
	background-image: -o-linear-gradient(top, #f5f5f5, #eee);
	background-image: linear-gradient(top, #f5f5f5, #eee);
}

.zebra th:first-child {
	-moz-border-radius: 6px 0 0 0;
	-webkit-border-radius: 6px 0 0 0;
	border-radius: 6px 0 0 0;
}

.zebra th:last-child {
	-moz-border-radius: 0 6px 0 0;
	-webkit-border-radius: 0 6px 0 0;
	border-radius: 0 6px 0 0;
}

.zebra th:only-child {
	-moz-border-radius: 6px 6px 0 0;
	-webkit-border-radius: 6px 6px 0 0;
	border-radius: 6px 6px 0 0;
}

.zebra tfoot td {
	border-bottom: 0;
	border-top: 1px solid #fff;
	background-color: #f1f1f1;
}

.zebra tfoot td:first-child {
	-moz-border-radius: 0 0 0 6px;
	-webkit-border-radius: 0 0 0 6px;
	border-radius: 0 0 0 6px;
}

.zebra tfoot td:last-child {
	-moz-border-radius: 0 0 6px 0;
	-webkit-border-radius: 0 0 6px 0;
	border-radius: 0 0 6px 0;
}

.zebra tfoot td:only-child {
	-moz-border-radius: 0 0 6px 6px;
	-webkit-border-radius: 0 0 6px 6px border-radius:              0 0 6px
		6px
}
</style>

<!--[if IE 7]>
	  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
	<![endif]-->

<!-- page specific plugin styles -->


<!-- ace styles -->

<!-- <link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="assets/css/ace-skins.min.css" /> -->

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

<script src="highCharts/highcharts.js"></script>

</head>

<body style="overflow-y:visible;">

	<!-- 组装头部 -->
	<jsp:include page="head.jsp"></jsp:include>


	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span> </a>

			<!-- 组装左侧菜单 -->
			<jsp:include page="left.jsp"></jsp:include>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a>内务查询</a></li>
						<li class="active">排行榜</li>
					</ul>
					<!-- .breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>排行榜</h1>
					</div>
					<span style="display:block;text-align: center;font-size:20px">排行榜</span>
				</div>
				<br>

				<div style="height: auto;width: 1000px; margin: 0 auto ;">
					<div class="div-inline" style="margin:10 10;float: left;">
						<table class="zebra" style="width: 280px;">
							<thead>
								<tr align="center">
									<th colspan="3" style="text-align:center;">读者前10</th>
								</tr>
							</thead>
							<tr>
								<td>名次</td>
								<td>名字</td>
								<td>次数</td>
							</tr>
							<s:iterator value="toplist1" id="toplist1" status="sta">
								<tr>
									<td><s:property value="#sta.getIndex()+1" /></td>
									<td><s:property value="#toplist1.getKey()" /></td>
									<td><s:property value="#toplist1.getValue()" /></td>
								</tr>
							</s:iterator>
						</table>

					</div>
					
					<div class="div-inline" style="margin:10 10;float: left;">
						<table class="zebra" style="width: 280px;">
							<thead>
								<tr align="center">
									<th colspan="3" style="text-align:center;">学院前10</th>
								</tr>
							</thead>
							<tr>
								<td>名次</td>
								<td>学院</td>
								<td>次数</td>
							</tr>
							<s:iterator value="toplist2" id="toplist2" status="sta">
								<tr>
									<td><s:property value="#sta.getIndex()+1" /></td>
									<td><s:property value="#toplist2.getKey()" /></td>
									<td><s:property value="#toplist2.getValue()" /></td>
								</tr>
							</s:iterator>
						</table>
					</div>

					<div class="div-inline" style="float: left;margin:10 10;">
						<table class="zebra" style="width: 280px;">
							<thead>
								<tr align="center">
									<th colspan="3" style=" text-align:center;">类型前10</th>
								</tr>
							</thead>
							<tr>
								<td>名次</td>
								<td>类型</td>
								<td>次数</td>
							</tr>
							<s:iterator value="toplist3" id="toplist3" status="sta">
								<tr>
									<td><s:property value="#sta.getIndex()+1" /></td>
									<td><s:property value="#toplist3.getKey()" /></td>
									<td><s:property value="#toplist3.getValue()" /></td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
		<!-- /.main-content -->

		<div class="ace-settings-container" id="ace-settings-container">
			<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
				id="ace-settings-btn">
				<i class="icon-cog bigger-150"></i>
			</div>

			<div class="ace-settings-box" id="ace-settings-box">
				<div>
					<div class="pull-left">
						<select id="skin-colorpicker" class="hide">
							<option data-skin="default" value="#438EB9">#438EB9</option>
							<option data-skin="skin-1" value="#222A2D">#222A2D</option>
							<option data-skin="skin-2" value="#C6487E">#C6487E</option>
							<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
						</select>
					</div>
					<span>&nbsp; 选择皮肤</span>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-navbar" /> <label class="lbl"
						for="ace-settings-navbar"> 固定导航条</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-sidebar" /> <label class="lbl"
						for="ace-settings-sidebar"> 固定滑动条</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-breadcrumbs" /> <label class="lbl"
						for="ace-settings-breadcrumbs">固定面包屑</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-rtl" /> <label class="lbl"
						for="ace-settings-rtl">切换到左边</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-add-container" /> <label class="lbl"
						for="ace-settings-add-container"> 切换窄屏 <b></b> </label>
				</div>
			</div>
		</div>
		<!-- /#ace-settings-container -->
	</div>
	<!-- /.main-container-inner -->

	<!-- 	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="icon-double-angle-up icon-only bigger-110"></i> </a> -->
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->

	<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script> -->

	<!-- <![endif]-->

	<!--[if IE]>
<![endif]-->

	<!--[if !IE]> -->

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"script>");
	</script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->

	<script src="assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/js/jquery.slimscroll.min.js"></script>
	<script src="assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="assets/js/jquery.sparkline.min.js"></script>
	<script src="assets/js/flot/jquery.flot.pie.min.js"></script>

	<!-- ace scripts -->

	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
</body>
</html>
