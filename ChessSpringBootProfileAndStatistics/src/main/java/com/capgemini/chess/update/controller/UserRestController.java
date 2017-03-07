package com.capgemini.chess.update.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.soruce.MapDataSource;
import com.capgemini.chess.to.UserTO;
import com.capgemini.chess.update.exception.UserValidationException;
import com.capgemini.chess.update.service.UserServiceFacade;

@RestController
@ResponseBody
public class UserRestController {
	@Autowired
	UserServiceFacade userServiceFacade;
	@Autowired
	MapDataSource mapDataSource;

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public UserEntity addUser(@RequestBody UserEntity user) throws UserValidationException {
		mapDataSource.getUsers().put(user.getId(), user);
		return user;
	}

	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
	public UserEntity getUser(@PathVariable("id") Long id) throws UserValidationException {
		UserEntity user = mapDataSource.getUsers().get(id);
		return user;
	}

}
