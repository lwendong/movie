package com.movie.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.MovieType;
import com.movie.service.admin.MovieTypeService;

/**
 * 管理后台 电影类型管理
 */
@Controller
@RequestMapping("/admin/type")
public class MovieTypeController {
	@Autowired
	private MovieTypeService movieTypeService;
	
	/**
	 * 管理后台 跳转到电影类型页面
	 */
	@RequestMapping("/movietype")
	public String toMovieType (Model model) {
		return movieTypeService.toMovieType(model,1);
	}
	
	/**
	 * 管理后台 添加电影类型
	 */
	@RequestMapping("/addType")
	@ResponseBody
	public JSONObject addType(@RequestBody MovieType movieType) {
		return movieTypeService.addType(movieType);
	}
	
	/**
	 * 管理后台 删除电影类型
	 */
	@RequestMapping("/deleteType")
	@ResponseBody
	public JSONObject deleteType(@RequestBody MovieType movieType) {
		return movieTypeService.deleteType(movieType);
	}
	
	/**
	 * 管理后台 分页查询电影数据
	 */
	@RequestMapping("/page")
	public String pageSwitch (Model model,Integer pageNo) {
		return movieTypeService.toMovieType(model,pageNo);
	}
}
