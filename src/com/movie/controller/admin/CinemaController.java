package com.movie.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Cinema;
import com.movie.service.admin.CinemaService;

@Controller
@RequestMapping("/admin/cinema")
public class CinemaController {
	@Autowired
	private CinemaService cinemaService;
	
	@RequestMapping("/cinema")
	public String toCinema (Model model) {
		return cinemaService.toCinema(model,1);
	}
	
	@RequestMapping("/addCinema")
	@ResponseBody
	public JSONObject addCinema(@RequestBody Cinema cinema) {
		return cinemaService.addCinema(cinema);
	}
	
	@RequestMapping("/deleteCinema")
	@ResponseBody
	public JSONObject deleteCinema(@RequestBody Cinema cinema) {
		return cinemaService.deleteCinema(cinema);
	}
	
	@RequestMapping("/page")
	public String pageSwitch (Model model,Integer pageNo) {
		return cinemaService.toCinema(model, pageNo);
	}
}
