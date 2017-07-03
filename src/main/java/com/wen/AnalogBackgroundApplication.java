package com.wen;

import com.wen.filter.ErrorFilter;
import com.wen.filter.ThrowExceptionFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;

@EnableZuulServer
@SpringBootApplication
public class AnalogBackgroundApplication {

	@Bean
	public ThrowExceptionFilter getThrowExceptionFilter(){
		return new ThrowExceptionFilter();
	}

	@Bean
	public ErrorFilter getErrorFilter(){
		return new ErrorFilter();
	}
	public static void main(String[] args) {
		SpringApplication.run(AnalogBackgroundApplication.class, args);
	}
}
