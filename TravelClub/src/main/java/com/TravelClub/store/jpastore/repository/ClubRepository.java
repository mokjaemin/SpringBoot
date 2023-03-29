package com.TravelClub.store.jpastore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelClub.store.jpastore.jpo.TravelClubJpo;

// JpaRepository 상속 -> Spring JPA에서 제공해주는 기본 CRUD 기능 등을 사용 가능
public interface ClubRepository extends JpaRepository<TravelClubJpo, String>{
	List<TravelClubJpo> findAllByName(String name);
}
