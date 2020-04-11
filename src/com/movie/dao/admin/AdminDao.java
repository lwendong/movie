package com.movie.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.movie.pojo.PageInfo;
import com.movie.pojo.User;


@Repository("adminDao")
@Mapper
public interface AdminDao {
	
	public List<User> selectAdminUserByPage(@Param("page") PageInfo page);
	
	public Integer selectAdminUserCount(@Param("page") PageInfo page);
	
	public Integer userState(String userId);
}
