package com.grange.board.board.vo;

import java.util.Date;

public class BoardVO {
	private int id;
	private String title;
	private String content;
	private Date regDtt;
	private String regId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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

}
