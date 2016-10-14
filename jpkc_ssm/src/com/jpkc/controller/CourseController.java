package com.jpkc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jpkc.common.CM;
import com.jpkc.pojo.Course;
import com.jpkc.pojo.CourseInfo;
import com.jpkc.service.CourseInfoService;
import com.jpkc.service.CourseService;

@Controller
public class CourseController
{
	@Autowired
	private CourseInfoService courseInfoService;
	@Autowired
	private CourseService courseService;

	@RequestMapping("/item/{id}")
	public ModelAndView get_course_info(ModelAndView model, @PathVariable("id") String id)
	{
		if (CM.validIsEmptyWithTrim(id))
		{
			// 将错误信息传到页面
			model.addObject("message", "没有找到此视频页面");
			// 指向错误页面
			model.setViewName("/WEB-INF/jsp/error");
			return model;
		}

		CourseInfo courseInfoFromDB=null;
		try
		{
			courseInfoFromDB = courseInfoService.selectByPrimaryKey(id);
		}
		catch (Exception e1)
		{
			System.out.println("没有找到课程信息");
		}
		if (courseInfoFromDB == null)
		{
			// 将错误信息传到页面
			model.addObject("message", "没有找到此视频页面");
			// 指向错误页面
			model.setViewName("/WEB-INF/jsp/error");
			return model;
		}

		Course courseFromDB = null;
		try
		{
			courseFromDB = courseService.selectByPrimaryKey(id);
		}
		catch (Exception e)
		{
			System.out.println("没有查找到课程");
		}
		if (courseFromDB == null)
		{
			// 将错误信息传到页面
			model.addObject("message", "没有找到此视频页面");
			// 指向错误页面
			model.setViewName("/WEB-INF/jsp/error");
			return model;
		}

		model.addObject("courseInfo", courseInfoFromDB);
		model.addObject("course", courseFromDB);
		model.setViewName("/story/story_02");
		return model;
	}

}
