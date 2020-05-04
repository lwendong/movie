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
/**
 * 前台控制
 */
@Controller
public class PageController {
	
	@Autowired
	private PageService pageService;
	
	/**
	 * 前台控制  跳转到登录页面
	 */
	@RequestMapping("/tologin")
	public String toLogin() {
		return "public/login";
	}
	
	/**
	 * 前台控制  跳转到注册页面
	 */
	@RequestMapping("/toregister")
	public String toRegister() {
		return "public/register";
	}
	
	/**
	 * 前台控制  跳转到首页
	 */
	@RequestMapping("/toindex")
	public String toIndex(Model model,HttpSession session) {
		return pageService.indexInfo(model, session);
	}
	
	/**
	 * 前台控制  跳转到管理后台首页
	 */
	@RequestMapping("/toadminindex")
	public String toAdminIndex(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null || !user.getIsAdmin()){
			return "redirect:/toindex";
		}else {
			return "admin/main";
		}
	}
	
	/**
	 * 前台控制  获取所有电影类型
	 */
	@RequestMapping("/movieByType")
	public String selectMovieByType(Model model,String typeCode,Integer pageNo) {
		return pageService.selectMovieByType(model, pageNo, typeCode);
	}
	
	/**
	 * 前台控制  搜索
	 */
	@RequestMapping("/search")
	public String search(Model model,String mykey) {
		return pageService.search(model, mykey);
	}
	
	/**
	 * 前台控制  主页电影分页
	 */
	@RequestMapping("/index/page")
	public String pageSwitch (Model model,HttpSession session, Integer pageNo,String code,String myKey) {
		return pageService.indexPage(model,session, pageNo,code,myKey);
	}
	
	/**
	 * 前台控制 电影详情
	 */
	@RequestMapping("/movieDetail")
	public String movieDetail(Model model,HttpSession session,String movieId) {
		pageService.findCommenByMovieId(model,movieId);
		return pageService.movieDetail(model, movieId,MyUtil.getUserId(session));
	}
	
	/**
	 * 前台控制 评论
	 */
	@RequestMapping("/addComment")
	@ResponseBody
	public JSONObject addComment(HttpSession session,@RequestBody Comment comment) {
		return pageService.addComment(session,comment.getMovieId(),comment.getComment());
	}
	
	/**
	 * 前台控制 购票
	 */
	@RequestMapping("/buy")
	public String buy(HttpSession session,String movieId, Integer num) {
		return pageService.buy(session,movieId,num);
	}
}
