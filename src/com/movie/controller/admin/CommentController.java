package com.movie.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.movie.service.admin.CommentService;

@Controller
@RequestMapping("admin/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/comment")
	public String toComment (Model model) {
		return commentService.toComment(model,1);
	}
	
	@RequestMapping("/deleteOneComment")
	@ResponseBody
	public JSONObject deleteOneComment(String movieId){
		return commentService.deleteOneComment(movieId);
	}
	
	@RequestMapping("/page")
	public String pageSwitch (Model model,Integer pageNo) {
		return commentService.toComment(model,pageNo);
	}
}
