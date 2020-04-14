<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>我的信息</title>
	<link href="<%=path%>/css/before/myinfo-manager.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/before/myinfo.css" rel="stylesheet" type="text/css" />
	<script src="<%=path%>/jquery/jquery.min.js" type="text/javascript"></script>
	<script src="<%=path%>/js/before/myInfo.js"  type="text/javascript"></script>

</head>
<body>
	<fieldset>
		<legend>
			<span>我的信息</span>
		</legend>
		<table class="myinfo" id="table">
			<tr>
				<th>名称:</th>
				<td>${user.name}</td>
			</tr>
			<tr>
				<th>手机号:</th>
				<td>${user.tel}</td>
			</tr>
			<tr>
				<th>email:</th>
				<td>${user.email}</td>
			</tr>
			<tr>
				<th>密码:</th>
				<td>${user.password}</td>
			</tr>
			<tr>
				<th>性别:</th>
				<td>${user.sex}</td>
			</tr>
			<tr>
				<th>年龄:</th>
				<td>${user.age}</td>
			</tr>
		</table>
	</fieldset>
	<div class="modal-header">
      <h3 class="modal-title">修改个人信息</h3>
    </div>
    <input type="hidden" id="id" value="${user.id}">
    <div class="modal-body">
    	<table>
    		<tr>
    			<td class="table_one">用户名:</td>
    			<td><input type="text" class="form-control" id="name"></td>
    		</tr>
    		<tr>
    			<td class="table_one">手机号:</td>
    			<td><input type="text" class="form-control" id="tel"></td>
    		</tr>
    		<tr>
    			<td class="table_one">电子邮箱:</td>
    			<td><input type="text" class="form-control" id="email"></td>
    		</tr>
    		<tr>
    			<td class="table_one">密码:</td>
    			<td><input type="text" class="form-control" id="password"></td>
    		</tr>
    		<tr>
    			<td class="table_one">年龄:</td>
    			<td><input type="text" class="form-control" id="age"></td>
    		</tr>
    		<tr>
    			<td class="table_one">性别:</td>
    			<td>
    				<input type="radio" id="sex1" name="sex" value="男"/><label for="sex1">男</label>
    				<input type="radio" id="sex2" name="sex" value="女"/><label for="sex2">女</label>
    			</td>
    		</tr>
    	</table>
		<button class="btn-info"  title="loadReport" onclick="updateInfo()">修改</button>
    </div>
</body>
</html>