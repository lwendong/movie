function changeColor(obj){
	obj.className = "bgcolor";
}
function changeColor1(obj){
	obj.className = "";
}
function checkDel(id){
	if(confirm("是否删除该公告？")){
		$.ajax({
	        url: "../../admin/notice/deleteOneNotice",
	        type: 'get',
	        contentType: 'application/json; charset=UTF-8',
	        data:{
	        	noticeId:id
			},  
	        success: function (data) {
	        	if(data.success){
	        		window.location.reload();
	        	}
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	            console.log(textStatus, errorThrown);
	            alert("系统繁忙，请稍后再操作！");
	        }
	    });	
	}
}