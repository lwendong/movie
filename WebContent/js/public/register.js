//刷新验证码
function refreshCode(){
	document.getElementById("code").src = "validateCode?" + Math.random();
}
//表单验证
function checkForm(){
	debugger
	var name = $("#name");
	var tel = $("#tel").val();
	//检测两次密码是否一致
	var bpwd = $("#password").val();
	var rebpwd = $("#rebpwd").val();
	//判断验证码是否为空
	var yzm = $("#codeInput").val();
	/*var telTest = ;
	var passwordTest = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d){6,}$/;*/
	if(name.val().length > 6){
		alert("用户名超长!");
		return false;
	}
	//验证手机号格式
	var reg = /^1[3|4|5|7|8][0-9]{9}$/;
	//邮箱不为空
	if(tel != ""){
		//检测邮箱格式
		if(!reg.test(tel)){
			alert("手机号不正确!");
			return false;
		}
	}else{
		alert("手机号不能为空!");
		return false;
	}
	
	if(yzm == ""){
		alert("验证码不能为空!");
		return false;
	}
	
	//两次密码不能为空
	var pawReg = /^(?!([a-zA-Z]+|\d+)$)[a-zA-Z\d]{6,20}$/;
	if(bpwd != "" && rebpwd != ""){
		if(bpwd != rebpwd){
			alert("两次密码不相等!");
			return false;
		}else{
			if(!pawReg.test(bpwd)){
				alert("密码格式不正确!");
				return false;
			}
		}
	}else{
		alert("两次密码不能为空!");
		return false;
	}
	//提交表单
	$.ajax({
		url:"user/register",
		contentType: 'application/json',
		dataType:"json",
		type:"POST",
		data:JSON.stringify({
			name:name.val(),
			tel:tel,
			password:bpwd,
			code:yzm
		}),  
        success: function(data){
        	if(data.success){
        		sessionStorage.setItem('user', data.user);
    			window.location.href="toindex"
        	}else{
        		alert(data.msg);
        	}
        },
        error:function(err){
          console.log(err.statusText);
        }
	});
	
	return true;
}