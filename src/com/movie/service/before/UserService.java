package com.movie.service.before;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.User;

public interface UserService {
	
	public JSONObject login(User user,HttpSession session);
	
	public JSONObject register(User user,HttpSession session);
}
