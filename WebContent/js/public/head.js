function clearValue(){
	document.form.mykey.value = "";
}
function jump(){
	sessionStorage.setItem("jump", "buy");
	window.location.href="userCenter/userCenterControl";
}
function openNotice(url){
	window.open (url, '<spring:message code="announcement"></spring:message>', 'height=400, width=400, top=100, left=100, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no');
}

