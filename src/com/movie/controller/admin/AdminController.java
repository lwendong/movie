package com.movie.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.movie.service.admin.AdminService;

/**
 * 管理后台 用户管理
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	/**
	 * 管理后台 退出
	 */
	@RequestMapping("/exit")
	@ResponseBody
	public JSONObject exit(HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		session.invalidate();
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	/**
	 * 管理后台 用户管理
	 */
	@RequestMapping("/user")
	public String toUser(Model model) {
		return adminService.toUser(model, 1);
	}
	
	/**
	 * 管理后台 更改用户状态
	 */
	@RequestMapping("/userstate")
	@ResponseBody
	public JSONObject userState(String userId) {
		return adminService.userState(userId);
	}
	/**
	 * 管理后台 分页查询用户
	 */
	@RequestMapping("/page")
	public String pageSwitch (Model model,Integer pageNo) {
		return adminService.toUser(model,pageNo);
	}
}
