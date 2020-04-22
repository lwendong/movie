<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<jsp:include page="../../page/public/head.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>影片详情</title>
<script src="<%=path%>/jquery/jquery.min.js"></script>
<link href="<%=path%>/css/before/usercontroller.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/before/moviedetail.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div class="list">
		<div class="list-group">
			<div class="list_bottom_gd">
				<form name="putcartform" method="post">
					<div class="goods">
						<div class="goodsInfo">
							<input type="hidden" name="id" value="${movie.id }"/>
							<img src="<%=imgPath%>/img/${movie.img }" width="230px" height="280px" />
							<div style="text-align: center;" class="name">
								<h2>${movie.name }</h2>
							</div>
						</div>
						<!--商品表述-->
						<div class="goods_desc">
							<div class="goods_show">
								<ul>
									<li><span>类型:</span> ${movie.typeName }</li>
									<li><span>上映时间:  </span><fmt:formatDate value="${movie.releaseTime }" pattern="yyyy-MM-dd HH:mm"/></li>
									<li><span>上映地点:  </span>${movie.playPlace }</li>
									<li><span>简介:</span>
										<div class="ms" title="${movie.description }">
											${movie.description }
										</div>
									</li>
								</ul>
								<c:if test="${user != null }">
									<c:if test="${movie.play == 1 }">
										<li><span>票价:</span> <strong class="xj">${movie.price }元</li>
										<li>
											<span><spring:message code="Purchasequantity"></spring:message>:</span>
											<input id="shopping" type="text" name="shoppingnum" class="good_txt" value="1" /> 
											<span class="xj">(票数剩余${movie.surplus })</span>
										</li>
										<p class="bottom10 top5">
											<c:if test="${isBuy == 0 }">
												<input type="button" style="cursor: pointer" class="bnt2" onclick="buy('${movie.id }')" value="买票" />
											</c:if>
											<c:if test="${isBuy == 1 }">
												<input type="button" style="cursor: default" class="bnt2" value="已购票" disabled="disabled"/>
											</c:if>
										</p>
									</c:if>
									<c:if test="${movie.play == 0 }"><span style="font-size:25px;color:red">此影片未上映</span></c:if>
								</c:if>
							</div>
						</div>
						<!--end-->
					</div>
					<div >
						
					</div>  
				</form>
				<div class="container">
					<div class="goods_com">影片评价</div>
					<c:if test="${commentList == null}">
						暂无评价
					</c:if>
					<c:if test="${commentList != null}">
						<c:forEach items="${commentList}" var="comment" varStatus="status">
		                    <div class="media">
	                             <h3 class="media-heading">${comment.userName}:</h3> 
	                             <p class="middle"><spring:message code="comment"></spring:message>：${comment.comment}</p>
	                             <p>${status.index+1}<spring:message code="tower"></spring:message>&nbsp;&nbsp;
	                             	<fmt:formatDate value="${ comment.time }" pattern="yyyy-MM-dd　HH:mm"/> <spring:message code="published"></spring:message>
	                       		 </p>
		                    </div>
		                </c:forEach>
					</c:if>
	                <c:if test="${user != null }">
	                	<div class="write">写评论</div>
		                <textarea class="com_text" id="textareaComment" rows="3" name="textarea"></textarea>
		                <button class="bnt" id="submit-info-btn" onclick="submitInfo()">评论</button>
	                </c:if>
	                
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	var movieId='${movie.id }';
	function buy(id) {
		debugger
		var snum = parseInt($("#shopping").val());
		var inve = parseInt('${movie.surplus }');
		if(snum > inve){
			alert("影票不足");
		}else if(snum < 0 || snum == 0){
			alert("购买数量不能为负和0");
		}else{
			
			document.putcartform.action="buy?movieId="+movieId+"&num="+snum;
			document.putcartform.submit();
		}
		
	}
	var baselocation='<%=basePath%>';
	
	function submitInfo(){
		var data=$("#textareaComment").val();
		var commentdata={};
		if(data!=null){
			commentdata.comment = data;
			commentdata.movieId = movieId;
			$.ajax({
		        url: 'addComment',
		        type: 'post',
		        dateType:"json",
		        data:JSON.stringify(commentdata),
		        contentType: 'application/json; charset=UTF-8',
		        success:function(data){
		        	top.location="<%=path%>/movieDetail?movieId="+movieId;
		        }
		    });	
			
		}
	}
</script>
</body>
</html>
