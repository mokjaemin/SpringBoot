package com.TravelClub.service;

import com.TravelClub.aggregate.club.TravelClub;
import com.TravelClub.service.sdo.TravelClubCdo;
import com.TravelClub.shared.NameValueList;

import java.util.List;

public interface ClubService {
	//
	String registerClub(TravelClubCdo club);
	TravelClub findClubById(String id);
	List<TravelClub> findClubsByName(String name);
	void modify(String clubId, NameValueList nameValues);
	void remove(String clubId);
}
