package com.capgemini.chess.to;

public class UserTO {

	private Long id;
	private String email;
	private String password;
	private ProfileTO profile;
	int rankingPosition;
	int points;
	int level;
	int numberOfGames;
	
	
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

	public Long getId() {
		return id;
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

	public ProfileTO getProfile() {
		return profile;
	}

	public void setProfile(ProfileTO profile) {
		this.profile = profile;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	
}
