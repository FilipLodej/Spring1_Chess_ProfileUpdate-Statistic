package com.capgemini.chess.ranking.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.soruce.MapDataSource;
import com.capgemini.chess.ranking.service.UpdateRankingService;
import com.capgemini.chess.to.UserTO;


public class UpdateRankingServiceImpl implements UpdateRankingService{

	@Autowired
	MapDataSource mapDataService;
	
	@Autowired
	UserDAO userDao;
	
	
	@Override
	public UserTO updateRanking(UserTO userTo) {
		List<UserEntity> users=mapDataService.getAllUsers();
		UserComparator comparator = new UserComparator();
		Collections.sort(users, comparator);	
		UserEntity user=getUser(users,userTo);
		int position=users.indexOf(user);		user.setPosition(position);
		return userDao.updateRanking(user);
		
	}

	private UserEntity getUser(List<UserEntity> users, UserTO userTo) {
		long userId=userTo.getId();
		UserEntity foundUser=users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);	
		return foundUser;
	}
}
