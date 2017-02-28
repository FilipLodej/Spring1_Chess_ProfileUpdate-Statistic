package com.capgemini.chess.update.service;

import com.capgemini.chess.to.ProfileTO;
import com.capgemini.chess.to.UserTO;
import com.capgemini.chess.update.exception.ProfileValidationException;
import com.capgemini.chess.update.exception.UserValidationException;

public interface UserServiceFacade {
	UserTO updateUser(UserTO userTo) throws UserValidationException;
	ProfileTO udpateProfile(ProfileTO profileTo) throws ProfileValidationException;
}
