package com.app.pojos;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Colleges {
	private Integer cid;
	private String collageName;
	private byte[] collageImage;
	private int establishmentYear;
	private String ownership;
	private String hostelInfo;
	private float hostelFee;
	private String email;
	private String password;
	//private text;
	private float rating;
	private String university;
	private Location selectedLocation;
	private String accredation;
	private CollegeRole collegeRole;
	private int placement;
	private List<Courses> courseList= new ArrayList<Courses>();
	public Colleges() {
		System.out.println("In colleges ctor");
	}
	
	

	public Colleges(String collageName, byte[] collageImage, int establishmentYear, String ownership, String hostelInfo,
			float hostelFee, String collegeEmail, String collegePassword, float rating, String university,
			String accredation, CollegeRole collegeRole, int placement) {
		
		this.collageName = collageName;
		this.collageImage = collageImage;
		this.establishmentYear = establishmentYear;
		this.ownership = ownership;
		this.hostelInfo = hostelInfo;
		this.hostelFee = hostelFee;
		this.email = collegeEmail;
		this.password = collegePassword;
		this.rating = rating;
		this.university = university;
		this.accredation = accredation;
		this.collegeRole = collegeRole;
		this.placement = placement;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Column(length = 70)
	public String getCollageName() {
		return collageName;
	}
	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}
	@Lob
	public byte[] getCollageImage() {
		return collageImage;
	}
	public void setCollageImage(byte[] collageImage) {
		this.collageImage = collageImage;
	}
	public int getEstablishmentYear() {
		return establishmentYear;
	}
	public void setEstablishmentYear(int establishmentYear) {
		this.establishmentYear = establishmentYear;
	}
	@Column(length = 70)
	public String getAccredation() {
		return accredation;
	}
	public void setAccredation(String accredation) {
		this.accredation = accredation;
	}
	@Column(length = 50)
	public String getOwnership() {
		return ownership;
	}
	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}
	public float getHostelFee() {
		return hostelFee;
	}
	public void setHostelFee(float hostelFee) {
		this.hostelFee = hostelFee;
	}
	
	@Column(length = 20)
	public String getHostelInfo() {
		return hostelInfo;
	}
	public void setHostelInfo(String hostelInfo) {
		this.hostelInfo = hostelInfo;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	@Column(length = 50)
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	@ManyToOne
	@JoinColumn(name = "locationId")
	@JsonIgnore
	public Location getSelectedLocation() {
		return selectedLocation;
	}
	public void setSelectedLocation(Location selectedLocation) {
		this.selectedLocation = selectedLocation;
	}
	@OneToMany(mappedBy = "college",
			cascade = CascadeType.ALL ,fetch=FetchType.EAGER , orphanRemoval = true)
	public List<Courses> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Courses> courseList) {
		this.courseList = courseList;
	}
	public void addCourse(Courses cr)
	{
		courseList.add(cr);
		cr.setCollege(this);
	}
	public void removeCollege(Courses cr)
	{
		courseList.remove(cr);
		cr.setCollege(null);
		
	}
	@Column(length = 70)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(length = 70)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	public CollegeRole getCollegeRole() {
		return collegeRole;
	}
	public void setCollegeRole(CollegeRole collegeRole) {
		this.collegeRole = collegeRole;
	}
	public int getPlacement() {
		return placement;
	}
	public void setPlacement(int placement) {
		this.placement = placement;
	}



	@Override
	public String toString() {
		return "Colleges [cid=" + cid + ", collageName=" + collageName + ", collageImage="
				+ Arrays.toString(collageImage) + ", establishmentYear=" + establishmentYear + ", ownership="
				+ ownership + ", hostelInfo=" + hostelInfo + ", hostelFee=" + hostelFee + ", email="
				+ email + ", password=" + password + ", rating=" + rating + ", university="
				+ university + ", accredation=" + accredation + ", collegeRole=" + collegeRole + ", placement="
				+ placement + "]";
	}

	
	



}
