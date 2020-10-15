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
import org.springframework.web.bind.annotation.ResponseBody;

import com.music.feature.board.service.BoardService;
import com.music.feature.board.vo.BoardVo;

@Controller
public class BoardController {
	public static final String TILES_PREFIX="tiles.board.";
	
	@Autowired BoardService boardService;

	/**
	 * <pre>자유게시판 목록 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/board/pageList.do")
	public String pageBoardList() {
		return TILES_PREFIX + "boardList";
	}
	/**
	 * <pre>자유게시판 등록 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/board/pageRegist.do")
	public String pageBoardRegist() {
		return TILES_PREFIX + "boardRegist";
	}
	/**
	 * <pre>자유게시판 상세 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/board/pageDetail.do")
	public String pageBoardDetail() {
		return TILES_PREFIX + "boardDetail";
	}
	/**
	 * <pre>자유게시판 수정 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/board/pageModify.do")
	public String pageBoardModify() {
		return TILES_PREFIX + "boardModify";
	}

	/**
	 * <pre>자유게시판 목록 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	@GetMapping("/board/getList.do")
	public @ResponseBody Map<String, Object> getBoardList(BoardVo boardVo) {
		return boardService.getBoardList(boardVo);
	}

	/**
	 * <pre>자유게시판 등록</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	@PostMapping("/board/create.do")
	public @ResponseBody ResponseEntity<String> createBoard(BoardVo boardVo) {
		boardService.createBoard(boardVo);
		return new ResponseEntity<String>(null, null, HttpStatus.CREATED);
	}

	/**
	 * <pre>자유게시판 상세 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	@GetMapping("/board/get.do")
	public @ResponseBody BoardVo getBoard(BoardVo boardVo) {
		return boardService.getBoard(boardVo);
	}

	/**
	 * <pre>자유게시판 수정</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	@PutMapping("/board/modify.do")
	public @ResponseBody ResponseEntity<String> modifyBoard(@RequestBody BoardVo boardVo) {
		boardService.modifyBoard(boardVo);
		return new ResponseEntity<String>(null, null, HttpStatus.OK);
	}

	/**
	 * <pre>자유게시판 삭제</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	@DeleteMapping("/board/remove.do")
	public @ResponseBody ResponseEntity<String> removeBoard(@RequestBody BoardVo boardVo) {
		boardService.removeBoard(boardVo);
		return new ResponseEntity<String>(null, null, HttpStatus.NO_CONTENT);
	}
}

