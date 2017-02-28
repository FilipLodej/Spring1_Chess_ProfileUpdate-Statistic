package com.capgemini.chess.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.soruce.MapDataSource;
import com.capgemini.chess.to.UserTO;
import com.capgemini.chess.update.service.mapper.UserMapper;

public class UserDAOImpl implements UserDAO {

	@Autowired
	private MapDataSource dataSource;

	@Override
	public UserTO update(UserTO user) {
		UserEntity userEntity = UserMapper.map(user);
		long userId = userEntity.getId();
		dataSource.getUsers().put(userId, userEntity);
		return UserMapper.map(userEntity);
	}

	@Override
	public UserTO findByID(Long id) {
		UserEntity userFoundById = dataSource.getUsers().values().stream().filter(u -> u.getId().equals(id)).findFirst()
				.orElse(null);
		return UserMapper.map(userFoundById);
	}

	@Override
	public UserTO updateRanking(UserEntity user) {
		UserEntity userEntity = user;
		long userId = userEntity.getId();
		dataSource.getUsers().put(userId, userEntity);
		return UserMapper.map(userEntity);
	}

	@Override
	public UserTO updatePoints(UserTO userTo, int points) {
		UserEntity userEntity = UserMapper.map(userTo);
		long userId = userEntity.getId();
		int sumPoints = userEntity.getPoints();
		int numberOfGames=userEntity.getNumberOfGames();
		sumPoints += points;
		numberOfGames++;
		userEntity.setPoints(sumPoints);
		userEntity.setNumberOfGames(numberOfGames);
		dataSource.getUsers().put(userId, userEntity);
		return UserMapper.map(userEntity);
	}

}
