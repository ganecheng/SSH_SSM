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
<html lang="zh">
<head>
<base href="${basePath }">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>《教师教学技能训练》精品资源共享课</title>
<!-- core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/owl.carousel.css" rel="stylesheet">
<link href="css/owl.transitions.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<script type="text/javascript">
	var isHTML5 = true;
</script>
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <script type="text/javascript">
		isHTML5 = false;
	</script>
<![endif]-->

<style type="text/css">
html, body {
	min-height: 100%;
	padding-top: 0px;
}

body {
	background: url("${basePath}images/book_and_leaf_1080.jpg") no-repeat;
	background-attachment: scroll;
	background-position: top;
	background-color: #dac2a7;
}

#footer {
	padding-top: 15px;
	padding-bottom: 15px;
	color: #fff;
	background: #2e2e2e;
	background: rgba(46, 46, 46, 0.8);
	position: relative;
	right: 0;
	left: 0;
	bottom: 0;
	z-index: 1030;
}

#footer a {
	color: #fff;
}

#footer a:hover {
	color: #45aed6;
}

#footer ul {
	list-style: none;
	padding: 0;
	margin: 0 -7.5px;
}

#footer ul>li {
	display: inline-block;
	margin: 0 7.5px;
}

@media only screen and (min-width: 768px) {
	#footer .social-icons {
		float: right;
	}
}

#home_text {
	position: relative;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	color: #fff;
}

#home_text h2 {
	font-size: 36px;
	line-height: 1;
	text-transform: uppercase;
	color: #fff;
	display: inline-block;
	height: 40px;
	line-height: 40px;
}

#home_text p {
	color: #fff;
	background-color: gray;
	background: rgba(0, 0, 0, .4);
	display: inline-block;
}

#story_div a {
	color: black;
}

#story_div a:HOVER {
	color: blue;
	text-decoration: underline;
}

#story_div .column-title:after {
	content: " ";
	position: absolute;
	bottom: -1px;
	left: 0;
	width: 40%;
	border-bottom: 1px solid #45aed6;
}

li>.fa-circle-thin {
	text-indent: 2em;
}

.first_title {
	font-weight: bold;
	font-family: 微软雅黑, 黑体;
	font-size: 18px;
}

.img_shadow_5 {
	box-shadow: 0 0 5px #aaa;
}

.text_shadow_5 {
	text-shadow: 0 0 5px #000;
}

.column-title {
	color: #8C4100;
}
</style>
</head>
<!--/head-->

