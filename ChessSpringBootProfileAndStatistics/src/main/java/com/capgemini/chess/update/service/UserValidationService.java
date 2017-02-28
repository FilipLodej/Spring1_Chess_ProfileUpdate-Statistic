package com.capgemini.chess.update.service;

import com.capgemini.chess.to.UserTO;
import com.capgemini.chess.update.exception.UserValidationException;

public interface UserValidationService {

	void validate(UserTO user) throws UserValidationException;
}
