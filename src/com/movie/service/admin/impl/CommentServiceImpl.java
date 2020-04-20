package com.movie.service.admin.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.movie.dao.admin.CommentDao;
import com.movie.pojo.Comment;
import com.movie.pojo.Movie;
import com.movie.pojo.PageInfo;
import com.movie.service.admin.CommentService;
import com.movie.util.MyUtil;

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
		Integer totalPage = 0;
		JSONObject jsonObject = new JSONObject();
		PageInfo pageInfo = new PageInfo(pageNo,10);
		List<Comment> commentList = commentDao.selectCommentByPage(pageInfo); 
		if(!CollectionUtils.isEmpty(commentList)) {
			totalPage = commentDao.selectCommentCount(pageInfo.nextPage(),pageInfo.getPageSize()); 
		}
		jsonObject.put("allComments", commentList);
		jsonObject.put("pageNo", pageNo); 
		jsonObject.put("totalPage", totalPage);
		return jsonObject;
	}

	@Override
	public JSONObject deleteOneComment(String commentId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", commentDao.deleteOneComment(commentId) > 0);
		return jsonObject;
	}

	@Override
	public List<Comment> selectCommentByMovieId(String movieId) {
		return commentDao.selectCommentByMovieId(movieId);
	}
	
	@Override
	public JSONObject addComment(HttpSession session,String movieId, String comment) {
		JSONObject jsonObject = new JSONObject();
		String userId = MyUtil.getUserId(session);
		jsonObject.put("success", commentDao.addComment(movieId,comment,userId));
		return jsonObject;
	}
}
