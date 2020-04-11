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
	
	public Integer selectCommentCount(@Param("page") PageInfo page);
	
	public Integer deleteOneComment(@Param("commentId") String commentId);
}
