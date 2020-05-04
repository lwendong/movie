package com.movie.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.service.admin.TicketService;

/**
 * 管理后台  购退票管理
 */
@Controller
@RequestMapping("/admin/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	/**
	 * 管理后台  跳转到购退票管理并查询页面
	 */
	@RequestMapping("/ticket")
	public String toTicket (Model model) {
		return ticketService.toTicket(model,1);
	}
	
	/**
	 * 管理后台 分页查询购退票数据
	 */
	@RequestMapping("/page")
	public String pageSwitch (Model model,Integer pageNo) {
		return ticketService.toTicket(model,pageNo);
	}
}
