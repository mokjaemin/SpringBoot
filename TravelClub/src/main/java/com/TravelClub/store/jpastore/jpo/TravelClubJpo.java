package com.TravelClub.store.jpastore.jpo;

import org.springframework.beans.BeanUtils;

import com.TravelClub.aggregate.club.TravelClub;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Travel_Club") // 테이블 생성시 이 이름으로 설정
public class TravelClubJpo {
	
	
	@Id // 식별자, key 정의
	private String id;
	private String name;
	private String intro;
	private long foundationTime;
	
	
	// DTO를 Entity로 변환
	public TravelClubJpo(TravelClub travelClub) {
		// DTO의 프로퍼티들을 Entity의 프로퍼티들로 매핑
		BeanUtils.copyProperties(travelClub, this);
	}
	
	// Entity를 다시 DTO로 변환 
	public TravelClub toDomain() {
		TravelClub travelClub = new TravelClub(this.name, this.intro);
		travelClub.setId(this.id);
		travelClub.setFoundationTime(this.foundationTime);
		return travelClub;
	}
}
