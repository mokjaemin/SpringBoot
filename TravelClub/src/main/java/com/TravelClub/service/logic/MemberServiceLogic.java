package com.TravelClub.service.logic;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TravelClub.aggregate.club.CommunityMember;
import com.TravelClub.service.MemberService;
import com.TravelClub.service.sdo.MemberCdo;
import com.TravelClub.shared.NameValueList;
import com.TravelClub.store.MemberStore;
import com.TravelClub.util.exception.MemberDuplicationException;
import com.TravelClub.util.exception.NoSuchMemberException;



@Service("memberService")
public class MemberServiceLogic implements MemberService{
	
	private MemberStore memberStore;
	
	
	// bean이 생성자를 통해 주입됨.
	public MemberServiceLogic(MemberStore memberStore) {
		this.memberStore = memberStore;
	}
	

	@Override
	public String registerMember(MemberCdo member) {
		String email = member.getEmail();
		CommunityMember foundedMember = memberStore.retrieveByEmail(email);
		
		if (foundedMember != null) {
			throw new MemberDuplicationException("Member already existes with Email " + email);
		}
		foundedMember = new CommunityMember(
				member.getEmail(), member.getName(), member.getPhoneNumber());
		foundedMember.setBirthDay(member.getBirthDay());
		foundedMember.setNickName(member.getNickName());
		
		foundedMember.checkValidation();
		
		memberStore.create(foundedMember);
		
		return foundedMember.getId();
		
	}

	@Override
	public CommunityMember findMemberById(String memberId) {
		return memberStore.retrieve(memberId);
	}

	@Override
	public CommunityMember findMemberByEmail(String memberEmail) {
		
		return memberStore.retrieveByEmail(memberEmail);
	}

	@Override
	public List<CommunityMember> findMembersByName(String name) {
		
		return memberStore.retrieveByName(name);
	}

	@Override
	public void modifyMember(String memberId, NameValueList nameValueList) {
		CommunityMember targetMember = memberStore.retrieve(memberId);
		if (targetMember != null) {
			throw new NoSuchMemberException("No such Member with " + memberId);
		}
		
		targetMember.modifyValues(nameValueList);
		
		memberStore.update(targetMember);
		
	}

	@Override
	public void removeMember(String memberId) {
		if (!memberStore.exists(memberId)) {
			throw new NoSuchMemberException("No such Member with " + memberId);
		}
		
		
		memberStore.delete(memberId);
		
	}

}
