package com.jpkc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpkc.mapper.CourseMapper;
import com.jpkc.pojo.Course;
import com.jpkc.pojo.CourseExample;
import com.jpkc.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService
{

	@Autowired
	CourseMapper courseMapper;

	@Override
	public List<Course> getAllCourse() throws Exception
	{
		return courseMapper.selectByExample(null);
	}

	@Override
	public Course selectByPrimaryKey(String courseId) throws Exception
	{
		return courseMapper.selectByPrimaryKey(courseId);
	}

	@Override
	public int countByExample(CourseExample example) throws Exception
	{
		return courseMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CourseExample example) throws Exception
	{
		return courseMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String courseId) throws Exception
	{
		return courseMapper.deleteByPrimaryKey(courseId);
	}

	@Override
	public int insert(Course record) throws Exception
	{
		return courseMapper.insert(record);
	}

	@Override
	public int insertSelective(Course record) throws Exception
	{
		return courseMapper.insertSelective(record);
	}

	@Override
	public List<Course> selectByExample(CourseExample example) throws Exception
	{
		return courseMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Course record, CourseExample example) throws Exception
	{
		return courseMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Course record, CourseExample example) throws Exception
	{
		return courseMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Course record) throws Exception
	{
		return courseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Course record) throws Exception
	{
		return courseMapper.updateByPrimaryKey(record);
	}

	@Override
	public int saveList(List<Course> list) throws Exception
	{
		for (Course course : list)
		{
			courseMapper.insert(course);
		}
		return list.size();
	}

	@Override
	public int deleteListByIds(List<String> list) throws Exception
	{
		for (String str : list)
		{
			courseMapper.deleteByPrimaryKey(str);
		}
		return list.size();
	}

}
