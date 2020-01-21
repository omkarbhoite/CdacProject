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

import com.app.dao.IUserRoleDao;
import com.app.pojos.UserRole;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	@Autowired
	private IUserRoleDao dao;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + dao);
	}
	
	@GetMapping
	public ResponseEntity<?> getUserRole()
	{
		System.out.println("In getUserRole method");
		List<UserRole> col = dao.getUserList();
		return new ResponseEntity<List<UserRole>>(col,HttpStatus.OK);
		
	}
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserRoleById(@PathVariable int userId)
	{
		System.out.println("In getUserRole method");
		UserRole selected_User = dao.getUserById(userId);
		if (selected_User == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<UserRole>(selected_User,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> addUserDetails(@RequestBody UserRole s) {
		System.out.println(s);
		System.out.println("In AddUserDetails Controller");
		UserRole user=dao.addUserDetailsInfo(s.getEmail(),s.getPassword());
		if(user!= null)
		{
			System.out.println(user);
			return new ResponseEntity<UserRole>(user, HttpStatus.CREATED);
		}
		else
		{
			return null;
		}
	
//		try {
//			return new ResponseEntity<UserRole>(dao.addUserDetailsInfo(s.getEmail(),s.getPassword()), HttpStatus.CREATED);
//		} catch (RuntimeException e1) {
//			e1.printStackTrace();
//			return null;
//		}

	}
	@PutMapping("/{userId}")
	public void updateUser(@PathVariable int userId,@RequestBody UserRole s)
	{
		System.out.println(userId);
	    UserRole stu =dao.getUserById(userId);
		dao.updateUserRole(stu,s);
	}
	
	
	
	
	@DeleteMapping("/{userId}")
	public void deleteUserDetail(@PathVariable int userId)
	{
		System.out.println("in deleteUserDetail");
		UserRole stu = dao.getUserById(userId);
		dao.deleteUserDetails(stu);
	}

}
