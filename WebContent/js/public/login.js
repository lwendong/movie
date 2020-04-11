//确定按钮
function login(){
	var _tel = $("#tel").val();
	var _password = $("#password").val();
	var _code = $("#codeInput").val();
	if(_tel != "" && _password != "" && _code != ""){
		$.ajax({
			url:"user/login",
			contentType: 'application/json',
			dataType:"json",
			type:"POST",
			data:JSON.stringify({
				tel:_tel,
				password:_password,
				code:_code
			}),  
	        success: function(data){
	        	if(data.success){
	        		sessionStorage.setItem('user', data.user);
	        		if(data.user.isAdmin){
	        			window.location.href="toadminindex"
	        		}else{
	        			window.location.href="toindex"
	        		}
	        		
	        	}else{
	        		alert(data.msg);
	        	}
	        },
	        error:function(err){
	          console.log(err.statusText);
	        }
		});
	}else{
		alert("手机号或密码或验证码不能为空!");
	}
}

//取消按钮
function cancel(){
	window.history.back(-1); 
}

function refreshCode(){
	document.getElementById("code").src = "validateCode?" + Math.random();
}