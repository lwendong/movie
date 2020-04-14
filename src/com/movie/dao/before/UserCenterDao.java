package com.movie.dao.before;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.movie.pojo.Comment;
import com.movie.pojo.PageInfo;
import com.movie.pojo.Ticket;
import com.movie.pojo.User;

@Repository("userCenterDao")
@Mapper
public interface UserCenterDao {
	
	public Integer updateInfo(@Param("user") User user);
	
	public List<Ticket> selectTicketByUserId(@Param("userId") String userId,@Param("page") PageInfo pageInfo);
	
	public Integer selectTicketByUserIdCount(@Param("userId") String userId,@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);
	
	public Integer refund(@Param("id") String id);
	
	public List<Comment> selectCommentByUserId(@Param("userId") String userId,@Param("page") PageInfo pageInfo);
	
	public Integer selectCommentByUserIdCount(@Param("userId") String userId,@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);
	
	public Integer deleteComment(@Param("id") String id);
}
