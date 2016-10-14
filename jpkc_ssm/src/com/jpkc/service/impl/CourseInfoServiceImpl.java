package com.jpkc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpkc.mapper.CourseInfoMapper;
import com.jpkc.pojo.CourseInfo;
import com.jpkc.pojo.CourseInfoExample;
import com.jpkc.service.CourseInfoService;

@Service
public class CourseInfoServiceImpl implements CourseInfoService
{
	@Autowired
	CourseInfoMapper courseInfoMapper;

	@Override
	public CourseInfo selectByPrimaryKey(String courseId) throws Exception
	{
		return courseInfoMapper.selectByPrimaryKey(courseId);
	}

	@Override
	public int countByExample(CourseInfoExample example) throws Exception
	{
		return courseInfoMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CourseInfoExample example) throws Exception
	{
		return courseInfoMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String courseId) throws Exception
	{
		return courseInfoMapper.deleteByPrimaryKey(courseId);
	}

	@Override
	public int insert(CourseInfo record) throws Exception
	{
		return courseInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(CourseInfo record) throws Exception
	{
		return courseInfoMapper.insertSelective(record);
	}

	@Override
	public List<CourseInfo> selectByExample(CourseInfoExample example) throws Exception
	{
		return courseInfoMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(CourseInfo record, CourseInfoExample example) throws Exception
	{
		return courseInfoMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(CourseInfo record, CourseInfoExample example) throws Exception
	{
		return courseInfoMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(CourseInfo record) throws Exception
	{
		return courseInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(CourseInfo record) throws Exception
	{
		return courseInfoMapper.updateByPrimaryKey(record);
	}

}
