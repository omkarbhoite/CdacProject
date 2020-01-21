package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Courses;
import com.app.pojos.RequestStatus;
import com.app.pojos.Students;
import com.app.pojos.UserRole;

@Repository
@Transactional
public class StudentDao implements IStudentDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Students> getStudentList() {
		String jpql = "select s from Students s";
		List<Students> list = sf.getCurrentSession().createQuery(jpql, Students.class).getResultList();
		return list;

	}

	@Override
	public Students getStudentById(int Id) {
		String jpql = "select s from Students s where s.studentId=:Id";
		return sf.getCurrentSession().createQuery(jpql, Students.class).setParameter("Id", Id).getSingleResult();

	}
	@Override
	public Students getStudentWithFeedBackById(int Id) {
		String jpql="select s from Students s left outer join fetch s.feedBackList where s.studentId=:Id";
		return sf.getCurrentSession().createQuery(jpql, Students.class).setParameter("Id", Id).getSingleResult();


	}

	@Override
	public Students addStudentDetailsInfo(Students s) {
		System.out.println("In addStudentDetailsInfo");
		sf.getCurrentSession().persist(s);
		return s;
	}

	@Override
	public void deleteStudentDetails(Students s) {
		System.out.println("In deleteStudentDetails");

		sf.getCurrentSession().delete(s);
		System.out.println("deleted succesfully");

	}

	
	  @Override public void updateStudents(Students stu, Students s) { 
	  System.out.println(stu);
	  stu.setStudName(s.getStudName());
	  stu.setStudEmail(s.getStudEmail());
	  stu.setMarks(s.getMarks());
	  stu.setAge(s.getAge());
	  stu.setStudPassword(s.getStudPassword());
	  stu.setStudLocation(s.getStudLocation());
	  //sf.getCurrentSession().update(stu);
	  sf.getCurrentSession().saveOrUpdate(stu);
	  System.out.println("Updated succesfully");
	  
	  }

	@Override
	public Students checkStudent(String email,String password) {
		System.out.println("In checkStudent Dao");
		System.out.println(email+" "+password);
		String jpql="select s from Students s where s.studEmail=:em and s.studPassword=:pass";
		//Students st=sf.getCurrentSession().createQuery(jpql, Students.class).setParameter("em", email).getSingleResult();
		System.out.println("Exception nahi aala");
		try {
			return sf.getCurrentSession().createQuery(jpql, Students.class).setParameter("em", email).
					setParameter("pass", password).getSingleResult();
		}
		catch (Exception e)
		{
			return null;
		}
		
		//return sf.getCurrentSession().createQuery(jpql, Students.class).setParameter("em", email).getSingleResult();
	}

	@Override
	public Students CheckEmailExistsIn(String email) {
		System.out.println("In CheckEmailExistsIn Dao");
		System.out.println(email+" ");
		String jpql="select s from Students s where s.studEmail=:em";
		//Students st=sf.getCurrentSession().createQuery(jpql, Students.class).setParameter("em", email).getSingleResult();
		System.out.println("Exception nahi aala");
		try {
			return sf.getCurrentSession().createQuery(jpql, Students.class).setParameter("em", email).getSingleResult();
		}
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public Integer registerStudentWithValidEmail(Students s)
	{
		s.setRequeststatus(RequestStatus.NOREQUEST);
		System.out.println("inside registerStudent");
		return (Integer)sf.getCurrentSession().save(s);
		
	}

	@Override
	public Students CheckEmailAndAgeExists(String email, int age) {
		System.out.println("In CheckEmailAndAgeExists Dao");
		System.out.println(email+" "+age);
		String jpql="select s from Students s where s.studEmail=:em and s.age=:Age";
		//Students st=sf.getCurrentSession().createQuery(jpql, Students.class).setParameter("em", email).getSingleResult();
		System.out.println("Exception nahi aala");
		try {
			return sf.getCurrentSession().createQuery(jpql, Students.class).setParameter("em", email).setParameter("Age", age).getSingleResult();
		}
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public void updateStudentsPassword(Students stu, Students s) {
		 System.out.println(stu);
		  stu.setStudPassword(s.getStudPassword());
		  //sf.getCurrentSession().update(stu);
		  sf.getCurrentSession().update(stu);
		  System.out.println("Updated succesfully");
		
	}
	 


}
