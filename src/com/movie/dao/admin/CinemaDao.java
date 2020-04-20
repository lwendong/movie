package com.movie.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.movie.pojo.Cinema;
import com.movie.pojo.PageInfo;

@Repository("cinemaDao")
@Mapper
public interface CinemaDao {
	
	public Integer addCinema(@Param("cinema") Cinema cinema);
	
	public List<Cinema> selectCinemaByPage(@Param("page") PageInfo page);
	
	public Integer selectCinemaCount(@Param("page") PageInfo page);
	 
	public Integer deleteCinema(@Param("cinemaId") String cinemaId);
	
	public List<Cinema> selectAllMovieType();
	
	public List<Cinema> selectCinema();
}
