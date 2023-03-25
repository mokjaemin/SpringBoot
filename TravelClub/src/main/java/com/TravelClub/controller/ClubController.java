package com.TravelClub.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TravelClub.aggregate.club.TravelClub;
import com.TravelClub.service.ClubService;
import com.TravelClub.service.sdo.TravelClubCdo;


@RestController
public class ClubController {
	
	private ClubService clubService;
	
	
	// 생성자를 통한 주입
	public ClubController(ClubService clubService) {
		this.clubService = clubService;
	}
	
	// Club 등록
	@PostMapping("/club") 
	// http://localhost:8090/club + Post 방식으로 오는 데이터에 대해서 처리
	// Post 데이터는 body에 데이터를 추가해서 전달됨.
	// 그런 body를 처리하기 위한 Annotation이 @ReqestBody임.
	public String register(@RequestBody TravelClubCdo travelClubCdo) {
		return clubService.registerClub(travelClubCdo);
	}
	
	// Club 전체리스트 검
	@GetMapping("/club/all")
	public List<TravelClub> findAll(){
		return clubService.findAll();
	}
	
	// Club Id로 검색
	// http://localhost:8090/club + Get 방식으로 오는 데이터에 대해서 처리
	// Get은 url에 달려서 전달됨
	// 그런 방식을 처리하기 위해 @PathVariable 사용
	
	 @GetMapping("/club/{clubId}")
	public TravelClub findById(@PathVariable String clubId){
		return clubService.findClubById(clubId);
	}
	
	@GetMapping("/club")
	// RequestParam은 http://localhost:8090/club?name=
	// url에 있는 ?name 과 변수명 같아야 함.
	// 즉, 기존의 정통 get방식 요청
	public List<TravelClub> findByName(@RequestParam String name){
		System.out.println(name);
		return clubService.findClubByName(name);
	}
	
	
}
