package com.movie.controller.pub;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Comment;
import com.movie.pojo.User;
import com.movie.service.pub.PageService;
import com.movie.util.MyUtil;

@Controller
public class PageController {
	
	@Autowired
	private PageService pageService;
	
	@RequestMapping("/tologin")
	public String toLogin() {
		return "public/login";
	}
	
	@RequestMapping("/toregister")
	public String toRegister() {
		return "public/register";
	}
	
	@RequestMapping("/toindex")
	public String toIndex(Model model,HttpSession session) {
		return pageService.indexInfo(model, session);
	}
	
	@RequestMapping("/toadminindex")
	public String toAdminIndex(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null || !user.getIsAdmin()){
			return "redirect:/toindex";
		}else {
			return "admin/main";
		}
	}
	
	@RequestMapping("/movieByType")
	public String selectMovieByType(Model model,String typeCode,Integer pageNo) {
		return pageService.selectMovieByType(model, pageNo, typeCode);
	}
	
	@RequestMapping("/search")
	public String search(Model model,String mykey) {
		return pageService.search(model, mykey);
	}
	
	@RequestMapping("/index/page")
	public String pageSwitch (Model model,HttpSession session, Integer pageNo,String code,String myKey) {
		return pageService.indexPage(model,session, pageNo,code,myKey);
	}
	
	@RequestMapping("/movieDetail")
	public String movieDetail(Model model,HttpSession session,String movieId) {
		pageService.findCommenByMovieId(model,movieId);
		return pageService.movieDetail(model, movieId,MyUtil.getUserId(session));
	}
	
	@RequestMapping("/addComment")
	@ResponseBody
	public JSONObject addComment(HttpSession session,@RequestBody Comment comment) {
		return pageService.addComment(session,comment.getMovieId(),comment.getComment());
	}
	
	@RequestMapping("/buy")
	public String buy(HttpSession session,String movieId, Integer num) {
		return pageService.buy(session,movieId,num);
	}
}
