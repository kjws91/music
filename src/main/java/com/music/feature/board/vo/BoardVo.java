package com.music.feature.board.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVo {
	private String id;
	private String title;
	private String content;
	private String regId;
	private String regDt;
	private String modId;
	private String modDt;
	private String delYn;
}
