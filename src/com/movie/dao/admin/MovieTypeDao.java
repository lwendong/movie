package com.movie.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.movie.pojo.Movie;
import com.movie.pojo.MovieType;
import com.movie.pojo.PageInfo;

@Repository("movieTypeDao")
@Mapper
public interface MovieTypeDao {
	
	public Integer addType(@Param("type") MovieType movieType);
	
	public List<MovieType> selectTypeByPage(@Param("page") PageInfo page);
	
	public Integer selectTypeCount(@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);
	 
	public Integer deleteType(@Param("typeId") String typeId);
	
	public List<MovieType> selectAllMovieType();
	
	public List<MovieType> selectType();
}
