package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Courses {
	private Integer courseId;
	private String courseName;
	private int intake;
	private double fees;
	private int strYear;
	private float cutOff;
	private Colleges college;
	//private List<Students> studList=new ArrayList<Students>();
	public Courses() {
		System.out.println("In Courses ctor");
	}
	

	public Courses(String courseName, int intake, double fees, int strYear, float cutOff) {
		
		this.courseName = courseName;
		this.intake = intake;
		this.fees = fees;
		this.strYear = strYear;
		this.cutOff = cutOff;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public int getIntake() {
		return intake;
	}
	public void setIntake(int intake) {
		this.intake = intake;
	}
	@Column(length = 50)
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	
	public int getStrYear() {
		return strYear;
	}
	public void setStrYear(int strYear) {
		this.strYear = strYear;
	}
	public float getCutOff() {
		return cutOff;
	}
	public void setCutOff(float cutOff) {
		this.cutOff = cutOff;
	}

	@ManyToOne
	@JoinColumn(name = "collegeId")
	@JsonIgnore
	public Colleges getCollege() {
		return college;
	}
	public void setCollege(Colleges college) {
		this.college = college;
	}
//	@OneToMany(mappedBy = "course",
//			cascade = CascadeType.ALL ,fetch=FetchType.EAGER , orphanRemoval = true)
//	public List<Students> getStudList() {
//		return studList;
//	}
//	public void setStudList(List<Students> studList) {
//		this.studList = studList;
//	}
//	public void addStudent(Students s) {
//		studList.add(s);
//		s.setCourse(this);
//
//	}
//
//	public void removeStudent(Students s) {
//		studList.remove(s);
//		s.setCourse(null);
//	}

	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", intake=" + intake + ", fees=" + fees
				+ ", strYear=" + strYear + ", cutOff=" + cutOff + "]";
	}
	
	
	

}
