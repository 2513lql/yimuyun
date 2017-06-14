<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta content="width=device-width,initial-scale=1,minimum-scale=1;maximum-scale=1,user-scalable=no" name="viewport" id="viewport"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/women.css">
</head>
<body>
<div class="div">
    <!--头部-->
    <div class="header">
        <div class="left"><img src="${pageContext.request.contextPath}/img/public/1.png" /></div>
        <ul class="center">
            <li><a href="${pageContext.request.contextPath}/home" >首页</a></li>
            <li><a href="${pageContext.request.contextPath}/news/center">新闻中心</a></li>
            <li><a href="${pageContext.request.contextPath}/trace">追溯防伪查询</a></li>
            <li><a href="${pageContext.request.contextPath}/muslim">清真文化</a></li>
            <li><a href="${pageContext.request.contextPath}/about" class="select">关于我们</a></li>
            <li><a href="${pageContext.request.contextPath}/join">加入我们</a></li>
        </ul>
        <div class="right">
            <div class="top"><img src="${pageContext.request.contextPath}/img/public/2.png" /><span>咨询电话</span></div>
            <div class="bottom"><c:out value="${map['phoneNumber']}"></c:out></div>
        </div>
    </div>
    <!--主体-->
    <div class="nav">
        <ul>
            <li class="select"><a href="javascript:void(0)">组织框架</a></li>
            <li><a href="javascript:void(0)">发展历程</a></li>
            <li><a href="javascript:void(0)">公司荣誉</a></li>
        </ul>
    </div>
    <div class="main">
        <div class="I">
            <h2>组织框架</h2>
        </div>
        <div class="phone">
            <img src="${pageContext.request.contextPath}/wenhuaimg/1c.png" />
        </div>
        <div class="main2">
            <p> 宁夏伊牧云农林牧科技开发有限公司成立于2016年4月，是一家以电子商务，软件开发服务为主营业务的现代化信息公司。公司目前拥有研发与管理为一体的年轻团队，并借助互联网的力量与物联网的发展趋势，建设伊牧云牧场项目，将传统农牧业与现代化信息技术有机结合，进行牛羊肉产品质量追溯、活畜在线交易、牛羊投资认领及相关软硬件营销业务，从而实现传统农牧业产业升级。
            </p>
            <p>公司自成立以来，专心于建设伊牧云牧场项目，现已完成部分平台的开发，在宁夏同心、盐池，甘肃天祝、高台，青海海北等地发展养殖企业并签订大量合作协议，对部分养殖企业也已完成相关硬件设备的安装。目前与中国银联、宁夏银行、杨哈吉健康食品有限公司、宁夏部分大型屠宰企业、餐饮企业等达成合作关系。</p>
        </div>
    </div>
    <div class="main" style="display:none;">
        <div class="I">
            <h2>发展历程</h2>
        </div>
        <div class="phone1">
            <c:forEach items="${map['companyTopNews']}" var="companyNew">
                <img src="${companyNew.picture}" />
            </c:forEach>
            <%--<img src="${pageContext.request.contextPath}/wenhuaimg/2c.png" />--%>
            <%--<img src="${pageContext.request.contextPath}/wenhuaimg/3c.png" />--%>
            <%--<img src="${pageContext.request.contextPath}/wenhuaimg/4c.png" />--%>
        </div>
        <div class="li">
            <c:forEach items="${map['companyNews']}" var="companyNew">
                <li>${companyNew.body}</li>
            </c:forEach>
            <%--<li> 2016年4月 宁夏伊牧云农林牧科技开发有限公司成立</li>--%>
            <%--<li> 2016年4月 宁夏伊牧云农林牧科技开发有限公司成立</li>--%>
            <%--<li> 2016年4月 宁夏伊牧云农林牧科技开发有限公司成立</li>--%>
            <%--<li> 2016年4月 宁夏伊牧云农林牧科技开发有限公司成立</li>--%>
            <%--<li> 2016年4月 宁夏伊牧云农林牧科技开发有限公司成立</li>--%>
            <%--<li> 2016年4月 宁夏伊牧云农林牧科技开发有限公司成立</li>--%>
        </div>
    </div>
    <div class="main" style="display:none;">
        <div class="I">
            <h2>公司荣誉</h2>
        </div>
        <div class="phone-text">
            <dl>
                <dt><a href="erjiye1.html"><img src="${pageContext.request.contextPath}/img/index/6.png"/></a></dt>
                <dd>
                    <p>为了能让老百姓吃上健康放心的好食品</p>
                </dd>
            </dl>
            <dl>
                <dt><a href="erjiye1.html"><img src="${pageContext.request.contextPath}/img/index/7.png"/></a></dt>
                <dd>
                    <p>伊萨耶娃说:在出口肉类产品方面</p>
                </dd>
            </dl>
            <dl>
                <dt><a href="erjiye1.html"><img src="${pageContext.request.contextPath}/img/index/8.png"/></a></dt>
                <dd>
                    <p>公安官兵将数桶汽油浇在非法</p>
                </dd>
            </dl>
        </div>
        <div class="phone-text">
            <dl>
                <dt><a href="erjiye1.html"><img src="${pageContext.request.contextPath}/img/index/6.png"/></a></dt>
                <dd>
                    <p>为了能让老百姓吃上健康放心的好食品</p>
                </dd>
            </dl>
            <dl>
                <dt><a href="erjiye1.html"><img src="${pageContext.request.contextPath}/img/index/7.png"/></a></dt>
                <dd>
                    <p>伊萨耶娃说:在出口肉类产品方面</p>
                </dd>
            </dl>
            <dl>
                <dt><a href="erjiye1.html"><img src="${pageContext.request.contextPath}/img/index/8.png"/></a></dt>
                <dd>
                    <p>公安官兵将数桶汽油浇在非法走私</p>
                </dd>
            </dl>
        </div>
        <div class="phone-text">
            <dl>
                <dt><a href="erjiye1.html"><img src="img/index/6.png"/></a></dt>
                <dd>
                    <p>为了能让老百姓吃上健康放心的好食品</p>
                </dd>
            </dl>
            <dl>
                <dt><a href="erjiye1.html"><img src="img/index/7.png"/></a></dt>
                <dd>
                    <p>伊萨耶娃说:在出口肉类产品方面</p>
                </dd>
            </dl>
            <dl>
                <dt><a href="erjiye1.html"><img src="img/index/8.png"/></a></dt>
                <dd>
                    <p>公安官兵将数桶汽油浇在非法走私</p>
                </dd>
            </dl>
        </div>
        <div class="page">
            <a href="">
                <</a><a class="current">1</a><a>2</a><a>3</a><span>下一页</span><i>共3页</i></div>
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
                <div class="right-top"><c:out value="${map['phoneNumber']}"></c:out></div>
                <div class="right-bottom">
                    <div><img src="${pageContext.request.contextPath}/img/index/3.png" alt=""><span>咨询热线</span></div>
                </div>
            </div>
        </div>
        <div class="bootom"><span>引领科技风尚，护航农牧发展</span></div>
    </div>
</div>


<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/women.js"></script>
</body>
</html>
