package com.capgemini.chess.ranking.service;

import com.capgemini.chess.to.UserTO;

public interface UpdatePointsService {

	UserTO addPointsToUser(UserTO userTo, int points);
}
