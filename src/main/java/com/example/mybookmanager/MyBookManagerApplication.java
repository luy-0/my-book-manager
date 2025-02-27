package com.example.mybookmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@SpringBootApplication
public class MyBookManagerApplication {

	@RequestMapping("/")
	String hello(){
		return "Hello!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(MyBookManagerApplication.class, args);
	}

}
