package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ILocationDao;
import com.app.pojos.Location;

@RestController
@CrossOrigin
@RequestMapping("/location")
public class LocationController {
	@Autowired
	private ILocationDao dao;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + dao);
	}

	@GetMapping
	public ResponseEntity<?> getLocations()
	{
		System.out.println("In getLocations method");
		List<Location> loc = dao.getLocationList();
		return new ResponseEntity<List<Location>>(loc,HttpStatus.OK);
		
	}
	@GetMapping("/{lid}")
	public ResponseEntity<?> getLocationsById(@PathVariable int lid)
	{
		System.out.println("In getLocationsByID controller method");
		Location selected_loc = dao.getLocationById(lid);
		return new ResponseEntity<Location>(selected_loc,HttpStatus.OK);
	}
	
	

	

}
