<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="line-big">
	<div class="xl3">
		<div class="panel border-back">
			<div class="panel-body text-center">
				<h1 class="margin-big-top">
					<strong>${accountSession.id }</strong>
				</h1>
				<h3 class="margin-top">${sellerSession.sellerPhone }</h3>
			</div>
			<div class="panel-foot bg-back border-back">
				您好，${accountSession.id }，管理您的网站吧。
				<!-- <button class="button button-small border-dot swing-hover click_go_to_nav_button" data-trigger-id="#sub_edit_shop">
					<span class="icon-pencil"></span> 编辑资料
				</button> -->
			</div>
		</div>
		<br />
		<div class="panel">
			<div class="panel-head">
				<strong>信息统计</strong>
			</div>
			<ul class="list-group">
				<!-- <li>
					<span style="display: none;" class="float-right badge bg-main" id="on_sale_number_badge">0</span><span class="icon-file-text"></span> <a href="javascript:void(0)" class="click_go_to_nav_button" data-trigger-id="#sub_see_on_sale_goods">
						销售中商品</a>
				</li>
				<li>
					<span style="display: none;" class="float-right badge bg-red" id="to_be_send_number_badge">0</span><span class="icon-shopping-cart"></span> <a href="javascript:void(0)" class="click_go_to_nav_button"
						data-trigger-id="#sub_see_to_be_send_order"> 待发货订单</a>
				</li> -->
			</ul>
		</div>
		<br />
	</div>
	<div class="xl9">
		
		<div class="alert">
			<h4>课程管理</h4>
			<p class="text-gray padding-top">您可以对章节进行管理，并对每一章节的视频和文档资源进行管理。</p>
			<button class="button border-main click_go_to_nav_button" data-trigger-id="#sub_update_custom_type">课程管理</button>
		</div>
	</div>
</div>
<script type="text/javascript">
	//去获取销售中的商品数量和待发货的商品数量
	$.post("admin/m_count_number_do", {}, function(json)
	{
		if (json.success == true)
		{
			$("#on_sale_number_badge,#to_be_send_number_badge").hide("slow");
			$("#on_sale_number_badge").html(json.on_sale_number);
			$("#to_be_send_number_badge").html(json.to_be_send_number);
			$("#on_sale_number_badge,#to_be_send_number_badge").show("slow");
		}
	},
	//返回类型
	"json");
</script>
