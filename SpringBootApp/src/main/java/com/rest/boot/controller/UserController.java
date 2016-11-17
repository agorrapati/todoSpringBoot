package com.rest.boot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.boot.model.User;
import com.rest.boot.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	/**
	 * Save the user data in database table USER
	 * 
	 * @param user
	 */
	@PostMapping(value = "/saveUser")
	public void save(@RequestBody User user) {
		LOGGER.info("Calling service layer to save user data :" + user);
		userService.saveUser(user);
	}

	@GetMapping(value = "/getUserById/{userID}")
	public @ResponseBody User getUserDataByUserId(@PathVariable("userID") Long userID) {
		LOGGER.info("Get the user data by UserID : " + userID);
		return userService.getUserDataByUserId(userID);
	}

	@GetMapping(value = "/getAllUser")
	public @ResponseBody List<User> getAllUser() {
		LOGGER.info("Get all user data ");
		return userService.getAllUser();
	}

	@GetMapping(value = "/updateUser")
	public @ResponseBody String updateUser(@RequestBody User user) {
		LOGGER.info("Started updating the user data");
		return userService.updateUser(user);
	}

	@GetMapping("/deleteUserById/{userID}")
	public @ResponseBody void deleteUserById(@PathVariable("userID") Long userID) {
		LOGGER.info("Started deleteing the user data for ID:" + userID);
		userService.deleteUserById(userID);
	}

}
