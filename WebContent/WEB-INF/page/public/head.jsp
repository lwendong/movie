<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><spring:message code="home"></spring:message></title>
<link href="<%=path%>/css/before/head.css" rel="stylesheet" type="text/css" />
<script src="jquery/jquery.min.js"></script>
<script type="text/javascript">
	function clearValue(){
		document.form.mykey.value = "";
	}
	function jump(){
		sessionStorage.setItem("jump", "cart");
		window.location.href="/shop/userControllerCenter";
	}
	function openNotice(url){
		window.open (url, '<spring:message code="announcement"></spring:message>', 'height=400, width=400, top=100, left=100, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no');
	}
</script>
</head>
<body>
	<div class="box">
		<div class="top">
			<div class="big_top">
				<div class="big_ul">
					
					<ul>
						<li class="user_a">
							<c:if test="${user!=null}"><spring:message code="welcome"></spring:message> ${user.name }</c:if>
							<c:if test="${user==null}"><a href="toLogin"><spring:message code="login"></spring:message></a></c:if> |
						</li>
						<li class="user_a">
							&nbsp;<a href="toRegister"><spring:message code="register"></spring:message></a> |
						</li>
						<li class="user_a">
							&nbsp;<a href="userControllerCenter"><spring:message code="userCenter"></spring:message></a> |
						</li>
						<li class="user_a">
							&nbsp;<span class="dropdown">
									  <button class="dropbtn">公告</button>
									  <span class="dropdown-content">
									    <a class="hii" href="javascript:openNotice('/shop/selectANotice?noticeId=${nt.id }');">213456456u四ui吧vjhyuiulnkmsdlzjbulg</a>
									  </span>
									</span>									
						</li>
						
					</ul>
					<c:if test="${user!= null}">	
						<div class="exit"><a href="user/exit"><spring:message code="exit"></spring:message></a></div>
					</c:if>
				</div>
			</div>
		</div>
		<div class="bottom_big">
			<div class="bottom_top">
				<!-- LOGO -->
				<div class="logo">
					<spring:message code="shopLogo"></spring:message>
				</div>
				
				<!-- 搜索 -->
				<div class="search_goods">
					<div class="eye"><img alt="" src="img/eye.png" /></div>
					<form name="form" action="search" method="post">
						<div class="input_text">
							<input class="search_input" type="text" name="mykey" placeholder="<spring:message code="inputTitel"></spring:message>" onfocus="clearValue()">
						</div>
						<div class="input_button">
							<input class="button" type="submit" name="submit" value="<spring:message code="search"></spring:message>">
						</div>
					</form>
				</div>
				<!-- 购物车 -->
				<div class="cart">
					<a href="JavaScript:jump()"><input class="cart_button" type="button" name="cart" value="购票信息"></a>
					<div class="catr_img"><img class="img_c" src="img/cart.png" alt=""/></div>
				</div>
				<!-- 导航条 -->
				<div class="navigation">
					<ul>
						<li class="home"><a href="before"><spring:message code="index"></spring:message></a></li>
						<!-- 显示商品类型 -->
						<c:forEach items="${goodsType}" var="g">
							<li class="ification"><a id="gt" href="goodsbyType?typeCode=${g.code }&&typeName=${g.name }">
							${g.name }</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
