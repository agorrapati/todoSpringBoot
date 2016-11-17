package com.rest.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rest.boot.model.User;

/**
 * here we have few default method provided by framework
 * 
 * Apart from that we can write our own method and define the query on top of
 * the method like below example
 *
 */
@RepositoryRestResource
public interface IUserDAO extends CrudRepository<User, Long> {

	/**
	 * Sample method
	 * Not user
	 * @param userName
	 * @return
	 */
//	@Query("select u from USER u where userName = (:userName)")
//	public User getUserByUserName(@Param("userName") String userName);
}
