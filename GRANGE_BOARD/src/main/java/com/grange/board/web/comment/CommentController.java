package com.grange.board.web.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.grange.board.comment.service.CommentService;
import com.grange.board.comment.vo.CommentVO;

@Controller(value = "webCommentController")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping(value = "board/{boardId}/comment")
	public String postComment(
			@PathVariable(name = "boardId", required = true) int boardId
			, CommentVO comment) {
		comment.setBoardId(boardId);
		this.commentService.insertComment(comment);
		
		return "redirect:/board/detail/{boardId}";
	}
}
