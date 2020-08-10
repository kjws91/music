package com.music.feature.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.music.feature.board.mapper.BoardMapper;
import com.music.feature.board.vo.BoardVo;

@Service
public class BoardService {

	@Autowired BoardMapper boardMapper;
	
	/**
	 * <pre>자유게시판 등록</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	@Transactional
	public void createBoard(BoardVo boardVo) {
		boardMapper.insertBoard(boardVo);
	}

	/**
	 * <pre>자유게시판 목록 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public Map<String, Object> getBoardList(BoardVo boardVo) {
		Map<String, Object> resMap = new HashMap<>();
		List<BoardVo> boardList = boardMapper.selectBoardList(boardVo);
		
		resMap.put("list", boardList);
		resMap.put("page", boardVo);
		return resMap;
	}

	public BoardVo getBoard(BoardVo boardVo) {
		return boardMapper.selectBoard(boardVo);
	}

	@Transactional
	public void modifyBoard(BoardVo boardVo) {
		int iRet = boardMapper.updateBoard(boardVo);
	}

	@Transactional
	public void removeBoard(BoardVo boardVo) {
		int iRet = boardMapper.deleteBoard(boardVo);
	}
	
}
