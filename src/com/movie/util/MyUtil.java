package com.movie.util;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import com.movie.pojo.User;


public class MyUtil {
	
	public static String getUserId(HttpSession session){
		User user = (User)session.getAttribute("user");
		if(user != null) {
			return user.getId();
		}
		return null;
	}
	
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-","");
	}
}
