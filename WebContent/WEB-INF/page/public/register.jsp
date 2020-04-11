<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="logo.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/public/register.css" rel="stylesheet" type="text/css" />
<script src="jquery/jquery.min.js"  type="text/javascript"></script>
<script src="js/public/register.js" type="text/javascript"></script>
</head>
<body>
	<center>
		<div>
			<h2 class="re_lo"><spring:message code='register'></spring:message></h2>
			<div class="regist">
				<form:form action="user/register" method="post" modelAttribute="user"  name="registerForm">
					<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="one_list"><span class="star">*</span>
								<spring:message code='userName'></spring:message>：</td>
							<td>
								<input type="text" id="name" name="name" class="reg_input" />
							</td>
							<td width="25%"></td>
						</tr>
						<tr>
							<td class="one_list">&nbsp;</td>
							<td class="prompt" colspan="2">
								（<spring:message code='userNameCheck'></spring:message>！）</td>
						</tr>
						<tr>
							<td class="one_list"><span class="star">*</span>
								<spring:message code='tel'></spring:message>：</td>
							<td>
								<input type="text" id="tel" name="tel" class="reg_input" />
							</td>
							<td width="25%"></td>
						</tr>
						<tr>
							<td class="one_list">&nbsp;</td>
							<td class="prompt" colspan="2">
								（<spring:message code='telCheck'></spring:message>。）</td>
						</tr>
						<tr>
							<td class="one_list"><span class="star">*</span> <spring:message code='password'></spring:message>：</td>
							<td><input type="password" id="password" name="password" class="reg_input" /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td class="one_list">&nbsp;</td>
							<td colspan="2" class="prompt">
								（<spring:message code='passwordCheck'></spring:message>。）</td>
						</tr>
						<tr>
							<td class="one_list"><span class="star">*</span> <spring:message code='repeatPassword'></spring:message>：</td>
							<td><input type="password" id="rebpwd" name="rebpwd" class="reg_input" /></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td class="one_list">&nbsp;</td>
							<td colspan="2" class="prompt">
								（<spring:message code='passwordMark'></spring:message>。）</td>
						</tr>				
						<tr>
							<td class="one_list"><span class="star">*</span> <spring:message code='code'></spring:message>：</td>
							<td colspan="2">
								<input type="text" id="codeInput"  name="code" class="reg_input" />
								<img class="code_img" id="code" src="validateCode" /> 
								<a href="javascript:refreshCode();"><spring:message code='next'></spring:message>！</a>
							</td>
						</tr>
						<tr>
							<td class="one_list">&nbsp;</td>
							<td class="subm"><input id="text" type="button" name="button" onclick="checkForm()" value="<spring:message code='register'></spring:message>" class="reg_submit" /></td>
							<td>&nbsp;</td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</center>
</body>
</html>
