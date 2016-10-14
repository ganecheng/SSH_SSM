package com.jpkc.view;

import java.io.Serializable;
import java.util.List;

public class CourseViewAndList implements Serializable
{
	private CourseView view;
	private List<CourseViewAndList> list;

	public CourseViewAndList()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseViewAndList(CourseView view, List<CourseViewAndList> list)
	{
		super();
		this.view = view;
		this.list = list;
	}

	public CourseView getView()
	{
		return view;
	}

	public void setView(CourseView view)
	{
		this.view = view;
	}

	public List<CourseViewAndList> getList()
	{
		return list;
	}

	public void setList(List<CourseViewAndList> list)
	{
		this.list = list;
	}

	@Override
	public String toString()
	{
		return "GoodsTypeViewAndList [view=" + view + ", list=" + list + "]";
	}

}
