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
	<link href="<%=path%>/css/before/index.css" rel="stylesheet" type="text/css" />
	<script src="<%=path%>/jquery/jquery.min.js"  type="text/javascript"></script>
	<script src="<%=path%>/js/before/index.js"  type="text/javascript"></script>
</head>
<body>
	<div class="index">
		<div class="index_center">
			<div class="index_center_middle">
				<!-- 所有电影 -->
				<div class="new">
					<div class="new_goods">
						<div class="movie_show">
							<ul>
								<c:if test="${movieList == null }">
									暂时没有影片信息哦 ! !
								</c:if>
								<c:if test="${movieList != null }">
									<c:forEach items="${movieList }" var="sg">
										<li>
											<div>
												<p class="pic">
													<a href="<%=path%>/movieDetail?movieId=${sg.id }">
													<img class="new_show" title="${sg.description}" src="<%=path%>/img/1.jpg" /></a>
												</p>
												<c:if test="${sg.play == 0}">
													<p class="wz">
														<div class="hi">
															<a href="<%=path%>/movieDetail?movieId=${sg.id }">${sg.name }</a>
														</div></br>
														<div class="hi_text">
															${sg.description}
														</div></br>
														<div class="f2">此电影未上映</div>
														
													</p>
												</c:if>
												<c:if test="${sg.play == 1}">
													<p class="wz">
														<div class="hi">
															<a href="<%=path%>/movieDetail?movieId=${sg.id }">${sg.name }</a>
														</div></br>
														<div class="hi_text">
															${sg.description}
														</div></br>
														<div class="f2">价格 ${sg.price} | ${sg.surplus} 剩余</div>
													</p>
												</c:if>
											</div>
										</li>
									</c:forEach>
								</c:if>
							</ul>
						</div>
						<c:if test="${movieList != null }">
							<div class="page">
								&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;第${pageNo}页&nbsp;&nbsp;
								<!-- 第一页没有上一页 -->
								<c:if test="${pageNo != null && pageNo != 1 }">
									<a href="<%=path%>/index/page?pageNo=${pageNo - 1 }">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>
								<!-- 最后一页，没有下一页 -->
								<c:if test="${totalPage != 0 && totalPage == 10}">
									<a href="<%=path%>/index/page?pageNo=${pageNo + 1 }">下一页</a>
								</c:if>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
