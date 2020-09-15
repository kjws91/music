package com.music.feature.search.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.music.feature.search.mapper.SearchMapper;
import com.music.feature.search.vo.SearchVo;

@Service
public class SearchService {

	@Autowired SearchMapper searchMapper;
	
	/**
	 * <pre>자유게시판 등록</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	@Transactional
	public void createSearch(SearchVo searchVo) {
		searchMapper.insertSearch(searchVo);
	}

	/**
	 * <pre>자유게시판 목록 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	public Map<String, Object> getSearchList(SearchVo searchVo) {
		Map<String, Object> resMap = new HashMap<>();
		List<SearchVo> searchList = searchMapper.selectSearchList(searchVo);
		
		resMap.put("list", searchList);
		resMap.put("page", searchVo);
		return resMap;
	}

	/**
	 * <pre>자유게시판 상세 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	public SearchVo getSearch(SearchVo searchVo) {
		return searchMapper.selectSearch(searchVo);
	}

	/**
	 * <pre>자유게시판 수정</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	@Transactional
	public void modifySearch(SearchVo searchVo) {
		int iRet = searchMapper.updateSearch(searchVo);
	}

	/**
	 * <pre>자유게시판 삭제</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	@Transactional
	public void removeSearch(SearchVo searchVo) {
		int iRet = searchMapper.deleteSearch(searchVo);
	}
	
}
