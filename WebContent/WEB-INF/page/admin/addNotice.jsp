<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加公告</title>
<link href="../../css/admin/moviedetail.css" type="text/css" rel="stylesheet">
<script src="../../jquery/jquery.min.js" type="text/javascript"></script>
<script src="../../js/admin/addNotice.js" type="text/javascript"></script>
</head>    
<body>
	<form action="../../admin/notice/addOrUpdateNotice" id="noticeForm">
		<h2>| 添加/修改公告</h2>
		<table >
			<input name="id" value="${notice.id}" hidden="hidden" />
			<tr>
				<td class="one">标题<font color="red">*</font></td>
				<td class="tow">
					<input class="in" name="title" value="${notice.title}"/>
				</td>
			</tr>
			<tr>
				<td class="one1">内容<font color="red">*</font></td>
				<td class="tow1">
					<textarea class="area" name="content">${notice.content}</textarea>
				</td>
			</tr>
			<tr>
				<td class="one" align="center">
					<input class="but1" type="button" value="提交" onclick="sub()"/>
				</td>
				<td class="but" align="left">
					<input class="but1" type="reset" value="重置"/>
					<input class="but1" type="button" value="返回" onclick="returnPage()"/>
				</td>
				
			</tr>
		</table>
	</form>
</body>
</html>
