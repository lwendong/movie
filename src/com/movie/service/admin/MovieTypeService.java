package com.movie.service.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.MovieType;

public interface MovieTypeService {
	
	public String toMovieType(Model model,Integer pageNo);
	
	public JSONObject selectTypeByPage(Integer pageNo);
	
	public JSONObject addType(MovieType movieType);
	
	public JSONObject deleteType(MovieType movieType);
	
	public List<MovieType> selectType();
	
}
