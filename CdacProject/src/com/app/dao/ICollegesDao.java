package com.app.dao;

import java.util.List;

import com.app.pojos.Colleges;
import com.app.pojos.Courses;
import com.app.pojos.RequestStatus;
import com.app.pojos.Students;

public interface ICollegesDao {

	List<Colleges> getCollegesList();

	Colleges getCollegeById(int Id);
//	List<Courses> getCollegeById(int Id);

	Colleges addCollegeDetailsInfo(int lid, Colleges c);

	void deleteCollegeDetails(Colleges col);

	void updateColleges(Colleges col, Colleges c);

	Colleges CheckCollegeLogin(String collegeEmail, String collegePassword);

	List<Students> getStudentOFRequestedList(int cid);

	void updateStudentsRequest(int cid, Students s);

	void updateStudentsRequestReject(int cid, Students s);

}
