package com.movie.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.movie.pojo.Movie;
import com.movie.pojo.Notice;
import com.movie.pojo.PageInfo;

@Repository("movieDao")
@Mapper
public interface MovieDao {
	
	public List<Movie> selectMovieByPage(@Param("page") PageInfo page,@Param("code") String code,@Param("myKey") String myKey);
	
	public Integer selectMovieCount(@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);
	
	public Integer deleteMovies(@Param("movieIds") List<String> movieIds);
	
	public Integer deleteOneMovie(@Param("movieId") String movieId);
	
	public Integer addNewMovie(@Param("movie") Movie movie);
	
	public Integer updateMovie(@Param("movie") Movie movie);
	
	public Movie movieDetails(String movieId);
	
	public List<Movie> selectMovieByType(@Param("page") PageInfo page,@Param("typeCode") String typeCode);
	
	public List<Movie> search(@Param("mykey") String mykey);
	
	public Movie selectMovieById(@Param("movieId") String movieId);
	
	public Integer updateMovieNum(@Param("movieId") String movieId,@Param("num") Integer num,@Param("type") Integer type);
	
}
