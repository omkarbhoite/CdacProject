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

import com.app.dao.ICollegesDao;
import com.app.pojos.Colleges;
import com.app.pojos.Students;


@RestController
@CrossOrigin
@RequestMapping("/college")
public class CollegesController {
	
	@Autowired
	private ICollegesDao dao;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + dao);
	}

	@GetMapping
	public ResponseEntity<?> getColleges()
	{
		System.out.println("In getLocations method");
		List<Colleges> col = dao.getCollegesList();
//		if (loc.size() == 0)
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Colleges>>(col,HttpStatus.OK);
		
	}
	@GetMapping("/{cid}")
	public ResponseEntity<?> getCollegesById(@PathVariable int cid)
	{
		System.out.println("In getLocations method");
		Colleges selected_college = dao.getCollegeById(cid);
		if (selected_college == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Colleges>(selected_college,HttpStatus.OK);
	}
	@PostMapping("/{lid}")
	public ResponseEntity<?> addCollegeDetails(@PathVariable int lid,@RequestBody Colleges c) {
		System.out.println("In AddCollegeDetails");
		System.out.println(lid);
		
		try {
			return new ResponseEntity<Colleges>(dao.addCollegeDetailsInfo(lid,c), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@PutMapping("/{cid}")
	public void updateCollege(@PathVariable int cid,@RequestBody Colleges c)
	{
		System.out.println(cid);
	    Colleges col =dao.getCollegeById(cid);
		dao.updateColleges(col,c);
		
	}
	@PostMapping("/requestStatus/{cid}")
	public void updateStudent(@PathVariable int cid,@RequestBody Students s)
	{
		
			System.out.println("in updateStudent");
			System.out.println(s);
			dao.updateStudentsRequest(cid,s);
		
		
	}
	@PostMapping("/requestStatusReject/{cid}")
	public void updateStudentToReject(@PathVariable int cid,@RequestBody Students s)
	{
		
			System.out.println("in updateStudentToReject");
			System.out.println(s);
			dao.updateStudentsRequestReject(cid,s);
		
		
	}
	
	
	
	
	@DeleteMapping("/{cid}")
	public void deleteCollegeDetail(@PathVariable int cid)
	{
		System.out.println("in deleteCollegeDetail");
		Colleges col = dao.getCollegeById(cid);
		dao.deleteCollegeDetails(col);
	}••••••••••••••••••
	
	@PostMapping
	public ResponseEntity<?> CheckCollegeLogin(@RequestBody Colleges c) {
		System.out.println(c);
		System.out.println("In CheckCollegeLogin Controller");
		Colleges colleges=dao.CheckCollegeLogin(c.getEmail(),c.getPassword());
		if(colleges!= null)
		{
			System.out.println(colleges);
			return new ResponseEntity<Colleges>(colleges, HttpStatus.CREATED);
		}
		else
		{
			return null;
		}


	}
	
	@GetMapping("/studentsfrom/{cid}")
	public ResponseEntity<?> GetStudentOFRequestedList(@PathVariable int cid)
	{
		System.out.println("In getStudents method");
		System.out.println(cid+" ");
		List<Students> stu = dao.getStudentOFRequestedList(cid);
		
		if(stu!= null)
		{
			//System.out.println(colleges);
			return new ResponseEntity<List<Students>>(stu,HttpStatus.OK);
		}
		else
		{
			return null;
		}
		
	}

	
	

}
