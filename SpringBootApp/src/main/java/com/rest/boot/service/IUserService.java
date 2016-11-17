package com.rest.boot.service;

import java.util.List;

import com.rest.boot.model.User;

public interface IUserService {

	void saveUser(User user);

	User getUserDataByUserId(Long userID);

	List<User> getAllUser();

	String updateUser(User user);

	void deleteUserById(Long userId);

}
