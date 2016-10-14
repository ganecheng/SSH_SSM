<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	session.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="${basePath }">
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<title>页面不存在 - 404</title>
</head>
<body>
	<h1>此页面不存在！</h1>
	<p>您访问的页面不存在了。</p>
	<p>${info }</p>
	<p>
		前往
		<a href="./">首页</a>
	</p>
</body>
</html>