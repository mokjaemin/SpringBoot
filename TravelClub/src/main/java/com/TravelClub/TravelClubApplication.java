package com.TravelClub;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.TravelClub.service.ClubService;
import com.TravelClub.service.sdo.TravelClubCdo;


// 앱시작 파일
@SpringBootApplication
public class TravelClubApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		String [] beanNames = context.getBeanDefinitionNames();
//		System.out.println(Arrays.toString(beanNames));
		
		TravelClubCdo clubcdo = new TravelClubCdo("TravelClub1", "Test Test Test");
		ClubService clubService = context.getBean("clubService", ClubService.class);
		String clubID = clubService.registerClub(clubcdo);
		System.out.println(clubID);
//		SpringApplication.run(TravelClubApplication.class, args);
	}

}
