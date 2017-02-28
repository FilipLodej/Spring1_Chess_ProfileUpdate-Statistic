package com.capgemini.chess.dao;

import com.capgemini.chess.to.ProfileTO;

public interface ProfileDAO {

	ProfileTO findById(Long id);

	ProfileTO update(ProfileTO profileTo);
}
