package com.music.feature.music.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.music.feature.music.vo.MusicVo;

@Mapper
public interface MusicMapper {
	/**
	 * <pre>자유게시판 목록 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public List<MusicVo> selectMusicList(MusicVo musicVo);

	/**
	 * <pre>자유게시판 등록</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public int insertMusic(MusicVo musicVo);

	/**
	 * <pre>자유게시판 상세 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public MusicVo selectMusic(MusicVo musicVo);

	/**
	 * <pre>자유게시판 수정</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public int updateMusic(MusicVo musicVo);

	/**
	 * <pre>자유게시판 삭제</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public int deleteMusic(MusicVo musicVo);
}
