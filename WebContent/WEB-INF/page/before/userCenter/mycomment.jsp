<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<link href="<%=path%>/css/before/myinfo-manager.css" rel="stylesheet" type="text/css" />
	<script src="<%=path%>/jquery/jquery.min.js"></script>
	<title>我的信息</title>
</head>
<body>
	<c:if test="${commentLiset == null}">
		<div id="sr" align="center">
			<h1 class='result'>
				您还没有评论电影
			</h1>
		</div>
	</c:if>
	<c:if test="${commentLiset != null}">
		<table class="comment_table" width="100%" align="center" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd"> 
			<tr>
				<th>电影名</th>
				<th>评论内容</th>
				<th>评论时间</th>
				<th>操作</th>
			</tr>
			<tr>
				<td colspan="4" height="15px" style="border: 0 none; background: #FFF"></td>
			</tr> 
			<c:forEach var="c" items="${commentLiset}"> 
				<tr>
					<td align="center" bgcolor="#ffffff">
						${c.movieName}
					</td>
					<td align="center" bgcolor="#ffffff">
						${c.comment}
					</td>
					<td align="center" bgcolor="#ffffff">
						<fmt:formatDate value="${c.time}" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td align="center" bgcolor="#ffffff">
						<a class="a_text" style="text-decoration: none;" href="<%=path%>/userCenter/deleteComment?id=${c.id}&pageNo=${pageNo}" onClick="return confirm('确定删除此评论吗?');" title="删除">
							删除
						</a>
					</td>
				</tr>
			</c:forEach>  	
		</table> 
		<div class="page">
			&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;第${pageNo}页&nbsp;&nbsp;
			<!-- 第一页没有上一页 -->
			<c:if test="${pageNo != null && pageNo != 1 }">
				<a href="<%=path%>/userCenter/userMyComment?pageNo=${pageNo - 1 }">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>
			<!-- 最后一页，没有下一页 -->
			<c:if test="${totalPage != null && totalPage != 0}">
				<a href="<%=path%>/userCenter/userMyComment?pageNo=${pageNo + 1 }">下一页</a>
			</c:if>
		</div> 
	</c:if>
</body>
</html>