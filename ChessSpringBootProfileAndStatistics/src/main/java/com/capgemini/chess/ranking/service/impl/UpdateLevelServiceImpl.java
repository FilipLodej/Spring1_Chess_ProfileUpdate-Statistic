package com.capgemini.chess.ranking.service.impl;

import com.capgemini.chess.ranking.service.UpdateLevelService;
import com.capgemini.chess.to.UserTO;

public class UpdateLevelServiceImpl implements UpdateLevelService {


	
	@Override
	public UserTO updatePlayerLevel(UserTO userTo) {
		int currentLevel=calculateLevel(userTo);
		userTo.setLevel(currentLevel);
		return userTo;
	}
	
	int calculateLevel(UserTO userTo){
		int points=userTo.getPoints();
		int calculatedLevel=points/10;
	return calculatedLevel;
	}

}
