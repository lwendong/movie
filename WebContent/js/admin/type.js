function addType(){
	var typeName = $("#typeName").val();
	var typeCode = $("#typeCode").val();
	if(typeName == "" || typeCode == ""){
		alert("存在未填项");
		return false;
	}
	$.ajax({
        url: "../../admin/type/addType",
        type: 'post',
        dateType:"json",
        contentType: 'application/json; charset=UTF-8',
        data:JSON.stringify({
			name:typeName,
			code:typeCode
		}),  
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

function deleteTy(typeId){
	if(confirm("您确定删除吗?")){
		$.ajax({
	        url: ".../../deleteType",
	        type: 'post',
	        dateType:"json",
	        contentType: 'application/json; charset=UTF-8',
	        data:JSON.stringify({
				id:typeId
			}),  
	        success: function (data) {
	        	window.location.reload();
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	            console.log(textStatus, errorThrown);
	            alert("系统繁忙，请稍后再操作！");
	        }
	    });	
	}		
}