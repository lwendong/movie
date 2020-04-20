package com.movie.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.movie.pojo.PageInfo;
import com.movie.pojo.Ticket;

@Repository("ticketDao")
@Mapper
public interface TicketDao {
	
	public List<Ticket> selectTicketByPage(@Param("page") PageInfo page);
	
	public Ticket selectTicketById(@Param("id") String id,@Param("type") Integer type);
	
	public Integer selectTicketCount(@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);
	
	public Integer buy(@Param("movieId") String movieId, @Param("num") Integer num, @Param("userId") String userId);
	
	public List<Ticket> selectTicketByMovieIdAndUserId(@Param("userId") String userId,@Param("movieId") String movieId);
	
	
}
