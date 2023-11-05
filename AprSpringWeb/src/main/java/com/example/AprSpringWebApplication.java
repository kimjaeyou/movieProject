package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
//@ComponentScan(basePackages{"com.example","com.test"})
public class AprSpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AprSpringWebApplication.class, args);
	}
	
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}
	//_method라는 이름으로 전달된 값을 요청방식으로 인식
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	//RestTemplate객체 만들어 주입 http요청( Json,Xml,String)응답을 Java객체로 스프링용 통신
}
