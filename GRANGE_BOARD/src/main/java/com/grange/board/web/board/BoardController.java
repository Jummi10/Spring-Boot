package com.grange.board.web.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grange.board.board.service.BoardService;
import com.grange.board.board.vo.BoardVO;

@Controller(value = "webBoardController") // 모든 함수들의 반환형은 String = html의 이름
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = "/index")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/list")
	public String list(ModelMap model // controller가 model(service->dao)에서 가져온 데이터를 modelmap으로 view로 보내준다
			, @RequestParam(name = "page", defaultValue = "1") int page
			, @RequestParam(name = "rows", defaultValue = "20") int rows) {
		
		List<BoardVO> boards = this.boardService.getBoards(page, rows);
		model.addAttribute("boards", boards);
		model.addAttribute("page", page);
		
//		if(true) {	// login이 안 되어 있으면
//			return "redirect:/user/login";
//		}	// 모든 함수에 넣을 수 없음. -> login 공통 부분은 interceptor로
		
		return "pages/board/list_ajax";	// return View	// ContextConfig.class - templates/*.html
	}
	
	@GetMapping(value = "/detail/{id}")
	public ModelAndView detail(
			@PathVariable(name = "id", required = true) int id) {
		BoardVO board = this.boardService.getBoard(id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/board/detail");
		mav.addObject("board", board);	//연결해주고 싶은 data
		
		// list에서는 view(String returnType)와 model(ModelMap) 따로 보내줬는데 여기서는 한 번에 보내줌.
		return mav;	// return "board/detial";
	}
	
	@GetMapping(value = "/write")
	public String wrtie() {
		return "pages/board/write";
	}
	
	@PostMapping(value = "/write")
	public String postWrite(BoardVO board) {
		board.setRegId("gmlgml");	// user table 없을 때
		this.boardService.insertBoard(board);
		
		return "redirect:/board/list";
	}
	
	@GetMapping(value = "/modify/{id}")
	public String modify(
			@PathVariable(name = "id", required = true) int id
			, ModelMap model) {
		
		BoardVO board = this.boardService.getBoard(id);
		model.addAttribute("board", board);
		
		return "pages/board/modify";
	}
	
	@PostMapping(value = "/modify")
	public String postModify(BoardVO board) {
		this.boardService.updateBoard(board);
		
		return "redirect:/board/detail/" + board.getId();
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(
			@PathVariable(name = "id", required = true) int id) {
		this.boardService.deleteBoard(id);
		
		return "redirect:/board/list";
	}

}
