package com.capgemini.chess.dao;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.to.UserTO;

public interface UserDAO {
	
	 UserTO update(UserTO userTo);
	 UserTO findByID(Long id);
	 UserTO updateRanking(UserEntity user);
	 UserTO updatePoints(UserTO userTo, int points);
}
