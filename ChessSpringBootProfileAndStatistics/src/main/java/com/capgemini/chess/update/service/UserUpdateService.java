package com.capgemini.chess.update.service;

import com.capgemini.chess.to.UserTO;
import com.capgemini.chess.update.exception.UserValidationException;

public interface UserUpdateService {

	UserTO updateUser(UserTO user) throws UserValidationException;
}
