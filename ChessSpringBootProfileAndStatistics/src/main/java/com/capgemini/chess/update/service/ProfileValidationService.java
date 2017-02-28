package com.capgemini.chess.update.service;

import com.capgemini.chess.to.ProfileTO;
import com.capgemini.chess.update.exception.ProfileValidationException;

public interface ProfileValidationService {

	void validate(ProfileTO profileTo) throws ProfileValidationException;
	
}
