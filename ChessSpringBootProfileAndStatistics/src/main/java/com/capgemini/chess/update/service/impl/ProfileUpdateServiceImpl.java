package com.capgemini.chess.update.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ProfileDAO;
import com.capgemini.chess.to.ProfileTO;
import com.capgemini.chess.update.exception.ProfileValidationException;
import com.capgemini.chess.update.service.ProfileUpdateService;
import com.capgemini.chess.update.service.ProfileValidationService;

@Service
public class ProfileUpdateServiceImpl implements ProfileUpdateService {

	@Autowired
	ProfileValidationService profileValidService;

	@Autowired
	ProfileDAO profileDao;

	@Override
	public ProfileTO updateProfile(ProfileTO profileTo) throws ProfileValidationException {
		profileValidService.validate(profileTo);
		return profileDao.update(profileTo);
	}

}
