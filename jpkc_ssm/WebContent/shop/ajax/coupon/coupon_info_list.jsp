<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="line-big">
	<div class="xl12">
		<div class="panel border-back" id="write_goods_info_div">
			<div class="panel-foot bg-yellow-light border-back">
				<div class="line-big">
					<div class="xl3 text-center border-small border-right border-blue">优惠券信息</div>
					<div class="xl1 text-center border-small border-right border-blue">优惠信息</div>
					<div class="xl2 text-center border-small border-right border-blue">使用开始-结束时间</div>
					<div class="xl2 text-center border-small border-right border-blue">抢购开始-结束时间</div>
					<div class="xl1 text-center border-small border-right border-blue">当前数量</div>
					<div class="xl1 text-center border-small border-right border-blue">创建时间</div>
					<div class="xl2 text-center">操作</div>
				</div>
			</div>
			<ul class="list-group list-striped">
				<c:forEach items="${couponList}" var="c">
					<li id="c_${c.couponId }">
						<div class="line-big">
							<div class="xl3 text-left">
								<h4 title="${c.couponTips }">
									<strong>${c.couponName }</strong> 
									<small>(编号:${c.couponId })</small>
								</h4>
								<c:if test="${c.couponTips!=null&&c.couponTips!='' }">
									<h5>${c.couponTips}</h5>
								</c:if>
								<h6><p>抢购链接:(${basePath}coupon/${c.couponId })</p></h6>
								
							</div>
							<div class="xl1 text-center">
								<c:choose>
									<c:when test="${c.couponType=='满减' }">
									满${c.param1 }减${c.param2 }元
									</c:when>
									<c:when test="${c.couponType=='立减' }">
									立减${c.param1 }元
									</c:when>
								</c:choose>
							</div>
							<div class="xl2 text-center">
								<fmt:formatDate value="${c.couponUseBeginTime }" pattern="yyyy-MM-dd HH:mm" />
								-
								<fmt:formatDate value="${c.couponUseEndTime }" pattern="yyyy-MM-dd HH:mm" />
							</div>
							<div class="xl2 text-center">
								<fmt:formatDate value="${c.couponSnapBeginTime }" pattern="yyyy-MM-dd HH:mm" />
								-
								<fmt:formatDate value="${c.couponSnapEndTime }" pattern="yyyy-MM-dd HH:mm" />
							</div>
							<div class="xl1 text-center">${c.couponNumber }</div>
							<div class="xl1 text-center">
								<fmt:formatDate value="${c.couponCreateTime }" pattern="yyyy-MM-dd HH:mm" />
							</div>
							<div class="xl2 text-center">
								<button class="coupon_need_update_button button button-little bg-blue" data-id="${c.couponId }">
									<span class="icon-pencil"></span> 修改
								</button>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
			<div class="panel-foot bg-white border-back" id="coupon_list_pages" data-url="pages_button" data-index="${page.currentIndex}" data-pages="${page.totalPages}" data-href="shop/show_coupon_info_list?i="></div>
		</div>
	</div>
</div>
<div class="clearfix G-MarginTop100"></div>

<div style="display: none;" id="goodsTypeJson">${goodsTypeJson }</div>
<div style="display: none;" id="k" data-value="${param.k }"></div>
<div style="display: none;" id="tid" data-value="${param.tid }"></div>
<div id="see_goods_detail"></div>
<script type="text/javascript" src="js/pintuer.js"></script>
<script type="text/javascript">
	$(function()
	{
		$(".coupon_need_update_button").click(function()
		{
			$("#admin_div").load("shop/shop_update_coupon?id=" + $(this).attr("data-id"), {}, function()
			{

			});
		});

		$("#coupon_list_pages").load($("#coupon_list_pages").attr("data-url"),
		{
			"page.currentIndex" : $("#coupon_list_pages").attr("data-index"),
			"page.totalPages" : $("#coupon_list_pages").attr("data-pages"),
			"page.href" : $("#coupon_list_pages").attr("data-href")
		}, function()
		{
		});
		$("#coupon_list_pages").on("click", "button[data-url]", function()
		{
			$("#admin_div").load(encodeURI($(this).attr("data-url")), {}, function()
			{
			});
		});

	});
</script>