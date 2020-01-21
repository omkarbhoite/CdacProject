package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Location;

@Repository
@Transactional
public class LocationDao implements ILocationDao {
	@Autowired
	private SessionFactory sf;

	
	  @Override public List<Location> getLocationList() {
	  System.out.println("In getLocationList");  
	  String jpql="SELECT l FROM Location l";
	  //"select l from Location l"; List<Location>
	  List<Location> list=sf.getCurrentSession().createQuery(jpql,Location.class).getResultList();
	  return list;
	  
	  }
	
	
	/*
	 * @Override public List<Object>getLocationList() { String
	 * jpql="SELECT l.lid, l.region FROM Location AS l";
	 * //"select l from Location l"; List<Object>
	 * list=sf.getCurrentSession().createQuery(jpql,Object.class).getResultList();
	 * return list;
	 * 
	 * }
	 */
//	@Override
//	public Location getLocationById(int Id) {
//	
//		String jpql="select l from Location l where l.lid=:Id ";
//		return sf.getCurrentSession().createQuery(jpql, Location.class).setParameter("Id",Id).getSingleResult();
//
//	}
	
	  public Location getLocationById(int Id) {
	  System.out.println("In getLocationByID dao");
	  String jpql="select l from Location l left outer join fetch l.collegeList where l.lid=:Id";
	  //String jpql="select l from Location l where l.lid=:Id "; return
	  return sf.getCurrentSession().createQuery(jpql,Location.class).setParameter("Id",Id).getSingleResult();
	  
	  }
	 
}
