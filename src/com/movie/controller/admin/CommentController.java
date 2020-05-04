package com.movie.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.movie.service.admin.CommentService;
/**
 * 管理后台 评论管理
 */
@Controller
@RequestMapping("admin/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	/**
	 * 管理后台 跳转到评论管理页面并查询数据
	 */
	@RequestMapping("/comment")
	public String toComment (Model model) {
		return commentService.toComment(model,1);
	}
	
	/**
	 * 管理后台 删除一条评论
	 */
	@RequestMapping("/deleteOneComment")
	@ResponseBody
	public JSONObject deleteOneComment(String movieId){
		return commentService.deleteOneComment(movieId);
	}
	
	/**
	 * 管理后台 分页查询评论
	 */
	@RequestMapping("/page")
	public String pageSwitch (Model model,Integer pageNo) {
		return commentService.toComment(model,pageNo);
	}
}
