package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class UserApp {


	private static final Logger logger = LoggerFactory.getLogger(UserApp.class);
	public static void main(String[] args) throws Exception {
		logger.info("this is a info message");
		SpringApplication.run(UserApp.class, args);
		
	}


}
