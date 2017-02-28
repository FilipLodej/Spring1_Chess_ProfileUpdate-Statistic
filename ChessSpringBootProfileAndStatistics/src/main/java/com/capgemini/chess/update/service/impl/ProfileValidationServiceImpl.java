package com.capgemini.chess.update.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.chess.dao.ProfileDAO;
import com.capgemini.chess.to.ProfileTO;
import com.capgemini.chess.update.exception.ProfileValidationException;
import com.capgemini.chess.update.service.ProfileValidationService;

public class ProfileValidationServiceImpl implements ProfileValidationService {

	@Autowired
	ProfileDAO profileDao;

	@Override
	public void validate(ProfileTO profileTo) throws ProfileValidationException {
		validateProfileId(profileTo.getId());
		validateProfileData(profileTo);
	}

	private void validateProfileId(Long id) throws ProfileValidationException {
		ProfileTO foundProfileById = profileDao.findById(id);
		if (foundProfileById == null) {
			throw new ProfileValidationException("User's profile with given id doesnt exists!");
		}
	}

	private void validateProfileData(ProfileTO profileTo) throws ProfileValidationException {
		if (profileTo.getName() == null || profileTo.getSurname() == null || profileTo.getAboutMe() == null
				|| profileTo.getLifeMotto() == null) {
			throw new ProfileValidationException("Profile data are incorrect. Fill in the missing data profile.");
		} else if (!checkNumberOfCharactersNameSurname(profileTo.getName())) {
			throw new ProfileValidationException("Name must contain between 1 and 10 characters");
		} else if (!checkNumberOfCharactersNameSurname(profileTo.getSurname())) {
			throw new ProfileValidationException("Surname must contain between 1 and 10 characters");
		} else if (!checkNumberOfCharactersAboutMeLifeMotto(profileTo.getAboutMe())) {
			throw new ProfileValidationException("About me must contain between 10 and 50 characters");
		} else if (!checkNumberOfCharactersAboutMeLifeMotto(profileTo.getLifeMotto())) {
			throw new ProfileValidationException("Life motto must contain between 10 and 50 characters");
		}
	}

	private boolean checkNumberOfCharactersNameSurname(String string) {
		boolean isCorrectNumberOfCharacters = false;
		if (string.length() > 1 && string.length() < 10) {
			isCorrectNumberOfCharacters = true;
		}
		return isCorrectNumberOfCharacters;
	}

	private boolean checkNumberOfCharactersAboutMeLifeMotto(String string) {
		boolean isCorrectNumberOfCharacters = false;
		if (string.length() > 10 && string.length() < 50) {
			isCorrectNumberOfCharacters = true;
		}
		return isCorrectNumberOfCharacters;
	}
}
