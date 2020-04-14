package com.movie.controller.before;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.BaseModel;
import com.movie.pojo.User;
import com.movie.service.before.UserCenterService;

@Controller
@RequestMapping("/userCenter")
public class UserCenterController extends BaseModel{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserCenterService userCenterService;
	
	@RequestMapping("/userCenterControl")
	public String userCenter(HttpSession session, Model model) {
		return userCenterService.userCenter(session, model);
	}

	@RequestMapping("/userMyInfo")
	public String userMyInfo(HttpSession session, Model model) {
		return userCenterService.userInfo(session, model);
	}
	
	@RequestMapping("/updateInfo")
	@ResponseBody
	public JSONObject updateInfo(@RequestBody User user) {
		return userCenterService.updateInfo(user);
	}
	
	@RequestMapping("/userMyBuy")
	public String userMyBuy(HttpSession session, Model model,Integer pageNo) {
		return userCenterService.userMyBuy(session, model,pageNo);
	}
	
	@RequestMapping("/refund")
	public String refund(HttpSession session, Model model,String id,Integer pageNo) {
		return userCenterService.refund(session, model,id,pageNo);
	}
	
	@RequestMapping("/userMySeen")
	public String userMySeen(HttpSession session, Model model,Integer pageNo) {
		return userCenterService.userMySeen(session, model,pageNo);
	}
	
	@RequestMapping("/userMyComment")
	public String userMyComment(HttpSession session, Model model,Integer pageNo) {
		return userCenterService.userMyComment(session, model, pageNo);
	}
	
	@RequestMapping("/deleteComment")
	public String deleteComment(HttpSession session, Model model,String id,Integer pageNo) {
		return userCenterService.deleteComment(session, model,id,pageNo);
	}
}
