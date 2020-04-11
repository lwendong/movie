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

@Controller
@RequestMapping("/admin/type")
public class MovieTypeController {
	@Autowired
	private MovieTypeService movieTypeService;
	
	@RequestMapping("/movietype")
	public String toMovieType (Model model) {
		return movieTypeService.toMovieType(model,1);
	}
	
	@RequestMapping("/addType")
	@ResponseBody
	public JSONObject addType(@RequestBody MovieType movieType) {
		return movieTypeService.addType(movieType);
	}
	
	@RequestMapping("/deleteType")
	@ResponseBody
	public JSONObject deleteType(@RequestBody MovieType movieType) {
		return movieTypeService.deleteType(movieType);
	}
	
	@RequestMapping("/page")
	public String pageSwitch (Model model,Integer pageNo) {
		return movieTypeService.toMovieType(model,pageNo);
	}
}
