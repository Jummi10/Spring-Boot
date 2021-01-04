package com.grange.board.map.vo;

import java.util.Date;

public class MapVO {
	
	private int id;
	private String comment;
	private Date regDtt;
	private String regId;
	private double latitude;
	private double longitude;
	private String useYn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getRegDtt() {
		return regDtt;
	}
	public void setRegDtt(Date regDtt) {
		this.regDtt = regDtt;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
}
