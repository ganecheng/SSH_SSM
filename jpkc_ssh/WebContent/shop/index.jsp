<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="${basePath }">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="chrome=1,IE=edge">
<meta name="renderer" content="webkit">
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<title>管理员后台主页</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/seller.css">
<link rel="stylesheet" href="css/zTreeStyle.css">
<link rel="stylesheet" href="css/toastr.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-datepicker.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" />
<!--[if lt IE 9]>
      <script src="js/respond.min.js"></script>
<![endif]-->

<style type="text/css">
html, body {
	min-width: 1320px;
}

.admin {
	min-width: 1140px;
}
</style>

</head>

<body id="admin_back_body">
	<div class="need_load_div" data-url="shop/ajax/common/seller_top_menu.jsp"></div>
	<!-- 清除浮动 -->
	<div class="clearfix"></div>
	<div class="admin">
		<div id="admin_div">
			<div class="need_load_div" data-url="shop/ajax/shop/welcome.jsp"></div>
		</div>
		<!-- 清除浮动 -->
		<div class="clearfix"></div>
		<hr class="G-Width1140 margin-large-top">
		<!-- 清除浮动 -->
		<div class="clearfix"></div>
		<div class="need_load_div" data-url="shop/ajax/common/seller_footer_div_black.jsp"></div>
	</div>

	<div style="display: none;" id="go_to_appointed_button" data-trigger-id="${param.ab }"></div>
	<!-- jQuery -->
	<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
	<!-- pintuer -->
	<script type="text/javascript" src="js/pintuer.js"></script>
	<!-- 树形控件 -->
	<script type="text/javascript" src="js/jquery.ztree.all-3.5.min.js"></script>
	<!-- 吐司提示插件 -->
	<script type="text/javascript" src="js/toastr.js"></script>
	<!-- 数字滚动效果 -->
	<script type="text/javascript" src="js/jquery.countTo.js"></script>
	<!-- ueditor -->
	<script type="text/javascript" charset="utf-8" src="ue/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="ue/ueditor.all.min.js"></script>
	<!-- 日期选择器 -->
	<script type="text/javascript" src="js/bootstrap-datepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/locales/bootstrap-datepicker.zh-CN.js" charset="UTF-8"></script>
	<!-- 日期时间选择器 -->
	<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
	<!-- 表单异步提交 -->
	<script type="text/javascript" src="js/jquery.form.js"></script>
	<!-- 拖拽排序功能 -->
	<script type="text/javascript" src="js/jquery.dragsort-0.5.2.min.js"></script>
	<script type="text/javascript">
		$(function()
		{
			$(document).ajaxError(function(event, request, settings, thrownError)
			{
				if (request.responseText.indexOf("seller_not_login_validate_flag_for_ajax") >= 0)
				{
					alert("您没有登录,或登录过期,或登录了买家账号,需要重新验证身份,即将跳转到登录界面。");
					window.location.href = "${basePath}seller/login.jsp";
				}
			});

			//关闭AJAX相应的缓存 
			$.ajaxSetup(
			{
				cache : false
			});

			var countFlag = 0;
			var need_load_divCount = $(".need_load_div").size();
			if (need_load_divCount == 0)
			{
				doTheseThing();
			}
			$(".need_load_div").each(function()
			{
				$(this).load($(this).attr("data-url"), {}, function()
				{
					$(this).show();
					countFlag++;
					if (countFlag == need_load_divCount)
					{
						doTheseThing();
						//解决谷歌浏览器不能滚动的问题
						$("body,html").animate(
						{
							scrollTop : $("html").scrollTop() + 1
						}, 0);
						$("body,html").animate(
						{
							scrollTop : $("html").scrollTop() - 1
						}, 0);
					}
				});
			});
		});

		function doTheseThing()
		{
			if ($("#go_to_appointed_button").attr("data-trigger-id").length > 0)
			{
				//根据顶部传来的网址按钮id,执行点击操作
				$("#" + $("#go_to_appointed_button").attr("data-trigger-id")).click();
			}

			//吐司初始化设置
			toastr.options =
			{
				"closeButton" : false,
				"debug" : false,
				"progressBar" : false,
				"positionClass" : "toast-top-center",
				"preventDuplicates" : false,
				"onclick" : null,
				"showDuration" : "300",
				"hideDuration" : "1000",
				"timeOut" : "5000",
				"extendedTimeOut" : "1000",
				"showEasing" : "swing",
				"hideEasing" : "linear",
				"showMethod" : "fadeIn",
				"hideMethod" : "fadeOut"
			};

			$("#admin_back_body").on("click", ".click_go_to_nav_button", function(e)
			{
				e.stopPropagation();
				$($(this).attr("data-trigger-id")).click();
			});
		}

		String.prototype.startWith = function(str)
		{
			var reg = new RegExp("^" + str);
			return reg.test(this);
		}

		String.prototype.endWith = function(str)
		{
			var reg = new RegExp(str + "$");
			return reg.test(this);
		}
	</script>
</body>
</html>
