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

@Controller
@RequestMapping("/admin/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/movie")
	public String toMovie (Model model) {
		return movieService.toMovie(model,1);
	}
	
	@RequestMapping("/addMovie")
	public String toAddMovie(Model model){
		return movieService.toAddMovie(model);
	}
	
	@RequestMapping("/addOrUpdateMovie")
	public String addOrUpdateMovie(@RequestParam("file") MultipartFile file,
            					Movie movie,HttpServletRequest request){
		return movieService.addOrUpdateMovie(movie, file);
	}
	
	@RequestMapping("/deleteMovies")
	@ResponseBody
	public JSONObject deleteMovies(String[] movieIds){
		return movieService.deleteMovies(movieIds);
	}
	
	@RequestMapping("/deleteOneMovie")
	@ResponseBody
	public JSONObject deleteOneMovie(String movieId){
		return movieService.deleteOneMovie(movieId);
	}
	
	@RequestMapping("/movieDetails")
	public String movieDetails(String movieId,Model model){
		return movieService.movieDetails(movieId,model);
	}
	
	@RequestMapping("/page")
	public String pageSwitch (Model model,Integer pageNo) {
		return movieService.toMovie(model,pageNo);
	}
	
}
