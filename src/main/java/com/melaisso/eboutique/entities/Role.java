package com.melaisso.eboutique.entities;


import javax.persistence.Entity;



@Entity
public class Role  extends BaseEntity{

	private String roleName ;
	private User user ;
	
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
