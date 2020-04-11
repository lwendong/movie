package com.movie.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.movie.dao.admin.TicketDao;
import com.movie.pojo.Comment;
import com.movie.pojo.PageInfo;
import com.movie.pojo.Ticket;
import com.movie.service.admin.TicketService;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketDao ticketDao;

	@Override
	public String toTicket(Model model, Integer pageNo) {
		JSONObject json = selectTicketByPage(pageNo);
		List<Ticket> list = (List<Ticket>) json.get("allTickets");
		model.addAttribute("allTickets", list); 
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("totalPage", json.get("totalPage"));
		return "admin/ticket";
	}

	@Override
	public JSONObject selectTicketByPage(Integer pageNo) {
		JSONObject jsonObject = new JSONObject();
		PageInfo pageInfo = new PageInfo(pageNo,10);
		List<Ticket> movieList = ticketDao.selectTicketByPage(pageInfo); 
		Integer num = ticketDao.selectTicketCount(pageInfo); 
		jsonObject.put("allTickets", movieList);
		jsonObject.put("pageNo", pageNo); 
		jsonObject.put("totalPage", num);
		return jsonObject;
	}


}
