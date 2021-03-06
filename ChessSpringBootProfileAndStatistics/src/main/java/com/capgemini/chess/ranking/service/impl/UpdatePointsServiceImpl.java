package com.capgemini.chess.ranking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.ranking.service.UpdatePointsService;
import com.capgemini.chess.to.UserTO;
@Service
public class UpdatePointsServiceImpl implements UpdatePointsService {

	@Autowired
	UserDAO userDao;

	@Override
	public UserTO addPointsToUser(UserTO userTo, int points) {
		return userDao.updatePoints(userTo, points);
	}
}
