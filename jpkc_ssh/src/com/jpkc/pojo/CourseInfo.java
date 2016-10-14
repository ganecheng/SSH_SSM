package com.jpkc.pojo;

import java.sql.Timestamp;

/**
 * CourseInfo entity. @author MyEclipse Persistence Tools
 */

public class CourseInfo implements java.io.Serializable {

	// Fields

	private String courseId;
	private String videoMp4;
	private String videoFlv;
	private Double starScore;
	private String doc1;
	private String doc2;
	private String doc3;
	private String doc4;
	private String doc5;
	private String doc6;
	private String doc7;
	private String doc8;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public CourseInfo() {
	}

	/** minimal constructor */
	public CourseInfo(String courseId, String videoMp4, Timestamp updateTime) {
		this.courseId = courseId;
		this.videoMp4 = videoMp4;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public CourseInfo(String courseId, String videoMp4, String videoFlv,
			Double starScore, String doc1, String doc2, String doc3,
			String doc4, String doc5, String doc6, String doc7, String doc8,
			Timestamp updateTime) {
		this.courseId = courseId;
		this.videoMp4 = videoMp4;
		this.videoFlv = videoFlv;
		this.starScore = starScore;
		this.doc1 = doc1;
		this.doc2 = doc2;
		this.doc3 = doc3;
		this.doc4 = doc4;
		this.doc5 = doc5;
		this.doc6 = doc6;
		this.doc7 = doc7;
		this.doc8 = doc8;
		this.updateTime = updateTime;
	}

	// Property accessors

	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getVideoMp4() {
		return this.videoMp4;
	}

	public void setVideoMp4(String videoMp4) {
		this.videoMp4 = videoMp4;
	}

	public String getVideoFlv() {
		return this.videoFlv;
	}

	public void setVideoFlv(String videoFlv) {
		this.videoFlv = videoFlv;
	}

	public Double getStarScore() {
		return this.starScore;
	}

	public void setStarScore(Double starScore) {
		this.starScore = starScore;
	}

	public String getDoc1() {
		return this.doc1;
	}

	public void setDoc1(String doc1) {
		this.doc1 = doc1;
	}

	public String getDoc2() {
		return this.doc2;
	}

	public void setDoc2(String doc2) {
		this.doc2 = doc2;
	}

	public String getDoc3() {
		return this.doc3;
	}

	public void setDoc3(String doc3) {
		this.doc3 = doc3;
	}

	public String getDoc4() {
		return this.doc4;
	}

	public void setDoc4(String doc4) {
		this.doc4 = doc4;
	}

	public String getDoc5() {
		return this.doc5;
	}

	public void setDoc5(String doc5) {
		this.doc5 = doc5;
	}

	public String getDoc6() {
		return this.doc6;
	}

	public void setDoc6(String doc6) {
		this.doc6 = doc6;
	}

	public String getDoc7() {
		return this.doc7;
	}

	public void setDoc7(String doc7) {
		this.doc7 = doc7;
	}

	public String getDoc8() {
		return this.doc8;
	}

	public void setDoc8(String doc8) {
		this.doc8 = doc8;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}