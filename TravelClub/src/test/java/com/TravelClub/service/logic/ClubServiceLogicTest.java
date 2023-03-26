package com.TravelClub.service.logic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TravelClub.aggregate.club.TravelClub;
import com.TravelClub.service.ClubService;
import com.TravelClub.service.sdo.TravelClubCdo;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClubServiceLogicTest {

	// TDD시에는 @RequiredArgsConstructor, 생성자로 의존성 주입 불가능
	// 사용시 주입안됨.
	@Autowired
	ClubService clubService;
	
	@Test
	public void registerTest() {
		TravelClub sample = TravelClub.sample();
		 assertThat(this.clubService.registerClubTest(sample));
		 // 등록했으면 삭제도 해줘야 함.
		 assertThat(this.clubService.findClubById(sample.getId())).isEqualTo(sample);
		 assertThat(this.clubService.findAll().size()).isEqualTo(1);
	}
}
