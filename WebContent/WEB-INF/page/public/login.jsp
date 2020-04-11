<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="logo.jsp"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><spring:message code="title"></spring:message></title>
	<link href="css/public/login.css" rel="stylesheet" type="text/css" />
	<script src="jquery/jquery.min.js"  type="text/javascript"></script>
	<script src="js/public/login.js"  type="text/javascript"></script>
  </head>
  <body>
  	<center>
  		<h2 class="login_text"><spring:message code="login"></spring:message></h2>
		<table>
			<tr>
				<td><spring:message code="tel"></spring:message>：</td>
				<td><input id="tel" type="text" name="email"  class="textSize"/></td>
			</tr>
			<tr>
				<td><spring:message code="password"></spring:message>：</td>
				<td><input id="password" type="password" name="password" class="textSize"/></td>
			</tr>		
			<tr>
				<td><spring:message code="code"></spring:message>：</td>
				<td><input id="codeInput" type="text" name="code" class="textSize"/></td>
			</tr>		
			<tr class="v_code">
				<td >
					<img class="v_img" id="code" src="validateCode"/>
				</td>
				<td class="ared">
					<a href="javascript:refreshCode();"><font color="blue"><spring:message code="next"></spring:message>！</font></a>
				</td>
			</tr>		
			<tr>
				<td class="but" colspan="2">
					<input type="image" src="img/gogo.png" onclick="login()">
					<input type="image" src="img/cancel.png" onclick="cancel()">
				</td>
			</tr>
		</table>
	</center>
  </body>
</html>
