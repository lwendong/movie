package com.movie.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.User;

public interface UserCenterService {

	public String userCenter(HttpSession session, Model model);
	
	public String userInfo(HttpSession session, Model model);
	
	public JSONObject updateInfo(User user);
	
	public String userMyBuy(HttpSession session, Model model,Integer pageNo);
	
	public String refund(HttpSession session, Model model,String id,Integer pageNo);
	
	public String userMySeen(HttpSession session, Model model,Integer pageNo);
	
	public String userMyComment(HttpSession session, Model model,Integer pageNo);
	
	public String deleteComment(HttpSession session, Model model, String id,Integer pageNo);
}
