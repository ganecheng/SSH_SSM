package com.jpkc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jpkc.pojo.CourseInfo;
import com.jpkc.pojo.CourseInfoExample;

public interface CourseInfoService
{
	CourseInfo selectByPrimaryKey(String courseId) throws Exception;

	int countByExample(CourseInfoExample example) throws Exception;

	int deleteByExample(CourseInfoExample example) throws Exception;

	int deleteByPrimaryKey(String courseId) throws Exception;

	int insert(CourseInfo record) throws Exception;

	int insertSelective(CourseInfo record) throws Exception;

	List<CourseInfo> selectByExample(CourseInfoExample example) throws Exception;

	int updateByExampleSelective(@Param("record") CourseInfo record, @Param("example") CourseInfoExample example) throws Exception;

	int updateByExample(@Param("record") CourseInfo record, @Param("example") CourseInfoExample example) throws Exception;

	int updateByPrimaryKeySelective(CourseInfo record) throws Exception;

	int updateByPrimaryKey(CourseInfo record) throws Exception;
}
