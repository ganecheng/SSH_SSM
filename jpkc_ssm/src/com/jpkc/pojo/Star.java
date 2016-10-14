package com.jpkc.pojo;

import java.util.Date;

public class Star {
    private String starId;

    private String courseId;

    private Integer starScore;

    private Date starTime;

    private String deviceInfo;

    public String getStarId() {
        return starId;
    }

    public void setStarId(String starId) {
        this.starId = starId == null ? null : starId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public Integer getStarScore() {
        return starScore;
    }

    public void setStarScore(Integer starScore) {
        this.starScore = starScore;
    }

    public Date getStarTime() {
        return starTime;
    }

    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo == null ? null : deviceInfo.trim();
    }

	@Override
	public String toString()
	{
		return "Star [starId=" + starId + ", courseId=" + courseId + ", starScore=" + starScore + ", starTime=" + starTime + ", deviceInfo=" + deviceInfo + "]";
	}
    
    
}