package com.movie.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Notice;
import com.movie.service.admin.NoticeService;

@Controller
@RequestMapping("/admin/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/notice")
	public String toNotice (Model model) {
		return noticeService.toNotice(model,1);
	}
	
	@RequestMapping("/addNotice")
	public String toAddNotice(){
		return "admin/addNotice";
	}
	
	@RequestMapping("/addOrUpdateNotice")
	public String addOrUpdateNotice(Notice notice){
		return noticeService.addOrUpdateNotice(notice);
	}
	
	@RequestMapping("/deleteOneNotice")
	@ResponseBody
	public JSONObject deleteOneNotice(String noticeId){
		return noticeService.deleteOneNotice(noticeId);
	}
	
	@RequestMapping("/noticeDetails")
	public String noticeDetails(String noticeId,Model model){
		return noticeService.noticeDetails(noticeId,model);
	}
	
	@RequestMapping("/page")
	public String pageSwitch (Model model,Integer pageNo) {
		return noticeService.toNotice(model,pageNo);
	}
}
