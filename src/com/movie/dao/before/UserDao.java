package com.movie.dao.before;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.movie.pojo.User;

@Repository("userDao")
@Mapper
public interface UserDao {
	
	public User selectUserByTelAndPassword(@Param("tel") String tel,@Param("pw") String password);
	
	public int insertUser(@Param("user") User user);
	
	public User selectByTel(@Param("tel") String tel);
	
	public User selectById(@Param("id") String id);
}
