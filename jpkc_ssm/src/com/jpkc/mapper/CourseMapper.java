package com.jpkc.mapper;

import com.jpkc.pojo.Course;
import com.jpkc.pojo.CourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper
{
	int countByExample(CourseExample example);

	int deleteByExample(CourseExample example);

	int deleteByPrimaryKey(String courseId);

	int insert(Course record);

	int insertSelective(Course record);

	List<Course> selectByExample(CourseExample example);

	Course selectByPrimaryKey(String courseId);

	int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

	int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

	int updateByPrimaryKeySelective(Course record);

	int updateByPrimaryKey(Course record);
}