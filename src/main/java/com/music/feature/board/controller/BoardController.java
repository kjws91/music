package com.music.feature.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.music.feature.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	public static final String TILES_PREFIX="tiles.board.";
	
	@Autowired BoardService boardService;
	
	
	@GetMapping("/pageList.do")
	public String pageBoardList() {
		return TILES_PREFIX + "boardList";
	}
	@GetMapping("/pageRegist.do")
	public String pageBoardRegist() {
		return TILES_PREFIX + "boardRegist";
	}
	@GetMapping("/pageDetail.do")
	public String pageBoardDetail() {
		return TILES_PREFIX + "boardDetail";
	}
	@GetMapping("/pageModify.do")
	public String pageBoardModify() {
		return TILES_PREFIX + "boardModify";
	}
}

