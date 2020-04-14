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
	<link href="<%=path%>/css/public/head.css" rel="stylesheet" type="text/css" />
	<script src="<%=path%>/jquery/jquery.min.js" type="text/javascript"></script>
	<script src="<%=path%>/js/public/head.js"  type="text/javascript"></script>
</head>
<body>
	<div class="top">
		<div class="big_top">
			<div class="big_ul">
				
				<ul>
					<li class="user_a">
						<c:if test="${user!=null}">欢迎  ${user.name }</c:if>
						<c:if test="${user==null}"><a href="<%=path%>/tologin">登录</a></c:if> |
					</li>
					<li class="user_a">
						<c:if test="${user==null}">
							&nbsp;<a href="<%=path%>/toregister">注册</a> |
						</c:if>
					</li>
					<li class="user_a">
						<c:if test="${user!=null}">
							&nbsp;<a href="<%=path%>/userCenter/userCenterControl">用户中心</a> |
						</c:if>
					</li>
					<li class="user_a">
						&nbsp;
						<span class="dropdown">
						  <button class="dropbtn">公告</button>
						  <span class="dropdown-content">
						  	<c:forEach items="${noticeList}" var="nt">
								<a class="hii" href="javascript:openNotice('<%=path%>/admin/notice/noticeDetailsForBefore?noticeId=${nt.id }');" title="${nt.title }">${nt.title }</a>
							</c:forEach>
						    
						  </span>
						</span>									
					</li>
					
				</ul>
				<c:if test="${user!= null}">	
					<div class="exit"><a id="exit" href="<%=path%>/user/exit"><spring:message code="exit"></spring:message></a></div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
