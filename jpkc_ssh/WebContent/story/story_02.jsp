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
<title>《教师教学技能训练》精品资源共享课视频</title>
<!-- core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/owl.carousel.css" rel="stylesheet">
<link href="css/owl.transitions.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<link href="css/video-js.min.css" rel="stylesheet">
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
						<li class="">
							<a href="story/story_01.jsp">首页</a>
						</li>
						<li class="scroll active">
							<a href="#div_video">视频 ● ${course.courseName }</a>
						</li>
						<li class="scroll">
							<a href="#div_2">课程资源</a>
						</li>
						<li class="scroll">
							<a href="#div_5">评论</a>
						</li>
					</ul>
				</div>
			</div>
			<!--/.container-->
		</nav>
		<!--/nav-->
	</header>
	<!--/header-->
	<section id="story_div">
		<div class="container" style="background: #f5f5f5; box-shadow: 0 0 5px #aaa;">

			<div class="row">
				<div class="col-sm-3" style="padding-top: 90px; padding-bottom: 30px;">
					<h3 class="column-title">课程章节</h3>
					<div class="row">
						<div class="col-sm-12" id="all_course_div"></div>
					</div>
				</div>
				<div class="col-sm-9" style="background: white; padding-top: 90px; padding-bottom: 30px;">
					<div id="div_video" style="height: 500px;">
						<h2 class="column-title">
							${course.courseName } <small><span style="color: #1caaea; padding-right: 5px;" title="8.5分"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i
									class="fa fa-star-half-o"></i></span></small>
						</h2>
						<div style="height: 460px;">
							<div id="a1"></div>
						</div>
						<script type="text/javascript" src="ckplayer/ckplayer.js" charset="utf-8"></script>
						<script type="text/javascript">
							var flashvars =
							{
								f : '${basePath}video/oceans.mp4',
								c : 0,
								p : 1,
								e : 6
							};
							var params =
							{
								bgcolor : '#FFF',
								allowFullScreen : true,
								allowScriptAccess : 'always',
								wmode : 'transparent'
							};
							//var video = [ '${courseInfo.videoMp4 }->video/mp4' ];
							var video = [ 'video/oceans.mp4->video/mp4' ];
							CKobject.embed('ckplayer/ckplayer.swf', 'a1', 'ckplayer_a1', '100%', '100%', true, flashvars, video, params);
						</script>
					</div>
					<div class="clearfix"></div>
					<div id="div_2" style="margin-top: 50px;">
						<h2 class="column-title">${course.courseName } 课程资源</h2>
						<p>以下内容为该教学视频的配套学习资源，请大家点击查看。</p>
						<div class="row">
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="0ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5 pdf_img" src="images/c1.jpg" alt="" data-pdf-url="${courseInfo.doc1 }">
										</a>
									</div>
									<div class="team-info">
										<h3 class="text-center">演示文稿</h3>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="0ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5 pdf_img" src="images/c1.jpg" alt="" data-pdf-url="${courseInfo.doc2 }">
										</a>
									</div>
									<div class="team-info">
										<h3 class="text-center">重点难点</h3>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="0ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5 pdf_img" src="images/c1.jpg" alt="" data-pdf-url="${courseInfo.doc3 }">
										</a>
									</div>
									<div class="team-info">
										<h3 class="text-center">教学设计</h3>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-md-3">
								<div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="0ms">
									<div class="team-img">
										<a href="javascript:void(0)">
											<img class="img-responsive center-block img_shadow_5 pdf_img" src="images/c1.jpg" alt="" data-pdf-url="${courseInfo.doc4 }">
										</a>
									</div>
									<div class="team-info">
										<h3 class="text-center">习题作业</h3>
									</div>
								</div>
							</div>

						</div>
					</div>
					<div class="divider" style="margin: 70px 0px 0px 0px;"></div>
					<div class="row">
						<div class="col-sm-12 col-md-6" style="padding-top: 90px; padding-bottom: 30px;">
							<div id="div_5">
								<h3 class="column-title">评论</h3>
								<p>我们精选的网友的评论。</p>
								<div class="row">
									<div class="col-sm-12">
										<!-- 多说评论框 start -->
										<div class="ds-thread" data-thread-key="video_${course.courseId }" data-title="教师教学技能培训 精品资源共享课" data-url="http://127.0.0.1/jpkc/story/story_02.jsp"></div>
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
						<div class="col-sm-12 col-md-6" style="padding-top: 90px; padding-bottom: 30px;">
							<h3 class="column-title">打分分布</h3>
							<p>我们精选的网友的打分。</p>
							<div id="main" style="width: 100%; height: 400px;"></div>
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

	<div style="display: none;" id="video_id_str_div">${course.courseId }</div>
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
	<script src="js/video.min.js"></script>
	<script src="js/echarts.min.js"></script>
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

			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(document.getElementById('main'));

			// 指定图表的配置项和数据
			option =
			{
				backgroundColor : '#fff',

				title :
				{
					text : '用户星级评价分布',
					left : 'center',
					top : 20,
					textStyle :
					{
						color : '#000'
					}
				},

				tooltip :
				{
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend :
				{
					x : 'center',
					y : 'bottom',
					data : [ '5星', '4星', '3星', '2星', '1星' ]
				},
				visualMap :
				{
					show : false,
					min : 80,
					max : 500,
					inRange :
					{
						colorLightness : [ 0.2, 1 ]
					}
				},
				series : [
				{
					name : '星级评价',
					type : 'pie',
					radius : '55%',
					center : [ '50%', '50%' ],
					data : [
					{
						value : 335,
						name : '5星'
					},
					{
						value : 310,
						name : '4星'
					},
					{
						value : 274,
						name : '3星'
					},
					{
						value : 235,
						name : '2星'
					},
					{
						value : 200,
						name : '1星'
					} ].sort(function(a, b)
					{
						return a.value - b.value
					}),
					roseType : 'angle',
					label :
					{
						emphasis :
						{
							textStyle :
							{
								color : 'rgba(0, 0, 0, 0.8)'
							}
						}
					},
					labelLine :
					{
						emphasis :
						{
							lineStyle :
							{
								color : 'rgba(0, 0, 0, 0.8)'
							},
							smooth : 0.2,
							length : 10,
							length2 : 20
						}
					},
					itemStyle :
					{
						emphasis :
						{
							shadowBlur : 100,
							shadowColor : 'rgba(0, 0, 0, 0.8)'
						}
					}
				} ]
			};

			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);

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
					$("#li_"+$("#video_id_str_div").text()).find("a").css("color","blue");
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