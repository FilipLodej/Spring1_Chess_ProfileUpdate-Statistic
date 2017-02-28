package com.capgemini.chess.update.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.to.ProfileTO;
import com.capgemini.chess.to.UserTO;
import com.capgemini.chess.update.exception.ProfileValidationException;
import com.capgemini.chess.update.exception.UserValidationException;
import com.capgemini.chess.update.service.ProfileUpdateService;
import com.capgemini.chess.update.service.UserServiceFacade;
import com.capgemini.chess.update.service.UserUpdateService;

@Service
public class UserServiceFacadeImpl implements UserServiceFacade {

	@Autowired
	private UserUpdateService userUpdateService;
	@Autowired
	private ProfileUpdateService profileUpdateService;

	@Override
	public UserTO updateUser(UserTO UserTo) throws UserValidationException {
		return userUpdateService.updateUser(UserTo);
	}

	@Override
	public ProfileTO udpateProfile(ProfileTO profileTo) throws ProfileValidationException {
		return profileUpdateService.updateProfile(profileTo);
	}

}
