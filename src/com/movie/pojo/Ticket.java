package com.movie.pojo;

import java.util.Date;

public class Ticket extends BaseModel{
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private Boolean type;
	
	private String userId;
	
	private String movieId;
	
	private Integer num;
	
	private Date time;
	
	private String movieName;
	
	private String moviePrice;
	
	private Date movieTime;
	
	private Date moviePlayTime;
	
	private String movieDescription;
	
	private Boolean isTp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMoviePrice() {
		return moviePrice;
	}

	public void setMoviePrice(String moviePrice) {
		this.moviePrice = moviePrice;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public Boolean getIsTp() {
		return isTp;
	}

	public void setIsTp(Boolean isTp) {
		this.isTp = isTp;
	}

	public Date getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(Date movieTime) {
		this.movieTime = movieTime;
	}

	public Date getMoviePlayTime() {
		return moviePlayTime;
	}

	public void setMoviePlayTime(Date moviePlayTime) {
		this.moviePlayTime = moviePlayTime;
	}
	
}
