package com.jpkc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver
{

	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	{

		// 上边代码变为
		CustomException customException = null;
		if (ex instanceof CustomException)
		{
			customException = (CustomException) ex;
		}
		else
		{
			customException = new CustomException("未知错误");
		}

		// 错误信息
		String message = customException.getMessage();

		ModelAndView modelAndView = new ModelAndView();

		// 将错误信息传到页面
		modelAndView.addObject("message", message);

		// 指向错误页面
		modelAndView.setViewName("/WEB-INF/jsp/error");

		return modelAndView;
	}

}
