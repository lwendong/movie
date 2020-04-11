<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>后台主页面</title>
<link href="css/admin/main.css" rel="stylesheet" type="text/css" />
<script src="jquery/jquery.min.js" type="text/javascript"></script>
<script src="js/admin/main.js" type="text/javascript"></script>
</head>
<body>
<div class="big">
	<div class="header">
		<div class="ll"><img alt="" src="img/system.png"></div>
		<div class="Logo"><u>商品购物网站后台管理</u></div>
		<div class="ll2"><img alt="" src="img/user.png"></div>
		<div class="us">${user.name}</div>
		<div class="ll"></div>
		<div class="ll2"><img alt="" src="img/exit.png"></div>
		<div class="us"><a href="javascript:exit();">exit</a></div>
		<div class="line"><font class="welcome">欢迎${user.name}进入商品购物网站后台管理系统!!!</font></div>
	</div>		
	<div class="left">
		<!-- <div class="manager_goods"></div> -->
		<div class="manager_goods">
			<a href="admin/movie/movie" target="center">
				<img alt="" src="img/movieManager.png">
				&nbsp;&nbsp;影片管理&nbsp;&nbsp;&nbsp;&nbsp;>
			</a>
		</div>
		<div class="manager_gType">
			<a href="admin/type/movietype" target="center">
				<img alt="" src="img/typeManager.png">
				&nbsp;&nbsp;类型管理&nbsp;&nbsp;&nbsp;&nbsp;>
			</a>
		</div>
		<div class="manager_user">
			<a href="admin/user" target="center">
				<img alt="" src="img/userManager.png">
				&nbsp;&nbsp;用户管理&nbsp;&nbsp;&nbsp;&nbsp;>
			</a>
		</div>
		<!-- <div class="manager_order">
			<a href="admin/orderInfo" target="center">
				<img alt="" src="img/orderManager.png">
				&nbsp;&nbsp;订单管理&nbsp;&nbsp;&nbsp;&nbsp;>
			</a>
		</div> -->
		<div class="manager_notice">
			<a href="admin/notice/notice" target="center">
				<img alt="" src="img/noticeManager.png">
				&nbsp;&nbsp;公告管理&nbsp;&nbsp;&nbsp;&nbsp;>
			</a>
		</div>
		<!-- <ul>
			<li><a href="adminNotice/toAddNotice" target="center">添加公告</a></li>
			<li><a href="adminNotice/deleteNoticeSelect" target="center">删除公告</a></li>
		</ul>
		 -->
	</div>
	<div class="content">
		<iframe class="iframe" id="iframe" src="admin/movie/movie" name="center" frameborder="0"></iframe>
	</div>
</div>
</body>
</html>


