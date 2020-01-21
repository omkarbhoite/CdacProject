package com.app.dao;

import java.util.List;

import com.app.pojos.Students;

public interface IStudentDao {
	List<Students> getStudentList();
	Students getStudentById(int Id);
	Students getStudentWithFeedBackById(int id);

	//Students addStudentDetailsInfo(Students s, int courseId);
	Students addStudentDetailsInfo(Students s);

	void deleteStudentDetails(Students stu);
	Integer registerStudentWithValidEmail(Students s);

	
	void updateStudents(Students stu, Students s);
	Students checkStudent(String studEmail,String studPassword);
	Students CheckEmailExistsIn(String studEmail);
	Students CheckEmailAndAgeExists(String studEmail,int age);
	void updateStudentsPassword(Students stu, Students s);

}
