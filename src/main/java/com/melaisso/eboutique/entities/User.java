package com.melaisso.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
/**
 * this calls used to authen by Spring security 
 * @author MELAISSO
 *
 */
@Entity
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser ;
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
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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
