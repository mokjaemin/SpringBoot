package com.TravelClub.service;

import com.TravelClub.aggregate.club.CommunityMember;
import com.TravelClub.service.sdo.MemberCdo;
import com.TravelClub.shared.NameValueList;

import java.util.List;

public interface MemberService {
	//
	String registerMember(MemberCdo member);
	CommunityMember findMemberById(String memberId);
	CommunityMember findMemberByEmail(String memberEmail);
	List<CommunityMember> findMembersByName(String name);
	void modifyMember(String memberId, NameValueList member);
	void removeMember(String memberId);
}