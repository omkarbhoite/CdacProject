package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ICourseDao;
import com.app.pojos.Courses;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private ICourseDao dao;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + dao);
	}
	
	@GetMapping
	public ResponseEntity<?> getCourses()
	{
		System.out.println("In getLocations method");
		List<Courses> col = dao.getCourseList();
		return new ResponseEntity<List<Courses>>(col,HttpStatus.OK);
		
	}
	@GetMapping("/{courseId}")
	public ResponseEntity<?> getCoursesById(@PathVariable int courseId)
	{
		System.out.println("In getLocations method");
		Courses selected_Course = dao.getCourseById(courseId);
		if (selected_Course == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Courses>(selected_Course,HttpStatus.OK);
	}
	@PostMapping("/{cid}")
	public ResponseEntity<?> addCourseDetails(@PathVariable int cid,@RequestBody Courses c) {
		System.out.println("In AddCourseDetails");
		System.out.println(cid);
		try {
			return new ResponseEntity<Courses>(dao.addCourseDetailsInfo(cid,c), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@PutMapping("/{courseId}")
	public void updateCourse(@PathVariable int courseId,@RequestBody Courses c)
	{
		System.out.println(courseId);
	    Courses cor =dao.getCourseById(courseId);
		dao.updateCourses(cor,c);
	}
	
	
	
	
	@DeleteMapping("/{courseId}")
	public void deleteCourseDetail(@PathVariable int courseId)
	{
		System.out.println("in deleteCourseDetail");
		Courses col = dao.getCourseById(courseId);
		dao.deleteCourseDetails(col);
	}
	

}
