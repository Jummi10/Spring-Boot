package com.grange.board.comment.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentVO {

	private int id;
	private int boardId;
	private String content;
	private Date regDtt;
	private String regId;
}
