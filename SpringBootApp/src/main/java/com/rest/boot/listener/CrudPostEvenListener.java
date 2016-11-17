package com.rest.boot.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.rest.boot.model.User;
import com.rest.boot.repository.IUserDAO;

@RepositoryEventHandler
public class CrudPostEvenListener {

	@Autowired
	private IUserDAO userDAO;

	@HandleBeforeSave
	@HandleBeforeCreate
	@HandleBeforeDelete
	public void onBefore(User userEntity) {
		User user = userDAO.findOne(userEntity.getUserId());

		// TODO: get the user object from token or request to check logged in
		// user or not
		User tokenUser = null;
		if (null != tokenUser && !tokenUser.equals(user)) {
		}

	}

}
