<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<jsp:include page="../../page/public/head.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><spring:message code="home"></spring:message></title>
	<link href="css/before/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="index">
	<div class="index_center">
		<div class="index_center_middle">
			<div class="new">
					<div class="new_goods">
						<ul>
							<c:forEach items="${movieByType }" var="sg">
								<li>
										<div>
											<p class="pic">
												<a href="goodsDetail?id=${sg.id }">
												<img class="new_show" title="${sg.description}" src="img/xxx.png.jpg" /></a>
											</p>
											<p class="wz">
												<div class="hi">
													<a href="goodsDetail?id=${sg.id }">${sg.name }</a>
												</div></br>
												<div class="hi_text">
													${sg.description}
												</div></br>
												<c:if test="${sg.play == 0}">
													<div class="f2">此电影未上映</div>
												</c:if>
												<c:if test="${sg.play != 0}">
													<div class="f2">价格 ${sg.price} | ${sg.surplus} 剩余</div>
												</c:if>
											</p>
										</div>
									</li>
							</c:forEach>
							<div class="page">
								&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;第${pageNo}页&nbsp;&nbsp;
								<!-- 第一页没有上一页 -->
								<c:if test="${pageNo != null && pageNo != 1 }">
									<a href="<%=path%>/index/page?pageNo=${pageNo - 1 }&typeCode=${movieType }">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>
								<!-- 最后一页，没有下一页 -->
								<c:if test="${totalPage != 0 && totalPage == 10}">
									<a href="<%=path%>/index/page?pageNo=${pageNo + 1 }&typeCode=${movieType }">下一页</a>
								</c:if>
							</div>
						</ul>
					</div>
				</div>
		</div>
	</div>
</div>
</body>
</html>
