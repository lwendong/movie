package com.movie.service.admin;


import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Movie;

public interface MovieService {
	
	public String toMovie(Model model,Integer pageNo);
	
	public String toAddMovie(Model model);
	
	public JSONObject selectMovieByPage(Integer pageNo);
	
	public JSONObject deleteMovies(String[] movieIds);
	
	public JSONObject deleteOneMovie(String movieId);
	
	public String movieDetails(String movieId,Model model);
	
	public String addOrUpdateMovie(Movie movie, MultipartFile file);
}
