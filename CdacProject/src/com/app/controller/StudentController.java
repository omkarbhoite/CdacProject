package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IStudentDao;
import com.app.pojos.Students;


@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private IStudentDao dao;
	
	@Autowired
	private JavaMailSender sender;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + dao);
	}
	
	@GetMapping
	public ResponseEntity<?> getStudents()
	{
		System.out.println("In getStudents method");
		List<Students> col = dao.getStudentList();
		return new ResponseEntity<List<Students>>(col,HttpStatus.OK);
		
	}
	@GetMapping("/{studentId}")
	public ResponseEntity<?> getStudentsById(@PathVariable int studentId)
	{
		System.out.println("In getStudents method");
		Students selected_Student = dao.getStudentById(studentId);
		if (selected_Student == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Students>(selected_Student,HttpStatus.OK);
	}
	@GetMapping("/studentsfeedback/{studentId}")
	public ResponseEntity<?> getStudentsWithFeedbackById(@PathVariable int studentId)
	{
		System.out.println("In getStudents method");
		Students selected_Student = dao.getStudentWithFeedBackById(studentId);
		if (selected_Student == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Students>(selected_Student,HttpStatus.OK);
	}
//	@PostMapping("/{courseId}")
//	public ResponseEntity<?> addStudentDetails(@PathVariable int courseId,@RequestBody Students s) {
//		System.out.println(s);
//		System.out.println(courseId);
//		System.out.println("In AddStudentDetails");
//		try {
//			return new ResponseEntity<Students>(dao.addStudentDetailsInfo(s,courseId), HttpStatus.CREATED);
//		} catch (RuntimeException e1) {
//			e1.printStackTrace();
//			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
	@PostMapping
	public ResponseEntity<?> addStudentDetails(@RequestBody Students s) {
		System.out.println(s);
		//System.out.println(courseId);
		System.out.println("In AddStudentDetails");
		try {
			return new ResponseEntity<Students>(dao.addStudentDetailsInfo(s), HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@PostMapping("/checkStudent")
	public ResponseEntity<?> CheckStudentRegistred(@RequestBody Students st) {
		System.out.println(st);
		System.out.println("In CheckStudentRegistred Controller");
		Students stu=dao.checkStudent(st.getStudEmail(),st.getStudPassword());
		if(stu !=null)
		{
			System.out.println(stu);
			return new ResponseEntity<Students>(stu, HttpStatus.CREATED);			
		}
		return null;
	
//		try {
//			return new ResponseEntity<Students>(dao.checkStudent(st.getStudEmail()), HttpStatus.CREATED);
//		} catch (Exception e1) {
//			System.out.println("In CheckStudentRegistred catch block");
//			e1.printStackTrace();
//			return null; //new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}

	}
	@PutMapping("/{studentId}")
	public void updateStudent(@PathVariable int studentId,@RequestBody Students s)
	{
		System.out.println(studentId);
		System.out.println(s);
	    Students stu =dao.getStudentById(studentId);
		dao.updateStudents(stu,s);
	}
	
	
	
	
	@DeleteMapping("/{studentId}")
	public void deleteStudentDetail(@PathVariable int studentId)
	{
		System.out.println("in deleteStudentDetail");
		Students stu = dao.getStudentById(studentId);
		dao.deleteStudentDetails(stu);
	}
	@PostMapping("/checkEmailExists")
	public ResponseEntity<?> CheckEmailExists(@RequestBody Students st) {
		System.out.println(st);
		System.out.println("In CheckStudentRegistred Controller");
		Students stu=dao.CheckEmailExistsIn(st.getStudEmail());
		if(stu !=null)
		{
			System.out.println(stu);
			return new ResponseEntity<Students>(stu, HttpStatus.CREATED);			
		}
		return null;
	
//		try {
//			return new ResponseEntity<Students>(dao.checkStudent(st.getStudEmail()), HttpStatus.CREATED);
//		} catch (Exception e1) {
//			System.out.println("In CheckStudentRegistred catch block");
//			e1.printStackTrace();
//			return null; //new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}

	}
	@PostMapping("/withEmail")
	public Integer addStudentWithValidEmail(@RequestBody Students s) {
		System.out.println(s);
		if(s !=null)
		{
			//hs.setAttribute("OTP", otp);
			String msg="Dear "+s.getStudName()+" You have successfully registered to our website, we recommend you to not share your"+s.getStudPassword()+"password with anyone."
					+ "Remember Your Age"+s.getAge() +"For future Reference";
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(s.getStudEmail());
			mailMessage.setSubject("Registration Successful");
			mailMessage.setText(msg);
			try
			{
				System.out.println("inside try block");
				sender.send(mailMessage);
			}
			catch (MailException e) 
			{
				System.out.println("inside mail exception");
				e.printStackTrace();
			}
			
		}
	
	return dao.registerStudentWithValidEmail(s);

	}
	@PostMapping("/forgotpassword")
	public ResponseEntity<?> CheckEmailAgeExists(@RequestBody Students st) {
		System.out.println(st);
		System.out.println("In CheckStudentRegistred Controller");
		Students stu=dao.CheckEmailAndAgeExists(st.getStudEmail(),st.getAge());
		System.out.println(stu);
		if(stu !=null)
		{
			System.out.println(stu);
			return new ResponseEntity<Students>(stu, HttpStatus.CREATED);			
		}
		return null;
	}
	@PutMapping("/updatePassword/{studentId}")
	public String updateStudentPassword(@PathVariable int studentId,@RequestBody Students s)
	{
		System.out.println("In updateStudentPassword");
		System.out.println(studentId);
		System.out.println(s);
	    Students stu =dao.getStudentById(studentId);
	    System.out.println(stu);
		
		if(s !=null)
		{
			//hs.setAttribute("OTP", otp);
			String msg="Dear "+stu.getStudName()+" You have successfully chnaged your "+stu.getStudPassword()+" password to"
					+" "+s.getStudPassword()+" "
					+"Remember Your New Password";
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(stu.getStudEmail());
			mailMessage.setSubject("Registration Successful");
			mailMessage.setText(msg);
			try
			{
				System.out.println("inside try block");
				sender.send(mailMessage);
			}
			catch (MailException e) 
			{
				System.out.println("inside mail exception");
				e.printStackTrace();
			}
			
		}
		dao.updateStudentsPassword(stu,s);
		return "Updated successfully";
	
	}

}
