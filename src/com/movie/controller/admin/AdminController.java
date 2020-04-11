package com.movie.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.movie.service.admin.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		return "admin/login";
	}
	
	@RequestMapping("/user")
	public String toUser(Model model) {
		return adminService.toUser(model, 1);
	}
	
	@RequestMapping("/userstate")
	@ResponseBody
	public JSONObject userState(String userId) {
		return adminService.userState(userId);
	}
	
	@RequestMapping("/page")
	public String pageSwitch (Model model,Integer pageNo) {
		return adminService.toUser(model,pageNo);
	}
}
