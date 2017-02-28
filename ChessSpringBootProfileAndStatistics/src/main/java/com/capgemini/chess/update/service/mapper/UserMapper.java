package com.capgemini.chess.update.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.to.UserTO;

public class UserMapper {

	public static UserTO map(UserEntity entity) {
		if (entity != null) {
			UserTO to = new UserTO();
			to.setId(entity.getId());
			to.setEmail(entity.getEmail());
			to.setPassword(entity.getPassword());
			to.setProfile(ProfileMapper.map(entity.getProfile()));
			to.setLevel(entity.getLevel());
			to.setNumberOfGames(entity.getNumberOfGames());
			to.setPoints(entity.getPoints());
			to.setRankingPosition(entity.getRankingPosition());
			
			return to;
		}
		return null;
	}

	public static UserEntity map(UserTO to) {
		if (to != null) {
			UserEntity entity = new UserEntity();
			entity.setId(to.getId());
			entity.setEmail(to.getEmail());
			entity.setPassword(to.getPassword());
			entity.setProfile(ProfileMapper.map(to.getProfile()));
			entity.setLevel(to.getLevel());
			entity.setNumberOfGames(to.getNumberOfGames());
			entity.setPoints(to.getPoints());
			entity.setRankingPosition(to.getRankingPosition());
			return entity;
		}
		return null;
	}

	public static List<UserTO> map2TOs(List<UserEntity> entities) {
		return entities.stream().map(UserMapper::map).collect(Collectors.toList());
	}

	public static List<UserEntity> map2Entities(List<UserTO> tos) {
		return tos.stream().map(UserMapper::map).collect(Collectors.toList());
	}
}
