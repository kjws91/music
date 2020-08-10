package com.music.feature.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.music.feature.board.vo.BoardVo;

@Mapper
public interface BoardMapper {
	public int insertBoard(BoardVo boardVo);
	public List<BoardVo> selectBoardList(BoardVo boardVo);
	public BoardVo selectBoard(BoardVo boardVo);
	public int updateBoard(BoardVo boardVo);
	public int deleteBoard(BoardVo boardVo);
}
