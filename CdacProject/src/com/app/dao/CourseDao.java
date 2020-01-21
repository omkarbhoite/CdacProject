package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Colleges;
import com.app.pojos.Courses;
import com.app.pojos.Courses;

@Repository
@Transactional
public class CourseDao implements ICourseDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Courses> getCourseList() {
		String jpql = "select c from Courses c";
		List<Courses> list = sf.getCurrentSession().createQuery(jpql, Courses.class).getResultList();
		return list;

	}

//	@Override
//	public Courses getCourseById(int Id) {
//		System.out.println("In getCourseBy id");
//		String jpql="select cr from Courses cr left outer join fetch cr.studList where cr.courseId=:Id";
//		return sf.getCurrentSession().createQuery(jpql, Courses.class).setParameter("Id", Id).getSingleResult();
//
//	}
	@Override
	public Courses getCourseById(int Id) {
		System.out.println("In getCourseBy id");
		String jpql="select cr from Courses cr where cr.courseId=:Id";
		return sf.getCurrentSession().createQuery(jpql, Courses.class).setParameter("Id", Id).getSingleResult();

	}

	@Override
	public Courses addCourseDetailsInfo(int cid,Courses c) {
		System.out.println("In addCourseDetailsInfo");
		String jpql="select c from Colleges c where c.cid=:Id ";
		Colleges cl= sf.getCurrentSession().createQuery(jpql, Colleges.class).setParameter("Id",cid).getSingleResult();
		cl.addCourse(c);
		sf.getCurrentSession().persist(c);
		return c;
	}

	@Override
	public void deleteCourseDetails(Courses c) {
		System.out.println("In deleteCourseDetails");

		sf.getCurrentSession().delete(c);
		System.out.println("deleted succesfully");

	}

	
	  @Override public void updateCourses(Courses cor, Courses c) { 
      cor.setCutOff(c.getCutOff());
      cor.setFees(c.getFees());
      cor.setIntake(c.getIntake());
	  sf.getCurrentSession().update(cor);
	  System.out.println("Updated succesfully");
	  
	  }
	 

}
