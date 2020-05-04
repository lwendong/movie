package com.movie.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Movie;
import com.movie.service.admin.MovieService;

/**
 * 管理后台 电影管理
 */
@Controller
@RequestMapping("/admin/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	/**
	 * 管理后台 跳转到电影管理并查询数据
	 */
	@RequestMapping("/movie")
	public String toMovie (Model model) {
		return movieService.toMovie(model,1);
	}
	
	/**
	 * 管理后台 跳转到添加影片页面
	 */
	@RequestMapping("/addMovie")
	public String toAddMovie(Model model){
		return movieService.toAddMovie(model);
	}
	
	/**
	 * 管理后台 新增或修改已存在影片
	 */
	@RequestMapping("/addOrUpdateMovie")
	public String addOrUpdateMovie(@RequestParam("file") MultipartFile file,
            					Movie movie,HttpServletRequest request){
		return movieService.addOrUpdateMovie(movie, file);
	}
	
	/**
	 * 管理后台 批量删除影片
	 */
	@RequestMapping("/deleteMovies")
	@ResponseBody
	public JSONObject deleteMovies(String[] movieIds){
		return movieService.deleteMovies(movieIds);
	}
	
	/**
	 * 管理后台 删除影片
	 */
	@RequestMapping("/deleteOneMovie")
	@ResponseBody
	public JSONObject deleteOneMovie(String movieId){
		return movieService.deleteOneMovie(movieId);
	}
	
	/**
	 * 管理后台 影片详情
	 */
	@RequestMapping("/movieDetails")
	public String movieDetails(String movieId,Model model){
		return movieService.movieDetails(movieId,model);
	}
	
	/**
	 * 管理后台 分页查询影片
	 */
	@RequestMapping("/page")
	public String pageSwitch (Model model,Integer pageNo) {
		return movieService.toMovie(model,pageNo);
	}
	
}
