package com.movie.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.service.admin.TicketService;

@Controller
@RequestMapping("/admin/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping("/ticket")
	public String toTicket (Model model) {
		return ticketService.toTicket(model,1);
	}
	
	@RequestMapping("/page")
	public String pageSwitch (Model model,Integer pageNo) {
		return ticketService.toTicket(model,pageNo);
	}
}
