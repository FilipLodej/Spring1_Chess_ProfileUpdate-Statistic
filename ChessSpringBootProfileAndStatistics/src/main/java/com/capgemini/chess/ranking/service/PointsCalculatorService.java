package com.capgemini.chess.ranking.service;

import com.capgemini.chess.ranking.exception.ResultException;
import com.capgemini.chess.to.ResultTO;


public interface PointsCalculatorService {

	int calculatePoints(ResultTO resultTo) throws ResultException;

}
