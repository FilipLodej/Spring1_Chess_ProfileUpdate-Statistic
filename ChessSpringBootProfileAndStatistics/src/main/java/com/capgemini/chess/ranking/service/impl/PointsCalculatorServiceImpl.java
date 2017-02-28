package com.capgemini.chess.ranking.service.impl;

import com.capgemini.chess.ranking.exception.ResultException;
import com.capgemini.chess.ranking.service.PointsCalculatorService;
import com.capgemini.chess.to.ResultTO;

public class PointsCalculatorServiceImpl implements PointsCalculatorService {

	@Override
	public int calculatePoints(ResultTO resultTo) throws ResultException {
		int result = resultTo.getResult();
		int points = 0;
		if (result == 1) {
			points = calculateProfitPoints();
			return points;
		} else if (result == -1) {
			points = calculateLostPoints();
			return points;
		} else if (result == 0) {
			return points;
		} else {
			throw new ResultException("Result is incorrect");
		}
	}

	public int calculateProfitPoints() {
		int profitPoints = 5;
		return profitPoints;
	}

	public int calculateLostPoints() {
		int lostPoints = -5;
		return lostPoints;
	}

}
