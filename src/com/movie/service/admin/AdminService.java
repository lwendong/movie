package com.movie.service.admin;

import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;

public interface AdminService {
	
	public String toUser(Model model,Integer pageNo);
	
	public JSONObject selectAdminUserByPage(Integer pageNo);
	
	public JSONObject userState(String userId);
}
