package com.movie.service.admin;


import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Movie;

public interface MovieService {
	
	public String toMovie(Model model,Integer pageNo);
	
	public String toAddMovie(Model model);
	
	public JSONObject selectMovieByPage(Integer pageNo, String code, String myKey);
	
	public JSONObject deleteMovies(String[] movieIds);
	
	public JSONObject deleteOneMovie(String movieId);
	
	public String movieDetails(String movieId,Model model);
	
	public String addOrUpdateMovie(Movie movie, MultipartFile file);
	
	public List<Movie> selectMovieByType(Model model,Integer pageNo,String typeCode);
	
	public List<Movie> selectMovieByPageIndex(Model model,Integer pageNo, String code, String myKey);
	
	public String search(Model model,String mykey);
	
	public Movie selectMovieById(String movieId);
	
	public void updateMovieNum(String movieId, Integer num,Integer type);
	
}
