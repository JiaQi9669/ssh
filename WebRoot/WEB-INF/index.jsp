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

<script src="highCharts/highcharts.js"></script>
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
						<li class="active">部门统计</li>
					</ul>
					<!-- .breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>部门统计</h1>
					</div>
					<!-- /.page-header -->
					<div class="row">
						<div class="col-xs-12">
							<div class="widget-box">
								<div class="widget-header">
									<h4 class="smaller">请选择条件</h4>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<form action="partfindBySelect" method="post">
											<div class="control-group">
												<label class="control-label bolder blue">部门</label>
												<div class="checkbox">
													<s:iterator id="part" value="#part" status="part">
														<label> <input name="chkName" type="checkbox"
															checked class="ace" value="<s:property/>" />&nbsp;<span
															class="lbl"><s:property />
														</span> </label>
													</s:iterator>
												</div>
												<label class="control-label bolder blue">时间</label>
												<div class="chkYear">
													<label> <input name="chkYear" type="radio"
														value="y1" class="ace" checked /> <span class="lbl">
															近一天</span> </label> <label> <input name="chkYear" type="radio"
														value="y2" class="ace" /> <span class="lbl"> 近一周</span> </label>
													<label> <input name="chkYear" type="radio"
														value="y3" class="ace" /> <span class="lbl"> 近一月</span> </label>
													<%-- <label> <input name="chkYear" type="radio"
														value="y4" class="ace" /> <span class="lbl"> 近一学期</span>
													</label> --%> <label> <input name="chkYear" type="radio"
														value="y5" class="ace" /> <span class="lbl"> 近一年</span> </label>
												</div>

												<div class="form-actions center">
													<script>
														var $box = document
																.getElementById('chkName');
														if ($box.checked === "checked") {
															alter("dsfszdfsdzf");
														} else {
														}
													</script>
													<input type="submit" value="查询"
														class="btn btn-sm btn-success"> </input>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">

							<div class="widget-box">
								<div class="widget-header">
									<h4 class="smaller">部门统计折线图</h4>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div id="zxt"
											style="min-width: 310px; height: 400px; margin: 0 auto"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /.row -->
					<div class="col-xs-12">

						<div class="widget-box">
							<div class="widget-header">
								<h4 class="smaller">部门统计柱状图</h4>
							</div>
							<div class="widget-body">
								<div class="widget-main">
									<div id="container"
										style="min-width: 310px; height: 400px; margin: 0 auto"></div>
								</div>
							</div>
						</div>
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

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		Highcharts.chart('zxt', {
			chart : {
				type : 'line'
			},
			title : {
				text : '部门统计折线图'
			},
			subtitle : {
				text : ''
			},
			xAxis : {
				categories : [
	<%=request.getAttribute("partName")%>
		]
			},
			yAxis : {
				title : {
					text : '人次'
				}
			},
			plotOptions : {
				line : {
					dataLabels : {
						enabled : true
					},
					enableMouseTracking : false
				}
			},
			series : [
	<%=request.getAttribute("partzxt")%>
		]

		});
		/* 柱状图 */
		Highcharts
				.chart(
						'container',
						{
							chart : {
								type : 'column'
							},
							title : {
								text : '部门统计柱状图'
							},
							subtitle : {
								text : ''
							},
							xAxis : {
								categories : [
	<%=request.getAttribute("partName")%>
		],
								crosshair : true
							},
							yAxis : {
								min : 0,
								title : {
									text : '人次'
								}
							},
							tooltip : {
								headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
								pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
										+ '<td style="padding:0"><b>{point.y:.1f} 人</b></td></tr>',
								footerFormat : '</table>',
								shared : true,
								useHTML : true
							},
							plotOptions : {
								column : {
									pointPadding : 0.2,
									borderWidth : 0
								}
							},
							series : [
	<%=request.getAttribute("partzxt")%>
		]
						});
	</script>
</body>
</html>
