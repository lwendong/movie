<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <title>购/退票查看</title>
	<link href="../../css/admin/movie.css" type="text/css" rel="stylesheet">
	<script src="../../jquery/jquery.min.js" type="text/javascript"></script>
	<script src="../../js/admin/comment.js" type="text/javascript"></script>
</head>
<body>
	<div class="outer">
		<h2>| 购/退票查看</h2><a class="addOne" href="../../admin/comment/comment" target="center">评论管理</a> <a class="add" href="../../admin/user" target="center">用户管理</a>
		<table border="1" >
			<tr>
				<th width="400px">购/退票ID</th>
				<th width="400px">购/退票人ID</th>
				<th width="400px">购/退票影片ID</th>
				<th width="250px">购/退票数</th>
				<th width="250px">购/退票时间</th>
				<th width="250px">类型</th>
			</tr>
			<c:forEach var="n" items="${allTickets}">
				<tr>
					<td>${n.id}</td>
					<td>${n.userId}</td>
					<td>${n.movieId}</td>
					<td>${n.num}</td>
					<td><fmt:formatDate value="${n.time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>
						<c:if test="${n.type}">退票</c:if>
						<c:if test="${!n.type}">购票</c:if>
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
				<a href="../../admin/ticket/page?pageNo=${pageNo - 1 }" target="center">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>
			<!-- 最后一页，没有下一页 -->
			<c:if test="${pageNo != totalPage && totalPage != 0 && totalPage > 10}">
				<a href="../../admin/ticket/page?pageNo=${pageNo + 1 }" target="center">下一页</a>
			</c:if>
		</div>
	</div>
</body>
</html>