<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="../../css/admin/type.css" type="text/css" rel="stylesheet">
	<script src="../../jquery/jquery.min.js" type="text/javascript"></script>
	<script src="../../js/admin/type.js" type="text/javascript"></script>
</head>
<body>
	<div class="outer">
		<h2>| 类型添加</h2>
		类型名称: <input id="typeName" class="te" type="text" name="name"/>&nbsp;&nbsp;&nbsp;&nbsp;
		类型code: <input id="typeCode" class="te" type="text" name="code"/>&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="but" type="button" value="添加" onclick="addType()"/>
		<br>
		<c:if test="${allTypes.size() == 0 }">
			您还没有类型。
		</c:if>
		<c:if test="${allTypes.size() != 0 }">
			<h2>| 商品类型</h2>
			<table border="1" >
				<tr>
					<th>类型ID</th>
					<th>类型名称</th>
					<th>类型code</th>
					<th>删除操作</th>
				</tr>
				<c:forEach items="${allTypes }" var="movieType">
					<tr>
						<td>${movieType.id }</td>
						<td>${movieType.name }</td>
						<td>${movieType.code }</td>
						<td>
							<a href="javascript:void(0);" class="dele" onclick="deleteTy('${movieType.id}')">
								<img title="删除该类型" alt="" src="../../img/delete.png"/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="typepage">
				&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;第${pageNo}页&nbsp;&nbsp;
				<!-- 第一页没有上一页 -->
				<c:if test="${pageNo != null && pageNo != 1  }">
					<a href="../../admin/type/page?pageNo=${pageNo - 1 }">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<!-- 最后一页，没有下一页 -->
				<c:if test="${totalPage != 0 && totalPage == 8}">
					<a href="../../admin/type/page?pageNo=${pageNo + 1 }">下一页</a>
				</c:if>
			</div>
		</c:if>
	</div>
</body>
</html>