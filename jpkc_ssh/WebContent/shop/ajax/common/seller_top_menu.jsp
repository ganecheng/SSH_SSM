<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<!-- 清除浮动 -->
	<div class="clearfix"></div>
	<div class="lefter">
		<div class="logo">
			<h3>
				<a href="${basePath }shop/show_shop">
					<strong>精品课程<br>后台管理
					</strong>
				</a>
			</h3>
		</div>
	</div>
	<div class="righter nav-navicon" id="admin-nav">
		<div class="mainer">
			<div class="admin-navbar">
				<span class="float-right"> <!-- <a class="button button-little bg-blue" href="seller/change_password.jsp"">
						<span class="icon-key"></span> 修改密码
					</a> --> <a class="button button-little bg-yellow" href="admin/exit"">
						<span class="icon-power-off"></span> 安全退出
					</a>
				</span>
				<ul class="nav nav-inline admin-nav">
					<li id="begin_module" class="active nav_first_li">
						<a href="javascript:void(0)" class="nav_tag_a_link icon-home" data-url="shop/ajax/shop/welcome.jsp"> 开始</a>
						<ul>
							<li class="active">
								<a href="javascript:void(0)" class="sub_tag_a_link" id="sub_my_shop" data-url="shop/ajax/shop/welcome.jsp">管理中心首页</a>
							</li>
						</ul>
					</li>
					<li id="type_module" class="nav_first_li">
						<a href="javascript:void(0)" class="nav_tag_a_link icon-cubes"> 课程管理</a>
						<ul>
							<li class="active">
								<a href="javascript:void(0)" class="sub_tag_a_link" id="sub_update_custom_type" data-url="goods_type/update_custom_type">课程资源管理</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="admin-bread">
				<span>您好，${accountSession.id }，欢迎您的光临。</span>
				<ul class="bread">
					<li>
						<a href="javascript:void(0)" class="icon-home click_go_to_nav_button" data-trigger-id="#sub_my_shop"> 开始</a>
					</li>
					<li id="bread_second_li">管理中心首页</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div id="module_name_list_div" style="display: none;">
	<span data-id="" data-text=""></span>
</div>
<script type="text/javascript">
	//关闭AJAX相应的缓存 
	$.ajaxSetup(
	{
		cache : false
	});
	$("#admin-nav").on("click", ".admin-nav>li", function(e)
	{
		$(".admin-nav>li").removeClass("active");
		$(this).addClass("active");
		$(this).find("ul li.active").trigger("click");
	});
	$("#admin-nav").on("click", ".admin-nav>li>ul>li", function(e)
	{
		$(this).parent().find("li").removeClass("active");
		$(this).addClass("active");
		$("#bread_second_li").html($(this).find("a").html());
		e.stopPropagation();
		$("#admin_div").load(encodeURI($(this).find("a").attr("data-url")), {}, function()
		{

		});
	});
	$("#admin-nav").on("click", ".sub_tag_a_link", function(e)
	{
		e.stopPropagation();
		$(this).closest("ul").find("li").removeClass("active");
		$(this).closest("li").addClass("active");
		$(this).closest("li.nav_first_li").trigger("click");
	});

</script>
