package com.capgemini.chess.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dao.impl.UserDAOImpl;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.soruce.MapDataSource;
import com.capgemini.chess.to.UserTO;

@RunWith(MockitoJUnitRunner.class)
public class UserDAOImplTest {

	private static final long EXISTING_ID = 1L;
	private static final long NOT_EXISTING_ID = 10L;

	private Map<Long, UserEntity> giveUsersMap() {
		HashMap<Long, UserEntity> users = new HashMap<Long, UserEntity>();
		UserEntity user1 = new UserEntity();
		user1.setId(EXISTING_ID);
		users.put(EXISTING_ID, user1);
		return users;
	}

	@InjectMocks
	UserDAOImpl userDao;

	@Mock
	private MapDataSource dataSource;

	@Test
	public void shouldNotFindUserWhenIdDoesNotExist() {
		// given
		Mockito.when(dataSource.getUsers()).thenReturn(giveUsersMap());

		// when
		UserTO user = userDao.findByID(NOT_EXISTING_ID);

		// then
		Assert.assertNull(user);
	}

	@Test
	public void shouldFindUserWhenIdExist() {
		// given
		Mockito.when(dataSource.getUsers()).thenReturn(giveUsersMap());

		// when
		UserTO user = userDao.findByID(EXISTING_ID);

		// then
		Assert.assertNotNull(user);
	} 

}
