package com.capgemini.chess.update.service.impl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dao.UserDAO;
import com.capgemini.chess.to.UserTO;
import com.capgemini.chess.update.exception.UserValidationException;
import com.capgemini.chess.update.service.impl.UserValidationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserValidationServiceImplTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Mock
	private UserDAO userDao;

	@InjectMocks
	private UserValidationServiceImpl userValidService;

	@Test
	public void shouldThrowExceptionWhenIdNotExists() throws Exception {
		// given
		UserTO user=new UserTO();
		Mockito.when(userDao.findByID(user.getId())).thenReturn(null);
		// expect
		exception.expect(UserValidationException.class);
		exception.expectMessage("User with given Id not exist!");
		// when
		userValidService.validate(user);
	}

	@Test
	public void shouldThrowExceptionWhenEmailIncorrect() throws Exception {
		// given
		UserTO user=new UserTO();
		user.setEmail("1234");
		Mockito.when(userDao.findByID(user.getId())).thenReturn(new UserTO());
		// expect
		exception.expect(UserValidationException.class);
		exception.expectMessage("Incorrect email adress to update");
		// when
		userValidService.validate(user);
	}
	@Test
	public void shouldThrowExceptionWhenEmailToUpdateIsNull() throws Exception {
		// given
		UserTO user=new UserTO();
		user.setEmail(null);
		Mockito.when(userDao.findByID(user.getId())).thenReturn(new UserTO());
		// expect
		exception.expect(UserValidationException.class);
		exception.expectMessage("Incorrect email adress to update. Cannot be empty");
		// when
		userValidService.validate(user);
	}
	
	@Test
	public void shouldThrowExceptionWhenPasswordToUpdateIsNull() throws Exception {
		// given
		UserTO user=new UserTO();
		Mockito.when(userDao.findByID(user.getId())).thenReturn(new UserTO());
		user.setEmail("abc@123.pl");
		// expect
		exception.expect(UserValidationException.class);
		exception.expectMessage("Incorrect password to update. Password cannot be empty");
		// when
		userValidService.validate(user);
	}
	@Test
	public void shouldThrowExceptionWhenPasswordToUpdateIsIncorrect() throws Exception {
		// given
		UserTO user=new UserTO();
		Mockito.when(userDao.findByID(user.getId())).thenReturn(new UserTO());
		user.setEmail("abc@123.pl");
		user.setPassword("asdf");
		// expect
		exception.expect(UserValidationException.class);
		exception.expectMessage("Incorrect password to update. Password should has at least 8 characters.");
		// when
		userValidService.validate(user);
	}
}
