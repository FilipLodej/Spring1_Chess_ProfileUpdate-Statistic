package com.capgemini.chess.ranking.service;

import com.capgemini.chess.ranking.exception.ResultException;
import com.capgemini.chess.to.ResultTO;
import com.capgemini.chess.to.UserTO;

public interface UpdatePlayerRankingService {

	UserTO updatePlayerRanking(UserTO userTo, ResultTO resultTo)throws ResultException;
	
}
