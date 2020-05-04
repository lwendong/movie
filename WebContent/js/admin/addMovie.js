function sub(){
	var releaseTime = $(".releaseTime");
	var releaseTimeNew = $(".releaseTimeNew");
	time = releaseTime.val();
	newTime = time.replace("T"," ");
	releaseTimeNew.val(newTime);
	
	var playTime = $(".playTime");
	var playTimeNew = $(".playTimeNew");
	playTime = playTime.val();
	newTimePlay = playTime.replace("T"," ");
	playTimeNew.val(newTimePlay);
	debugger
	var release = new Date(newTime).getTime();
	var play = new Date(newTimePlay).getTime();
	if(release > play){
		alert("播放时间不能在上映时间之前");
		return false;
	}
	
	$("#movieForm").submit();
}
function returnPage(){
	window.history.back(-1); 
}