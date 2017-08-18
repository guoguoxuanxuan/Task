package com.crrcgo.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@SpringBootApplication
@MapperScan(basePackages = "com.crrcgo.task.mapper")
public class CrrcgoTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrrcgoTaskApplication.class, args);
	}
	
	 @RequestMapping("/")
	    String home() {
		 
		 return "redirect:tasks";
	       // return "redirect:tasks";
	    }
}
