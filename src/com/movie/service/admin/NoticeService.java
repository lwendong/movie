package com.movie.service.admin;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Movie;
import com.movie.pojo.Notice;

public interface NoticeService {
	
	public String toNotice(Model model,Integer pageNo);
	
	public JSONObject selectNoticeByPage(Integer pageNo);
	
	public JSONObject deleteOneNotice(String noticeId);
	
	public String noticeDetails(String noticeId,Model model);
	
	public String noticeDetailsForBefore(String noticeId,Model model);
	
	public String addOrUpdateNotice(Notice notice);
	
	public List<Notice> selectNotice();
}
