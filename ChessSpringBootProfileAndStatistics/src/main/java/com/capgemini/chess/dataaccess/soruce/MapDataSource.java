package com.capgemini.chess.dataaccess.soruce;

import java.util.List;
import java.util.Map;

import com.capgemini.chess.dataaccess.entities.ProfileEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;

public interface MapDataSource {

	Map<Long, UserEntity> getUsers();
	Map<Long, ProfileEntity> getProfile();
	List<UserEntity> getAllUsers();
}
