package com.movie.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.movie.pojo.Comment;
import com.movie.pojo.PageInfo;

@Repository("commentDao")
@Mapper
public interface CommentDao {
	
	public List<Comment> selectCommentByPage(@Param("page") PageInfo page);
	
	public Integer selectCommentCount(@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);
	
	public Integer deleteOneComment(@Param("commentId") String commentId);
	
	public List<Comment> selectCommentByMovieId(@Param("commentId") String commentId);
	
	public Integer addComment(@Param("movieId") String movieId,@Param("comment") String comment,@Param("userId") String userId);
}
