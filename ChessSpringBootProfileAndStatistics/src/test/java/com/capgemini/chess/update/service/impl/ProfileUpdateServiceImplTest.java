package com.capgemini.chess.update.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dao.ProfileDAO;
import com.capgemini.chess.to.ProfileTO;
import com.capgemini.chess.update.service.ProfileValidationService;
import com.capgemini.chess.update.service.impl.ProfileUpdateServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class ProfileUpdateServiceImplTest {

	@Mock
	ProfileDAO profileDao;
	@Mock
	ProfileValidationService profileValidService;
	@InjectMocks
	ProfileUpdateServiceImpl profileUpdateService;

	
	@Test
	public void shouldValidateAndThenUpdateProfileAndUser() throws Exception {
		// given
		ProfileTO profileToUpdate = new ProfileTO();
		// when
		profileUpdateService.updateProfile(profileToUpdate);
		// then
		InOrder inOrder = Mockito.inOrder(profileValidService, profileDao);
		inOrder.verify(profileValidService).validate(profileToUpdate);
		inOrder.verify(profileDao).update(profileToUpdate);
	}

}
