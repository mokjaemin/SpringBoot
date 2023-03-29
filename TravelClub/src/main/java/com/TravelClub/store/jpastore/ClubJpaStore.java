package com.TravelClub.store.jpastore;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.TravelClub.aggregate.club.TravelClub;
import com.TravelClub.store.ClubStore;
import com.TravelClub.store.jpastore.jpo.TravelClubJpo;
import com.TravelClub.store.jpastore.repository.ClubRepository;
import com.TravelClub.util.exception.NoSuchClubException;


@Repository("clubJpaStore")
public class ClubJpaStore implements ClubStore{
	
	private ClubRepository clubRepository;
	
	
	public ClubJpaStore(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}

	@Override
	public String create(TravelClub club) {
		clubRepository.save(new TravelClubJpo(club));
		return club.getId();
	}

	@Override
	public TravelClub retrieve(String clubId) {
		Optional<TravelClubJpo> clubJpo = clubRepository.findById(clubId);
		if(!clubJpo.isPresent()) {
			throw new NoSuchClubException(String.format("Travel Club(%s) is not Found", clubId));
		}
		// Optional 객체를 사용중이기에 get()해줘야 함.
		return clubJpo.get().toDomain();
	}

	@Override
	public List<TravelClub> retrieveByName(String name) {
		List<TravelClubJpo> clubJpos = clubRepository.findAllByName(name);
		return clubJpos.stream().map(TravelClubJpo::toDomain).collect(Collectors.toList());
	}

	@Override
	public List<TravelClub> retrieveAll() {
		List<TravelClubJpo> clubJpo = clubRepository.findAll();
		// return clubJpo.stream().map(club -> club.toDomain()).collect(Collectors.toList());
		return clubJpo.stream().map(TravelClubJpo::toDomain).collect(Collectors.toList());
	}

	@Override
	public void update(TravelClub club) {
		clubRepository.save(new TravelClubJpo(club));
		
	}

	@Override
	public void delete(String clubId) {
		clubRepository.deleteById(clubId);
		
	}

	@Override
	public boolean exists(String clubId) {
		return clubRepository.existsById(clubId);	
	}

}
