package com.jpkc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jpkc.pojo.Course;
import com.jpkc.pojo.CourseExample;

public interface CourseService
{
	List<Course> getAllCourse() throws Exception;

	Course selectByPrimaryKey(String courseId) throws Exception;

	int countByExample(CourseExample example) throws Exception;

	int deleteByExample(CourseExample example) throws Exception;

	int deleteByPrimaryKey(String courseId) throws Exception;

	int insert(Course record) throws Exception;

	int saveList(List<Course> list) throws Exception;

	int deleteListByIds(List<String> list) throws Exception;

	int insertSelective(Course record) throws Exception;

	List<Course> selectByExample(CourseExample example) throws Exception;

	int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example) throws Exception;

	int updateByExample(@Param("record") Course record, @Param("example") CourseExample example) throws Exception;

	int updateByPrimaryKeySelective(Course record) throws Exception;

	int updateByPrimaryKey(Course record) throws Exception;
}
