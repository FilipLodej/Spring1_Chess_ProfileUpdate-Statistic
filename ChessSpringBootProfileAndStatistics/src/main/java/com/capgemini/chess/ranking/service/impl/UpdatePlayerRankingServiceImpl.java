package com.capgemini.chess.ranking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.ranking.exception.ResultException;
import com.capgemini.chess.ranking.service.PointsCalculatorService;
import com.capgemini.chess.ranking.service.UpdateLevelService;
import com.capgemini.chess.ranking.service.UpdatePlayerRankingService;
import com.capgemini.chess.ranking.service.UpdateRankingService;
import com.capgemini.chess.ranking.service.UpdatePointsService;
import com.capgemini.chess.to.ResultTO;
import com.capgemini.chess.to.UserTO;


public class UpdatePlayerRankingServiceImpl implements UpdatePlayerRankingService {

	@Autowired
	PointsCalculatorService pointsCalculator;

	@Autowired
	UpdatePointsService updatePointsService;

	@Autowired
	UpdateLevelService updateLevelService;

	@Autowired
	UserDAO userDao;
	
	@Autowired
	UpdateRankingService updateRankingService;

	@Override
	public UserTO updatePlayerRanking(UserTO userTo, ResultTO resultTo) throws ResultException {
		int points=pointsCalculator.calculatePoints(resultTo);
		UserTO user=updatePointsService.addPointsToUser(userTo, points);
		user = updateLevelService.updatePlayerLevel(user);
		user = updateRankingService.updateRanking(user);
		return userDao.update(user);
	}
	
}
