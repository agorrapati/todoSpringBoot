package com.rest.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.rest.boot.model.User;
import com.rest.boot.repository.IUserDAO;

@Component
public class UserServiceSecurity implements UserDetailsService {

	@Autowired
	private  IUserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User user = this.userDAO.findOne(Long.valueOf(arg0));
		return new org.springframework.security.core.userdetails.User(user.getUserId().toString(), user.getPassword(),
				AuthorityUtils.NO_AUTHORITIES);
	}

}