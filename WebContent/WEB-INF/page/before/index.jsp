<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<jsp:include page="../public/head.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><spring:message code="home"></spring:message></title>
<link href="css/before/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
		function hiddenDiv(){
			 var tbox=document.getElementById("sale");   
			 tbox.style.display = tbox.style.display=="none"?"":"none";   
		}
		function hiddenPDiv(){
			 var tbox=document.getElementById("popular");   
			 tbox.style.display = tbox.style.display=="none"?"":"none";   
		}
</script>
</head>
<body>
	<div class="index">
		<div class="index_center">
			<div class="index_center_middle">
				<!-- 所有电影 -->
				<div class="new">
					<div class="new_goods">
						<ul>
							<c:forEach items="${lastedlist }" var="sg">
								<li>
									<div>
										<p class="pic">
											<a href="goodsDetail?id=${sg.id }">
											<img class="new_show" title="${sg.description}" src="<%=imgPath%>/img/up/${sg.img}" /></a>
										</p>
										<p class="wz">
											<div class="hi">
												<a href="goodsDetail?id=${sg.id }">${sg.name }</a>
											</div></br>
											<div class="hi_text">
												简介：基本法客户警方未婚夫未必减减肥被u啊u咖啡货币u阿布货物功夫亚非v九九八幅v额纠结啊比uiu拜访给i因违反v与 与高峰v欧阳
											</div></br>
											<div class="f2">价格 160.00 | 40  剩余</div>
										</p>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
