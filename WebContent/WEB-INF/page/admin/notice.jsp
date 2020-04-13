<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>后台管理</title>
	<link href="../../css/admin/movie.css" type="text/css" rel="stylesheet">
	<script src="../../jquery/jquery.min.js" type="text/javascript"></script>
	<script src="../../js/admin/notice.js" type="text/javascript"></script>
</head>
<body>
	<div class="outer">
		<h2>| 公告列表</h2><a class="add" href="../../admin/notice/addNotice">添加公告</a>
		<c:if test="${allNotices.size() == 0 }">
			没有公告。
		</c:if>
		<c:if test="${allNotices.size() != 0 }">
			<table border="1">
				<tr>
					<th width="350px">ID</th>
					<th width="350px">标题</th>
					<th width="350px">内容</th>
					<th width="300px">时间</th>
					<th width="100px">详情</th>
					<th width="100px">操作</th>
				</tr>
				<c:forEach items="${allNotices }" var="notice">
					<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
						<td width="350px">${notice.id }</td>
						<td width="350px">${notice.title }</td>
						<td width="350px">${notice.content }</td>
						<td width="300px"><fmt:formatDate value="${notice.time }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td width="100px"><a href="../../admin/notice/noticeDetails?noticeId=${notice.id}">详情</a></td>
						<td width="100px">
							<a href="javascript:checkDel('${notice.id }')">
								<img title="删除该公告" alt="" src="../../img/delete.png"/>
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
					<a href="../../admin/notice/page?pageNo=${pageNo - 1 }">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:if>
				<!-- 最后一页，没有下一页 -->
				<c:if test="${totalPage != 0 && totalPage == 10}">
					<a href="../../admin/notice/page?pageNo=${pageNo + 1 }">下一页</a>
				</c:if>
			</div>
		</c:if>
	</div>
</body>
</html>