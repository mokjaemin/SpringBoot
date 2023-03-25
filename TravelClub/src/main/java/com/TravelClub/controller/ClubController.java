package com.TravelClub.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TravelClub.service.ClubService;
import com.TravelClub.service.sdo.TravelClubCdo;


@RestController
public class ClubController {
	
	private ClubService clubService;
	
	
	// 생성자를 통한 주입
	public ClubController(ClubService clubService) {
		this.clubService = clubService;
	}
	
	@PostMapping("/club") 
	// localhost:8090/club + Post 방식으로 오는 데이터에 대해서 처리
	// Post 데이터는 body에 데이터를 추가해서 전달됨.
	// 그런 body를 처리하기 위한 Annotation이 @ReqestBody임.
	public String register(@RequestBody TravelClubCdo travelClubCdo) {
		return clubService.registerClub(travelClubCdo);
	}
	
	
}
