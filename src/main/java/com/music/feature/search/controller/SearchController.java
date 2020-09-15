package com.music.feature.search.controller;

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

import com.music.feature.search.service.SearchService;
import com.music.feature.search.vo.SearchVo;

@Controller
public class SearchController {
	public static final String TILES_PREFIX="tiles.search.";
	
	@Autowired SearchService searchService;

	/**
	 * <pre>자유게시판 목록 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/search/pageList.do")
	public String pageSearchList() {
		return TILES_PREFIX + "searchList";
	}
	/**
	 * <pre>자유게시판 등록 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/search/pageRegist.do")
	public String pageSearchRegist() {
		return TILES_PREFIX + "searchRegist";
	}
	/**
	 * <pre>자유게시판 상세 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/search/pageDetail.do")
	public String pageSearchDetail() {
		return TILES_PREFIX + "searchDetail";
	}
	/**
	 * <pre>자유게시판 수정 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/search/pageModify.do")
	public String pageSearchModify() {
		return TILES_PREFIX + "searchModify";
	}

	/**
	 * <pre>자유게시판 목록 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	@GetMapping("/search/getList.do")
	public @ResponseBody Map<String, Object> getSearchList(SearchVo searchVo) {
		return searchService.getSearchList(searchVo);
	}

	/**
	 * <pre>자유게시판 등록</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	@PostMapping("/search/create.do")
	public @ResponseBody ResponseEntity<String> createSearch(SearchVo searchVo) {
		searchService.createSearch(searchVo);
		return new ResponseEntity<String>(null, null, HttpStatus.CREATED);
	}

	/**
	 * <pre>자유게시판 상세 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	@GetMapping("/search/get.do")
	public @ResponseBody SearchVo getSearch(SearchVo searchVo) {
		return searchService.getSearch(searchVo);
	}

	/**
	 * <pre>자유게시판 수정</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	@PutMapping("/search/modify.do")
	public @ResponseBody ResponseEntity<String> modifySearch(@RequestBody SearchVo searchVo) {
		searchService.modifySearch(searchVo);
		return new ResponseEntity<String>(null, null, HttpStatus.OK);
	}

	/**
	 * <pre>자유게시판 삭제</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param searchVo
	 * @return
	 */
	@DeleteMapping("/search/remove.do")
	public @ResponseBody ResponseEntity<String> removeSearch(@RequestBody SearchVo searchVo) {
		searchService.removeSearch(searchVo);
		return new ResponseEntity<String>(null, null, HttpStatus.NO_CONTENT);
	}
}

