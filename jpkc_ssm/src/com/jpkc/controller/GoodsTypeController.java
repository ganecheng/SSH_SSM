package com.jpkc.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jpkc.common.CM;
import com.jpkc.pojo.Course;
import com.jpkc.pojo.CourseInfo;
import com.jpkc.service.CourseInfoService;
import com.jpkc.service.CourseService;
import com.jpkc.view.CourseView;
import com.jpkc.view.CourseViewAndList;

@Controller
@RequestMapping("/goods_type")
public class GoodsTypeController
{

	@Autowired
	CourseService courseService;
	@Autowired
	CourseInfoService courseInfoService;

	@RequestMapping("/get_ajax_course")
	public void get_ajax_course(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");

		Map<String, Object> json = new HashMap<String, Object>();
		String info;
		List<Course> courseListTemp = null;
		try
		{
			courseListTemp = courseService.getAllCourse();
		}
		catch (Exception e)
		{
			System.out.println("获取所有课程失败");
		}

		if (courseListTemp == null || courseListTemp.size() == 0)
		{
			info = "没有课程。";
			json.put("success", false);
			json.put("info", info);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		Map<String, CourseView> courseMap = new LinkedHashMap<String, CourseView>();
		for (Course gt : courseListTemp)
		{
			CourseView gtvTemp = new CourseView();
			gtvTemp.setId(gt.getCourseId());
			gtvTemp.setName(gt.getCourseName());
			gtvTemp.setpId(gt.getCourseParentId() == null ? "" : gt.getCourseParentId());
			gtvTemp.setOpen(true);
			gtvTemp.setNoR(false);
			gtvTemp.setGrade(1);
			courseMap.put(gt.getCourseId(), gtvTemp);
		}
		List<CourseView> courseViewListForJson = new ArrayList<CourseView>();
		Set<Map.Entry<String, CourseView>> set = courseMap.entrySet();
		for (Iterator<Map.Entry<String, CourseView>> it = set.iterator(); it.hasNext();)
		{
			Map.Entry<String, CourseView> entry = (Map.Entry<String, CourseView>) it.next();
			if (CM.validIsEmpty(entry.getValue().getpId()))
			{
				entry.getValue().setGrade(1);
				courseMap.put(entry.getKey(), entry.getValue());
			}
			else if (CM.validIsEmpty(courseMap.get(entry.getValue().getpId()).getpId()))
			{
				entry.getValue().setGrade(2);
				courseMap.put(entry.getKey(), entry.getValue());
			}
			else if (CM.validIsEmpty(courseMap.get(courseMap.get(entry.getValue().getpId()).getpId()).getpId()))
			{
				entry.getValue().setGrade(3);
				courseMap.put(entry.getKey(), entry.getValue());
			}
			courseViewListForJson.add(entry.getValue());
		}

		List<CourseViewAndList> courseViewAndListForShowList = new ArrayList<CourseViewAndList>();
		for (int i = 0; i < courseViewListForJson.size(); i++)
		{
			if (courseViewListForJson.get(i).getGrade() == 1)
			{
				CourseViewAndList CourseViewAndListTemp = new CourseViewAndList();
				CourseViewAndListTemp.setView(courseViewListForJson.get(i));
				courseViewAndListForShowList.add(CourseViewAndListTemp);
			}
		}
		for (int i = 0; i < courseViewAndListForShowList.size(); i++)
		{
			List<CourseViewAndList> CourseViewAndListForShowList_2 = new ArrayList<CourseViewAndList>();
			for (int j = 0; j < courseViewListForJson.size(); j++)
			{
				if (courseViewListForJson.get(j).getGrade() == 2
						&& courseViewListForJson.get(j).getpId().equals(courseViewAndListForShowList.get(i).getView().getId()))
				{
					CourseViewAndList CourseViewAndListTemp = new CourseViewAndList();
					CourseViewAndListTemp.setView(courseViewListForJson.get(j));
					CourseViewAndListForShowList_2.add(CourseViewAndListTemp);
				}
			}
			courseViewAndListForShowList.get(i).setList(CourseViewAndListForShowList_2);
		}

		json.put("success", true);
		json.put("course_ajax", courseViewAndListForShowList);
		response.getWriter().write(new ObjectMapper().writeValueAsString(json));
		return;
	}

	@RequestMapping("/update_custom_type")
	public ModelAndView update_custom_type(ModelAndView model)
	{

		List<Course> goodsTypeListTemp = null;
		try
		{
			goodsTypeListTemp = courseService.getAllCourse();
		}
		catch (Exception e)
		{
			System.out.println("获取所有课程失败");
		}
		if (goodsTypeListTemp == null || goodsTypeListTemp.size() == 0)
		{
			model.addObject("courseJson", null);
		}
		Map<String, CourseView> goodsTypeMap = new LinkedHashMap<String, CourseView>();
		for (Course gt : goodsTypeListTemp)
		{
			// System.out.println(gt.toString());
			CourseView gtvTemp = new CourseView();
			gtvTemp.setId(gt.getCourseId());
			gtvTemp.setName(gt.getCourseName());
			gtvTemp.setpId(gt.getCourseParentId() == null ? "" : gt.getCourseParentId());
			gtvTemp.setOpen(false);
			gtvTemp.setNoR(false);
			gtvTemp.setGrade(1);
			goodsTypeMap.put(gt.getCourseId(), gtvTemp);
		}
		List<CourseView> goodsTypeViewListForJson = new ArrayList<CourseView>();
		Set<Map.Entry<String, CourseView>> set = goodsTypeMap.entrySet();
		for (Iterator<Map.Entry<String, CourseView>> it = set.iterator(); it.hasNext();)
		{
			Map.Entry<String, CourseView> entry = (Map.Entry<String, CourseView>) it.next();
			// System.out.println(entry.getKey() + "--->" + entry.getValue());
			if (CM.validIsEmpty(entry.getValue().getpId()))
			{
				entry.getValue().setGrade(1);
				entry.getValue().setOpen(true);
				goodsTypeMap.put(entry.getKey(), entry.getValue());
			}
			else if (CM.validIsEmpty(goodsTypeMap.get(entry.getValue().getpId()).getpId()))
			{
				entry.getValue().setGrade(2);
				goodsTypeMap.put(entry.getKey(), entry.getValue());
			}
			goodsTypeViewListForJson.add(entry.getValue());
		}
		String courseJsonTemp = null;
		try
		{
			courseJsonTemp = new ObjectMapper().writeValueAsString(goodsTypeViewListForJson);
		}
		catch (IOException e)
		{
			System.out.println("JSON转换失败");
		}
		model.addObject("courseJson", courseJsonTemp);
		model.setViewName("/shop/ajax/type/edit_types");
		return model;
	}

	@RequestMapping(value = "/goods_type_set_new_pic_do", method = { RequestMethod.POST })
	public void goods_type_set_new_pic_do(HttpServletRequest request, HttpServletResponse response, CourseInfo courseInfo) throws IOException
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");

		Map<String, Object> json = new HashMap<String, Object>();
		String info;

		if (courseInfo == null || CM.validIsEmptyWithTrim(courseInfo.getCourseId()) || CM.validIsEmptyWithTrim(courseInfo.getVideoMp4()))
		{
			info = "没有找到此类型。";
			json.put("success", false);
			json.put("info", info);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		CourseInfo courseInfoFromDB = null;
		try
		{
			courseInfoFromDB = courseInfoService.selectByPrimaryKey(courseInfo.getCourseId());
		}
		catch (Exception e1)
		{
			System.out.println("未找到课程信息");
		}
		// 为空就添加,不为空就修改
		if (courseInfoFromDB == null)
		{
			courseInfoFromDB = new CourseInfo();
			courseInfoFromDB.setCourseId(courseInfo.getCourseId());
		}

		List<String> mp4ListTemp = CM.getVideoSrcList(courseInfo.getVideoMp4(), 1);
		if (mp4ListTemp == null)
		{
			info = "MP4上传是必选项。";
			json.put("success", false);
			json.put("info", info);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		courseInfoFromDB.setVideoMp4(mp4ListTemp.get(0));

		List<String> flvListTemp = CM.getVideoSrcList(courseInfo.getVideoFlv(), 1);
		if (flvListTemp != null)
		{
			courseInfoFromDB.setVideoFlv(flvListTemp.get(0));
		}

		List<String> doc1ListTemp = CM.getPDFSrcList(courseInfo.getDoc1(), 1);
		if (doc1ListTemp != null)
		{
			courseInfoFromDB.setDoc1(doc1ListTemp.get(0));
		}

		List<String> doc2ListTemp = CM.getPDFSrcList(courseInfo.getDoc2(), 1);
		if (doc2ListTemp != null)
		{
			courseInfoFromDB.setDoc2(doc2ListTemp.get(0));
		}

		List<String> doc3ListTemp = CM.getPDFSrcList(courseInfo.getDoc3(), 1);
		if (doc3ListTemp != null)
		{
			courseInfoFromDB.setDoc3(doc3ListTemp.get(0));
		}

		List<String> doc4ListTemp = CM.getPDFSrcList(courseInfo.getDoc4(), 1);
		if (doc4ListTemp != null)
		{
			courseInfoFromDB.setDoc4(doc4ListTemp.get(0));
		}

		courseInfoFromDB.setStarScore(5.0);
		courseInfoFromDB.setUpdateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		int exeResult = 0;
		try
		{
			exeResult = courseInfoService.updateByPrimaryKeySelective(courseInfoFromDB);
		}
		catch (Exception e)
		{
			System.out.println("保存出错");
		}
		if (exeResult <= 0)
		{
			info = "保存失败，请稍后再试。";
			json.put("success", false);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		json.put("success", true);
		response.getWriter().write(new ObjectMapper().writeValueAsString(json));
		return;
	}

	@RequestMapping(value = "goods_type_get_old_pic_do", method = { RequestMethod.POST })
	public void goods_type_get_old_pic_do(HttpServletRequest request, HttpServletResponse response, String commonStr) throws Exception
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");

		Map<String, Object> json = new HashMap<String, Object>();
		String info;

		if (CM.validIsEmptyWithTrim(commonStr))
		{
			info = "没有找到此类型。";
			json.put("success", false);
			json.put("info", info);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		CourseInfo courseInfo = courseInfoService.selectByPrimaryKey(commonStr);
		if (courseInfo == null)
		{
			info = "没有找到此课程信息。";
			json.put("success", false);
			json.put("info", info);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		json.put("success", true);
		json.put("courseInfo", courseInfo);
		response.getWriter().write(new ObjectMapper().writeValueAsString(json));
		return;
	}

	@RequestMapping(value = "goods_type_add_do", method = { RequestMethod.POST })
	public void goods_type_add_do(HttpServletRequest request, HttpServletResponse response, Course course) throws Exception
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");

		Map<String, Object> json = new HashMap<String, Object>();
		String info;

		if (course == null || CM.validIsEmpty(course.getCourseName()))
		{
			info = "类型名称是必填项。";
			json.put("success", false);
			json.put("info", info);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		String[] gtNames = course.getCourseName().split(",");
		List<Course> CourseList = new ArrayList<Course>();
		Calendar cal = Calendar.getInstance();
		for (String gtName : gtNames)
		{
			cal.add(Calendar.MILLISECOND, 1);
			Course gtTemp = new Course();
			gtTemp.setCourseId(CM.getRandomTwentyFivePrimaryKeyId(cal));
			if (CM.validIsEmpty(course.getCourseParentId()) == true)
			{
				gtTemp.setCourseParentId("");
			}
			else
			{
				gtTemp.setCourseParentId(course.getCourseParentId());
			}
			gtTemp.setCourseName(gtName.trim());
			gtTemp.setCourseAddTime(new Timestamp(cal.getTimeInMillis()));
			gtTemp.setCourseUpdateTime(new Timestamp(cal.getTimeInMillis()));
			CourseList.add(gtTemp);
		}
		int exeResult = courseService.saveList(CourseList);
		if (exeResult <= 0)
		{
			info = "保存失败。";
			json.put("success", false);
			json.put("info", info);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		json.put("success", true);
		json.put("course", CourseList);
		response.getWriter().write(new ObjectMapper().writeValueAsString(json));
		return;
	}

	@RequestMapping(value = "goods_type_delete_do", method = { RequestMethod.POST })
	public void goods_type_delete_do(HttpServletRequest request, HttpServletResponse response, String commonStr) throws Exception
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");

		Map<String, Object> json = new HashMap<String, Object>();
		String info;
		if (CM.validIsEmpty(commonStr))
		{
			info = "类型id是必填项。";
			json.put("success", false);
			json.put("info", info);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		String[] ids = commonStr.split(",");

		List<String> idsList = new ArrayList<String>();
		for (String idsTemp : ids)
		{
			idsList.add(idsTemp.trim());
		}
		int deleteResult = courseService.deleteListByIds(idsList);
		if (deleteResult <= 0)
		{
			info = "删除失败。";
			json.put("success", false);
			json.put("info", info);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		json.put("success", true);
		response.getWriter().write(new ObjectMapper().writeValueAsString(json));
		return;
	}

	@RequestMapping(value = "goods_type_update_do", method = { RequestMethod.POST })
	public void goods_type_update_do(HttpServletRequest request, HttpServletResponse response, Course course) throws Exception
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");

		Map<String, Object> json = new HashMap<String, Object>();
		String info;

		if (course == null || CM.validIsEmpty(course.getCourseId()) || CM.validIsEmpty(course.getCourseName()))
		{
			info = "类型名称是必填项。";
			json.put("success", false);
			json.put("info", info);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		Course CourseTemp = courseService.selectByPrimaryKey(course.getCourseId());
		if (CourseTemp == null)
		{
			info = "没有找到此类型。";
			json.put("success", false);
			json.put("info", info);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		CourseTemp.setCourseName(course.getCourseName());
		int exeResult = courseService.insert(CourseTemp);
		if (exeResult <= 0)
		{
			info = "更新失败。";
			json.put("success", false);
			json.put("info", info);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		json.put("success", true);
		response.getWriter().write(new ObjectMapper().writeValueAsString(json));
		return;
	}

}
