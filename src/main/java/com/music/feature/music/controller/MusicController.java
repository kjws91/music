package com.music.feature.music.controller;

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

import com.music.feature.music.service.MusicService;
import com.music.feature.music.vo.MusicVo;

@Controller
public class MusicController {
	public static final String TILES_PREFIX="tiles.music.";
	
	@Autowired MusicService musicService;

	/**
	 * <pre>자유게시판 목록 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/music/pageList.do")
	public String pageMusicList() {
		return TILES_PREFIX + "musicList";
	}
	/**
	 * <pre>자유게시판 등록 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/music/pageRegist.do")
	public String pagemusicRegist() {
		return TILES_PREFIX + "musicRegist";
	}
	/**
	 * <pre>자유게시판 상세 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/music/pageDetail.do")
	public String pageMusicDetail() {
		return TILES_PREFIX + "musicDetail";
	}
	/**
	 * <pre>자유게시판 수정 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/music/pageModify.do")
	public String pageMusicModify() {
		return TILES_PREFIX + "musicModify";
	}

	/**
	 * <pre>자유게시판 목록 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param musicVo
	 * @return
	 */
	@GetMapping("/music/getList.do")
	public @ResponseBody Map<String, Object> getusicList(MusicVo musicVo) {
		return musicService.getMusicList(musicVo);
	}

	/**
	 * <pre>자유게시판 등록</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param musicVo
	 * @return
	 */
	@PostMapping("/music/create.do")
	public @ResponseBody ResponseEntity<String> createMusic(MusicVo musicVo) {
		musicService.createMusic(musicVo);
		return new ResponseEntity<String>(null, null, HttpStatus.CREATED);
	}

	/**
	 * <pre>자유게시판 상세 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param musicVo
	 * @return
	 */
	@GetMapping("/music/get.do")
	public @ResponseBody MusicVo getMusic(MusicVo musicVo) {
		return musicService.getMusic(musicVo);
	}

	/**
	 * <pre>자유게시판 수정</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param musicVo
	 * @return
	 */
	@PutMapping("/music/modify.do")
	public @ResponseBody ResponseEntity<String> modifyMusic(@RequestBody MusicVo musicVo) {
		musicService.modifyMusic(musicVo);
		return new ResponseEntity<String>(null, null, HttpStatus.OK);
	}

	/**
	 * <pre>자유게시판 삭제</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param musicVo
	 * @return
	 */
	@DeleteMapping("/music/remove.do")
	public @ResponseBody ResponseEntity<String> removeMusic(@RequestBody MusicVo musicVo) {
		musicService.removeMusic(musicVo);
		return new ResponseEntity<String>(null, null, HttpStatus.NO_CONTENT);
	}
}

