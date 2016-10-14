package com.jpkc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jpkc.exception.CustomException;
import com.jpkc.mapper.CourseInfoMapper;
import com.jpkc.pojo.CourseInfo;
import com.jpkc.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService
{

	@Autowired
	CourseInfoMapper courseInfoMapper;

	/*@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)*/
	@Override
	public int saveLogin() throws Exception
	{
		CourseInfo courseInfo = courseInfoMapper.selectByPrimaryKey("1609032329332864655731643");
		courseInfo.setDoc1("3");
		int updateResult = courseInfoMapper.updateByPrimaryKey(courseInfo);

		for (int i = 0; i < 1; i++)
		{
			throw new CustomException("我要抛异常");
		}

		CourseInfo courseInfo2 = courseInfoMapper.selectByPrimaryKey("1609032329404095427579225");
		courseInfo2.setDoc1("3");
		int updateResult2 = courseInfoMapper.updateByPrimaryKey(courseInfo2);

		System.out.println(courseInfo);
		return 0;
	}

}
