package com.movie.service.admin;

import java.util.List;

import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Cinema;

public interface CinemaService {
	
	public String toCinema(Model model,Integer pageNo);
	
	public JSONObject selectCinemaByPage(Integer pageNo);
	
	public JSONObject addCinema(Cinema cinema);
	
	public JSONObject deleteCinema(Cinema cinema);
	
	public List<Cinema> selectCinema();
}
