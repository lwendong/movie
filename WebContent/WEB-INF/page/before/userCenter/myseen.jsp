<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>我看过的电影</title>
	<link href="<%=path%>/css/before/usercontroller.css" rel="stylesheet" type="text/css" />
	<script src="<%=path%>/jquery/jquery.min.js"></script>
</head>
<body>
	<div class="user_center">
		<div>
			<div class="order_list">
				<c:if test="${ticketlist == null}">
					<div id="sr" align="center">
						<h1 class='result'>
							您还没有看过电影
						</h1>
					</div>
				</c:if>
				<c:if test="${ticketlist != null}">
					<table width="99%" align="center" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
						<tr>
							<th>电影名</th>
							<th>电影简介</th>
							<th>上映时间</th>
						</tr>
						<tr>
							<td colspan="3" height="15px" style="border: 0 none; background: #FFF"></td>
						</tr> 
						<c:forEach var="mo" items="${ticketlist}"> 
							<c:if test="${!mo.isTp}">
								<tr>
									<td bgcolor="#ffffff" align="center">${mo.movieName}</td>
									<td bgcolor="#ffffff" align="center">${mo.movieDescription}</td>
									<td bgcolor="#ffffff" align="center" >${mo.movieTime}<%-- <fmt:formatDate value="${mo.movieTime}" pattern="yyyy-MM-dd HH:mm:ss" /> --%></td>
								</tr>
							</c:if>
						</c:forEach>
					</table>
					<div class="page">
						&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;第${pageNo}页&nbsp;&nbsp;
						<!-- 第一页没有上一页 -->
						<c:if test="${pageNo != null && pageNo != 1 }">
							<a href="<%=path%>/userCenter/userMySeen?pageNo=${pageNo - 1 }">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
						</c:if>
						<!-- 最后一页，没有下一页 -->
						<c:if test="${totalPage != null && totalPage != 0}">
							<a href="<%=path%>/userCenter/userMySeen?pageNo=${pageNo + 1 }">下一页</a>
						</c:if>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>