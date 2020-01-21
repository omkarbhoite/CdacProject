package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Colleges;
import com.app.pojos.Location;
import com.app.pojos.RequestStatus;
import com.app.pojos.Students;

@Repository
@Transactional
public class CollegesDao implements ICollegesDao {
	@Autowired
	private SessionFactory sf;

	
	@Override
	public List<Colleges> getCollegesList() {
		String jpql="select c from Colleges c";
		List<Colleges> list=sf.getCurrentSession().createQuery(jpql,Colleges.class).getResultList();
		return list;
	}

//	@Override
//	public Colleges getCollegeById(int Id) {
//		String jpql="select c from Colleges c where c.cid=:Id ";
//		return sf.getCurrentSession().createQuery(jpql, Colleges.class).setParameter("Id",Id).getSingleResult();
//
//	}
//	@Override
	public Colleges getCollegeById(int Id) {
		System.out.println("In getCollegeByID dao");
		
		 String jpql="select c from Colleges c left outer join fetch c.courseList where c.cid=:Id";
		return sf.getCurrentSession().createQuery(jpql, Colleges.class).setParameter("Id",Id).getSingleResult();

	}
//	@Override
//	public List<Courses> getCollegeById(int Id) {
//		System.out.println("In getCollegeByID dao");
//		
//		 String jpql="select c from Courses c where collegeId=:Id";
//		return sf.getCurrentSession().createQuery(jpql, Courses.class).setParameter("Id",Id).getResultList();
//
//	}

	@Override
	public Colleges addCollegeDetailsInfo(int lid,Colleges c) {
		System.out.println("In addCollegeDetailsInfo");
		String jpql="select l from Location l where l.lid=:Id ";
        Location l= sf.getCurrentSession().createQuery(jpql, Location.class).setParameter("Id",lid).getSingleResult();
        l.addCollege(c);
		sf.getCurrentSession().persist(c);
		return c;
	}

	@Override
	public void deleteCollegeDetails(Colleges c) {
		System.out.println("In deleteCollegeDetails");

		sf.getCurrentSession().delete(c);
		System.out.println("deleted succesfully");
		
	}

	@Override
	public void updateColleges(Colleges col, Colleges c) {
		col.setPlacement(c.getPlacement());
		col.setHostelInfo(c.getHostelInfo());
		col.setHostelFee(c.getHostelFee());
		col.setOwnership(c.getOwnership());
		col.setUniversity(c.getUniversity());
		col.setRating(c.getRating());
		sf.getCurrentSession().update(col);
		System.out.println("Updated succesfully");
		
	}

	@Override
	public Colleges CheckCollegeLogin(String collegeEmail, String collegePassword) {
		System.out.println("In CheckCollegeLogin Dao");
		System.out.println(collegeEmail+" "+collegeEmail);
		String jpql="select c from Colleges c where c.email=:em and c.password=:psw";
		try {
		   return sf.getCurrentSession().createQuery(jpql, Colleges.class).setParameter("em", collegeEmail).setParameter("psw", collegePassword).getSingleResult();

		}
		catch(Exception e)
		{
			return null;
		}
		
		//return ur;
	}

	@Override
	public List<Students> getStudentOFRequestedList(int cid) {
		System.out.println(cid);
		//String jpql = "select s from Students s where s.collegeId=:Id and s.requeststatus=:status";
		String jpql="select s from Students s where s.collegeId=:Id and s.requeststatus='PENDING'";
		try
		{
		   return sf.getCurrentSession().createQuery(jpql, Students.class).setParameter("Id", cid).getResultList();

		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public void updateStudentsRequest(int cid,Students s) {
		System.out.println("In updateStudentsRequest");
		if(s.getRequeststatus() == RequestStatus.NOREQUEST || s.getRequeststatus() == RequestStatus.ACCEPTED || s.getRequeststatus() == RequestStatus.REJECTED)
		{
			System.out.println(RequestStatus.NOREQUEST);
			s.setRequeststatus(RequestStatus.PENDING);
		}
		else if(s.getRequeststatus() == RequestStatus.PENDING)
		{
			System.out.println(RequestStatus.PENDING);
			s.setRequeststatus(RequestStatus.ACCEPTED);
		}
		s.setCollegeId(cid);
		
		
		
		System.out.println(" "+s);
		String jpql = "select s from Students s where s.studentId=:Id";
		Students stu= sf.getCurrentSession().createQuery(jpql, Students.class).setParameter("Id", s.getStudentId()).getSingleResult();
		stu.setRequeststatus(s.getRequeststatus());
		stu.setCollegeId(s.getCollegeId());
		sf.getCurrentSession().update(stu);
	}

	@Override
	public void updateStudentsRequestReject(int cid, Students s) {
		
		s.setRequeststatus(RequestStatus.REJECTED);
		s.setCollegeId(0);

		System.out.println(" "+s);
		String jpql = "select s from Students s where s.studentId=:Id";
		Students stu= sf.getCurrentSession().createQuery(jpql, Students.class).setParameter("Id", s.getStudentId()).getSingleResult();
		stu.setRequeststatus(s.getRequeststatus());
		stu.setCollegeId(s.getCollegeId());
		sf.getCurrentSession().update(stu);
		
	}

	

}
