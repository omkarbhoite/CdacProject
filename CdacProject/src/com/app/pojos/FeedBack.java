package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FeedBack {
	private Integer feedbackId;
	private int webAppRating;
	private int infoRating;
	private int locationRating;
	private Students student;
	public FeedBack() {
		System.out.println("In FeedBackPojo");
	}
	public FeedBack(int webAppRating, int infoRating, int locationRating) {
		super();
		this.webAppRating = webAppRating;
		this.infoRating = infoRating;
		this.locationRating = locationRating;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	public int getWebAppRating() {
		return webAppRating;
	}
	public void setWebAppRating(int webAppRating) {
		this.webAppRating = webAppRating;
	}
	public int getInfoRating() {
		return infoRating;
	}
	public void setInfoRating(int infoRating) {
		this.infoRating = infoRating;
	}
	@ManyToOne
	@JoinColumn(name = "studId")
	@JsonIgnore
	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
	public int getLocationRating() {
		return locationRating;
	}
	public void setLocationRating(int locationRating) {
		this.locationRating = locationRating;
	}
	@Override
	public String toString() {
		return "FeedBackPojo [feedbackId=" + feedbackId + ", webAppRating=" + webAppRating + ", infoRating="
				+ infoRating + ", locationRating=" + locationRating + "]";
	}
	
	

}
