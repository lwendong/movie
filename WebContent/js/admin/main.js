function exit(){
	$.ajax({
		  url:"admin/exit",
		  type:"post",
		  success: function(data){
			  sessionStorage.setItem('user',null);
		  },
		  error: function (XMLHttpRequest, textStatus, errorThrown) {
		    console.log(textStatus, errorThrown);
		    alert("系统繁忙，请稍后再操作！");
		  }
		});
}