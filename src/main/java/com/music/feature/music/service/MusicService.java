package com.music.feature.music.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.music.feature.music.mapper.MusicMapper;
import com.music.feature.music.vo.MusicVo;

@Service
public class MusicService {

	@Autowired MusicMapper musicMapper;
	
	/**
	 * <pre>자유게시판 등록</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param musicVo
	 * @return
	 */
	@Transactional
	public void createMusic(MusicVo musicVo) {
		musicMapper.insertMusic(musicVo);
	}

	/**
	 * <pre>자유게시판 목록 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public Map<String, Object> getMusicList(MusicVo musicVo) {
		Map<String, Object> resMap = new HashMap<>();
		List<MusicVo> musicList = musicMapper.selectMusicList(musicVo);
		
		resMap.put("list", musicList);
		resMap.put("page", musicVo);
		return resMap;
	}

	/**
	 * <pre>자유게시판 상세 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param musicVo
	 * @return
	 */
	public MusicVo getMusic(MusicVo musicVo) {
		return musicMapper.selectMusic(musicVo);
	}

	/**
	 * <pre>자유게시판 수정</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param musicVo
	 * @return
	 */
	@Transactional
	public void modifyMusic(MusicVo musicVo) {
		int iRet = musicMapper.updateMusic(musicVo);
	}

	/**
	 * <pre>자유게시판 삭제</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param musicVo
	 * @return
	 */
	@Transactional
	public void removeMusic(MusicVo musicVo) {
		int iRet = musicMapper.deleteMusic(musicVo);
	}
	
}
