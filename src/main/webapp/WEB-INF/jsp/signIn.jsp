<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no/">
	<meta name="format-detection" content="telephone=no"/>
    <meta name="format-detection" content="email=no"/>
    <title>物流签收</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/signIn.css">
</head>
<body id="signIn">
	<header>
		<span></span>
		<h1>物流签收</h1>
		<b id="verify">验证</b>
	</header>
	<section>

		<div class="iphone_number iphone_box">
			<span>手机号</span>
			<p><input id="phone" type="text" placeholder="请输入手机号"></p>
			
		</div>
		<div class="iphone_number">
			<span>验证码</span>
			<p><input id="code" type="text" placeholder="请输入验证码"></p>
			<button id="getCode">获取验证码</button>
			<button id="countDown" style="display: none"><span id="seconds">60</span>秒后重发</button>
		</div>
		
	</section>
	<!-- 遮罩 -->
	<div class="dialog" id="wrong" style="display: none">
		<div>验证码错误</div>
	</div>

	<!-- 遮罩 -->
	<div class="dialog" id="noPhone" style="display: none">
		<div>请输入手机号</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/setfontsize_log.js"></script>
<script src="${pageContext.request.contextPath}/event/signIn.js"></script>

</html>