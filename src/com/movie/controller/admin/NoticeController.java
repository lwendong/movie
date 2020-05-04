package com.movie.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Notice;
import com.movie.service.admin.NoticeService;
/**
 * 管理后台 公告管理
 */
@Controller
@RequestMapping("/admin/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	/**
	 * 管理后台 跳转到公告管理页面并查询数据
	 */
	@RequestMapping("/notice")
	public String toNotice (Model model) {
		return noticeService.toNotice(model,1);
	}
	
	/**
	 * 管理后台 添加公告
	 */
	@RequestMapping("/addNotice")
	public String toAddNotice(){
		return "admin/addNotice";
	}
	
	/**
	 * 管理后台 添加或者更新公告
	 */
	@RequestMapping("/addOrUpdateNotice")
	public String addOrUpdateNotice(Notice notice){
		return noticeService.addOrUpdateNotice(notice);
	}
	
	/**
	 * 管理后台 删除一条公告
	 */
	@RequestMapping("/deleteOneNotice")
	@ResponseBody
	public JSONObject deleteOneNotice(String noticeId){
		return noticeService.deleteOneNotice(noticeId);
	}
	
	/**
	 * 管理后台 公告详情
	 */
	@RequestMapping("/noticeDetails")
	public String noticeDetails(String noticeId,Model model){
		return noticeService.noticeDetails(noticeId,model);
	}
	
	/**
	 * 管理后台 分页查询公告
	 */
	@RequestMapping("/page")
	public String pageSwitch (Model model,Integer pageNo) {
		return noticeService.toNotice(model,pageNo);
	}
	

	/**
	 * 管理后台 前台使用的公告方法
	 */
	@RequestMapping("/noticeDetailsForBefore")
	public String noticeDetailsForBefore(String noticeId,Model model){
		return noticeService.noticeDetailsForBefore(noticeId,model);
	}
	
	
}
