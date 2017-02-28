package com.capgemini.chess.dataaccess.entities;

public class UserEntity {

	private Long id;
	private String email;
	private String password;
	private ProfileEntity profile;
	int rankingPosition;
	int points;
	int level;
	int numberOfGames;
	
	public Long getId() {
		return id;
	}

	public int getRankingPosition() {
		return rankingPosition;
	}

	public void setRankingPosition(int rankingPosition) {
		this.rankingPosition = rankingPosition;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getNumberOfGames() {
		return numberOfGames;
	}

	public void setNumberOfGames(int numberOfGames) {
		this.numberOfGames = numberOfGames;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProfileEntity getProfile() {
		return profile;
	}

	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}

	public int getPosition() {
		return rankingPosition;
	}

	public void setPosition(int position) {
		this.rankingPosition = position;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	
}
