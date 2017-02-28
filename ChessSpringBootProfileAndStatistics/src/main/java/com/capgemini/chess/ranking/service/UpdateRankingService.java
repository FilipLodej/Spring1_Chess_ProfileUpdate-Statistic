package com.capgemini.chess.ranking.service;

import com.capgemini.chess.ranking.exception.ResultException;
import com.capgemini.chess.to.UserTO;

public interface UpdateRankingService {

	public UserTO updateRanking(UserTO userTo) throws ResultException;

}
