package com.app.controller;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IFeedBackDao;
import com.app.pojos.FeedBack;

@RestController
@CrossOrigin
@RequestMapping("/feedback")
public class FeedBackController {
	@Autowired
	private IFeedBackDao dao;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + dao);
	}
	
//	@GetMapping("/getAvg")
//	public ResponseEntity<?> getAvgFeedBack()
//	{
//		List<Integer> resultList=new ArrayList<Integer>();
//		int avg1;
//		int avg2;
//		int avg3;
//		int result1=0;
//		int result2=0;
//		int result3=0;
//		System.out.println("In getFeedBack method");
//		List<FeedBack> fed = dao.getFeedbackList();
//		for (FeedBack feedBack : fed) {
//			
//			result1=result1+feedBack.getInfoRating();
//			result2=result2+feedBack.getLocationRating();
//			
//			result3=result3+feedBack.getWebAppRating();
//		}
//		System.out.println(result1);
//		avg1=result1/fed.size();
//		System.out.println(avg1);
//		System.out.println(result1);
//		avg2=result2/fed.size();
//		System.out.println(avg1);
//		System.out.println(result1);
//		avg3=result3/fed.size();
//		System.out.println(avg1);
//		resultList.add(avg1);
//		resultList.add(avg2);
//		resultList.add(avg3);
//		
//		
//		return new ResponseEntity<List<Integer>>(resultList,HttpStatus.OK);
//		
//	}
	@GetMapping("/getAvg")
	public ResponseEntity<?> getAvgFeedBack()
	{
		Map<String,Integer> map=new Hashtable<String,Integer>();
		int avg1;
		int avg2;
		int avg3;
		int result1=0;
		int result2=0;
		int result3=0;
		System.out.println("In getFeedBack method");
		List<FeedBack> fed = dao.getFeedbackList();
		for (FeedBack feedBack : fed) {
			
			result1=result1+feedBack.getInfoRating();
			result2=result2+feedBack.getLocationRating();
			
			result3=result3+feedBack.getWebAppRating();
		}
		System.out.println(result1);
		avg1=result1/fed.size();
		System.out.println(avg1);
		System.out.println(result1);
		avg2=result2/fed.size();
		System.out.println(avg1);
		System.out.println(result1);
		avg3=result3/fed.size();
		System.out.println(avg1);
//		resultList.add(avg1);
//		resultList.add(avg2);
//		resultList.add(avg3);
		map.put("infoRating",avg1);
		map.put("locationRating",avg2);
		map.put("webAppRating",avg3);
		
		if(map!=null)
		{
			return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
		}
		else {
			return null;
		}
		
	}
	@GetMapping
	public ResponseEntity<?> getFeedBack()
	{
		System.out.println("In getFeedBack method");
		List<FeedBack> fed = dao.getFeedbackList();
		return new ResponseEntity<List<FeedBack>>(fed,HttpStatus.OK);
		
	}
	@PostMapping("/{studentId}")
	public ResponseEntity<?> addFeedbackDetails(@PathVariable int studentId,@RequestBody FeedBack f) {
		System.out.println(f);
		System.out.println(studentId);
		System.out.println("In AddFeedbackDetails");
		try {
			return new ResponseEntity<FeedBack>(dao.addFeedbackDetailsInfo(studentId,f), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
//	@DeleteMapping("/{FeedbackId}")
//	public void deleteFeedbackDetail(@PathVariable int FeedbackId)
//	{
//		System.out.println("in deleteFeedbackDetail");
//		FeedBack fed = dao.getFeedbackById(FeedbackId);
//		dao.deleteFeedbackDetails(fed);
//	}
	@DeleteMapping
	public void deleteFeedbackDetail()
	{
		System.out.println("in deleteFeedbackDetail controller");
		
		dao.deleteFeedbackDetails();
		System.out.println("deleted successfuly");
	}

	
}
