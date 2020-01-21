package com.app.pojos;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Students {
	
	private Integer studentId;
	private String studName;
	private String studLocation;
	private String studEmail;
	private int age;
	private String studPassword;
	private float marks;
	private RequestStatus requeststatus;
	private int collegeId;
	//private Courses course;
	private List<FeedBack> feedBackList=new ArrayList<>();
	public Students() {
		System.out.println("In students ctor");
	}


	public Students(String studName, String studLocation, String studEmail, int age,
			String studPassword, float marks, RequestStatus requeststatus, int collegeId) {
		this.studName = studName;
		this.studLocation = studLocation;
		this.studEmail = studEmail;
		this.age = age;
		this.studPassword = studPassword;
		this.marks = marks;
		this.requeststatus = requeststatus;
		this.collegeId = collegeId;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	@Column(length = 60)
	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}
	@Column(length = 50)
	public String getStudLocation() {
		return studLocation;
	}
	public void setStudLocation(String studLocation) {
		this.studLocation = studLocation;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	@OneToMany(mappedBy = "student",
			cascade = CascadeType.ALL ,fetch=FetchType.EAGER , orphanRemoval = true)
	public List<FeedBack> getFeedBackList() {
		return feedBackList;
	}
	public void setFeedBackList(List<FeedBack> feedBackList) {
		this.feedBackList = feedBackList;
	}
    @Column(length = 30)
	public String getStudEmail() {
		return studEmail;
	}
	public void setStudEmail(String studEmail) {
		this.studEmail = studEmail;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	public RequestStatus getRequeststatus() {
		return requeststatus;
	}
	public void setRequeststatus(RequestStatus requeststatus) {
		this.requeststatus = requeststatus;
	}
	
	@Column(length = 30)
	public String getStudPassword() {
		return studPassword;
	}
	public void setStudPassword(String studPassword) {
		this.studPassword = studPassword;
	}
//	@ManyToOne
//	@JoinColumn(name = "courseId")
//	@JsonIgnore
//	public Courses getCourse() {
//		return course;
//	}
//	public void setCourse(Courses course) {
//		this.course = course;
//	}
	public void addFeedBack(FeedBack f) {
		feedBackList.add(f);
		f.setStudent(this);

	}

	public void removeFeedBack(FeedBack f) {
		feedBackList.remove(f);
		f.setStudent(null);
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}


	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", studName=" + studName + ", studLocation=" + studLocation
				+ ", studEmail=" + studEmail + ", age=" + age + ", studPassword=" + studPassword + ", marks=" + marks
				+ ", requeststatus=" + requeststatus + ", collegeId=" + collegeId + "]";
	}
	


	
	
	
	

}
