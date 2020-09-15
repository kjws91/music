package com.music.feature.search.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.music.feature.search.vo.SearchVo;

@Mapper
public interface SearchMapper {
	/**
	 * <pre>자유게시판 목록 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	public List<SearchVo> selectSearchList(SearchVo searchVo);

	/**
	 * <pre>자유게시판 등록</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	public int insertSearch(SearchVo searchVo);

	/**
	 * <pre>자유게시판 상세 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	public SearchVo selectSearch(SearchVo searchVo);

	/**
	 * <pre>자유게시판 수정</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	public int updateSearch(SearchVo searchVo);

	/**
	 * <pre>자유게시판 삭제</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	public int deleteSearch(SearchVo searchVo);
}
