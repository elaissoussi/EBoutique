package com.melaisso.eboutique.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * Base entity to hold common id property and toString and equals and hachcode 
 * used just for heritance no mapping into table 
 * @author MELAISSO
 *
 */

@MappedSuperclass
public class BaseEntity  implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return " entity. "+this.getClass()+" [id=" + this.id + "]";
	}


	@Override
	public int hashCode() {
		
		int hash  = 0 ;
			hash += (id != null ? id.hashCode() : 0);
		
		return hash ;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		BaseEntity other = (BaseEntity) obj;
		
		if (id == null) {
			if (other.id != null)
				return false;
			
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
