package com.melaisso.eboutique.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;




import org.springframework.util.Assert;

import com.melaisso.eboutique.entities.User;

public class UserJpaDao  extends GenericJpaDao<User, Long> implements UserDao {

	public UserJpaDao() {
		super(User.class);
	}

	 /**
     * Queries database for user name availability
     * 
     * @param userName
     * @return true if available
     */
    public boolean checkAvailable(String userName) {
            Assert.notNull(userName);
            
            Query query = getEntityManager()
                    .createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
                                    + " u where u.userName = :userName").setParameter("userName", userName);
            
            Long count = (Long) query.getSingleResult();
            
            return count < 1;
    }

    /**
     * Queries user by username
     * 
     * @param userName
     * @return User entity
     */
    public User loadUserByUserName(String userName) {
            Assert.notNull(userName);
            
            User user = null;
            
            Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
                            + " u where u.userName = :userName").setParameter("userName", userName);
            
            try {
                    user = (User) query.getSingleResult();
            } catch(NoResultException e) {
                    //do nothing
            }
            
            return user;
    }

}
