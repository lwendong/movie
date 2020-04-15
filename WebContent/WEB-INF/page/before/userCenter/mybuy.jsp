<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<title>我的信息</title>
	<link href="<%=path%>/css/before/mybuy.css" rel="stylesheet" type="text/css" />
	<script src="<%=path%>/jquery/jquery.min.js"></script>
</head>
<body>
	<div class="cart_big">
		<c:if test="${ticketlist == null}">
			<div id="sr" align="center">
				<h1 class='result'>
					您还没有购买电影票
				</h1>
			</div>
		</c:if>
		<c:if test="${ticketlist != null}">
			<table id="mytable" class="movie_info_table" cellpadding="6" cellspacing="1" >
				<tr>
					<th>电影名</th>
					<th>票价（元）</th>
					<th>数量</th>
					<th>上映时间</th>
					<th>购买时间</th>
					<th>退票</th>
				</tr>
				<tr>
					<td class="cart_space" colspan="6"></td>
				</tr> 
				<c:forEach var="ce" items="${ticketlist}"> 
					<tr>
						<td class="goods_info">
							${ce.movieName}
						</td>
						<td class="goods_info_115" >
							${ce.moviePrice}
						</td>
						<td class="goods_info_115" >
							${ce.num}
						</td>
						<td class="goods_info_115" >
							${ce.movieTime}
						</td>
						<td class="goods_info_115">
							<fmt:formatDate value="${ce.time}" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td class="goods_info_185">
							<a class="a_text" style="text-decoration: none;" href="<%=path%>/userCenter/refund?id=${ce.id}&pageNo=${pageNo}&num=${ce.num}" onClick="return confirm('确定退票吗?');" title="退票">
							退票
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
					<a href="<%=path%>/userCenter/userMyBuy?pageNo=${pageNo - 1 }">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<!-- 最后一页，没有下一页 -->
				<c:if test="${totalPage != null && totalPage != 0}">
					<a href="<%=path%>/userCenter/userMyBuy?pageNo=${pageNo + 1 }">下一页</a>
				</c:if>
			</div>
		</c:if>
	</div>
</body>
</html>