package com.TravelClub.store.mapstore;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.TravelClub.aggregate.club.TravelClub;
import com.TravelClub.store.ClubStore;



//@Repository("clubMapStore")
public class ClubMapStore implements ClubStore{
	
	private Map<String, TravelClub> clubMap;
	
	// 생성자
	public ClubMapStore() {
		this.clubMap = new LinkedHashMap();
	}
	
	
	// Club 추가
	@Override
	public String create(TravelClub club) {
		// 아이디와 클럽객체 추가
		clubMap.put(club.getId(), club);
		// 확인으로 클럽아이디 반환
		return club.getId();
	}
	
	// 모든 클럽 반환
	public List<TravelClub> retrieveAll() {
		return clubMap.values().stream()
				.collect(Collectors.toList());
	}

	// 클럽 아이디로 해당 클럽이 있는지 찾기
	@Override
	public TravelClub retrieve(String clubId) {
		// 해당 클럽아이디를 찾아 클럽객체 리턴
		return	clubMap.get(clubId);
	}

	// 이름과 동일한 클럽 반환
	// 같은 이름 모두 반환.
	@Override
	public List<TravelClub> retrieveByName(String name) {
		// 이름에 맞는 클럽을 모두 찾아 리스트로 반환
		// Stream 사용		
		
		return clubMap.values().stream()
				.filter(club -> club.getName().equals(name))
				.collect(Collectors.toList());
	}

	// 클럽 수정
	// 이미 수정된 정보가 넘어온다고 가정
	@Override
	public void update(TravelClub club) {
		clubMap.put(club.getId(), club);
		
	}

	// 클럽 삭제
	@Override
	public void delete(String clubId) {
		clubMap.remove(clubId);
		
	}

	
	// 해당 클럽아이디가 있는지?
	@Override
	public boolean exists(String clubId) {
		// TODO Auto-generated method stub
		// clubMap.containsKey(clubId); // 동일
		return Optional.ofNullable(clubMap.get(clubId)).isPresent();
	}

}
