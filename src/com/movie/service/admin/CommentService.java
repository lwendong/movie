package com.movie.service.admin;

import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;

public interface CommentService {
	
	public String toComment(Model model,Integer pageNo);
	
	public JSONObject selectCommentByPage(Integer pageNo);
	
	public JSONObject deleteOneComment(String commentId);
	
}
