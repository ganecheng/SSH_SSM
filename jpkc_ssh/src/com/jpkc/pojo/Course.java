package com.jpkc.pojo;

import java.sql.Timestamp;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private String courseId;
	private String courseName;
	private String courseParentId;
	private Timestamp courseAddTime;
	private Timestamp courseUpdateTime;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String courseId, String courseName, Timestamp courseAddTime,
			Timestamp courseUpdateTime) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseAddTime = courseAddTime;
		this.courseUpdateTime = courseUpdateTime;
	}

	/** full constructor */
	public Course(String courseId, String courseName, String courseParentId,
			Timestamp courseAddTime, Timestamp courseUpdateTime) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseParentId = courseParentId;
		this.courseAddTime = courseAddTime;
		this.courseUpdateTime = courseUpdateTime;
	}

	// Property accessors

	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseParentId() {
		return this.courseParentId;
	}

	public void setCourseParentId(String courseParentId) {
		this.courseParentId = courseParentId;
	}

	public Timestamp getCourseAddTime() {
		return this.courseAddTime;
	}

	public void setCourseAddTime(Timestamp courseAddTime) {
		this.courseAddTime = courseAddTime;
	}

	public Timestamp getCourseUpdateTime() {
		return this.courseUpdateTime;
	}

	public void setCourseUpdateTime(Timestamp courseUpdateTime) {
		this.courseUpdateTime = courseUpdateTime;
	}

}