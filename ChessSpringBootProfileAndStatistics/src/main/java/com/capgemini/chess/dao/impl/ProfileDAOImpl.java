package com.capgemini.chess.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ProfileDAO;
import com.capgemini.chess.dataaccess.entities.ProfileEntity;

import com.capgemini.chess.dataaccess.soruce.MapDataSource;
import com.capgemini.chess.to.ProfileTO;

import com.capgemini.chess.update.service.mapper.ProfileMapper;

@Service
public class ProfileDAOImpl implements ProfileDAO {

	@Autowired
	private MapDataSource dataSource;

	@Override
	public ProfileTO findById(Long id) {
		ProfileEntity profileFoundByIdEntity = dataSource.getProfile().values().stream()
				.filter(u -> u.getId().equals(id)).findFirst().orElse(null);
		return ProfileMapper.map(profileFoundByIdEntity);
	}

	@Override
	public ProfileTO update(ProfileTO profileTo) {
		ProfileEntity profileEntity = ProfileMapper.map(profileTo);
		long profileId = profileEntity.getId();
		dataSource.getProfile().put(profileId, profileEntity);
		return ProfileMapper.map(profileEntity);

	}

}
