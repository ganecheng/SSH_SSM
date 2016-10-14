<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="line-big" id="write_goods_info_div">
	<div class="xl1"></div>
	<div class="xl10">
		<div class="panel border-back">
			<div class="panel-body text-center">
				<h1>
					<strong>添加优惠券</strong>
				</h1>
			</div>
			<div class="panel-foot bg-white border-back">
				<div class="line-big G-MarginTopBottom20">
					<div class="xl6">
						<div class="label">
							<label for="shop_name">*优惠券名称(2-20个字)</label>
						</div>
						<div class="field">
							<input type="text" class="input" id="couponName" value="${coupon.couponName }" data-regex="^\S.{0,18}\S$" />
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
				<div class="line-big G-MarginTopBottom20">
					<div class="xl6">
						<div class="label">
							<label for="shop_min_limit">优惠券提示(4-200字)</label>
						</div>
						<div class="field">
							<input type="text" class="input" id="couponTips" value="${coupon.couponTips }" data-regex="(^\S.{2,198}\S$)|(^\S{0}$)" />
						</div>
					</div>
					<div class="xl6"></div>
				</div>
				<div class="line-big G-MarginTopBottom20">
					<div class="xl6">
						<div class="label">
							<label for="shop_name">*优惠券类型(满减或立减)</label>
						</div>
						<div class="field">
							<select class="input" id="couponType">
								<option value="满减">满减</option>
								<option value="立减">立减</option>
							</select>
						</div>
					</div>
					<div class="xl3">
						<div class="label">
							<label for="shop_min_limit">*参数1(最多两位小数,单位:元)</label>
						</div>
						<div class="field">
							<input type="text" class="input" id="param1" value="${coupon.param1 }" data-regex="(^(0|[1-9][0-9]{0,9})(.[0-9]{1,2})?$)|(^\S{0}$)" />
						</div>
					</div>
					<div class="xl3">
						<div class="label">
							<label for="shop_min_limit">参数2(最多两位小数,单位:元)</label>
						</div>
						<div class="field">
							<input type="text" class="input" id="param2" value="${coupon.param2 }" data-regex="(^(0|[1-9][0-9]{0,9})(.[0-9]{1,2})?$)|(^\S{0}$)" />
						</div>
					</div>
				</div>
				<div class="line-big G-MarginTopBottom20">
					<div class="xl3">
						<div class="label">
							<label for="shop_name">*优惠券使用开始时间</label>
						</div>
						<div class="field">
							<div class="date form_datetime" data-date="">
								<input id="couponUseBeginTime" class="input form-control" size="16" type="text" value='' readonly>
								<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>
					<div class="xl3">
						<div class="label">
							<label for="shop_min_limit">*优惠券使用结束时间</label>
						</div>
						<div class="field">
							<div class="date form_datetime" data-date="">
								<input id="couponUseEndTime" class="input form-control" size="16" type="text" value='' readonly>
								<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>
					<div class="xl3">
						<div class="label">
							<label for="shop_min_limit">*优惠券抢购开始时间</label>
						</div>
						<div class="field">
							<div class="date form_datetime" data-date="">
								<input id="couponSnapBeginTime" class="input form-control" size="16" type="text" value='' readonly>
								<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>
					<div class="xl3">
						<div class="label">
							<label for="shop_min_limit">*优惠券抢购结束时间</label>
						</div>
						<div class="field">
							<div class="date form_datetime" data-date="">
								<input id="couponSnapEndTime" class="input form-control" size="16" type="text" value='' readonly>
								<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
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

		//日期选择器
		$('.form_datetime').datepicker(
		{
			format : "yyyy-mm-dd",
			startView : 3,
			todayBtn : "linked",
			clearBtn : true,
			language : "zh-CN",
			autoclose : true,
			todayHighlight : true,
			orientation : "top left"
		});

		var myDate = new Date();
		$("#time_temp_div").html(myDate.getHours() + "-" + myDate.getMinutes() + "-" + myDate.getSeconds() + "-" + myDate.getMilliseconds());

		$("#submit_coupon_button").click(function()
		{
			var couponName = $("#couponName").val();
			var couponNumber = $("#couponNumber").val();
			var couponTips = $("#couponTips").val();
			var couponType = $("#couponType").val();
			var param1 = $("#param1").val();
			var param2 = $("#param2").val();
			var couponUseBeginTime = $("#couponUseBeginTime").val();
			var couponUseEndTime = $("#couponUseEndTime").val();
			var couponSnapBeginTime = $("#couponSnapBeginTime").val();
			var couponSnapEndTime = $("#couponSnapEndTime").val();

			if (couponName.length <= 0 || couponNumber.length <= 0 || couponType.length <= 0 || param1.length <= 0 || couponUseBeginTime.length <= 0 || couponUseEndTime.length <= 0 || couponSnapBeginTime.length <= 0 || couponSnapEndTime.length <= 0)
			{
				alert("标有*的输入项都是必填项.")
				return false;
			}

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
				url : "admin/m_add_coupon_do",
				type : "POST",
				dataType : "json",
				beforeSend : function(XMLHttpRequest)
				{
					$("#submit_coupon_button").attr("disabled", "disabled");
					$("#submit_coupon_button").html("正在提交优惠券信息中...");
				},
				data :
				{
					'coupon.couponName' : couponName,
					'coupon.couponNumber' : couponNumber,
					'coupon.couponTips' : couponTips,
					'coupon.couponType' : couponType,
					'coupon.param1' : param1,
					'coupon.param2' : param2,
					'coupon.couponUseBeginTime' : couponUseBeginTime,
					'coupon.couponUseEndTime' : couponUseEndTime,
					'coupon.couponSnapBeginTime' : couponSnapBeginTime,
					'coupon.couponSnapEndTime' : couponSnapEndTime
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