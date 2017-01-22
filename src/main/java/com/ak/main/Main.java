package com.ak.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.ak.service", "com.ak.DAO", "com.ak.controller"})
@EnableAutoConfiguration
public class Main {
	
	public static void main(String[] args){
//		ConfigurableApplicationContext ctx = 
		SpringApplication.run(Main.class, args);
		System.out.println("działa");
		//defaultowo je�eli jest nazwa banner w spring.boot to sie wywo�uje!

	}

}
