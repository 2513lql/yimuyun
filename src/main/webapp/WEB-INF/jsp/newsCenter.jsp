<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>新闻中心</title>
    <base href="http://139.129.233.104/yimuyun_web/">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xinwen.css">
</head>
<body>

<div class="div">
    <!--头部-->
    <div class="header">
        <div class="left"><img src="${pageContext.request.contextPath}/img/public/1.png" /></div>
        <ul class="center">
            <li><a href="${pageContext.request.contextPath}/home" >首页</a></li>
            <li><a href="${pageContext.request.contextPath}/news/center" class="selected">新闻中心</a></li>
            <li><a href="${pageContext.request.contextPath}/trace">追溯防伪查询</a></li>
            <li><a href="${pageContext.request.contextPath}/muslim">清真文化</a></li>
            <li><a href="${pageContext.request.contextPath}/about">关于我们</a></li>
            <li><a href="${pageContext.request.contextPath}/join">加入我们</a></li>
        </ul>
        <div class="right">
            <div class="top"><img src="${pageContext.request.contextPath}/img/public/2.png" /><span>咨询热线</span></div>
            <div class="bottom"> <c:out value="${map['phoneNumber']}"></c:out></div>
        </div>
    </div>
    <!--主体-->
    <div class="main">
        <div class="I">
            <h2>新闻中心</h2>
        </div>
        <div class="phone-text">
    <c:forEach items="${map['topNews']}" var="news">
        <dl>
            <dt><a href="${pageContext.request.contextPath}/news/${news.id}"><img src="${news.picture}"/></a></dt>
            <dd>
                <h3>${news.title}</h3>
                <p>${news.digest}...</p>
            </dd>
        </dl>
    </c:forEach>
            <%--<dl>--%>
                <%--<dt><a href="erjiye1.html"><img src="img/index/6.png"/></a></dt>--%>
                <%--<dd>--%>
                    <%--<h3>世界四大养羊牧场 中国有三个</h3>--%>
                    <%--<p>为了能让老百姓吃上健康放心的好食品,对肉食品的...</p>--%>
                <%--</dd>--%>
            <%--</dl>--%>
            <%--<dl>--%>
                <%--<dt><a href="erjiye1.html"><img src="img/index/7.png"/></a></dt>--%>
                <%--<dd>--%>
                    <%--<h3>哈萨克斯坦优质肉类有望上架中国</h3>--%>
                    <%--<p>伊萨耶娃说:在出口肉类产品方面，我们有一定的优...</p>--%>
                <%--</dd>--%>
            <%--</dl>--%>
            <%--<dl>--%>
                <%--<dt><a href="erjiye1.html"><img src="img/index/8.png"/></a></dt>--%>
                <%--<dd>--%>
                    <%--<h3>云南销毁600余吨“僵尸肉” 涉多种肉类</h3>--%>
                    <%--<p>公安官兵将数桶汽油浇在非法走私入境的“僵尸肉”…</p>--%>
                <%--</dd>--%>
            <%--</dl>--%>
        </div>
        <div class="more"><a href="${pageContext.request.contextPath}/news/list">更多></a></div>
        <div class="I">
            <h2>行业快讯</h2>
        </div>
        <div class="liebiao">
            <div class="liebai">
                <ul>
                    <c:forEach items="${map['zixuanList1']}" var="news">
                    <li><a href="${pageContext.request.contextPath}/news/${news.id}"><b>${news.title}</b><span>${news.newsTime}</span></a></li>
                    </c:forEach>
                    <%--<li><a href="erjiye1.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                    <%--<li><a href="erjiye1.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                    <%--<li><a href="erjiye1.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                    <%--<li><a href="erjiye1.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                    <%--<li><a href="erjiye1.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                    <%--<li><a href="erjiye1.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                    <%--<li><a href="erjiye1.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                </ul>
            </div>
            <div class="liebai1">
                <ul>
                    <c:forEach items="${map['zixuanList2']}" var="news">
                        <li><a href="${pageContext.request.contextPath}/news/${news.id}"><b>${news.title}</b><span>${news.newsTime}</span></a></li>
                    </c:forEach>
                    <%--<li><a href="erjiye2.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                    <%--<li><a href="erjiye2.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                    <%--<li><a href="erjiye2.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                    <%--<li><a href="erjiye2.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                    <%--<li><a href="erjiye2.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                    <%--<li><a href="erjiye2.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                    <%--<li><a href="erjiye2.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                    <%--<li><a href="erjiye2.html"><b>舌尖上的美食 | 世界四大养羊牧场 中国有三个</b><span>2017年5月13日</span></a></li>--%>
                </ul>
            </div>
        </div>
        <div class="more"><a href="${pageContext.request.contextPath}/news/more">更多></a></div>
    </div>
    <!--底部-->
    <div class="footer">
        <div class="top">
            <div class="left">
                <div class="left-top"><a href="http://www.boc.cn/">中国银联</a> | <a href="http://www.bankofnx.com.cn/portal/zh_CN/home/index.html">宁夏银行</a> | <a href="http://www.tianyancha.com/company/2958336768">杨哈吉健康食品有限公司</a></div>
                <div class="left-bottom">
                    <p>Copyright@2010,All Rights Reserved　宁夏伊牧云农林牧科技开发有限公司</p>
                    <p>版权所有 京ICP备11007834号 公安备案号:11011502002638</p>
                </div>
            </div>
            <div class="right">
                <div class="right-top"><c:out value="${map['phoneNumber']}"></c:out></div>
                <div class="right-bottom">
                    <div><img src="${pageContext.request.contextPath}/img/index/3.png" alt=""><span>咨询热线</span></div>
                </div>
            </div>
        </div>
        <div class="bootom"><span>引领科技风尚，护航农牧发展</span></div>
    </div>
    <div class="totop"><div class="return_top"></div></div>
</div>

<script src="${pageContext.request.contextPath}/js/public.js"></script>
</body>
</html>
