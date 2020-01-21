package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Location {
	
	private Integer lid;
	private String region;
	private int pincode;
	private List<Colleges> collegeList=new ArrayList<>();
	public Location() {
		System.out.println("In Location ctor");
		
	}
	public Location(String region, int pincode) {
		
		this.region = region;
		this.pincode = pincode;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
		
	}
	@Column(length = 30)
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	//@Column
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@OneToMany(mappedBy = "selectedLocation",
			cascade = CascadeType.ALL ,fetch=FetchType.EAGER, orphanRemoval = true)
	public List<Colleges> getCollegeList() {
		return collegeList;
	}
	public void setCollegeList(List<Colleges> collegeList) {
		this.collegeList = collegeList;
	}
	public void addCollege(Colleges c)
	{
		collegeList.add(c);
		c.setSelectedLocation(this);
	}
	public void removeCollege(Colleges c)
	{
		collegeList.remove(c);
		c.setSelectedLocation(null);
	}
	@Override
	public String toString() {
		return "Location [lid=" + lid + ", region=" + region + ", pincode=" + pincode + "]";
	}
	
	

}
