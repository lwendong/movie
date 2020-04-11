function checkDel(id){
	if(window.confirm("是否改变该用户状态？")){
		$.ajax({
			url:"../admin/userstate",
			type:"post",
			data:{
				"userId": id
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