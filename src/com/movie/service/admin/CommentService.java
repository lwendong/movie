package com.movie.service.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Comment;

public interface CommentService {
	
	public String toComment(Model model,Integer pageNo);
	
	public JSONObject selectCommentByPage(Integer pageNo);
	
	public List<Comment> selectCommentByMovieId(String movieId);
	
	public JSONObject deleteOneComment(String commentId);
	
	public JSONObject addComment(HttpSession session,String movieId,String comment);
	
}
