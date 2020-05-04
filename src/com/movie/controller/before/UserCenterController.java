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

/**
 * 前台  用户中心
 */
@Controller
@RequestMapping("/userCenter")
public class UserCenterController extends BaseModel{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserCenterService userCenterService;
	
	/**
	 * 跳转到用户中心
	 */
	@RequestMapping("/userCenterControl")
	public String userCenter(HttpSession session, Model model) {
		return userCenterService.userCenter(session, model);
	}

	/**
	 * 跳转到用户中心我的信息
	 */
	@RequestMapping("/userMyInfo")
	public String userMyInfo(HttpSession session, Model model) {
		return userCenterService.userInfo(session, model);
	}
	
	
	/**
	 * 更改用户信息
	 */
	@RequestMapping("/updateInfo")
	@ResponseBody
	public JSONObject updateInfo(@RequestBody User user) {
		return userCenterService.updateInfo(user);
	}
	
	/**
	 * 用户中心 我的购票
	 */
	@RequestMapping("/userMyBuy")
	public String userMyBuy(HttpSession session, Model model,Integer pageNo) {
		return userCenterService.userMyBuy(session, model,pageNo);
	}
	
	/**
	 * 用户中心 退票
	 */
	@RequestMapping("/refund")
	public String refund(HttpSession session, Model model,String id,Integer pageNo) {
		return userCenterService.refund(session, model,id,pageNo);
	}
	
	/**
	 * 用户中心 我看过的电影
	 */
	@RequestMapping("/userMySeen")
	public String userMySeen(HttpSession session, Model model,Integer pageNo) {
		return userCenterService.userMySeen(session, model,pageNo);
	}
	
	/**
	 * 用户中心 我的评论
	 */
	@RequestMapping("/userMyComment")
	public String userMyComment(HttpSession session, Model model,Integer pageNo) {
		return userCenterService.userMyComment(session, model, pageNo);
	}
	
	/**
	 * 用户中心 删除我的评论
	 */
	@RequestMapping("/deleteComment")
	public String deleteComment(HttpSession session, Model model,String id,Integer pageNo) {
		return userCenterService.deleteComment(session, model,id,pageNo);
	}
}
