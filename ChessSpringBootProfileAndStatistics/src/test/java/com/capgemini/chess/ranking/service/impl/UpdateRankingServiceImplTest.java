package com.capgemini.chess.ranking.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.soruce.MapDataSource;
import com.capgemini.chess.to.UserTO;

public class UpdateRankingServiceImplTest {
	
	@Mock
	MapDataSource dataSource;
	@Mock
	UserDAO userDao;
	@InjectMocks
	UpdateRankingServiceImpl updateRankingService;
	

	private List<UserEntity> giveUsersEnitiesList() {
		List<UserEntity> users = new ArrayList<UserEntity>();
		UserEntity user1 = new UserEntity();
		user1.setPoints(10);
		user1.setId(1L);
		UserEntity user2 = new UserEntity();
		user2.setPoints(20);
		user2.setId(2L);
		UserEntity user3 = new UserEntity();
		user3.setId(3L);
		user3.setPoints(30);
		UserEntity preparedUser=new UserEntity();
		preparedUser.setPoints(40);
		preparedUser.setId(4L);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(preparedUser);
		return users;
	}

}
