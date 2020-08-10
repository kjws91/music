package com.music.feature.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.music.feature.board.service.BoardService;
import com.music.feature.board.vo.BoardVo;

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
	
	@GetMapping("/getList.do")
	public @ResponseBody Map<String, Object> getBoardList(BoardVo boardVo) {
		return boardService.getBoardList(boardVo);
	}
	
	@PostMapping("/create.do")
	public @ResponseBody ResponseEntity<String> createBoard(BoardVo boardVo) {
		boardService.createBoard(boardVo);
		return new ResponseEntity<String>(null, null, HttpStatus.CREATED);
	}
	
	@GetMapping("/get.do")
	public @ResponseBody BoardVo getBoard(BoardVo boardVo) {
		return boardService.getBoard(boardVo);
	}
	
	@PutMapping("/modify.do")
	public @ResponseBody ResponseEntity<String> modifyBoard(@RequestBody BoardVo boardVo) {
		boardService.modifyBoard(boardVo);
		return new ResponseEntity<String>(null, null, HttpStatus.OK);
	}
	
	@DeleteMapping("/remove.do")
	public @ResponseBody ResponseEntity<String> removeBoard(@RequestBody BoardVo boardVo) {
		boardService.removeBoard(boardVo);
		return new ResponseEntity<String>(null, null, HttpStatus.NO_CONTENT);
	}
}

