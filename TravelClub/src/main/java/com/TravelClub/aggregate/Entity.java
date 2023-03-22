package com.TravelClub.aggregate;

import lombok.Getter;
import lombok.Setter;

import java.util.*;


//lombok annotation
@Getter
@Setter
public abstract class Entity {
	//
	protected String id;

	protected Entity() {
		// 랜덤한 아이디 발생
		this.id = UUID.randomUUID().toString();
	}

	protected Entity(String id) {
		//
		this.id = id;
	}
}
