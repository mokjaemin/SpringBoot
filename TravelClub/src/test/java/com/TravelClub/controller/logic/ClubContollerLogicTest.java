package com.TravelClub.controller.logic;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.TravelClub.controller.ClubController;



//@SpringBootTest
//@AutoConfigureMockMvc // MockMvc를 주입해주기 위한 애너테이션

// 위의 과정 한줄로 경량화해 처리
@WebMvcTest(ClubController.class)
class ClubContollerLogicTest {

	// 임의적으로 get,post방식의 HTTP메서드를 보낼 수 있도록 해주는 클래스
	@Autowired
	private MockMvc mokmvc;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRegister() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByName() {
		fail("Not yet implemented");
	}

	@Test
	void testModify() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
}
