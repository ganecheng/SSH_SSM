package com.jpkc.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.jpkc.common.Page;
import com.jpkc.pojo.Account;

public class AdminAction extends BaseAction
{

	// 常用变量
	private Map<String, Object> json;// 返回到前台的map对象
	private String info;// 提示信息
	private Account account;
	private String downloadTag;
	private String fileName;

	private String uploadTag;
	private File excelFile; // 具体上传文件的 引用 , 指向临时目录中的临时文件
	private String excelFileFileName; // 上传文件的名字 ,FileName 固定的写法
	private String excelFileContentType; // 上传文件的类型， ContentType 固定的写法

	private Page page;

	public AdminAction()
	{
		json = new HashMap<String, Object>();
	}
	
	public String exit()
	{
		getSession().removeAttribute("accountSession");
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

	public String getInfo()
	{
		return info;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	public Account getAccount()
	{
		return account;
	}

	public void setAccount(Account account)
	{
		this.account = account;
	}

	public String getDownloadTag()
	{
		return downloadTag;
	}

	public void setDownloadTag(String downloadTag)
	{
		this.downloadTag = downloadTag;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getUploadTag()
	{
		return uploadTag;
	}

	public void setUploadTag(String uploadTag)
	{
		this.uploadTag = uploadTag;
	}

	public File getExcelFile()
	{
		return excelFile;
	}

	public void setExcelFile(File excelFile)
	{
		this.excelFile = excelFile;
	}

	public String getExcelFileFileName()
	{
		return excelFileFileName;
	}

	public void setExcelFileFileName(String excelFileFileName)
	{
		this.excelFileFileName = excelFileFileName;
	}

	public String getExcelFileContentType()
	{
		return excelFileContentType;
	}

	public void setExcelFileContentType(String excelFileContentType)
	{
		this.excelFileContentType = excelFileContentType;
	}

	public Page getPage()
	{
		return page;
	}

	public void setPage(Page page)
	{
		this.page = page;
	}

}
