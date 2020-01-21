package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.UserRole;

@Repository
@Transactional
public class UserRoleDao implements IUserRoleDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<UserRole> getUserList() {
		String jpql = "select u from UserRole u";
		List<UserRole> list = sf.getCurrentSession().createQuery(jpql, UserRole.class).getResultList();
		return list;

	}

	@Override
	public UserRole getUserById(int Id) {
		String jpql = "select u from UserRole u where u.userId=:Id ";
		return sf.getCurrentSession().createQuery(jpql, UserRole.class).setParameter("Id", Id).getSingleResult();

	}

	@Override
	public UserRole addUserDetailsInfo(String email,String password) {
		System.out.println("In addUserDetailsInfo Dao");
		System.out.println(email+" "+password);
		String jpql="select u from UserRole u where u.email=:em and u.password=:psw";
		try {
		   return sf.getCurrentSession().createQuery(jpql, UserRole.class).setParameter("em", email).setParameter("psw", password).getSingleResult();

		}
		catch(Exception e)
		{
			return null;
		}
		
		//return ur;
	}
//	public UserRole addUserDetailsInfo(UserRole s) {
//		System.out.println("In addUserDetailsInfo");
//		String jpql="select u from UserRole u where"
//		sf.getCurrentSession().persist(s);
//		return s;
//	}

	@Override
	public void deleteUserDetails(UserRole s) {
		System.out.println("In deleteUserDetails");

		sf.getCurrentSession().delete(s);
		System.out.println("deleted succesfully");

	}

	
	  @Override public void updateUserRole(UserRole u, UserRole s) { 
		  u.setUserName(s.getUserName());
		  u.setEmail(s.getEmail());
		  u.setPassword(s.getPassword());
     
	  sf.getCurrentSession().update(u);
	  System.out.println("Updated succesfully");
	  
	  }

}
