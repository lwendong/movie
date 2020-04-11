<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>用户管理</title>
	<link href="../css/admin/movie.css" type="text/css" rel="stylesheet">
	<script src="../jquery/jquery.min.js" type="text/javascript"></script>
	<script src="../js/admin/admin.js" type="text/javascript"></script>
</head>
<body>
<div class="outer">
	<h2>| 用户管理</h2><a class="add" href="../admin/comment/comment" target="center">评论管理</a><a class="addOne" href="../admin/ticket/ticket" target="center">购/退票查看</a>
	<table border="1" >
		<tr>
			<th width="400px">用户ID</th>
			<th width="300px">用户名</th>
			<th width="300px">用户手机号</th>
			<th width="250px">用户状态</th>
			<th width="250px">状态操作</th>
		</tr>
		<c:forEach var="n" items="${allUsers}">
			<tr>
				<td>${n.id}</td>
				<td>${n.name}</td>
				<td>${n.tel}</td>
				<c:if test="${n.state}">
						<td>冻结</td>
				</c:if>
				<c:if test="${!n.state}">
						<td>正常</td>
				</c:if>
				<td>
					<c:if test="${!n.state}">
						<a class="yes" href="javascript:void(0)" onclick="checkDel('${n.id}')" target="center">冻结用户</a>
					</c:if>
					<c:if test="${n.state}">
						<a class="yes" href="javascript:void(0)" onclick="checkDel('${n.id}')" target="center">解除冻结</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="page">
			&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;
			第${pageNo}页&nbsp;&nbsp;
			<!-- 第一页没有上一页 -->
			<c:if test="${pageNo != null && pageNo != 1 }">
				<a href="../admin/page?pageNo=${pageNo - 1 }" target="center">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>
			<!-- 最后一页，没有下一页 -->
			<c:if test="${pageNo != totalPage && totalPage != 0 && totalPage > 10}">
				<a href="../admin/page?pageNo=${pageNo + 1 }" target="center">下一页</a>
			</c:if>
		</div>
</div>
</body>
</html>