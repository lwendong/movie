package com.movie.service.admin.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.movie.dao.admin.CommentDao;
import com.movie.pojo.Comment;
import com.movie.pojo.Movie;
import com.movie.pojo.PageInfo;
import com.movie.service.admin.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;

	@Override
	public String toComment(Model model, Integer pageNo) {
		JSONObject json = selectCommentByPage(pageNo);
		List<Comment> list = (List<Comment>) json.get("allComments");
		model.addAttribute("allComments", list); 
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("totalPage", json.get("totalPage"));
		return "admin/comment";
	}

	@Override
	public JSONObject selectCommentByPage(Integer pageNo) {
		JSONObject jsonObject = new JSONObject();
		PageInfo pageInfo = new PageInfo(pageNo,10);
		List<Comment> movieList = commentDao.selectCommentByPage(pageInfo); 
		Integer num = commentDao.selectCommentCount(pageInfo); 
		jsonObject.put("allComments", movieList);
		jsonObject.put("pageNo", pageNo); 
		jsonObject.put("totalPage", num);
		return jsonObject;
	}

	@Override
	public JSONObject deleteOneComment(String commentId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", commentDao.deleteOneComment(commentId) > 0);
		return jsonObject;
	}
}
