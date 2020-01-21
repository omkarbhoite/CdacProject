package com.app.dao;

import java.util.List;

import com.app.pojos.FeedBack;

public interface IFeedBackDao {
	List<FeedBack> getFeedbackList();
	FeedBack getFeedbackById(int Id);

	FeedBack addFeedbackDetailsInfo( int studId,FeedBack f);

	//void deleteFeedbackDetails(FeedBack fed);
	void deleteFeedbackDetails();
//	int getAvgFeedback();

	
	//void updateFeedBack(FeedBack fed, FeedBack f);
//	FeedBack checkFeedback(String fed);


}
