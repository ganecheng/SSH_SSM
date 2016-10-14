package com.jpkc.pojo;

import java.sql.Timestamp;

/**
 * Star entity. @author MyEclipse Persistence Tools
 */

public class Star implements java.io.Serializable {

	// Fields

	private String starId;
	private String courseId;
	private Integer starScore;
	private Timestamp starTime;
	private String deviceInfo;

	// Constructors

	/** default constructor */
	public Star() {
	}

	/** minimal constructor */
	public Star(String starId, String courseId, Integer starScore,
			Timestamp starTime) {
		this.starId = starId;
		this.courseId = courseId;
		this.starScore = starScore;
		this.starTime = starTime;
	}

	/** full constructor */
	public Star(String starId, String courseId, Integer starScore,
			Timestamp starTime, String deviceInfo) {
		this.starId = starId;
		this.courseId = courseId;
		this.starScore = starScore;
		this.starTime = starTime;
		this.deviceInfo = deviceInfo;
	}

	// Property accessors

	public String getStarId() {
		return this.starId;
	}

	public void setStarId(String starId) {
		this.starId = starId;
	}

	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Integer getStarScore() {
		return this.starScore;
	}

	public void setStarScore(Integer starScore) {
		this.starScore = starScore;
	}

	public Timestamp getStarTime() {
		return this.starTime;
	}

	public void setStarTime(Timestamp starTime) {
		this.starTime = starTime;
	}

	public String getDeviceInfo() {
		return this.deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

}