package com.movie.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.movie.dao.admin.CinemaDao;
import com.movie.dao.admin.MovieTypeDao;
import com.movie.pojo.Cinema;
import com.movie.pojo.MovieType;
import com.movie.pojo.PageInfo;
import com.movie.service.admin.CinemaService;

@Service("cinemaService")
public class CinemaServiceImpl implements CinemaService{
	@Autowired
	private CinemaDao cinemaDao;
	
	@Override
	public JSONObject addCinema(Cinema cinema) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", cinemaDao.addCinema(cinema) > 0);
		return jsonObject;
	}

	@Override
	public JSONObject selectCinemaByPage(Integer pageNo) {
		JSONObject jsonObject = new JSONObject();
		PageInfo pageInfo = new PageInfo(pageNo,8);
		List<Cinema> list = cinemaDao.selectCinemaByPage(pageInfo);
		Integer num = cinemaDao.selectCinemaCount(pageInfo);
		jsonObject.put("allCinemas", list);
		jsonObject.put("pageNo", pageNo);
		jsonObject.put("totalPage", num);
		return jsonObject;
	}

	@Override
	public String toCinema(Model model,Integer pageNo) {
		JSONObject json = selectCinemaByPage(pageNo);
		List<Cinema> list = (List<Cinema>) json.get("allCinemas");
		model.addAttribute("allCinemas", list);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("totalPage", json.get("totalPage"));
		return "admin/cinema";
	}

	@Override
	public JSONObject deleteCinema(Cinema cinema) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success",cinemaDao.deleteCinema(cinema.getId()) > 0);
		return jsonObject;
	}

	@Override
	public List<Cinema> selectCinema() {
		return cinemaDao.selectCinema();
	}
}
