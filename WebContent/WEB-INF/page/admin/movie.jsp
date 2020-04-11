<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>影片管理</title>
	<link href="../../css/admin/movie.css" type="text/css" rel="stylesheet">
	<script src="../../jquery/jquery.min.js" type="text/javascript"></script>
	<script src="../../js/admin/movie.js" type="text/javascript"></script>
</head>
<body>
	<div class="outer">
		<h2>| 商品列表</h2><a class="add" href="../../admin/movie/addMovie">添加影片</a>
		<c:if test="${allMovies.size() == 0 }">
			您还没有商品。
		</c:if>
		<c:if test="${allMovies.size() != 0 }">
			<table border="1" bordercolor="#343E4A">
				<tr>
					<th width="100px">选择删除</th>
					<th width="300px">ID</th>
					<th width="300px">影片名</th>
					<th width="150px">影片描述</th>
					<th width="150px">影片类型</th>
					<th width="150px">影片上映时间</th>
					<th width="200px">影片上映地点</th>
					<th width="200px">影片封面</th>
					<th width="50px">是否已上映</th>
					<th width="100px">详情</th>
					<th width="100px">删除</th>
				</tr>
				<c:forEach items="${allMovie}" var="movie">
					<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
						<td><input type="checkbox" name="checkbox1" value="${movie.id }"/></td>
						<td>${movie.id }</td>
						<td>${movie.name }</td>
						<td>${movie.description }</td>
						<td>${movie.typeName }</td>
						<td><fmt:formatDate value="${movie.releaseTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${movie.playPlace }</td>
						<td><img alt="" width="50" height="50" src="/img/up/${movie.img}"/></td>
						<td>
							<c:if test="${movie.play == 1}">是</c:if>
							<c:if test="${movie.play == 0}">否</c:if>
						</td>
						<td><a href="../../admin/movie/movieDetails?movieId=${movie.id }" target="_self">详情</a></td>
						<td>
							<a onclick="deleteOne('${movie.id}')" target="_blank">
								<img title="删除该商品" alt="" src="../../img/delete.png"/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="page">
				<button class="dele" onclick="del()">删除</button>
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;第${pageNo}页&nbsp;&nbsp;
				<!-- 第一页没有上一页 -->
				<c:if test="${pageNo != null && pageNo != 1 }">
					<a href="../../admin/movie/page?pageNo=${pageNo - 1 }">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<!-- 最后一页，没有下一页 -->
				<c:if test="${pageNo != totalPage && totalPage != 0 && totalPage > 10}">
					<a href="../../admin/movie/page?pageNo=${pageNo + 1 }">下一页</a>
				</c:if>
			</div>
		</c:if>
	</div>
</body>
</html>