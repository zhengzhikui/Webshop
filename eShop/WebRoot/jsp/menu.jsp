<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
			<c:if test="${sessionScope.user == null}">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a
					href="${ pageContext.request.contextPath }/userLogin">登录</a>|
				</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a
					href="${ pageContext.request.contextPath }/userRegister">注册</a>|
				</li>
			</c:if>
			<c:if test="${sessionScope.user != null}">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<c:out value="${user.username }"/>
				</li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a
					href="${ pageContext.request.contextPath }/findOrderByUid/1">我的订单</a>
					|
				</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a
					href="${ pageContext.request.contextPath }/quit">退出</a>|
				</li>
			</c:if>
			<li><a>会员中心</a> |</li>
			<li><a>购物指南</a> |</li>
			<li><a>关于我们</a></li>
		</ul>
	</div>
	<div class="cart">
		<a href="${pageContext.request.contextPath}/myCart">购物车</a>
	</div>
	<div class="phone">
		客服热线: <strong>96008/53277764</strong>
	</div>
</div>
<div class="span24">
	<ul class="mainNav">
		<li><a href="${ pageContext.request.contextPath }/index">首页</a>|</li>
		<c:forEach items="${sessionScope.cList}" var="c">
		   <li><a
				href="${ pageContext.request.contextPath }/findByCid/<c:out value="${c.cid}"/>/1">
				<c:out value="${c.cname}"></c:out> 
			  </a>
		   </li>
		</c:forEach>
	</ul>
</div>