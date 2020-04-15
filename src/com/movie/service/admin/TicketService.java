package com.movie.service.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Ticket;

public interface TicketService {
	
	public String toTicket(Model model,Integer pageNo);
	
	public JSONObject selectTicketByPage(Integer pageNo);
	
	public List<Ticket> selectTicketByMovieIdAndUserId(String userId,String movieId);
	
	public void buy(HttpSession session,String movieId, Integer num);
	
	public Ticket selectTicketById(String id,Integer type);
	
}
