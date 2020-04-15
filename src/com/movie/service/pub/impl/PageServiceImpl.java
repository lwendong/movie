package com.movie.service.pub.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Comment;
import com.movie.pojo.Movie;
import com.movie.pojo.Ticket;
import com.movie.service.admin.CommentService;
import com.movie.service.admin.MovieService;
import com.movie.service.admin.MovieTypeService;
import com.movie.service.admin.NoticeService;
import com.movie.service.admin.TicketService;
import com.movie.service.pub.PageService;

@Service("pageService")
public class PageServiceImpl implements PageService{
	
	@Autowired
	private MovieTypeService movieTypeService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private TicketService ticketService;
	
	@Override
	public String indexInfo(Model model, HttpSession session) {
		session.setAttribute("movieTypeList", movieTypeService.selectType());
		session.setAttribute("noticeList", noticeService.selectNotice());
		model.addAttribute("movieList", movieService.selectMovieByPageIndex(model,1,null,null));
		return "before/index";
	}

	@Override
	public String selectMovieByType(Model model, Integer pageNo, String typeCode) {
		List<Movie> movieList = movieService.selectMovieByType(model,pageNo,typeCode);
		movieList.forEach(movie ->{
			Date releaseDate = movie.getReleaseTime();
			long nowTime = new Date().getTime();
			long releaseTime = releaseDate.getTime();
			movie.setPlay(nowTime >= releaseTime?1:0);
		});
		model.addAttribute("movieByType",CollectionUtils.isEmpty(movieList)?null:movieList);
		model.addAttribute("movieType",typeCode);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("totalPage", movieList.size());
		return "before/movietypeshow";
	}

	@Override
	public String search(Model model, String mykey) {
		return movieService.search(model, mykey);
	}

	@Override
	public String indexPage(Model model, HttpSession session, Integer pageNo, String code, String myKey) {
		session.setAttribute("movieTypeList", movieTypeService.selectType());
		session.setAttribute("noticeList", noticeService.selectNotice());
		model.addAttribute("movieList", movieService.selectMovieByPageIndex(model, pageNo, code, myKey));
		if(StringUtils.isNotEmpty(code)) {
			return "before/movietypeshow";
		}else if(StringUtils.isNotEmpty(code)) {
			return "redirect:/search";
		}else {
			return "before/index";
		}
		
	}

	@Override
	public void findCommenByMovieId(Model model, String movieId) {
		List<Comment> commentList = commentService.selectCommentByMovieId(movieId);
		model.addAttribute("commentList",commentList);
	}

	@Override
	public String movieDetail(Model model, String movieId, String userId) {
		Movie movie = movieService.selectMovieById(movieId);
		List<Ticket> ticketList = ticketService.selectTicketByMovieIdAndUserId(userId,movieId);
		Date releaseDate = movie.getReleaseTime();
		long nowTime = new Date().getTime();
		long releaseTime = releaseDate.getTime();
		movie.setPlay(nowTime >= releaseTime?1:0);
		//还有个查电影院的方法
		model.addAttribute("movie", movie);
		model.addAttribute("isBuy", ticketList == null ? 0: ticketList.size() > 0 ?1:0);
		return "before/moviedetail";
	}

	@Override
	public JSONObject addComment(HttpSession session,String movieId, String comment) {
		return commentService.addComment(session,movieId,comment);
	}

	@Override
	public String buy(HttpSession session, String movieId, Integer num) {
		ticketService.buy(session,movieId, num);
		movieService.updateMovieNum(movieId, num,0);
		return "redirect:/movieDetail?movieId="+movieId;
	}

}
