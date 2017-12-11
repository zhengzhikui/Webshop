<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>订单页面</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="./网上商城/index.htm"> <img
					src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.jpg"
					alt="silence商城" />
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="${pageContext.request.contextPath}/image/header.jpg"
					width="320" height="50" alt="正品保障" title="正品保障" />
			</div>
		</div>
		<%@ include file="menu.jsp"%>
	</div>

	<div class="container cart">
		<div class="span24">
			<div>
				<ul>
					<li class="current"></li>
					<li><b>我的订单</b></li>
				</ul>
			</div>
			<table>
				<tbody>
					<c:forEach var="order" items="${orders}">
						<tr>
							<th colspan="5">订单编号:<c:out value="${order.oid}" />&nbsp;&nbsp;&nbsp;&nbsp;
								订单金额:<font color="red"><c:out value="${order.total }" /></font>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<c:if test="${order.state == 1}">
									<a
										href="${ pageContext.request.contextPath }/findByOid/<c:out value="${order.oid}" />">
										<font color="red">付款</font>
									</a>
								</c:if>
								<c:if test="${order.state == 2}">
									已付款
								</c:if>
								<c:if test="${order.state == 3}">
									<a href="${ pageContext.request.contextPath }/updateState/<c:out value="${order.oid}" />">确认收货</a>
								</c:if>
								<c:if test="${order.state == 4}">
									交易成功
								</c:if>
							</th>
						</tr>
						<tr>
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<c:forEach var="orderItem" items="${order.orderItems}">
							<tr>
								<td width="60"><a
									href="${ pageContext.request.contextPath }/findByPid/<c:out value="${orderItem.product.pid}"/>">
										<img
										src="${ pageContext.request.contextPath }/<c:out value="${orderItem.product.image}"/>" />
								</a></td>
								<td><c:out value="${ orderItem.product.pname}" /></td>
								<td><c:out value="${orderItem.product.shop_price}" /></td>
								<td class="quantity" width="60"><c:out
										value="${orderItem.count}" /></td>
								<td width="140"><span class="subtotal">￥<c:out
											value="${orderItem.subtotal}" />
								</span></td>
							</tr>
						</c:forEach>
					</c:forEach>
					<tr>
						<th colspan="5">
							<div class="pagination">
								<span>第 <c:out value="${page}" />/<c:out
										value="${count}" />页
								</span>
								<!-- 首页 -->
								<span><a class="firstPage"
									href="${pageContext.request.contextPath}/findOrderByUid/1"></a></span>
								<c:if test="${page != 1}">
									<span><a class="previousPage"
										href="${pageContext.request.contextPath}/findOrderByUid/<c:out value="${page-1}"/>"></a></span>
								</c:if>
								<c:forEach var="i" begin="1" end="${count }">
									<span> <!-- 如果是当前页则不能够点击 --> <c:if test="${i == page }">
											<span class="currentPage">${page }</span>
										</c:if> <c:if test="${i != page }">
											<a
												href="${pageContext.request.contextPath}/findOrderByUid/<c:out value="${i}"/>">
												<c:out value="${i}" />
											</a>
										</c:if>
									</span>
								</c:forEach>
								<!-- 下一页 -->
								<c:if test="${page !=count }">
									<span><a class="nextPage"
										href="${pageContext.request.contextPath}/findOrderByUid/<c:out value="${page+1}"/>"></a></span>
								</c:if>
								<!-- 尾页 -->
								<a class="lastPage"
									href="${pageContext.request.contextPath}/findOrderByUid/<c:out value="${count}"/>"></a>
							</div>
						</th>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img
					src="${pageContext.request.contextPath}/image/r___________renleipic_01/footer.jpg"
					alt="我们的优势" title="我们的优势" height="52" width="950" />
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a href="#">关于我们</a> |</li>
				<li><a href="#">联系我们</a> |</li>
				<li><a href="#">诚聘英才</a> |</li>
				<li><a href="#">法律声明</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a target="_blank">支付方式</a> |</li>
				<li><a target="_blank">配送方式</a> |</li>
				<li><a>SHOP++官网</a> |</li>
				<li><a>SHOP++论坛</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
		</div>
	</div>
</body>
</html>