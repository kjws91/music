package com.music.feature.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	public static final String TILES_PREFIX="tiles.main.";
	@RequestMapping("/")
	public String pageMain() {
		return TILES_PREFIX + "main";
	}

}
