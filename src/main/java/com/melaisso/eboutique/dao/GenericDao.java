package com.melaisso.eboutique.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic interface for Data Acess Objets, to be extended or implemented 
 * contains commons persistance methods  
 * @author MELAISSO
 * @param <T>
 * @param <ID>
 *
 */

public interface GenericDao<T, ID extends Serializable> {
	  T save(T entity);
      T update(T entity);
      void delete(T entity);
      T findById(ID id);
      List<T> findAll();
      void flush();
}
