package com.music.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.music")
public class MusicApplication {
	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}

}
