package com.capgemini.chess.dataaccess.soruce.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.entities.ProfileEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.soruce.MapDataSource;
@Service
public class MapDataSoruceImpl implements MapDataSource {

	private Map<Long, UserEntity> usersById = new HashMap<Long, UserEntity>();
	private Map<Long, ProfileEntity> profilesById = new HashMap<Long, ProfileEntity>();

	@Override
	public Map<Long, UserEntity> getUsers() {
		return usersById;
	}

	@Override
	public Map<Long, ProfileEntity> getProfile() {
		return profilesById;
	}

	public void setUsers(Map<Long, UserEntity> usersById) {
		this.usersById = usersById;
	}

	public void setProfiles(Map<Long, ProfileEntity> profilesById) {
		this.profilesById = profilesById;
	}
	
	public List<UserEntity> getAllUsers(){
		return new ArrayList<UserEntity>( usersById.values());
	}

}
