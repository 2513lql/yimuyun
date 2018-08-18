<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>伊牧云</title>
    <meta name="Keywords" content="追溯,牛羊追溯,防伪查询,伊牧云,云牧场追溯" />
    <meta itemprop="description" name="description" content="追溯、牛羊追溯、防伪查询、伊牧云、云牧场追溯" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>

<div class="div">
    <!--头部-->
    <div class="banner">
        <div class="shuffling">
            <ul class="slider">
                <%--<li><img src="${pageContext.request.contextPath}/img/index/11.png" /></li>--%>
                <%--<li><img src="${pageContext.request.contextPath}/img/index/2.png" /></li>--%>
                <%--<li><img src="${pageContext.request.contextPath}/img/index/1.png" /></li>--%>
                    <li><img src="${map['homePage'].picture1}" /></li>
                    <li><img src="${map['homePage'].picture2}" /></li>
                    <li><img src="${map['homePage'].picture3}" /></li>
            </ul>
            <ul class="num">
                <li class="on"></li>
                <li></li>
                <li></li>
            </ul>
        </div>
        <div class="header">
            <div class="left"><img src="${pageContext.request.contextPath}/img/public/1.png" /></div>
            <ul class="center">
                <li><a href="${pageContext.request.contextPath}/home" class="selected">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/news/center">新闻中心</a></li>
                <li><a href="${pageContext.request.contextPath}/trace">追溯防伪查询</a></li>
                <li><a href="${pageContext.request.contextPath}/muslim">清真文化</a></li>
                <li><a href="${pageContext.request.contextPath}/about">关于我们</a></li>
                <li><a href="${pageContext.request.contextPath}/join">加入我们</a></li>
            </ul>
            <div class="right">
                <div class="top"><img src="${pageContext.request.contextPath}/img/public/2.png" /><span>咨询热线</span></div>
                <div class="bottom">
                    <%--${homePage.telephoneNumber}--%>
                    <c:out value="${map['homePage'].telephoneNumber}"></c:out>
                    <%--<c:forEach items="${map}" var="entry">--%>
                        <%--<c:out value="${entry.key}" />--%>
                        <%--<c:out value="${entry.value}" />--%>
                    <%--</c:forEach>--%>
                </div>
            </div>
        </div>
    </div>

    <!--主体-->
    <div class="main">
        <div class="main1">
            <div class="main1-top">
                安全放心
            </div>
            <div class="main1-bottom">
                让消费者吃到真正安全放心的牛羊肉！
            </div>
        </div>
        <div class="phone">
            <div class="phone-left">
                <a><img src="${pageContext.request.contextPath}/img/index/1.png" /></a>
            </div>
            <div class="phone-right">
                <a><img src="${pageContext.request.contextPath}/img/index/2.png" /></a>
            </div>
        </div>
        <div class="main1">
            <div class="main1-top">
                在线交易
            </div>
            <div class="main1-bottom">
                让牛羊购买者足不出户便可实现安全交易！
            </div>
        </div>
        <div class="phone">
            <div class="phone-left">
                <a href="http://www.yimuyhc.com/"><img src="${pageContext.request.contextPath}/img/index/12.png" /></a>
            </div>
            <div class="phone-right">
                <a href="http://www.yimuyhc.com/"><img src="${pageContext.request.contextPath}/img/index/13.png" /></a>
            </div>
        </div>
        <div class="main1">
            <div class="main1-top">
                趣牧投
            </div>
            <div class="main1-bottom">
                发现有趣好玩平台，寻找全新理财模式，尽在趣牧投！
            </div>
        </div>
        <div class="phone">
            <div class="phone-left">
                <a href="http://www.yimuyrl.com"><img src="${pageContext.request.contextPath}/img/index/9.png" /></a>
            </div>
            <div class="phone-right">
                <a href="http://www.yimuyrl.com"><img src="${pageContext.request.contextPath}/img/index/10.png" /></a>
            </div>
        </div>
        <div class="main-bottom">
            公司新闻
        </div>
        <div class="phone-text">
            <c:forEach items="${map['homeNews']}" var="homeNew">
                <dl>
                    <dt><a href="${pageContext.request.contextPath}/news/${homeNew.id}"><img src="${homeNew.picture}"/></a></dt>
                    <dd>
                        <h3>${homeNew.title}</h3>
                        <p>${homeNew.digest}...</p>
                    </dd>
                </dl>
            </c:forEach>

            <%--<dl>--%>
                <%--<dt><a href="erjiye1.html"><img src="${pageContext.request.contextPath}/img/index/6.png"/></a></dt>--%>
                <%--<dd>--%>
                    <%--<h3>世界四大养羊牧场 中国有三个</h3>--%>
                    <%--<p>为了能让老百姓吃上健康放心的好食品,对肉食品的...</p>--%>
                <%--</dd>--%>
            <%--</dl>--%>
            <%--<dl>--%>
                <%--<dt><a href="erjiye1.html"><img src="${pageContext.request.contextPath}/img/index/7.png"/></a></dt>--%>
                <%--<dd>--%>
                    <%--<h3>哈萨克斯坦优质肉类有望上架中国</h3>--%>
                    <%--<p>伊萨耶娃说:在出口肉类产品方面，我们有一定的优...</p>--%>
                <%--</dd>--%>
            <%--</dl>--%>
            <%--<dl>--%>
                <%--<dt><a href="erjiye1.html"><img src="${pageContext.request.contextPath}/img/index/8.png"/></a></dt>--%>
                <%--<dd>--%>
                    <%--<h3>云南销毁600余吨“僵尸肉” 涉多种肉类</h3>--%>
                    <%--<p>公安官兵将数桶汽油浇在非法走私入境的“僵尸肉”…</p>--%>
                <%--</dd>--%>
            <%--</dl>--%>
        </div>
    </div>

    <!--底部-->
    <div class="footer">
        <div class="top">
            <div class="left">
                <div class="left-top"><a href="http://www.yimuyhc.com/">活畜交易平台</a> | <a href="http://www.yimuyrl.com/">趣牧投平台</a> | <a href="http://www.xn--nyqp2g2pza885ck6ds6gq7tl68h.com/">杨哈吉健康食品有限公司</a> | <a href="http://www.nxyhj.com/">杨哈吉农牧产业控股有限公司</a></div>
                <div class="left-bottom">
                    <p>Copyright@2010,All Rights Reserved　宁夏伊牧云农林牧科技开发有限公司</p>
                    <p>版权所有 ICP备案号：宁ICP备16001687号-1 <span class="security">公安备案号：</span>64032402000018</p>
                </div>
            </div>
            <div class="right">
                <div class="right-top"><c:out value="${map['homePage'].telephoneNumber}"></c:out></div>
                <div class="right-bottom">
                    <div><img src="${pageContext.request.contextPath}/img/public/3.png" alt=""><span>咨询热线</span></div>
                </div>
            </div>
        </div>
        <div class="bootom"><span>引领科技风尚，护航农牧发展</span></div>
    </div>
    <div class="totop"><div class="return_top"></div></div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/public.js"></script>
</body>
</html>