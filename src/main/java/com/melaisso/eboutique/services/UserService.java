package com.melaisso.eboutique.services;

import com.melaisso.eboutique.entities.User;

public interface UserService {

    /**
     * Create user - persist to database
     * 
     * @param userEntity
     * @return true if success
     */
    boolean createUser(User userEntity);
    
  
    /**
     * Retrieves full User record from database by user name
     * 
     * @param userName
     * @return UserEntity
     */
    User loadUserEntityByUsername(String userName);
}