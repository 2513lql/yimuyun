<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta content="width=device-width,initial-scale=1,minimum-scale=1;maximum-scale=1,user-scalable=no" name="viewport" id="viewport"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/erjiye2.css">
</head>
<head>
    <title>Title</title>
</head>
<body>

<div class="div">
    <!--头部-->
    <div class="header">
        <div class="left"><img src="${pageContext.request.contextPath}/img/public/1.png" /></div>
        <ul class="center">
            <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
            <li><a href="${pageContext.request.contextPath}/news/center" class="selected">新闻中心</a></li>
            <li><a href="${pageContext.request.contextPath}/trace">追溯防伪查询</a></li>
            <li><a href="${pageContext.request.contextPath}/muslim">清真文化</a></li>
            <li><a href="${pageContext.request.contextPath}/about">关于我们</a></li>
            <li><a href="${pageContext.request.contextPath}/join">加入我们</a></li>
        </ul>
        <div class="right">
            <div class="top"><img src="${pageContext.request.contextPath}/img/public/2.png" /><span>咨询电话</span></div>
            <div class="bottom">${news.phoneNumber}</div>
        </div>
    </div>

    <!--主体-->
    <div class="main">
        <div class="I">
            <%--<h2>哈萨克斯坦优质肉类有望上架中国</h2>--%>
            <h2>${news.title}</h2>
        </div>
        <div class="text">
            <%--<p>05-23 20:44：13 小煎饼。</p>--%>
            <p>${news.newsTime}   ${news.author}</p>
        </div>
        <div class="main2">
            <p>
                ${news.body}
            </p>
        </div>
        <%--<div class="main2">--%>
            <%--<p> 农业部副部长古丽米拉?伊萨耶娃26日在阿斯塔纳举行的一场新闻发布会上表示，今年年底，哈萨克斯坦安全优质肉类有望上架中国大型商场。伊萨耶娃说:"在出口肉类产品方面，我们有一定的优势。两国相关部门就哈萨克斯坦肉类出口中国的审查认证工作和运输问题举行多次谈判，并达成共识，这标志着政府层面的程序已完成大部分，近期有望签署相关的协定。我们对中国市场有信心，首批安全优质肉类有望年底正式上架中国大型商场。"</p>--%>
        <%--</div>--%>
        <%--<div class="phone">--%>
            <%--<img src="${pageContext.request.contextPath}/img/index/rou1.png" />--%>
        <%--</div>--%>
        <%--<div class="main2">--%>
            <%--<p> 伊萨耶娃说:"在出口肉类产品方面，我们有一定的优势。两国相关部门就哈萨克斯坦肉类出口中国的审查认证工作和运输问题举行多次谈判，并达成共识，这标志着政府层面的程序已完成大部分，近期有望签署相关的协定。我们对中国市场有信心，首批安全优质肉类有望年底正式上架中国大型商场。"伊萨耶娃说:"在出口肉类产品方面，我们有一定的优势。两国相关部门就哈萨克斯坦肉类出口中国的审查认证工作和运输问题举行多次谈判，并达成共识，这标志着政府层面的程序已完成大部分，近期有望签署相关的协定。我们对中国市场有信心，首批安全优质肉类有望年底正式上架中国大型商场。"伊萨耶娃说:"在出口肉类产品方面，我们有一定的优势。两国相关部门就哈萨克斯坦肉类出口中国的审查认证工作和运输问题举行多次谈判，并达成共识，这标志着政府层面的程序已完成大部分，近期有望签署相关的协定。我们对中国市场有信心，首批安全优质肉类有望年底正式上架中国大型商场。"伊萨耶娃说:"在出口肉类产品方面，我们有一定的优势。两国相关部门就哈萨克斯坦肉类出口中国的审查认证工作和运输问题举行多次谈判，并达成共识，这标志着政府层面的程序已完成大部分，近期有望签署相关的协定。我们对中国市场有信心，首批安全优质肉类有望年底正式上架中国大型商场。"</p>--%>
        <%--</div>--%>
        <%--<div class="main2">--%>
            <%--<p> 伊萨耶娃说:"在出口肉类产品方面，我们有一定的优势。两国相关部门就哈萨克斯坦肉类出口中国的审查认证工作和运输问题举行多次谈判，并达成共识，这标志着政府层面的程序已完成大部分，近期有望签署相关的协定。我们对中国市场有信心，首批安全优质肉类有望年底正式上架中国大型商场。</p>--%>
        <%--</div>--%>
    </div>
    <!--底部-->
    <div class="footer">
        <div class="top">
            <div class="left">
                <div class="left-top">中国银联 | 宁夏银行 | 杨哈吉健康食品有限公司</div>
                <div class="left-bottom">
                    <p>Copyright@2010,All Rights Reserved　宁夏伊牧云农林牧科技开发有限公司</p>
                    <p>版权所有 京ICP备11007834号 公安备案号:11011502002638</p>
                </div>
            </div>
            <div class="right">
                <div class="right-top">${news.phoneNumber}</div>
                <div class="right-bottom">
                    <div><img src="${pageContext.request.contextPath}/img/index/3.png" alt=""><span>咨询热线</span></div>
                </div>
            </div>
        </div>
        <div class="bootom"><span>引领科技风尚，护航农牧发展</span></div>
    </div>
</div>

</body>
</html>
