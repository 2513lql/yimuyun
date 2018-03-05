<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
	<meta name="format-detection" content="telephone=no"/>
    <meta name="format-detection" content="email=no"/>
	<title>物流签收详情</title>>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.png" type="image/x-icon">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/signDetail.css">
</head>
<body>
	<header>
		<span></span>
		<h1>物流签收详情</h1>
		<b>验证</b>
	</header>
	<input id="packingId" type="hidden" value="${result.get("packingId")}" />

	<section>
		<ul>
			<li>
				<span>包装名称</span>
				<b>${result.get("packingName")}</b>
			</li>
			<li>
				<span>合计</span>
				<b>${result.get("packingNum")}件</b>
			</li>
		</ul>
			
		
		
		<div class="sign_title">包装货物</div>
		<ul>
			<c:forEach var="item" items="${result['packing']}">
				<li>
					<span>${item.get("part")}</span>
					<b>${item.get("weight")}公斤</b>
				</li>
			</c:forEach>

		</ul>	
	</section>
	<footer id="receive">
		签收
	</footer>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.i18n.properties-min-1.0.9.js"></script>
	<script src="${pageContext.request.contextPath}/js/setfontsize_log.js"></script>
	<script src="${pageContext.request.contextPath}/event/receive.js"></script>
</body>
</html>