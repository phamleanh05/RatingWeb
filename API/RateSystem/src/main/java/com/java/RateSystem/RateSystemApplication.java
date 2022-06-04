package com.java.RateSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class RateSystemApplication{

	public static void main(String[] args) {
		SpringApplication.run(RateSystemApplication.class, args);
	}
}
