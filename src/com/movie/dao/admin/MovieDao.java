package com.movie.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.movie.pojo.Movie;
import com.movie.pojo.Notice;
import com.movie.pojo.PageInfo;

@Repository("movieDao")
@Mapper
public interface MovieDao {
	
	public List<Movie> selectMovieByPage(@Param("page") PageInfo page);
	
	public Integer selectMovieCount(@Param("page") PageInfo page);
	
	public Integer deleteMovies(@Param("movieIds") List<String> movieIds);
	
	public Integer deleteOneMovie(@Param("movieId") String movieId);
	
	public Integer addNewMovie(@Param("movie") Movie movie);
	
	public Integer updateMovie(@Param("movie") Movie movie);
	
	public Movie movieDetails(String movieId);
}
