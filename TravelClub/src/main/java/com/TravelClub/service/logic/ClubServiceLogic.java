package com.TravelClub.service.logic;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TravelClub.aggregate.club.TravelClub;
import com.TravelClub.service.ClubService;
import com.TravelClub.service.sdo.TravelClubCdo;
import com.TravelClub.shared.NameValueList;
import com.TravelClub.store.ClubStore;
import com.TravelClub.store.mapstore.ClubMapStore;


@Service("clubService")
public class ClubServiceLogic implements ClubService{
	
	// interface 객체 생성
	private ClubStore clubStore;
	
	// 생성자
	// IoC 처리 전
	public ClubServiceLogic() {
		this.clubStore = new ClubMapStore();
	}
	// IoC 처리 
	// public ClubServiceLogic(ClubStore clubStore) {
	// 	this.clubstore = clubStore;
	// }
	

	// 클럽 등록
	@Override
	public String registerClub(TravelClubCdo club) {
		TravelClub newClub = new TravelClub(club.getName(), club.getIntro());
		newClub.checkValidation();
		return clubStore.create(newClub);
	}

	@Override
	public TravelClub findClubById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TravelClub> findClubsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(String clubId, NameValueList nameValues) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String clubId) {
		// TODO Auto-generated method stub
		
	}

}
