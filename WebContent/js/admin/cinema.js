function addCinema(){
	debugger
	var cinemaName = $("#cinemaName").val();
	var cinemaCode = $("#cinemaCode").val();
	if(cinemaName == "" || cinemaCode == ""){
		alert("存在未填项");
		return false;
	}
	$.ajax({
        url: "../../admin/cinema/addCinema",
        type: 'post',
        dateType:"json",
        contentType: 'application/json; charset=UTF-8',
        data:JSON.stringify({
			name:cinemaName,
			code:cinemaCode
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

function deleteTy(cinemaId){
	if(confirm("您确定删除吗?")){
		$.ajax({
	        url: "../../admin/cinema/deleteCinema",
	        type: 'post',
	        dateType:"json",
	        contentType: 'application/json; charset=UTF-8',
	        data:JSON.stringify({
				id:cinemaId
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