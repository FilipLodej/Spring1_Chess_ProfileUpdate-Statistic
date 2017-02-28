package com.capgemini.chess.update.service;

import com.capgemini.chess.to.ProfileTO;
import com.capgemini.chess.update.exception.ProfileValidationException;

public interface ProfileUpdateService {

	ProfileTO updateProfile(ProfileTO profileTO) throws ProfileValidationException;
}
