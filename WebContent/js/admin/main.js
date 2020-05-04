function exit(){
	$.ajax({
	  url:"admin/exit",
	  type:"post",
	  dateType:"json",
	  contentType: 'application/json; charset=UTF-8',
	  success: function(data){
		  sessionStorage.setItem('user',null);
		  window.location.href="toindex";
	  }
	});
}