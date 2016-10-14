package com.jpkc.common;

public interface IResult
{
	/**
	  *插入的公共静态变量结果
	  * @author 甘士成
	  *
	 */
	public static final int INSERT_SUCCESS=1;
	public static final int INSERT_HAVE_EXIST=2;
	public static final int INSERT_EXCEPTION=3;
	
	/**
	  *修改的公共静态变量结果
	  * @author 甘士成
	  *
	 */
	public static final int UPDATE_SUCCESS=101;
	public static final int UPDATE_EXCEPTION=102;
	
	/**
	 *删除的公共静态变量结果
	 * @author 甘士成
	 *
	 */
	public static final int DELETE_SUCCESS=201;
	public static final int DELETE_EXCEPTION=202;
	
}
