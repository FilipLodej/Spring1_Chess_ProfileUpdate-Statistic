package com.capgemini.chess.ranking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.ranking.exception.ResultException;
import com.capgemini.chess.ranking.service.StatisticsServiceFacade;
import com.capgemini.chess.ranking.service.UpdatePlayerRankingService;
import com.capgemini.chess.to.ResultTO;
import com.capgemini.chess.to.UserTO;
@Service
public class StatisticsServiceFacadeImpl implements StatisticsServiceFacade {

	@Autowired
	UpdatePlayerRankingService updatePlayerRankingService;

	@Override
	public UserTO updatePlayerRanking(UserTO userTo, ResultTO resultTo) throws ResultException {
		return updatePlayerRankingService.updatePlayerRanking(userTo, resultTo);
	}
}
