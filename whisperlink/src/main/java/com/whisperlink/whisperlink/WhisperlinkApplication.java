package com.whisperlink.whisperlink;
//import com.whisperlink.whisperlink.services.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(SecurityConfig.class)
public class WhisperlinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhisperlinkApplication.class, args);
	}

}
