package com.TravelClub.service;

import com.TravelClub.aggregate.club.TravelClub;
import com.TravelClub.service.sdo.TravelClubCdo;
import com.TravelClub.shared.NameValueList;

import java.util.List;

public interface ClubService {
	//
	String registerClub(TravelClubCdo club);
	String registerClubTest(TravelClub travelClub);
	TravelClub findClubById(String id);
	List<TravelClub> findClubByName(String name);
	List<TravelClub> findAll();
	void modify(String clubId, NameValueList nameValues);
	void remove(String clubId);
}
