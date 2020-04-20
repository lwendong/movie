package com.movie.pojo;

import java.util.Date;

public class Cinema extends BaseModel{
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String code;
	
	private Date time;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
