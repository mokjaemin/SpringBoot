package com.TravelClub.controller.logic;


//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.TravelClub.aggregate.club.TravelClub;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootTest
@AutoConfigureMockMvc // MockMvc를 주입해주기 위한 애너테이션

// 위의 과정 한줄로 경량화해 처리
//@WebMvcTest(ClubController.class)
class ClubContollerLogicTest {

	
	
	// 임의적으로 get,post방식의 HTTP메서드를 보낼 수 있도록 해주는 클래스
	 @Autowired
	 private MockMvc mockmvc;
	
	 
	 
	// json을 전송할 수 있게해주는 클래스
	 @Autowired
	 private ObjectMapper objectMapper;


	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	// JsonProcessingException을 Exception으로 변경 -> Exception의 경우가 더 많아서
	void testRegister() throws Exception {
		TravelClub sample = TravelClub.sample();
		// TravelClub 클래스를 Json으로 변경
		String content = objectMapper.writeValueAsString(sample);
		// 요청 보내기, post는 static임. 
		mockmvc.perform(post("/club")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()) // 200 OK?
				.andExpect(content().string(sample.getId())) // 전달한 데이터와 전달하려고한 데이터가 같은지
				.andDo(print()); // 그 결과 전체를 출력
	}

	@Test
	void testFindAll() {
		// fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		// fail("Not yet implemented");
	}

	@Test
	void testFindByName() {
		// fail("Not yet implemented");
	}

	@Test
	void testModify() {
		// fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		// fail("Not yet implemented");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
}
