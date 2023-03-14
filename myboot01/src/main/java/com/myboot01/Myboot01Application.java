package com.myboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Myboot01Application {
	// 스프링 부트 프로젝트는 반드시 메인은 항상 존재
	// 일반 자바 어플리케이션과 유사하게 개발하려는 의도
	public static void main(String[] args) {
		SpringApplication.run(Myboot01Application.class, args);
	}

}
