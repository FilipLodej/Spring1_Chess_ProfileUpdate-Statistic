package com.capgemini.chess.update.service.impl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dao.ProfileDAO;
import com.capgemini.chess.to.ProfileTO;
import com.capgemini.chess.to.UserTO;
import com.capgemini.chess.update.exception.ProfileValidationException;
import com.capgemini.chess.update.service.impl.ProfileValidationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProfileValidationServiceImplTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Mock
	private ProfileDAO profileDao;
	@InjectMocks
	private ProfileValidationServiceImpl profileValidService;

	@Test
	public void shouldThrowExceptionWhenProfileIdNotExists() throws ProfileValidationException {
		// given
		UserTO user = new UserTO();
		ProfileTO userProfile= new ProfileTO();
		userProfile.setId(1L);
		user.setProfile(userProfile);
		Mockito.when(profileDao.findById(user.getProfile().getId())).thenReturn(null);
		// expect
		exception.expect(ProfileValidationException.class);
		exception.expectMessage("User's profile with given id doesnt exists!");
		// when
		profileValidService.validate(user.getProfile());
	}
	@Test
	public void shouldThrowExceptionWhenProfileHasNullData() throws ProfileValidationException {
		// given
		UserTO user = new UserTO();
		ProfileTO userProfile= new ProfileTO();
		userProfile.setId(1L);
		user.setProfile(userProfile);
		Mockito.when(profileDao.findById(user.getProfile().getId())).thenReturn(new ProfileTO());
		// expect
		exception.expect(ProfileValidationException.class);
		exception.expectMessage("Profile data are incorrect. Fill in the missing data profile.");
		// when
		profileValidService.validate(user.getProfile());
	}
	@Test
	public void shouldThrowExceptionWhenProfileHasNameIncorrect() throws ProfileValidationException {
		// given
		UserTO user = new UserTO();
		ProfileTO userProfile= new ProfileTO();
		userProfile.setId(1L);
		userProfile.setName("asdfghjklzx"); //Name over then 10 characters
		userProfile.setSurname("abacki");
		userProfile.setAboutMe("asdfghjklzx");
		userProfile.setLifeMotto("asdfghjklzxc");
		user.setProfile(userProfile);
		Mockito.when(profileDao.findById(user.getProfile().getId())).thenReturn(new ProfileTO());
		// expect
		exception.expect(ProfileValidationException.class);
		exception.expectMessage("Name must contain between 1 and 10 characters");
		// when
		profileValidService.validate(user.getProfile());
	}
	@Test
	public void shouldThrowExceptionWhenProfileHasSurnameIsIncorrect() throws ProfileValidationException {
		// given
		UserTO user = new UserTO();
		ProfileTO userProfile= new ProfileTO();
		userProfile.setId(1L);
		userProfile.setName("asdfghj"); 
		userProfile.setSurname("abackiabackiabacki"); //Surname over then 10 characters
		userProfile.setAboutMe("asdfghjklzx");
		userProfile.setLifeMotto("asdfghjklzxc");
		user.setProfile(userProfile);
		Mockito.when(profileDao.findById(user.getProfile().getId())).thenReturn(new ProfileTO());
		// expect
		exception.expect(ProfileValidationException.class);
		exception.expectMessage("Surname must contain between 1 and 10 characters");
		// when
		profileValidService.validate(user.getProfile());
	}
	@Test
	public void shouldThrowExceptionWhenProfileHasAboutMeIsIncorrect() throws ProfileValidationException {
		// given
		UserTO user = new UserTO();
		ProfileTO userProfile= new ProfileTO();
		userProfile.setId(1L);
		userProfile.setName("asdfghj"); 
		userProfile.setSurname("abacki"); 
		userProfile.setAboutMe("asd"); //About me less then 10 characters
		userProfile.setLifeMotto("asdfghjklzxc");
		user.setProfile(userProfile);
		Mockito.when(profileDao.findById(user.getProfile().getId())).thenReturn(new ProfileTO());
		// expect
		exception.expect(ProfileValidationException.class);
		exception.expectMessage("About me must contain between 10 and 50 characters");
		// when
		profileValidService.validate(user.getProfile());
	}
	@Test
	public void shouldThrowExceptionWhenProfileHasLifeMottoIsIncorrect() throws ProfileValidationException {
		// given
		UserTO user = new UserTO();
		ProfileTO userProfile= new ProfileTO();
		userProfile.setId(1L);
		userProfile.setName("asdfghj"); 
		userProfile.setSurname("abacki"); 
		userProfile.setAboutMe("asdfghjklzxc"); 
		userProfile.setLifeMotto("asd"); //Life motto less then 10 characters
		user.setProfile(userProfile);
		Mockito.when(profileDao.findById(user.getProfile().getId())).thenReturn(new ProfileTO());
		// expect
		exception.expect(ProfileValidationException.class);
		exception.expectMessage("Life motto must contain between 10 and 50 characters");
		// when
		profileValidService.validate(user.getProfile());
	}
}
