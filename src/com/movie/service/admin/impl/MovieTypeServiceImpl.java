package com.movie.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.movie.dao.admin.MovieTypeDao;
import com.movie.pojo.MovieType;
import com.movie.pojo.PageInfo;
import com.movie.service.admin.MovieTypeService;

@Service("movieTypeService")
public class MovieTypeServiceImpl implements MovieTypeService {
	@Autowired
	private MovieTypeDao movieTypeDao;
	
	@Override
	public JSONObject addType(MovieType movieType) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", movieTypeDao.addType(movieType) > 0);
		return jsonObject;
	}

	@Override
	public JSONObject selectTypeByPage(Integer pageNo) {
		JSONObject jsonObject = new JSONObject();
		PageInfo pageInfo = new PageInfo(pageNo,8);
		List<MovieType> list = movieTypeDao.selectTypeByPage(pageInfo);
		Integer num = movieTypeDao.selectTypeCount(pageInfo);
		jsonObject.put("allTypes", list);
		jsonObject.put("pageNo", pageNo);
		jsonObject.put("totalPage", num);
		return jsonObject;
	}

	@Override
	public String toMovieType(Model model,Integer pageNo) {
		JSONObject json = selectTypeByPage(pageNo);
		List<MovieType> list = (List<MovieType>) json.get("allTypes");
		model.addAttribute("allTypes", list);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("totalPage", json.get("totalPage"));
		return "admin/movieType";
	}

	@Override
	public JSONObject deleteType(MovieType movieType) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success",movieTypeDao.deleteType(movieType.getId()) > 0);
		return jsonObject;
	}

}
