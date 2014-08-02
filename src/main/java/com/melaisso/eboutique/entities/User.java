package com.melaisso.eboutique.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
/**
 * this calls used to authen by Spring security 
 * @author MELAISSO
 *
 */
@Entity
public class User extends BaseEntity{

	private String userName ;
	private String password;
	private boolean actived ;
	
	// user <--> 1..* Role
	@OneToMany
	@JoinColumn(name="idUser")
	private Collection<Role> roles ;
	
	public User(String userName, String password, boolean actived) {
		super();
		this.userName = userName;
		this.password = password;
		this.actived = actived;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	

}
