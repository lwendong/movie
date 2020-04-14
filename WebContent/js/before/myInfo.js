function updateInfo(){
	var user={};
	var name = $("#name").val();
	var tel = $("#tel").val();
	var email = $("#email").val();
	var pwd = $("#password").val();
	var age = $("#age").val();
	var sex = document.getElementsByName("sex");
	var reg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
	var value = "";
	for(var i=0;i<sex.length;i++){
		if(sex[i].checked == true){
			value = sex[i].value;
		}
	}
	//邮箱不为空
	debugger
	if(name != "" || tel != "" || email != ""|| pwd != ""|| age != ""|| value != ""){
		//检测邮箱格式
		if(email != ""){
			if(reg.test(email)==false){
				alert("邮箱格式不正确！");
				return false;
			}
		}
	}else{
		return false;
	}
	
	user.id=$("#id").val();
	user.name=name;
	user.tel=tel;
	user.email=email;
	user.password=pwd;
	user.age=age;
	user.sex=value;
	$.ajax({
        url: '../userCenter/updateInfo',
        type: 'post',
        dateType:"json",
        data:JSON.stringify(user),
        contentType: 'application/json; charset=UTF-8',
        success: function (retuslt) {
            alert("修改成功,需要重新登录");
            sessionStorage.removeItem("user");
            top.location="../user/exit";
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
            alert("系统繁忙，请稍后再操作！");
        }
    });		
}