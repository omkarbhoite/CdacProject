package com.app.dao;

import java.util.List;

import com.app.pojos.Courses;

public interface ICourseDao {

	List<Courses> getCourseList();
	Courses getCourseById(int Id);

	Courses addCourseDetailsInfo(int cid, Courses c);

	void deleteCourseDetails(Courses cor);

	
	void updateCourses(Courses cor, Courses c);
	 
}
