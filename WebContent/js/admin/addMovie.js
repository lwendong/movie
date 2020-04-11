function sub(){
	var releaseTime = $(".releaseTime");
	var releaseTimeNew = $(".releaseTimeNew");
	time = releaseTime.val();
	newTime = time.replace("T"," ");
	releaseTimeNew.val(newTime)
	$("#movieForm").submit();
}
function returnPage(){
	window.history.back(-1); 
}