function deleteOne(movieId){
	if(confirm("您确定删除吗?")){
		$.ajax({
	        url: "../../admin/comment/deleteOneComment",
	        type: 'post',
	        data:{
			  "movieId": movieId
		    },
	        success: function (data) {
	        	debugger
	        	if(!data.success){
	        		alert("删除失败");
	        	}
	        	window.location.reload();
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	            console.log(textStatus, errorThrown);
	            alert("系统繁忙，请稍后再操作！");
	        }
	    });	
	}
}