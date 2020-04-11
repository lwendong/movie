package com.movie.controller.pub;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.pojo.User;

@Controller
public class PageController {
	
	@RequestMapping("/tologin")
	public String toLogin() {
		return "public/login";
	}
	
	@RequestMapping("/toregister")
	public String toRegister() {
		return "public/register";
	}
	
	@RequestMapping("/toindex")
	public String toIndex() {
		return "before/index";
	}
	
	@RequestMapping("/toadminindex")
	public String toAdminIndex(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null || !user.getIsAdmin()){
			return "redirect:/toindex";
		}else {
			return "admin/main";
		}
	}
	
}
