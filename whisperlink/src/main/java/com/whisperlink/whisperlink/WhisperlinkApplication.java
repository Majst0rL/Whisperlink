package com.whisperlink.whisperlink;
//import com.whisperlink.whisperlink.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootApplication
public class WhisperlinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhisperlinkApplication.class, args);
	}


//	@Configuration
//	@EnableWebSecurity
//	class SecurityConfig extends WebSecurityConfiguration {
//
//		@Autowired
//		private UserService userService;
//
//		@Override
//		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//			auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//		}
//
//		@Bean
//		public PasswordEncoder passwordEncoder() {
//			return new BCryptPasswordEncoder();
//		}
//	}
}
