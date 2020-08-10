package com.music.feature.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.music.feature.board.vo.BoardVo;

@Mapper
public interface BoardMapper {
	/**
	 * <pre>자유게시판 목록 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public List<BoardVo> selectBoardList(BoardVo boardVo);

	/**
	 * <pre>자유게시판 등록</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public int insertBoard(BoardVo boardVo);

	/**
	 * <pre>자유게시판 상세 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public BoardVo selectBoard(BoardVo boardVo);

	/**
	 * <pre>자유게시판 수정</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public int updateBoard(BoardVo boardVo);

	/**
	 * <pre>자유게시판 삭제</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public int deleteBoard(BoardVo boardVo);
}
