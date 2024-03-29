package com.TravelClub.service.logic;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TravelClub.aggregate.club.TravelClub;
import com.TravelClub.service.ClubService;
import com.TravelClub.service.sdo.TravelClubCdo;
import com.TravelClub.shared.NameValueList;
import com.TravelClub.store.ClubStore;
import com.TravelClub.util.exception.NoSuchClubException;


@Service("clubService")
public class ClubServiceLogic implements ClubService{
	
	// interface 객체 생성
	private ClubStore clubStore;
	
	// 생성자
	// IoC 처리 전
	// public ClubServiceLogic() {
	// 	this.clubStore = new ClubMapStore();
	// }
	
	 // IoC 처리 
	 public ClubServiceLogic(ClubStore clubStore) {
	 	this.clubStore = clubStore;
	 }
	
	// 테스트 클럽 등록을 위한 메서드
	 @Override
		public String registerClubTest(TravelClub travelClub) {
			// 제한사항 체크
			travelClub.checkValidation();
			return clubStore.create(travelClub);
	}
		
	 

	// 클럽 등록
	@Override
	public String registerClub(TravelClubCdo club) {
		TravelClub newClub = new TravelClub(club.getName(), club.getIntro());
		// 제한사항 체크
		newClub.checkValidation();
		return clubStore.create(newClub);
	}
	
	// 클럽 전체 리스트 찾기
	@Override
	public List<TravelClub> findAll() {
		return clubStore.retrieveAll();
	}

	// 아이디로 클럽찾기
	@Override
	public TravelClub findClubById(String id) {
		return clubStore.retrieve(id);
	}

	// 이름으로 클럽찾기
	@Override
	public List<TravelClub> findClubByName(String name) {
		return clubStore.retrieveByName(name);
	}
	
	// 클럽 수정
	@Override
	public void modify(String clubId, NameValueList nameValues) {
		TravelClub foundedClub = clubStore.retrieve(clubId);
		if (foundedClub == null) {
			throw new NoSuchClubException("No Such Club with ID : " + clubId);
		}
		foundedClub.modifyValues(nameValues);
		clubStore.update(foundedClub);
	}

	// 클럽 삭제
	@Override
	public void remove(String clubId) {
		if (!clubStore.exists(clubId)) {
			throw new NoSuchClubException("No Such Club with ID : " + clubId);
		}
		clubStore.delete(clubId);
	}

}
