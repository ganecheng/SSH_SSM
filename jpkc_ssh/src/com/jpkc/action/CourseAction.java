package com.jpkc.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.jpkc.common.CM;
import com.jpkc.common.IResult;
import com.jpkc.pojo.*;
import com.jpkc.view.*;

import net.sf.json.JSONArray;

public class CourseAction extends BaseAction
{
	// 常用变量
	private Map<String, Object> json;// 返回到前台的map对象
	private Course Course;
	private List<Course> CourseList;

	private CourseInfo courseInfo;
	private List<CourseInfo> courseInfoList;

	private String CourseJson;

	private List<CourseViewAndList> viewAndList;

	private String commonStr;

	public CourseAction()
	{
		json = new HashMap<String, Object>();
	}

	public String update_custom_type()
	{
		List<Course> goodsTypeListTemp = courseDAO.findAll();
		if (goodsTypeListTemp.size() == 0)
		{
			setCourseJson(null);
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

		JSONArray jsonArray = JSONArray.fromObject(goodsTypeViewListForJson);
		setCourseJson(jsonArray.toString());

		return SUCCESS;
	}

	public String goods_type_add_do()
	{
		String method = getRequest().getMethod();
		System.out.println("=========请求是get还是post:" + method);
		if (method.toUpperCase().equals("GET"))
		{
			System.out.println("============如果直接输入网址进来的,什么操作都不做,必须是表单提交的!==========");
			return "404";
		}
		if (getCourse() == null || CM.validIsEmpty(getCourse().getCourseName()))
		{
			info = "类型名称是必填项。";
			json.put("success", false);
			json.put("info", info);
			return SUCCESS;
		}

		String[] gtNames = getCourse().getCourseName().split(",");
		List<Course> CourseList = new ArrayList<Course>();
		Calendar cal = Calendar.getInstance();
		for (String gtName : gtNames)
		{
			cal.add(Calendar.MILLISECOND, 1);
			Course gtTemp = new Course();
			gtTemp.setCourseId(CM.getRandomTwentyFivePrimaryKeyId(cal));
			if (CM.validIsEmpty(getCourse().getCourseParentId()) == true)
			{
				gtTemp.setCourseParentId("");
			}
			else
			{
				gtTemp.setCourseParentId(getCourse().getCourseParentId());
			}
			gtTemp.setCourseName(gtName.trim());
			gtTemp.setCourseAddTime(new Timestamp(cal.getTimeInMillis()));
			gtTemp.setCourseUpdateTime(new Timestamp(cal.getTimeInMillis()));
			CourseList.add(gtTemp);
		}
		List<Course> CourseListResult = courseDAO.saveList(CourseList);
		if (CourseListResult == null)
		{
			info = "保存失败。";
			json.put("success", false);
			json.put("info", info);
			return SUCCESS;
		}

		json.put("success", true);
		json.put("course", CourseListResult);
		return SUCCESS;
	}

	public String goods_type_delete_do()
	{
		String method = getRequest().getMethod();
		System.out.println("=========请求是get还是post:" + method);
		if (method.toUpperCase().equals("GET"))
		{
			System.out.println("============如果直接输入网址进来的,什么操作都不做,必须是表单提交的!==========");
			return "404";
		}
		if (CM.validIsEmpty(getCommonStr()))
		{
			info = "类型id是必填项。";
			json.put("success", false);
			json.put("info", info);
			return SUCCESS;
		}

		String[] ids = getCommonStr().split(",");

		List<String> idsList = new ArrayList<String>();
		for (String idsTemp : ids)
		{
			idsList.add(idsTemp.trim());
		}
		int deleteResult = courseDAO.deleteListByIds(idsList);
		if (deleteResult == IResult.DELETE_EXCEPTION)
		{
			info = "删除失败。";
			json.put("success", false);
			json.put("info", info);
			return SUCCESS;
		}

		json.put("success", true);
		return SUCCESS;
	}

	public String goods_type_update_do()
	{
		String method = getRequest().getMethod();
		System.out.println("=========请求是get还是post:" + method);
		if (method.toUpperCase().equals("GET"))
		{
			System.out.println("============如果直接输入网址进来的,什么操作都不做,必须是表单提交的!==========");
			return "404";
		}
		if (getCourse() == null || CM.validIsEmpty(getCourse().getCourseId()) || CM.validIsEmpty(getCourse().getCourseName()))
		{
			info = "类型名称是必填项。";
			json.put("success", false);
			json.put("info", info);
			return SUCCESS;
		}

		Course CourseTemp = courseDAO.findById(getCourse().getCourseId());
		if (CourseTemp == null)
		{
			info = "没有找到此类型。";
			json.put("success", false);
			json.put("info", info);
			return SUCCESS;
		}

		CourseTemp.setCourseName(getCourse().getCourseName());
		Course CourseResult = courseDAO.save(CourseTemp);
		if (CourseResult == null)
		{
			info = "更新失败。";
			json.put("success", false);
			json.put("info", info);
			return SUCCESS;
		}

		json.put("success", true);
		return SUCCESS;
	}

	public String get_shop_goods_type()
	{
		List<Course> CourseListTemp = courseDAO.findAll();
		if (CourseListTemp.size() == 0)
		{
			setCourseJson(null);
		}
		Map<String, CourseView> CourseMap = new LinkedHashMap<String, CourseView>();
		for (Course gt : CourseListTemp)
		{
			CourseView gtvTemp = new CourseView();
			gtvTemp.setId(gt.getCourseId());
			gtvTemp.setName(gt.getCourseName());
			gtvTemp.setpId(gt.getCourseParentId() == null ? "" : gt.getCourseParentId());
			gtvTemp.setOpen(true);
			gtvTemp.setNoR(false);
			gtvTemp.setGrade(1);
			CourseMap.put(gt.getCourseId(), gtvTemp);
		}
		List<CourseView> CourseViewListForJson = new ArrayList<CourseView>();
		Set<Map.Entry<String, CourseView>> set = CourseMap.entrySet();
		for (Iterator<Map.Entry<String, CourseView>> it = set.iterator(); it.hasNext();)
		{
			Map.Entry<String, CourseView> entry = (Map.Entry<String, CourseView>) it.next();
			if (CM.validIsEmpty(entry.getValue().getpId()))
			{
				entry.getValue().setGrade(1);
				CourseMap.put(entry.getKey(), entry.getValue());
			}
			else if (CM.validIsEmpty(CourseMap.get(entry.getValue().getpId()).getpId()))
			{
				entry.getValue().setGrade(2);
				CourseMap.put(entry.getKey(), entry.getValue());
			}
			else if (CM.validIsEmpty(CourseMap.get(CourseMap.get(entry.getValue().getpId()).getpId()).getpId()))
			{
				entry.getValue().setGrade(3);
				CourseMap.put(entry.getKey(), entry.getValue());
			}
			CourseViewListForJson.add(entry.getValue());
		}

		List<CourseViewAndList> CourseViewAndListForShowList = new ArrayList<CourseViewAndList>();
		for (int i = 0; i < CourseViewListForJson.size(); i++)
		{
			if (CourseViewListForJson.get(i).getGrade() == 1)
			{
				CourseViewAndList CourseViewAndListTemp = new CourseViewAndList();
				CourseViewAndListTemp.setView(CourseViewListForJson.get(i));
				CourseViewAndListForShowList.add(CourseViewAndListTemp);
			}
		}
		for (int i = 0; i < CourseViewAndListForShowList.size(); i++)
		{
			List<CourseViewAndList> CourseViewAndListForShowList_2 = new ArrayList<CourseViewAndList>();
			for (int j = 0; j < CourseViewListForJson.size(); j++)
			{
				if (CourseViewListForJson.get(j).getGrade() == 2
						&& CourseViewListForJson.get(j).getpId().equals(CourseViewAndListForShowList.get(i).getView().getId()))
				{
					CourseViewAndList CourseViewAndListTemp = new CourseViewAndList();
					CourseViewAndListTemp.setView(CourseViewListForJson.get(j));
					CourseViewAndListForShowList_2.add(CourseViewAndListTemp);
				}
			}
			CourseViewAndListForShowList.get(i).setList(CourseViewAndListForShowList_2);
		}

		setViewAndList(CourseViewAndListForShowList);

		for (CourseViewAndList gtvl : CourseViewAndListForShowList)
		{
			// System.out.println(gtvl.getView().getId() + "," +
			// gtvl.getView().getName() + "," +
			// gtvl.getView().getChildrenIds());
			for (CourseViewAndList gtvl2 : gtvl.getList())
			{
				// System.out.println("----" + gtvl2.getView().getId() + "," +
				// gtvl2.getView().getName() + "," +
				// gtvl2.getView().getChildrenIds());
			}
		}
		return SUCCESS;
	}

	public String get_ajax_course()
	{
		List<Course> CourseListTemp = courseDAO.findAll();
		if (CourseListTemp.size() == 0)
		{
			info = "没有课程。";
			json.put("success", false);
			json.put("info", info);
			return SUCCESS;
		}
		Map<String, CourseView> CourseMap = new LinkedHashMap<String, CourseView>();
		for (Course gt : CourseListTemp)
		{
			CourseView gtvTemp = new CourseView();
			gtvTemp.setId(gt.getCourseId());
			gtvTemp.setName(gt.getCourseName());
			gtvTemp.setpId(gt.getCourseParentId() == null ? "" : gt.getCourseParentId());
			gtvTemp.setOpen(true);
			gtvTemp.setNoR(false);
			gtvTemp.setGrade(1);
			CourseMap.put(gt.getCourseId(), gtvTemp);
		}
		List<CourseView> CourseViewListForJson = new ArrayList<CourseView>();
		Set<Map.Entry<String, CourseView>> set = CourseMap.entrySet();
		for (Iterator<Map.Entry<String, CourseView>> it = set.iterator(); it.hasNext();)
		{
			Map.Entry<String, CourseView> entry = (Map.Entry<String, CourseView>) it.next();
			if (CM.validIsEmpty(entry.getValue().getpId()))
			{
				entry.getValue().setGrade(1);
				CourseMap.put(entry.getKey(), entry.getValue());
			}
			else if (CM.validIsEmpty(CourseMap.get(entry.getValue().getpId()).getpId()))
			{
				entry.getValue().setGrade(2);
				CourseMap.put(entry.getKey(), entry.getValue());
			}
			else if (CM.validIsEmpty(CourseMap.get(CourseMap.get(entry.getValue().getpId()).getpId()).getpId()))
			{
				entry.getValue().setGrade(3);
				CourseMap.put(entry.getKey(), entry.getValue());
			}
			CourseViewListForJson.add(entry.getValue());
		}

		List<CourseViewAndList> CourseViewAndListForShowList = new ArrayList<CourseViewAndList>();
		for (int i = 0; i < CourseViewListForJson.size(); i++)
		{
			if (CourseViewListForJson.get(i).getGrade() == 1)
			{
				CourseViewAndList CourseViewAndListTemp = new CourseViewAndList();
				CourseViewAndListTemp.setView(CourseViewListForJson.get(i));
				CourseViewAndListForShowList.add(CourseViewAndListTemp);
			}
		}
		for (int i = 0; i < CourseViewAndListForShowList.size(); i++)
		{
			List<CourseViewAndList> CourseViewAndListForShowList_2 = new ArrayList<CourseViewAndList>();
			for (int j = 0; j < CourseViewListForJson.size(); j++)
			{
				if (CourseViewListForJson.get(j).getGrade() == 2
						&& CourseViewListForJson.get(j).getpId().equals(CourseViewAndListForShowList.get(i).getView().getId()))
				{
					CourseViewAndList CourseViewAndListTemp = new CourseViewAndList();
					CourseViewAndListTemp.setView(CourseViewListForJson.get(j));
					CourseViewAndListForShowList_2.add(CourseViewAndListTemp);
				}
			}
			CourseViewAndListForShowList.get(i).setList(CourseViewAndListForShowList_2);
		}

		json.put("success", true);
		json.put("course_ajax", CourseViewAndListForShowList);
		return SUCCESS;
	}

	public String goods_type_set_new_pic_do()
	{
		String method = getRequest().getMethod();
		System.out.println("=========请求是get还是post:" + method);
		if (method.toUpperCase().equals("GET"))
		{
			System.out.println("============如果直接输入网址进来的,什么操作都不做,必须是表单提交的!==========");
			return "404";
		}

		if (getCourseInfo() == null || CM.validIsEmptyWithTrim(getCourseInfo().getCourseId()) || CM.validIsEmptyWithTrim(getCourseInfo().getVideoMp4()))
		{
			info = "没有找到此类型。";
			json.put("success", false);
			json.put("info", info);
			return SUCCESS;
		}

		CourseInfo courseInfoFromDB = courseInfoDAO.findById(getCourseInfo().getCourseId());
		// 为空就添加,不为空就修改
		if (courseInfoFromDB == null)
		{
			courseInfoFromDB = new CourseInfo();
			courseInfoFromDB.setCourseId(getCourseInfo().getCourseId());
		}

		List<String> mp4ListTemp = CM.getVideoSrcList(getCourseInfo().getVideoMp4(), 1);
		if (mp4ListTemp == null)
		{
			info = "MP4上传是必选项。";
			json.put("success", false);
			json.put("info", info);
			return SUCCESS;
		}

		courseInfoFromDB.setVideoMp4(mp4ListTemp.get(0));

		List<String> flvListTemp = CM.getVideoSrcList(getCourseInfo().getVideoFlv(), 1);
		if (flvListTemp != null)
		{
			courseInfoFromDB.setVideoFlv(flvListTemp.get(0));
		}

		List<String> doc1ListTemp = CM.getPDFSrcList(getCourseInfo().getDoc1(), 1);
		if (doc1ListTemp != null)
		{
			courseInfoFromDB.setDoc1(doc1ListTemp.get(0));
		}

		List<String> doc2ListTemp = CM.getPDFSrcList(getCourseInfo().getDoc2(), 1);
		if (doc2ListTemp != null)
		{
			courseInfoFromDB.setDoc2(doc2ListTemp.get(0));
		}

		List<String> doc3ListTemp = CM.getPDFSrcList(getCourseInfo().getDoc3(), 1);
		if (doc3ListTemp != null)
		{
			courseInfoFromDB.setDoc3(doc3ListTemp.get(0));
		}

		List<String> doc4ListTemp = CM.getPDFSrcList(getCourseInfo().getDoc4(), 1);
		if (doc4ListTemp != null)
		{
			courseInfoFromDB.setDoc4(doc4ListTemp.get(0));
		}

		courseInfoFromDB.setStarScore(5.0);
		courseInfoFromDB.setUpdateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		CourseInfo courseInfoResult = courseInfoDAO.save(courseInfoFromDB);
		if (courseInfoResult == null)
		{
			info = "保存失败，请稍后再试。";
			json.put("success", false);
			json.put("info", info);
			return SUCCESS;
		}

		json.put("success", true);
		return SUCCESS;
	}

	public String goods_type_get_old_pic_do()
	{
		String method = getRequest().getMethod();
		System.out.println("=========请求是get还是post:" + method);
		if (method.toUpperCase().equals("GET"))
		{
			System.out.println("============如果直接输入网址进来的,什么操作都不做,必须是表单提交的!==========");
			return "404";
		}
		if (CM.validIsEmptyWithTrim(getCommonStr()))
		{
			info = "没有找到此类型。";
			json.put("success", false);
			json.put("info", info);
			return SUCCESS;
		}

		CourseInfo courseInfo = courseInfoDAO.findById(getCommonStr());
		if (courseInfo == null)
		{
			info = "没有找到此课程信息。";
			json.put("success", false);
			json.put("info", info);
			return SUCCESS;
		}

		json.put("success", true);
		json.put("courseInfo", courseInfo);
		return SUCCESS;
	}

	public String get_course_info()
	{
		String actionName = ServletActionContext.getActionMapping().getName();
		CourseInfo courseInfoFromDB = courseInfoDAO.findById(actionName);
		if (courseInfoFromDB == null)
		{
			return "404";
		}

		Course courseFromDB = courseDAO.findById(actionName);
		if (courseFromDB == null)
		{
			return "404";
		}

		setCourseInfo(courseInfoFromDB);
		setCourse(courseFromDB);

		return SUCCESS;
	}

	public Map<String, Object> getJson()
	{
		return json;
	}

	public void setJson(Map<String, Object> json)
	{
		this.json = json;
	}

	public Course getCourse()
	{
		return Course;
	}

	public void setCourse(Course Course)
	{
		this.Course = Course;
	}

	public List<Course> getCourseList()
	{
		return CourseList;
	}

	public void setCourseList(List<Course> CourseList)
	{
		this.CourseList = CourseList;
	}

	public String getCourseJson()
	{
		return CourseJson;
	}

	public void setCourseJson(String CourseJson)
	{
		this.CourseJson = CourseJson;
	}

	public String getCommonStr()
	{
		return commonStr;
	}

	public void setCommonStr(String commonStr)
	{
		this.commonStr = commonStr;
	}

	public List<CourseViewAndList> getViewAndList()
	{
		return viewAndList;
	}

	public void setViewAndList(List<CourseViewAndList> viewAndList)
	{
		this.viewAndList = viewAndList;
	}

	public CourseInfo getCourseInfo()
	{
		return courseInfo;
	}

	public void setCourseInfo(CourseInfo courseInfo)
	{
		this.courseInfo = courseInfo;
	}

	public List<CourseInfo> getCourseInfoList()
	{
		return courseInfoList;
	}

	public void setCourseInfoList(List<CourseInfo> courseInfoList)
	{
		this.courseInfoList = courseInfoList;
	}

}
