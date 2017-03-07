package com.capgemini.chess.update.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.to.UserTO;
import com.capgemini.chess.update.exception.UserValidationException;
import com.capgemini.chess.update.service.UserUpdateService;
import com.capgemini.chess.update.service.UserValidationService;

@Service
public class UserUpdateServiceImpl implements UserUpdateService {

	@Autowired
	private UserValidationService userValidationService;
	
	@Autowired
	private UserDAO userDao;

	@Override
	public UserTO updateUser(UserTO userTo) throws UserValidationException {
		userValidationService.validate(userTo);
		return userDao.update(userTo);
	}
}
