package com.movie.service.pub;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;

public interface PageService {
	
	public String indexInfo(Model model,HttpSession session);
	
	public String selectMovieByType(Model model, Integer pageNo,String typeCode );
	
	public String search(Model model,String mykey);
	
	public String indexPage(Model model, HttpSession session, Integer pageNo,String code,String myKey);
	
	public void findCommenByMovieId(Model model,String movieId);
	
	public String movieDetail(Model model,String movieId,String userId);
	
	public JSONObject addComment(HttpSession session,String movieId,String comment);
	
	public String buy(HttpSession session,String movieId, Integer num);
	
}
