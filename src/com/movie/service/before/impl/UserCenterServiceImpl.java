package com.movie.service.before.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.movie.dao.before.UserCenterDao;
import com.movie.dao.before.UserDao;
import com.movie.pojo.Comment;
import com.movie.pojo.PageInfo;
import com.movie.pojo.Ticket;
import com.movie.pojo.User;
import com.movie.service.admin.MovieService;
import com.movie.service.admin.TicketService;
import com.movie.service.before.UserCenterService;
import com.movie.util.MyUtil;



@Service("userCenterService")
public class UserCenterServiceImpl implements UserCenterService{
	
	@Autowired
	private UserCenterDao userCenterDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private TicketService ticketService;
	
	@Override
	public String userCenter(HttpSession session, Model model) {
		if(session.getAttribute("user") == null) {
			return "redirect:/toindex";
		}
		return "before/userCenter/userCenterControl";
	}

	@Override
	public String userInfo(HttpSession session, Model model) {
		User user = userDao.selectById(MyUtil.getUserId(session));
		model.addAttribute("user", user);
		return "before/userCenter/myinfo";
	}

	@Override
	public JSONObject updateInfo(User user) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", userCenterDao.updateInfo(user) > 0);
		return jsonObject;
	}

	@Override
	public String userMyBuy(HttpSession session, Model model,Integer pageNo) {
		Integer totalPage = 0;
		PageInfo pageInfo = new PageInfo(pageNo, 10);
		String userId = MyUtil.getUserId(session);
		List<Ticket> ticket = userCenterDao.selectTicketByUserId(userId,pageInfo);
		if(!CollectionUtils.isEmpty(ticket)) {
			totalPage = userCenterDao.selectTicketByUserIdCount(userId, pageInfo.nextPage(),pageInfo.getPageSize());
			ticket.forEach(t ->{
				Long playTime = t.getMoviePlayTime().getTime();
				Long nowTime = new Date().getTime();
				t.setIsTp(playTime > nowTime);
			});
		}
		model.addAttribute("ticketlist", ticket.size()>0?ticket:null);
		model.addAttribute("pageNo", pageNo == null ? 1 : pageNo);
		model.addAttribute("totalPage", totalPage);
		return "before/userCenter/mybuy";
	}

	@Override
	public String refund(HttpSession session, Model model, String id,Integer pageNo) {
		Ticket ticket = ticketService.selectTicketById(id,0);
		userCenterDao.refund(id);
		movieService.updateMovieNum(ticket.getMovieId(),ticket.getNum(),1);
		return userMyBuy(session,model,pageNo);
	}

	@Override
	public String userMySeen(HttpSession session, Model model, Integer pageNo) {
		userMyBuy(session,model,pageNo);
		
		return "before/userCenter/myseen";
	}

	@Override
	public String userMyComment(HttpSession session, Model model, Integer pageNo) {
		Integer totalPage = 0;
		PageInfo pageInfo = new PageInfo(pageNo, 10);
		String userId = MyUtil.getUserId(session);
		List<Comment> comment = userCenterDao.selectCommentByUserId(userId,pageInfo);
		if(!CollectionUtils.isEmpty(comment)) {
			totalPage = userCenterDao.selectCommentByUserIdCount(userId, pageInfo.nextPage(),pageInfo.getPageSize());
		}
		model.addAttribute("commentLiset", comment.size()>0?comment:null);
		model.addAttribute("pageNo", pageNo == null ? 1 : pageNo);
		model.addAttribute("totalPage", totalPage);
		return "before/userCenter/mycomment";
	}
	
	@Override
	public String deleteComment(HttpSession session, Model model, String id,Integer pageNo) {
		userCenterDao.deleteComment(id);
		return userMyComment(session,model,pageNo);
	}

}
