package com.jpkc.pojo;

import java.util.Date;

public class CourseInfo {
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

    private Date updateTime;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getVideoMp4() {
        return videoMp4;
    }

    public void setVideoMp4(String videoMp4) {
        this.videoMp4 = videoMp4 == null ? null : videoMp4.trim();
    }

    public String getVideoFlv() {
        return videoFlv;
    }

    public void setVideoFlv(String videoFlv) {
        this.videoFlv = videoFlv == null ? null : videoFlv.trim();
    }

    public Double getStarScore() {
        return starScore;
    }

    public void setStarScore(Double starScore) {
        this.starScore = starScore;
    }

    public String getDoc1() {
        return doc1;
    }

    public void setDoc1(String doc1) {
        this.doc1 = doc1 == null ? null : doc1.trim();
    }

    public String getDoc2() {
        return doc2;
    }

    public void setDoc2(String doc2) {
        this.doc2 = doc2 == null ? null : doc2.trim();
    }

    public String getDoc3() {
        return doc3;
    }

    public void setDoc3(String doc3) {
        this.doc3 = doc3 == null ? null : doc3.trim();
    }

    public String getDoc4() {
        return doc4;
    }

    public void setDoc4(String doc4) {
        this.doc4 = doc4 == null ? null : doc4.trim();
    }

    public String getDoc5() {
        return doc5;
    }

    public void setDoc5(String doc5) {
        this.doc5 = doc5 == null ? null : doc5.trim();
    }

    public String getDoc6() {
        return doc6;
    }

    public void setDoc6(String doc6) {
        this.doc6 = doc6 == null ? null : doc6.trim();
    }

    public String getDoc7() {
        return doc7;
    }

    public void setDoc7(String doc7) {
        this.doc7 = doc7 == null ? null : doc7.trim();
    }

    public String getDoc8() {
        return doc8;
    }

    public void setDoc8(String doc8) {
        this.doc8 = doc8 == null ? null : doc8.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString()
	{
		return "CourseInfo [courseId=" + courseId + ", videoMp4=" + videoMp4 + ", videoFlv=" + videoFlv + ", starScore=" + starScore + ", doc1=" + doc1
				+ ", doc2=" + doc2 + ", doc3=" + doc3 + ", doc4=" + doc4 + ", doc5=" + doc5 + ", doc6=" + doc6 + ", doc7=" + doc7 + ", doc8=" + doc8
				+ ", updateTime=" + updateTime + "]";
	}
    
    
}