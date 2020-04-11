function del(){
	if(confirm("您确定删除吗?")){
	 var selectItem = [];
	 var ck = $("input[type='checkbox']:checked");
	 for(var i = 0; i<ck.length; i++){
		 if(i != ck.length-1){
			 selectItem += $(ck[i]).val() + ",";
		 }else{
			 selectItem += $(ck[i]).val();
		 }
	}
	 if(ck.length == 0){
		 alert("您没有选中任何数据");
	 }else{
		 $.ajax({
		  url:"../../admin/movie/deleteMovies",
		  type:"post",
		  data:{
			  "movieIds": selectItem
		  }, 
		  success: function(data){
		    window.location.reload();
		  },
			error: function (XMLHttpRequest, textStatus, errorThrown) {
			    console.log(textStatus, errorThrown);
			    alert("系统繁忙，请稍后再操作！");
			}
		});
	  }
	}
}

function deleteOne(movieId){
	if(confirm("您确定删除吗?")){
		$.ajax({
	        url: "../../admin/movie/deleteOneMovie",
	        type: 'post',
	        data:{
			  "movieId": movieId
		    },
	        success: function (data) {
	        	if(data.success){
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

function changeColor(obj){
	obj.className = "bgcolor";
}

function changeColor1(obj){
	obj.className = "";
}