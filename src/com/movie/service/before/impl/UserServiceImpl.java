package com.movie.service.before.impl;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.movie.dao.before.UserDao;
import com.movie.pojo.User;
import com.movie.service.before.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public JSONObject login(User user,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		String displayCode = session.getAttribute("code").toString();
		if(!StringUtils.equalsIgnoreCase(user.getCode(), displayCode)) {
			jsonObject.put("success", false);
			jsonObject.put("msg", "验证码不正确!");
			return jsonObject;
		}
		User u = userDao.selectUserByTelAndPassword(user.getTel(), user.getPassword());
		if(u == null) {
			jsonObject.put("success",false);
			jsonObject.put("msg", "用户不存在或密码不正确！！");
			return jsonObject;
		}
		if(u.getState()) {
			jsonObject.put("success",false);
			jsonObject.put("msg", "此用户已被冻结");
			return jsonObject;
		}
		session.setAttribute("user", u);
		jsonObject.put("success", u != null);
		jsonObject.put("user", u);
		return jsonObject;
	}
	
	@Override
	public JSONObject register(User user,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		User user2 = userDao.selectByTel(user.getTel());
		if(user2 != null) {
			jsonObject.put("success", false);
			jsonObject.put("msg", "此手机已被注册");
			return jsonObject;
		}
		String displayCode = session.getAttribute("code").toString();
		if(!StringUtils.equalsIgnoreCase(user.getCode(), displayCode)) {
			jsonObject.put("success", false);
			jsonObject.put("msg", "验证码不正确  !");
			return jsonObject;
		}
		int num = userDao.insertUser(user);
		if(num != 0) {
			session.setAttribute("user", user);
			jsonObject.put("success", true);
			jsonObject.put("user", user);
		}else {
			session.setAttribute("user", null);
			jsonObject.put("success", false);
			jsonObject.put("user", null);
		}
		return jsonObject;
	}

}
