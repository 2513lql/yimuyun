<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="format-detection" content="email=no"/>
    <title>账户授权</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signDeta.css">
</head>
<body>
<header>
    <span></span>
    <h1>账户授权</h1>
    <b>验证</b>
</header>
<section>
    <!-- 签收成功 将隐藏的样式去掉即可-->
    <div class="deta_box" style="display:none">
        <span class="success_info"></span>
        <p>签收成功</p>
    </div>

    <!-- 失败-->
    <div class="deta_box error_box">
        <span class="error_info"></span>
        <p>您的手机账户未被授权
            请联系伊牧云管理人员
        </p>
    </div>
</section>

<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.i18n.properties-min-1.0.9.js"></script>
<script src="${pageContext.request.contextPath}/js/setfontsize_log.js"></script>

</body>
</html>