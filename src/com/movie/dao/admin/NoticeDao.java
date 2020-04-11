package com.movie.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Movie;
import com.movie.pojo.Notice;
import com.movie.pojo.PageInfo;

@Repository("noticeDao")
@Mapper
public interface NoticeDao {
	
	public List<Notice> selectNoticeByPage(@Param("page") PageInfo page);
	
	public Integer selectNoticeCount(@Param("page") PageInfo page);
	
	public Integer deleteOneNotice(@Param("noticeId") String noticeId);
	
	public Integer addNewNotice(@Param("notice") Notice notice);
	
	public Integer updateNotice(@Param("notice") Notice notice);
	
	public Notice noticeDetails(String noticeId);
}
