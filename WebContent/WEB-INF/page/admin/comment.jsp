<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>评论管理</title>
	<link href="../../css/admin/movie.css" type="text/css" rel="stylesheet">
	<script src="../../jquery/jquery.min.js" type="text/javascript"></script>
	<script src="../../js/admin/comment.js" type="text/javascript"></script>
</head>
<body>
	<div class="outer">
		<h2>| 评论管理</h2><a class="add" href="../../admin/user" target="center">用户管理</a><a class="addOne" href="../../admin/ticket/ticket" target="center">购/退票查看</a>
		<table border="1" >
			<tr>
				<th width="400px">影片评论ID</th>
				<th width="300px">影片评论人ID</th>
				<th width="300px">被评论影片ID</th>
				<th width="250px">影片评论</th>
				<th width="250px">创建时间</th>
				<th width="250px">操作</th>
			</tr>
			<c:forEach var="n" items="${allComments}">
				<tr>
					<td>${n.id}</td>
					<td>${n.userId}</td>
					<td>${n.movieId}</td>
					<td>${n.comment}</td>
					<td><fmt:formatDate value="${n.time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>
						<a onclick="deleteOne('${n.id}')" target="_blank">
							<img title="删除该评论" alt="" src="../../img/delete.png"/>
						</a>
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
				<a href="../../admin/comment/page?pageNo=${pageNo - 1 }" target="center">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>
			<!-- 最后一页，没有下一页 -->
			<c:if test="${totalPage != null && totalPage != 0}">
				<a href="../../admin/comment/page?pageNo=${pageNo + 1 }" target="center">下一页</a>
			</c:if>
		</div>
	</div>
</body>
</html>