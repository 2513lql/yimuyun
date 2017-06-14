<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta content="width=device-width,initial-scale=1,minimum-scale=1;maximum-scale=1,user-scalable=no" name="viewport" id="viewport"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/join.css">
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
            <li><a href="${pageContext.request.contextPath}/home" >首页</a></li>
            <li><a href="${pageContext.request.contextPath}/news/center">新闻中心</a></li>
            <li><a href="${pageContext.request.contextPath}/trace">追溯防伪查询</a></li>
            <li><a href="${pageContext.request.contextPath}/muslim">清真文化</a></li>
            <li><a href="${pageContext.request.contextPath}/about">关于我们</a></li>
            <li><a href="${pageContext.request.contextPath}/join" class="select">加入我们</a></li>
        </ul>
        <div class="right">
            <div class="top"><img src="${pageContext.request.contextPath}/img/public/2.png" /><span>咨询电话</span></div>
            <div class="bottom">${phoneNumber}</div>
        </div>
    </div>

    <!--主体-->
    <div class="main">
        <h2>合作流程示意图</h2>
        <div class="process">
            <img src="${pageContext.request.contextPath}/img/join/4.png" alt="">
        </div>
        <div class="introduction">宁夏伊牧云农林牧科技开发有限公司成立于2016年4月，是一家以电子商务，软件开发服务为主营业务的现代化信息公司。公司目前拥有研发与管理为一体的年轻团队，并借助互联网的力量与物联网的发展趋势，建设伊牧云牧场项目，将传统农牧业与现代化信息技术有机结合，进行牛羊肉产品质量追溯、活畜在线交易、牛羊投资认领及相关软硬件营销业务，从而实现传统农牧业产业升级。</div>
        <div class="information">
            <h3>您好，如有意向与我们合作请填写如下信息</h3>
            <div class="information-main">
                <div class="left">
                    <p>(屠宰加工或餐饮企业申请)</p>
                    <label for=""><span>企业类型：</span>
                        <input type="text">
                    </label>
                    <label for=""><span>企业名称：</span>
                        <input type="text">
                    </label>
                    <label for=""><span>企业地址:</span>
                        <input type="text">
                    </label>
                    <label for=""><span>联系电话:</span>
                        <input type="text">
                    </label>
                    <label for=""><span>联系人:</span>
                        <input type="text">
                    </label>
                    <input type="button" value="提交信息" class="btn">
                </div>
                <div class="right">
                    <form action="">
                        <p>(屠宰加工或餐饮企业申请)</p>
                        <label for=""><span>养殖单位名称：</span>
                            <input type="text">
                        </label>
                        <label for=""><span>养殖规模:</span>
                            <input type="text">
                        </label>
                        <label for=""><span>养殖类别:</span>
                            <input type="text">
                        </label>
                        <label for=""><span style="float:left;">养殖场照片:</span>
                            <div class="farm-photos">
                                <div class="upload-photos">
                                    <input type="file" class="upload" name="bannerUrl" />
                                </div>
                                <div class="photos"></div>
                            </div>
                        </label>
                        <label for=""><span>联系电话:</span>
                            <input type="text">
                        </label>
                        <input type="button" value="提交信息" class="btn">
                    </form>
                </div>
            </div>
            <div class="I">
                <h2>联系方式</h2>
            </div>
            <div class="text">
                <p>电话 ${phoneNumber}</p>
                <p>地址 宁夏路23号伊牧云农林牧科技</p>
            </div>
            <div class="J">
                <h2>留言反馈</h2>
            </div>
            <div class="text">
                <p>对您给予的帮助和支持，深表感谢！</p>
            </div>
            <div class="liuyan">
                <div class="wenti">
                    <select name="" id="">
                        <option placeholder="问题类型">问题类型</option>
                    </select>
                </div>
                <div class="fankui">
                    <textarea name="yj" cols="20" rows="5" placeholder="在这里描述你遇到的问题"></textarea>
                </div>
                <div class="feedback-photos">
                    <div class="upload-photos">
                        <input type="file" class="upload" />
                    </div>
                    <div class="photos"></div>
                </div>
                <div class="lianxi">
                    <input type="text" placeholder="你的联系方式">
                </div>
                <div class="tijiao">
                    <input type="button" value="提交问题">
                </div>
            </div>
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
                    <div class="right-top">${phoneNumber}</div>
                    <div class="right-bottom">
                        <div><img src="${pageContext.request.contextPath}/img/public/3.png" alt=""><span>咨询热线</span></div>
                    </div>
                </div>
            </div>
            <div class="bootom"><span>引领科技风尚，护航农牧发展</span></div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/join.js"></script>
</body>
</html>
