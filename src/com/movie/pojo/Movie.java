package com.movie.pojo;

import java.util.Date;

public class Movie extends BaseModel{
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String description;
	
	private String typeName;
	
	private String typeCode;
	
	private String img;
	
	private Integer surplus;
	
	private Integer price;
	
	private Date time;
	
	private Date releaseTime;
	
	private String releaseTimeLocal;
	
	private String playPlace;
	
	private Integer play;
	
	private Boolean deleted;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getSurplus() {
		return surplus;
	}

	public void setSurplus(Integer surplus) {
		this.surplus = surplus;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getPlayPlace() {
		return playPlace;
	}

	public void setPlayPlace(String playPlace) {
		this.playPlace = playPlace;
	}

	public Integer getPlay() {
		return play;
	}

	public void setPlay(Integer play) {
		this.play = play;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getReleaseTimeLocal() {
		return releaseTimeLocal;
	}

	public void setReleaseTimeLocal(String releaseTimeLocal) {
		this.releaseTimeLocal = releaseTimeLocal;
	}
	
	
}
