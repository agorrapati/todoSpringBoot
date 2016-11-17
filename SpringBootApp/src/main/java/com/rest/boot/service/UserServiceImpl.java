package com.rest.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.boot.model.User;
import com.rest.boot.repository.IUserDAO;

/**
 * Service layer is for business logic.
 * 
 * If you have extra validation or some other logic then better to write code in
 * service layer 
 * 
 * For now we don't have any business logic but kept just null
 * validations
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	public void saveUser(User user) {
		if (null != user && null != user.getUserName()) {
			// call DAO to save the user object in USER table
			userDAO.save(user);
		} else {
			throw new IllegalArgumentException("User/name must not be NULL");
		}
	}

	/**
	 * Get the record by user id from USER table
	 * 
	 * @param userID
	 * @return User object
	 */
	@Override
	public User getUserDataByUserId(Long userID) {
		if (null == userID) {
			throw new IllegalArgumentException("User ID must not be NULL");
		}
		return userDAO.findOne(userID);
	}

	@Override
	public List<User> getAllUser() {
		return (List<User>) userDAO.findAll();
	}

	@Override
	public String updateUser(User user) {
		if (null != user) {
			userDAO.save(user);
		}
		return "Updated";
	}

	@Override
	public void deleteUserById(Long userId) {
		if (null != userId) {
			userDAO.delete(userId);
		}
	}

}
