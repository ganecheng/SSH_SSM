package com.jpkc.common;

import java.io.Serializable;

public class Page implements Serializable
{
	private int currentIndex;// 当前页的下标
	private int totalPages;// 所有页数
	private String href;

	public Page()
	{
		super();
	}

	public Page(int currentIndex, int totalPages, String href)
	{
		super();
		this.currentIndex = currentIndex;
		this.totalPages = totalPages;
		this.href = href;
	}

	public int getCurrentIndex()
	{
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex)
	{
		this.currentIndex = currentIndex;
	}

	public int getTotalPages()
	{
		return totalPages;
	}

	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
	}

	public String getHref()
	{
		return href;
	}

	public void setHref(String href)
	{
		this.href = href;
	}

	@Override
	public String toString()
	{
		return "Page [currentIndex=" + currentIndex + ", totalPages=" + totalPages + ", href=" + href + "]";
	}

}
