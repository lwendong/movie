<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加商品</title>
<link href="../../css/admin/moviedetail.css" type="text/css" rel="stylesheet">
<script src="../../jquery/jquery.min.js" type="text/javascript"></script>
<script src="../../js/admin/addMovie.js" type="text/javascript"></script>
</head>    
<body>
	<form action="../../admin/movie/addOrUpdateMovie" method="post" enctype="multipart/form-data" id="movieForm">
		<table>
			<h2>| 添加/修改电影信息</h2>
			<input name="id" value="${movie.id}" hidden="hidden" />
			<tr>
				<td class="one"><font color="red">*</font>影片名:</td>
				<td class="tow">
					<input class="in" name="name" value="${movie.name}"/>
				</td>
			</tr>
			<tr>
				<td class="one"><font color="red">*</font>影片描述:</td>
				<td class="tow">
					<input class="in" name="description" value="${movie.description}"/>
				</td>
			</tr>
			<tr>
				<td class="one"><font color="red">*</font>影票价格:</td>
				<td class="tow">
					<input class="in" name="price" value="${movie.price}"/>
				</td>
			</tr>
			<tr>
				<td class="one"><font color="red">*</font>影票剩余:</td>
				<td class="tow">
					<input class="in" name="surplus" value="${movie.surplus}"/>(最多为40  如过超出40 自动设置为40)
				</td>
			</tr>
			<tr>
				<td class="one"><font color="red">*</font>影片封面:</td>
				<td class="tow">
					<input class="in" type="file" name="file"/>
				</td>
			</tr>
			<tr>
				<td class="one"><font color="red">*</font>影片上映时间:</td>
				<td class="tow">
					<input class="in releaseTime" type="datetime-local" value="${movie.releaseTimeLocal}"/>
					<input class="in releaseTimeNew" name="releaseTimeLocal" hidden="hidden"/>
				</td>
			</tr>
			<c:if test="${movie.id != null }">
				<tr>
					<td class="one"><font color="red">*</font>是否上映:</td>
					<td class="tow">
						<input type="radio" name="play" value="1" id="radio1" <c:if test="${movie.play == 1 }">checked</c:if> /><label for="radio1">是</label>
    					<input type="radio" name="play" value="0" id="radio2" <c:if test="${movie.play == 0 }">checked</c:if> /><label for="radio2">否</label>(如果选择是 上映时间会自动设置为当前时间)
					</td>
				</tr>
			</c:if>
			<tr>
				<td class="one"><font color="red">*</font>影片上映地点:</td>
				<td class="tow">
					<input class="in" name="playPlace"  value="${movie.playPlace}"/>(多个地点用/分隔)
				</td>
			</tr>
			<tr>
				<td class="one"><font color="red">*</font>影片类型:</td>
				<td class="tow">
					<select class="in typeCode" name="typeCode" >
						<option  value="${movie.typeCode}">${movie.typeName}</option>
						<c:forEach items="${movieTypeList}" var="var" varStatus="vs">
							<c:if test="${movie.typeCode != var.code }">
								<option value="${var.code}"> ${var.name}</option>
							</c:if>
                        </c:forEach>
   					</select>
				</td>
			</tr>
			<tr>
				<td class="one" align="center">
					<input class="but1" type="button" onclick="sub()" value="提交"/>
				</td>
				<td class="but" align="left">
					<input class="but1" type="reset" value="重置"/>
					<input class="but1" type="button" value="返回" onclick="returnPage()" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
