package com.capgemini.chess.update.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.to.UserTO;
import com.capgemini.chess.update.exception.UserValidationException;
import com.capgemini.chess.update.service.UserValidationService;

public class UserValidationServiceImpl implements UserValidationService {

	@Autowired
	private UserDAO userDao;

	@Override
	public void validate(UserTO user) throws UserValidationException {

		validateId(user);
		validateEmail(user);
		validatePassword(user);
		
	}

	private void validateId(UserTO user) throws UserValidationException {
		UserTO foundUserById = userDao.findByID(user.getId());
		if (foundUserById == null) {
			throw new UserValidationException("User with given Id not exist!");
		}

	}
	
	private void validateEmail(UserTO user)throws UserValidationException{
		Pattern eMailPattern = Pattern.compile(".+@.+\\.[a-z]+");
		if(user.getEmail()!=null){
		Matcher matcher=eMailPattern.matcher(user.getEmail());
		boolean matchFound=matcher.matches();
			if(!matchFound){
			throw new UserValidationException("Incorrect email adress to update");
			}
		}else{
			throw new UserValidationException("Incorrect email adress to update. Cannot be empty");
		}
	}
	
	private void validatePassword(UserTO user) throws UserValidationException{
		if(user.getPassword()!=null && user.getPassword().length()<8){
			throw new UserValidationException("Incorrect password to update. Password should has at least 8 characters.");
		}else if(user.getPassword()==null){
			throw new UserValidationException("Incorrect password to update. Password cannot be empty");
		}
	}
}
