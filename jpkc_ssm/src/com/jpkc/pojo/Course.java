package com.jpkc.pojo;

import java.util.Date;

public class Course {
    private String courseId;

    private String courseName;

    private String courseParentId;

    private Date courseAddTime;

    private Date courseUpdateTime;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseParentId() {
        return courseParentId;
    }

    public void setCourseParentId(String courseParentId) {
        this.courseParentId = courseParentId == null ? null : courseParentId.trim();
    }

    public Date getCourseAddTime() {
        return courseAddTime;
    }

    public void setCourseAddTime(Date courseAddTime) {
        this.courseAddTime = courseAddTime;
    }

    public Date getCourseUpdateTime() {
        return courseUpdateTime;
    }

    public void setCourseUpdateTime(Date courseUpdateTime) {
        this.courseUpdateTime = courseUpdateTime;
    }

	@Override
	public String toString()
	{
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseParentId=" + courseParentId + ", courseAddTime=" + courseAddTime
				+ ", courseUpdateTime=" + courseUpdateTime + "]";
	}
    
    
}