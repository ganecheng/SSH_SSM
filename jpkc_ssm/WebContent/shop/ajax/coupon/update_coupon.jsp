<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${coupon==null }">
	<h1 class="text-center G-MarginTop150">
		<span class="icon-frown-o"></span> 无法加载此页面
	</h1>
</c:if>
<c:if test="${coupon!=null }">
	<input type="hidden" id="couponId" value="${coupon.couponId }" />
	<div class="line-big" id="write_goods_info_div">
		<div class="xl1"></div>
		<div class="xl10">
			<div class="panel border-back">
				<div class="panel-body text-center">
					<h1>
						<strong>修改优惠券数量</strong>
					</h1>
				</div>
				<div class="panel-foot bg-white border-back">
					<div class="line-big G-MarginTopBottom20">
						<div class="xl6">
							<div class="label">
								<label for="shop_name">*优惠券名称(2-20个字)</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="couponName" value="${coupon.couponName }" readonly="readonly" />
							</div>
						</div>
						<div class="xl3">
							<div class="label">
								<label for="shop_min_limit">*优惠券数量(正整数)</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="couponNumber" value="${coupon.couponNumber }" data-regex="^[1-9]\d*$" />
							</div>
						</div>
					</div>
				</div>
				<div class="panel-foot bg-white">
					<div class="line-big G-MarginTopBottom20">
						<div class="xl4"></div>
						<div class="xl4 text-center">
							<button class="button border-blue" id="submit_coupon_button">提交优惠券信息</button>
						</div>
						<div class="xl4"></div>
					</div>
				</div>
			</div>

		</div>
		<div class="xl1"></div>
	</div>
</c:if>
<div id="add_success_div" class="G-MarginTop100" style="display: none;">
	<div class="line-big">
		<div class="xl3"></div>
		<div class="xl6 text-center">
			<h1 class="text-center">
				<span class="icon-check-circle text-yellow"></span> 提交优惠券信息成功了。
			</h1>
			<br />
			<p>
				<button class="button border-main click_go_to_nav_button" data-trigger-id="#sub_see_coupon_list">查看所有优惠券</button>
			</p>
		</div>
		<div class="xl3"></div>
	</div>
</div>

<div class="clearfix G-MarginTop100"></div>
<div style="display: none" id="time_temp_div"></div>
<script type="text/javascript">
	$(function()
	{


		var myDate = new Date();
		$("#time_temp_div").html(myDate.getHours() + "-" + myDate.getMinutes() + "-" + myDate.getSeconds() + "-" + myDate.getMilliseconds());

		$("#submit_coupon_button").click(function()
		{
			var couponId = $("#couponId").val();
			var couponNumber = $("#couponNumber").val();

			var tips = "";
			var tips_number = 1;
			$("input[data-regex]").each(function(i, dom)
			{
				var n = $(dom);
				if (new RegExp(n.attr("data-regex")).test(n.val()) == false)
				{
					tips += tips_number++ + " . \"" + n.val() + "\" 不满足输入要求;\n";
				}
			});
			if (tips.length > 0)
			{
				alert(tips + "\n请检查一下重新输入.");
				return false;
			}

			var submit_coupon_button_html = $("#submit_coupon_button").html();
			$.ajax(
			{
				url : "admin/m_update_coupon_do",
				type : "POST",
				dataType : "json",
				beforeSend : function(XMLHttpRequest)
				{
					$("#submit_coupon_button").attr("disabled", "disabled");
					$("#submit_coupon_button").html("正在提交优惠券信息中...");
				},
				data :
				{
					'coupon.couponId' : couponId,
					'coupon.couponNumber' : couponNumber
				},
				success : function(json, textStatus)
				{
					if (json.success == true)
					{
						$("#write_goods_info_div").slideUp();
						$("#add_success_div").slideDown(function()
						{
							$(".admin").animate(
							{
								scrollTop : 0
							}, 0);
						});

					}
					else
					{
						alert(json.info);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown)
				{
					alert("提交失败，请仔细检查您的输入是否满足要求。");
				},
				complete : function(XMLHttpRequest, textStatus)
				{
					$("#submit_coupon_button").removeAttr("disabled");
					$("#submit_coupon_button").html(submit_coupon_button_html);
				}
			});
		});
	});
</script>