package com.movie.service.admin.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.movie.dao.admin.NoticeDao;
import com.movie.pojo.MovieType;
import com.movie.pojo.Notice;
import com.movie.pojo.PageInfo;
import com.movie.service.admin.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public String toNotice(Model model, Integer pageNo) {
		JSONObject json = selectNoticeByPage(pageNo);
		List<Notice> list = (List<Notice>) json.get("allNotices");
		model.addAttribute("allNotices", list); 
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("totalPage", json.get("totalPage"));
		return "admin/notice";
	}

	@Override
	public JSONObject selectNoticeByPage(Integer pageNo) {
		JSONObject jsonObject = new JSONObject();
		PageInfo pageInfo = new PageInfo(pageNo,10);
		List<Notice> movieList = noticeDao.selectNoticeByPage(pageInfo); 
		Integer num = noticeDao.selectNoticeCount(pageInfo); 
		jsonObject.put("allNotices", movieList);
		jsonObject.put("pageNo", pageNo); 
		jsonObject.put("totalPage", num);
		return jsonObject;
	}

	@Override
	public JSONObject deleteOneNotice(String noticeId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", noticeDao.deleteOneNotice(noticeId) > 0);
		return jsonObject;
	}

	@Override
	public String addOrUpdateNotice(Notice notice) {
		if(StringUtils.isNotEmpty(notice.getId())) {
			noticeDao.updateNotice(notice);
		}else {
			noticeDao.addNewNotice(notice);
		}
		return "forward:/admin/notice/notice";
	}

	@Override
	public String noticeDetails(String noticeId,Model model) {
		Notice notice = noticeDao.noticeDetails(noticeId);
		model.addAttribute("notice", notice);
		return "admin/addNotice";
	}
}
