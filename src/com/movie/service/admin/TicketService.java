package com.movie.service.admin;

import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;

public interface TicketService {
	
	public String toTicket(Model model,Integer pageNo);
	
	public JSONObject selectTicketByPage(Integer pageNo);
}
