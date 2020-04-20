package com.movie.service.admin.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.movie.dao.admin.TicketDao;
import com.movie.pojo.Comment;
import com.movie.pojo.PageInfo;
import com.movie.pojo.Ticket;
import com.movie.service.admin.TicketService;
import com.movie.util.MyUtil;

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
		Integer totalPage = 0;
		JSONObject jsonObject = new JSONObject();
		PageInfo pageInfo = new PageInfo(pageNo,10);
		List<Ticket> movieList = ticketDao.selectTicketByPage(pageInfo); 
		if(!CollectionUtils.isEmpty(movieList)) {
			totalPage = ticketDao.selectTicketCount(pageInfo.nextPage(),pageInfo.getPageSize()); 
		}
		jsonObject.put("allTickets", movieList);
		jsonObject.put("pageNo", pageNo); 
		jsonObject.put("totalPage", totalPage);
		return jsonObject;
	}

	@Override
	public List<Ticket> selectTicketByMovieIdAndUserId(String userId, String movieId) {
		return ticketDao.selectTicketByMovieIdAndUserId(userId,movieId);
	}

	@Override
	public void buy(HttpSession session,String movieId, Integer num) {
		ticketDao.buy(movieId, num,MyUtil.getUserId(session));
		
	}

	@Override
	public Ticket selectTicketById(String id, Integer type) {
		return ticketDao.selectTicketById(id,type);
	}

}
