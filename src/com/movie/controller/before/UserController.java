package com.movie.controller.before;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.User;
import com.movie.service.before.UserService;
/**
 * 前台
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 前台 登录
	 */
	@RequestMapping("/login")
	@ResponseBody
	public JSONObject login(@RequestBody User user,HttpSession session) {
		return userService.login(user,session);
	}
	
	/**
	 * 前台 注册
	 */
	@RequestMapping("/register")
	@ResponseBody
	public JSONObject register(@RequestBody User user,HttpSession session) {
		return userService.register(user,session);
	}
	
	/**
	 * 前台 退出登录
	 */
	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		return "redirect:/toindex";
	}
}