<body id="home" class="homepage">

	<header id="header">
		<nav id="main-menu" class="navbar navbar-default navbar-fixed-top" role="banner">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="story/story_01.jsp">
						<img src="images/LOGO.png" alt="logo">
					</a>
				</div>

				<div class="collapse navbar-collapse navbar-right">
					<ul class="nav navbar-nav">
						<li class="scroll active">
							<a href="#home_text">首页</a>
						</li>
						<li class="scroll">
							<a href="#div_2">课程介绍</a>
						</li>
						<li class="scroll">
							<a href="#div_3">教师团队</a>
						</li>
						<li class="scroll">
							<a href="#div_4">参考教材</a>
						</li>
						<li class="scroll">
							<a href="#div_5">课程评价</a>
						</li>
					</ul>
				</div>
			</div>
			<!--/.container-->
		</nav>
		<!--/nav-->
	</header>
	<!--/header-->

	<div id="home_text" class="text-center" style="margin-top: 140px;">
		<h2 class="wow fadeInDown text_shadow_5" data-wow-duration="300ms" data-wow-delay="0ms">
			<span>教师教学技能培训 精品资源共享课</span>
		</h2>
		<div class="clearfix"></div>
	</div>

	<section id="story_div" style="margin-top: 90px;">
		<div class="container" style="background: #f5f5f5; box-shadow: 0 0 5px #aaa;">

			<div class="row">
				<div class="col-sm-3" style="padding-top: 30px; padding-bottom: 30px;">
					<h3 class="column-title">课程章节</h3>
					<div class="row">
						<div class="col-sm-12" id="all_course_div"></div>
					</div>
				</div>
				<div class="col-sm-9" style="background: white; padding-top: 30px; padding-bottom: 30px;">
					<div id="div_2">
						<div class="section-header">
							<h2 class="section-title text-center wow fadeInDown">课程介绍</h2>
							<p class="text-left text-indent wow fadeInDown">自2007年起，《教师教学技能训练》为我校电子、计科、美术、经贸、管理、自动化、音乐、机电、政法、中文、会计、外国语等学院的师范生必修课。该课程针对职业教育教师教学所需要的技能，提出了“三位一体”式教学技能训练模式，将课程内容拓展为“普通师范技能训练模块”、“信息化教学技能训练模块”、“职教情景教学技能训练模块”，体现职业技术师范教育教学技能训练的特色。</p>
						</div>
						<div class="row">
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="0ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5 pdf_img" src="images/ke_cheng_da_gang.jpg" alt="" data-pdf-url="${basePath }pdf/ke_cheng_da_gang.pdf">
										</a>
									</div>
									<div class="team-info">
										<h3 class="text-center">课程大纲</h3>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="0ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5 pdf_img" src="images/jiao_xue_ri_li.jpg" alt="" data-pdf-url="${basePath }pdf/jiao_xue_ri_li.pdf">
										</a>
									</div>
									<div class="team-info">
										<h3 class="text-center">教学日历</h3>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="0ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5 pdf_img" src="images/kao_ping.jpg" alt="" data-pdf-url="${basePath }pdf/kao_ping.pdf">
										</a>
									</div>
									<div class="team-info">
										<h3 class="text-center">考评方式与标准</h3>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="0ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5 pdf_img" src="images/xue_xi_zhi_nan.jpg" alt="" data-pdf-url="${basePath }pdf/xue_xi_zhi_nan.pdf">
										</a>
									</div>
									<div class="team-info">
										<h3 class="text-center">学习指南</h3>
									</div>
								</div>
							</div>

						</div>
					</div>
					<div id="div_3" style="margin-top: 50px;">
						<div class="divider" style="margin: 0px 0px 70px 0px;"></div>
						<div class="section-header">
							<h2 class="section-title text-center wow fadeInDown">教师团队</h2>
							<p class="text-center wow fadeInDown">我们拥有的教师团队黄金组合。</p>
						</div>
						<div class="row">
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="100ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5" src="images/teacher_yao_rui.jpg" alt="">
										</a>
									</div>
									<div class="team-info">
										<h3 class="text-center">**</h3>
										<p class="text-center">高级实验师</p>
										<p class="text-center">教育技术学 课程负责人</p>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="100ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5" src="images/teacher_zhang_jin.jpg" alt="">
										</a>
									</div>
									<div class="team-info">
										<h3 class="text-center">**</h3>
										<p class="text-center">教授</p>
										<p class="text-center">电子 教学总体设计</p>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="100ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5" src="images/teacher_gao_a_lin.jpg" alt="">
										</a>
									</div>
									<div class="team-info">
										<h3 class="text-center">***</h3>
										<p class="text-center">讲师</p>
										<p class="text-center">英语 实训教学</p>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="100ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5" src="images/teacher_lin_yue_jiao.jpg" alt="">
										</a>
									</div>
									<div class="team-info">
										<h3 class="text-center">***</h3>
										<p class="text-center">实验员</p>
										<p class="text-center">教育技术学 实训指导</p>
									</div>
								</div>
							</div>
						</div>
						<div class="row" style="margin-top: 30px;">
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="100ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5" src="images/teacher_wang_qin_lei.jpg" alt="">
										</a>
									</div>
									<div class="team-info">
										<h3 class="text-center">***</h3>
										<p class="text-center">助教</p>
										<p class="text-center">教育技术学 实训教学</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="div_4" style="margin-top: 50px;">
						<div class="divider" style="margin: 0px 0px 70px 0px;"></div>
						<div class="section-header">
							<h2 class="section-title text-center wow fadeInDown">参考教材</h2>
							<p class="text-center wow fadeInDown">我们使用的参考教材。</p>
						</div>
						<div class="row">
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="0ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5" src="images/book_cover_01.jpg" alt="">
										</a>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInRight" data-wow-duration="400ms" data-wow-delay="0ms">
									<div class="team-info">
										<h3>新编教师教学技能训练教程</h3>
										<p>
											<strong>主教材</strong>
										</p>
										<p>主编：吴萍</p>
										<p>北京师范大学出版社</p>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="0ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5" src="images/book_cover_02.jpg" alt="">
										</a>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInRight" data-wow-duration="400ms" data-wow-delay="0ms">
									<div class="team-info">
										<h3>课堂教学技能训练</h3>
										<p>
											<strong>辅教材</strong>
										</p>
										<p>主编：彭小明 郑东</p>
										<p>高等教育出版社</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="div_5" style="margin-top: 50px;">
						<div class="divider" style="margin: 0px 0px 70px 0px;"></div>
						<div class="section-header">
							<h2 class="section-title text-center wow fadeInDown">课程评价</h2>
							<p class="text-center wow fadeInDown">我们精选的网友的评价。</p>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<!-- 多说评论框 start -->
								<div class="ds-thread" data-thread-key="jpkc" data-title="教师教学技能培训 精品资源共享课" data-url="http://127.0.0.1/jpkc/story/story_01.jsp"></div>
								<!-- 多说评论框 end -->
								<!-- 多说公共JS代码 start (一个网页只需插入一次) -->
								<script type="text/javascript">
									var duoshuoQuery =
									{
										short_name : "jxjnpx"
									};
									(function()
									{
										var ds = document.createElement('script');
										ds.type = 'text/javascript';
										ds.async = true;
										ds.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') + '//static.duoshuo.com/embed.js';
										ds.charset = 'UTF-8';
										(document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(ds);
									})();
								</script>
								<!-- 多说公共JS代码 end -->
							</div>

						</div>
					</div>


				</div>
			</div>
	</section>

	<footer id="footer" class="wow fadeIn" data-wow-duration="1000ms" data-wow-delay="300ms">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-xs-12 text-left">工业实训中心 版权所有</div>
				<div class="col-sm-6 hidden-xs text-right">地址：广东省广州市 邮编：510665</div>
			</div>
		</div>
	</footer>
	<!--/#footer-->

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">查看文档</h4>
				</div>
				<div class="modal-body" id="modal-body" style="min-height: 900px;"></div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/mousescroll.js"></script>
	<script src="js/smoothscroll.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/jquery.isotope.min.js"></script>
	<script src="js/jquery.inview.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/pdfobject.js"></script>
	<script src="js/main.js"></script>
	<script type="text/javascript">
		$(function()
		{
			var isPCOrNot = IsPC();
			$(".pdf_img").each(function()
			{
				var pdf_img_obj = $(this);
				pdf_img_obj.click(function()
				{
					if (isPCOrNot)
					{
						$("#myModal").modal("show");
						var myPDF = new PDFObject(
						{
							url : pdf_img_obj.attr("data-pdf-url"),
							height : "900px"
						}).embed("modal-body");
					}
					else
					{
						window.location.href = pdf_img_obj.attr("data-pdf-url");
					}
				});
			});

			//获取所有课程信息
			$.post("goods_type/get_ajax_course", {}, function(json)
			{
				if (json.success == true)
				{
					var html_str = "";
					$.each(json.course_ajax, function(i, n)
					{
						html_str += '<ul class="nostyle">';
						html_str += '<li>';
						html_str += '<i class="fa fa-circle"></i> ';
						html_str += '<a href="javascript:void(0)" class="first_title">' + n.view.name + '</a>';
						html_str += '</li>';
						var list = n.list;
						$.each(list, function(i2, n2)
						{
							html_str += '<li id="li_'+n2.view.id+'">';
							html_str += '<i class="fa fa-circle-thin"></i> ';
							html_str += '<a href="item/'+n2.view.id+'">' + n2.view.name + '</a>';
							html_str += '</li>';
						});
						html_str += '</ul>';
					});
					$("#all_course_div").append(html_str);
				}
			}, "json");
		});
		function IsPC()
		{
			var userAgentInfo = navigator.userAgent;
			var Agents = [ "Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod" ];
			var flag = true;
			for (var v = 0; v < Agents.length; v++)
			{
				if (userAgentInfo.indexOf(Agents[v]) > 0)
				{
					flag = false;
					break;
				}
			}
			return flag;
		}
	</script>
</body>
</html>