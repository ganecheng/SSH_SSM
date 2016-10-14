package com.jpkc.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jpkc.dao.CourseDAO;
import com.jpkc.dao.CourseInfoDAO;
import com.jpkc.dao.StarDAO;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport
{

	// 常用字符串
	public static final String GLOBAL_RESULT_HOME = "home";
	public static final String GLOBAL_RESULT_EXCEPTION = "exception";
	public static final String GLOBAL_RESULT_404 = "404";
	public static final String GLOBAL_RESULT_LOGIN = "login";

	// 常用DAO
	public CourseDAO courseDAO;
	public CourseInfoDAO courseInfoDAO;
	public StarDAO starDAO;

	public String info;// 提示信息

	public BaseAction()
	{
		super();
		courseDAO = new CourseDAO();
		courseInfoDAO = new CourseInfoDAO();
		starDAO = new StarDAO();

	}

	public HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse()
	{
		return ServletActionContext.getResponse();
	}

	public HttpSession getSession()
	{
		return getRequest().getSession();
	}

	public ServletContext getApplication()
	{
		return ServletActionContext.getServletContext();
	}

	public String getRealyPath(String path)
	{
		return getApplication().getRealPath(path);
	}

	public String getInfo()
	{
		return info;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

}
