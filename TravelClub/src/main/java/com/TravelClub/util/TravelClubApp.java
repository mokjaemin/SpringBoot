package com.TravelClub.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.TravelClub.service.ClubService;
import com.TravelClub.service.sdo.TravelClubCdo;

public class TravelClubApp {

	public static void main(String[] args) {
		
		// xml 파일을 읽음
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		String [] beanNames = context.getBeanDefinitionNames();
		// System.out.println(Arrays.toString(beanNames));
		
		
		// 클럽 이름, 설명 객체에 담음
		TravelClubCdo clubCdo = new TravelClubCdo("TravelClub1", "Test Test Test");
		// Bean clubService 빈 받아옴
		ClubService clubService = context.getBean("clubService", ClubService.class);
		// ClubService의 매서드 이용해 클럽 등록
		String clubID = clubService.registerClub(clubCdo);
		// 반환된 클럽아이디 출력
		System.out.println(clubID);

	}

}
