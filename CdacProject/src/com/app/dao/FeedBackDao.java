package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.FeedBack;
import com.app.pojos.Students;

@Repository
@Transactional
public class FeedBackDao implements IFeedBackDao {
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<FeedBack> getFeedbackList() {
		String jpql = "select f from FeedBack f";
		List<FeedBack> list = sf.getCurrentSession().createQuery(jpql, FeedBack.class).getResultList();
		return list;

	}

	@Override
	public FeedBack getFeedbackById(int Id) {
		String jpql = "select f from FeedBack f where f.feedbackId=:Id ";
		return sf.getCurrentSession().createQuery(jpql, FeedBack.class).setParameter("Id", Id).getSingleResult();

	}

	@Override
	public FeedBack addFeedbackDetailsInfo(int studId,FeedBack f) {
		System.out.println("In addFeedbackDetailsInfo");
		String jpql = "select s from Students s where s.studentId=:Id ";
		Students s= sf.getCurrentSession().createQuery(jpql, Students.class).setParameter("Id", studId).getSingleResult();
		s.addFeedBack(f);
		
		sf.getCurrentSession().persist(f);
		return f;
	}

//	@Override
//	public void deleteFeedbackDetails(FeedBack f) {
//		System.out.println("In deleteFeedbackDetails");
//
//		sf.getCurrentSession().delete(f);
//		System.out.println("deleted succesfully");
//
//	}
	@Override
	public void deleteFeedbackDetails() {
		System.out.println("In deleteFeedbackDetails dao");
//		Students s=new Students();
//		String jpql = "select f from FeedBack f";
//		List<FeedBack> fedList = sf.getCurrentSession().createQuery(jpql, FeedBack.class).getResultList();
//		for (FeedBack feedBack : fedList) {
//			s.removeFeedBack(feedBack);
//			sf.getCurrentSession().delete(feedBack);
//			System.out.println("deleted Successfully");
//		}
		
		String sql="DELETE from FeedBack";
		sf.getCurrentSession().createQuery(sql).executeUpdate();
	
		

		
		

	}

//	@Override
//	public int getAvgFeedback() {
//		String jpql="Select AVG(infoRating) FROM FeedBack";
//		int fed=sf.getCurrentSession().createQuery(jpql).executeUpdate();
//		System.out.println(fed);
//				
//		return fed;
//	}

	
	  

}
