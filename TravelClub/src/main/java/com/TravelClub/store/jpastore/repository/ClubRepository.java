package com.TravelClub.store.jpastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelClub.store.jpastore.jpo.TravelClubJpo;

// JpaRepository 상속 ->
public interface ClubRepository extends JpaRepository<TravelClubJpo, String>{

}
