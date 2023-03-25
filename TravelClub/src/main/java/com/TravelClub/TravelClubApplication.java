package com.TravelClub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.TravelClub.service.ClubService;
import com.TravelClub.service.sdo.TravelClubCdo;


// 앱시작 파일
@SpringBootApplication
public class TravelClubApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(TravelClubApplication.class, args);
		
	}

}
