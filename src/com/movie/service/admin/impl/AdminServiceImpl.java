package com.movie.service.admin.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.movie.dao.admin.AdminDao;
import com.movie.pojo.PageInfo;
import com.movie.pojo.User;
import com.movie.service.admin.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public String toUser(Model model, Integer pageNo) {
		JSONObject json = selectAdminUserByPage(pageNo);
		List<User> list = (List<User>) json.get("allUsers");
		model.addAttribute("allUsers",list); 
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("totalPage", json.get("totalPage"));
		return "admin/admin";
	}

	@Override
	public JSONObject selectAdminUserByPage(Integer pageNo) {
		Integer totalPage = 0;
		JSONObject jsonObject = new JSONObject();
		PageInfo pageInfo = new PageInfo(pageNo,10);
		List<User> userList = adminDao.selectAdminUserByPage(pageInfo); 
		if(!CollectionUtils.isEmpty(userList)) {
			totalPage = adminDao.selectAdminUserCount(pageInfo.nextPage(),pageInfo.getPageSize()); 
		}
		jsonObject.put("allUsers", userList);
		jsonObject.put("pageNo", pageNo); 
		jsonObject.put("totalPage", totalPage);
		return jsonObject;
	}

	@Override
	public JSONObject userState(String userId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", adminDao.userState(userId) > 0);
		return jsonObject;
	}
	
	
}
