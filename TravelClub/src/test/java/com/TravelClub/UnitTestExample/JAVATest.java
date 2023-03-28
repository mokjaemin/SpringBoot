

package com.TravelClub.UnitTestExample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


// 가독성을 위한 애너테이션 설정
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;



public class JAVATest {

	
	// 로또 번호 생성 클래스
	public class LottoNumberGenerator {

		// 돈을 입력
		// final - 더이상 수정을 할 수 없다.
	    public List<Integer> generate(final int money) {
	    	// 입력받은 돈 타당성 체크
	        if (!isValidMoney(money)) {
	            throw new RuntimeException("올바른 금액이 아닙니다.");
	        }
	        // 로또 번호 생성해서 반환
	        return generateList();
	    }

	    
	    // 돈이 타당한지 판단
	    // 1000원인지 아닌지 판단
	    private boolean isValidMoney(final int money) {
	        return money == 1000;
	    }

	    
	    // 로또 생성 메서드 
	    private List<Integer> generateList() {
	        return new Random()
	                .ints(1, 45 + 1) // 1~46 사이의
	                .distinct() // 각각의 구별된 
	                .limit(6) // 6개의 숫자 생성을 하고
	                .boxed() 
	                .collect(Collectors.toList()); // 리스트로 반환
	    }

	}
	
	// given - 어떠한 데이터가 준비되어 있을 
	// when - 어떠한 함수를 실행하면
	// then - 어떠한 결과가 나와야한다.
	
	@Test
	@DisplayName("로또 번호 갯수 테스트")
	public void lottoNumberSizeTest() {
		
	    // given
		// 로또 생성기 객체와 돈 1000원이 주어졌을 때 
	    final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
	    final int price = 1000;
	    

	    // when
	    // 로또 생성기 함수를 실행하면
	    final List<Integer> lottoNumber = lottoNumberGenerator.generate(price);

	    
	    // then
	    // 결과의 사이즈가 6이 나와야한다.
	    assertThat(lottoNumber.size()).isEqualTo(6);
	}
	
	
	@Test
	@DisplayName("로또 번호 범위 테스트")
	public void lottoNumberRangeTest() {
	    
		// given
		// 로또 생성기 객체와 돈 1000원이 주어졌을 때 
	    final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
	    final int price = 1000;

	    
	    // when
	    // 로또 생성기 함수를 실행하면
	    final List<Integer> lotto = lottoNumberGenerator.generate(price);

	    
	    // then
	    // 결과 각각의 범위가 1과 45 사이에 해당하는지 확인했을 때 전부 true여야 한다.
	    assertThat(lotto.stream().allMatch(v -> v >= 1 && v <= 45)).isTrue();
	}
	
	
	@Test
	@DisplayName("잘못된 로또 금액 테스트")
	public void lottoNumberInvalidMoneyTest() {
	    
		// given
		// 로또 생성기 객체와 돈 2000원이 주어졌을 때 
		// 즉, 돈이 잘못되게 주어졌을 때, 
	    final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
	    final int price = 2000;

	    
	    // when
	    // 로또 생성기의 함수를 실행시키면
	    final RuntimeException exception = assertThrows(RuntimeException.class, () -> lottoNumberGenerator.generate(price));

	    
	    // then
	    // 올바른 금액이 아닙니다. 라는 올바른 메시지가 Exception으로 와야한다.
	    assertThat(exception.getMessage()).isEqualTo("올바른 금액이 아닙니다.");
	}
}
