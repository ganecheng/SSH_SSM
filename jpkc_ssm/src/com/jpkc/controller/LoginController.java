package com.jpkc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jpkc.common.CM;
import com.jpkc.exception.CustomException;
import com.jpkc.mapper.CourseInfoMapper;
import com.jpkc.pojo.Account;
import com.jpkc.pojo.CourseInfo;
import com.jpkc.service.LoginService;

@RequestMapping("/admin")
@Controller
public class LoginController
{
	@Autowired
	LoginService loginService;

	// 登录
	@RequestMapping(value = "/login_do", method = { RequestMethod.POST })
	public void login_do(ModelAndView model, HttpServletRequest request, HttpServletResponse response, HttpSession session, Account account) throws Exception
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		Map<String, Object> json = new HashMap<String, Object>();
		String info;

		if (account == null || CM.validIsEmpty(account.getId()) || CM.validIsEmpty(account.getPassword()))
		{
			info = "用户名、密码都是必填项。";
			json.put("success", false);
			json.put("info", info);
			response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return;
		}

		session.setAttribute("accountSession", account);
		json.put("success", true);
		response.getWriter().write(new ObjectMapper().writeValueAsString(json));
		return;

	}
	// 登录
	@RequestMapping(value = "/login_do2", method = { RequestMethod.POST,RequestMethod.GET })
	public @ResponseBody Map<String, Object> login_do2(ModelAndView model, HttpServletRequest request, HttpServletResponse response, HttpSession session, Account account) throws Exception
	{
		//response.setCharacterEncoding("utf-8");
		//response.setContentType("application/json;charset=utf-8");
		Map<String, Object> json = new HashMap<String, Object>();
		String info;
		
		if (account == null || CM.validIsEmpty(account.getId()) || CM.validIsEmpty(account.getPassword()))
		{
			info = "用户名、密码都是必填项。";
			json.put("success", false);
			json.put("info", info);
			//response.getWriter().write(new ObjectMapper().writeValueAsString(json));
			return json;
		}
		
		session.setAttribute("accountSession", account);
		json.put("success", true);
		//response.getWriter().write(new ObjectMapper().writeValueAsString(json));
		return json;
		
	}
	
	@RequestMapping("/admin_home")
	public String admin_home() throws Exception
	{
		return "forward:/shop/index.jsp";
	}

	// 退出
	@RequestMapping("/exit")
	public String logout(ModelAndView model, HttpSession session) throws Exception
	{

		// 清除session
		session.invalidate();
		// 重定向到商品列表页面
		return "redirect:/manager/login.jsp";
	}

}
