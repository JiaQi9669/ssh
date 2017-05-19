<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />

<!--[if IE 7]>
	  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
	<![endif]-->

<!-- page specific plugin styles -->

<!-- fonts -->

<!-- ace styles -->

<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<link href="css/demo1.css" rel="stylesheet" />
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
<%-- <script src="assets/js/jquery-2.0.3.min.js"></script> --%>
</head>

<body>

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
						<li><i class="icon-home home-icon"></i> <a>信息统计</a>
						</li>
						<li class="active">首页</li>
					</ul>
					<!-- .breadcrumb -->
				</div>

				<div class="page-content" style="">
					<div class="page-header">
						<h1>首页</h1>
					</div>
				</div>
				<div id="interface">
					<h1>图书馆入馆信息管理系统</h1>
					<script type="text/javascript">
						function test() {
							$.ajax({
								//提交数据的类型 POST GET
								type : "POST",
								//提交的网址
								url : "Baseindex2.jsp",
								//提交的数据
								//data:{Name:"sanmao",Password:"sanmaoword"},
								//返回数据的格式
								datatype : "html",//"xml", "html", "script", "json", "jsonp", "text".
							//在请求之前调用的函数
							//beforeSend:function(){$("#msg").html("logining");},
							//成功返回之后调用的函数             
							/* success:function(data){
							$("#msg").html(decodeURI(data));            
							}   , */
							//调用执行后调用的函数
							/* complete: function(XMLHttpRequest, textStatus){
							   alert(XMLHttpRequest.responseText);
							   alert(textStatus);
							    //HideLoading();
							},
							//调用出错执行的函数
							error: function(){
							    //请求出错处理
							}   */
							});

						}
					</script>
					<div id="haha">
						<span style="cursor:default">主馆昨天进馆人数</span>
						<span>
						${requestScope.num }&nbsp;人
						</span>
						<br /> 
						
						<br />
					</div>
				</div>
				<!-- /.page-content -->
			</div>

			<!-- /.main-content -->

			<div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
					id="ace-settings-btn">
					<i class="icon-cog bigger-150"></i>
				</div>
			</div>
			<!-- /#ace-settings-container -->
		</div>
		<!-- /.main-container-inner -->

<!-- 		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i> </a> -->
	</div>


	<!--[if !IE]> -->




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
<%-- 	<script src="assets/js/flot/jquery.flot.resize.min.js"></script> --%>

	<!-- ace scripts -->

	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
</body>
</html>
