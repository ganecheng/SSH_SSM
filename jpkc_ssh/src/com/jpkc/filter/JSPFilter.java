package com.jpkc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jpkc.pojo.Account;

public class JSPFilter implements Filter
{

	@Override
	public void destroy()
	{

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		System.out.println("++++++++JSP页面过滤器开始过滤...............");
		HttpServletRequest httpReq = (HttpServletRequest) request;
		// 转换成HtppServletRequest，以获取包含的地址信息，请求的参数，提交的数据
		String Url = httpReq.getRequestURI();
		if (Url.toLowerCase().endsWith(".jsp"))
		{
			// 判断URL以jsp结尾
			HttpSession session = httpReq.getSession();
			Account account = (Account) session.getAttribute("accountSession");
			if (account == null)
			{
				HttpServletResponse httpRes = (HttpServletResponse) response;
				System.out.println("根路径是:" + httpReq.getContextPath());
				httpRes.sendRedirect(httpReq.getContextPath() + "/404");
				// 重定向到某个action
				return;
			}

		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{

	}

}
