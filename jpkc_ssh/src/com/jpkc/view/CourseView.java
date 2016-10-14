package com.jpkc.view;

import java.io.Serializable;

public class CourseView implements Serializable
{
	private String id;// 类型id
	private String pId;// 类型父id
	private String name;// 类型名称
	private boolean open;// 打开状态
	private boolean noR;// 是否有右键菜单
	private int grade;// 级别
	private String childrenIds;// 自己的id和下一级别的所有子类型的id

	public CourseView()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseView(String id, String pId, String name, boolean open, boolean noR, int grade, String childrenIds)
	{
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.noR = noR;
		this.grade = grade;
		this.childrenIds = childrenIds;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getpId()
	{
		return pId;
	}

	public void setpId(String pId)
	{
		this.pId = pId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isOpen()
	{
		return open;
	}

	public void setOpen(boolean open)
	{
		this.open = open;
	}

	public boolean isNoR()
	{
		return noR;
	}

	public void setNoR(boolean noR)
	{
		this.noR = noR;
	}

	public int getGrade()
	{
		return grade;
	}

	public void setGrade(int grade)
	{
		this.grade = grade;
	}

	public String getChildrenIds()
	{
		return childrenIds;
	}

	public void setChildrenIds(String childrenIds)
	{
		this.childrenIds = childrenIds;
	}

	@Override
	public String toString()
	{
		return "CourseView [id=" + id + ", pId=" + pId + ", name=" + name + ", open=" + open + ", noR=" + noR + ", grade=" + grade + ", childrenIds="
				+ childrenIds + "]";
	}

}
