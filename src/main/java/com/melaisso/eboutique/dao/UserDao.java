package com.melaisso.eboutique.dao;

import com.melaisso.eboutique.entities.User;

public interface UserDao extends GenericDao< User, Long > {

	
	  /**
     * Queries database for user name availability
     * 
     * @param userName
     * @return true if available
     */
    boolean checkAvailable(String userName);
    
    /**
     * Queries user by username
     * 
     * @param userName
     * @return User entity
     */
    
    User loadUserByUserName(String userName);
}
