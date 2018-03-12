<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>加入我们</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/join.css">
</head>
<body>
<input type="hidden" id="contextPath" value="${pageContext.request.contextPath}"/>
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
            <li><a href="${pageContext.request.contextPath}/join" class="selected">加入我们</a></li>
        </ul>
        <div class="right">
            <div class="top"><img src="${pageContext.request.contextPath}/img/public/2.png" /><span>咨询热线</span></div>
            <div class="bottom">${phoneNumber}</div>
        </div>
    </div>
    <iframe id="formiframe" name="nm_iframe" style="display:none;"></iframe>
    <!--主体-->
    <div class="main">
        <h2>合作流程示意图</h2>
        <div class="process">
            <img src="${pageContext.request.contextPath}/img/join/4.png" alt="">
        </div>
        <div class="introduction">宁夏伊牧云农林牧科技开发有限公司成立于2016年，是一家集电子商务、软件开发、数字智能化平台运营服务为一体的物联网科技公司。公司本着“谋求长远合作，携手共同发展”的经营理念与畜牧行业精英企业、规模合作社建立了联盟体，并成立了产业商会和产业基金。运用物联网技术搭建的伊牧云平台，通过手机APP和PC网页两大客户端，把传统农牧业和互联网平台有机结合，开通牛羊肉质量追溯、互联网活畜交易、趣牧投个性认领、伊牧鲜电子商务和互联网金融桥等公共服务窗口，将牛羊肉一二三全产业链无缝融合。<br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;实现三大目标：<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;消费者吃到安全放心的高品质牛羊肉！<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;牛羊供需双方足不出户便可直接交易！<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;投资者可获得清晰透明、稳定的收益！<br>
        </div>
        <%--<div class="introduction">宁夏伊牧云农林牧科技开发有限公司成立于2016年4月，是一家以电子商务，软件开发服务为主营业务的现代化信息公司。公司目前拥有研发与管理为一体的年轻团队，并借助互联网的力量与物联网的发展趋势，建设伊牧云牧场项目，将传统农牧业与现代化信息技术有机结合，进行牛羊肉产品质量追溯、活畜在线交易、牛羊投资认领及相关软硬件营销业务，从而实现传统农牧业产业升级。</div>--%>
        <div class="information">
            <h3>您好，如有意向与我们合作请填写如下信息</h3>
            <div class="information-main">
                <div class="left">
                    <p>(屠宰加工企业或终端销售单位申请)</p>
                    <label for=""><span>企业类型：</span>
                        <input id="enterpriseType" name="enterpriseType" type="text">
                    </label>
                    <label for=""><span>企业名称：</span>
                        <input id="slaughterName" name="name"  type="text">
                    </label>
                    <label for=""><span>企业地址:</span>
                        <input id="address" name="address" type="text">
                    </label>
                    <label for=""><span>联系电话:</span>
                        <input id="telephoneNumber" name="telephoneNumber" type="text" onkeypress="return event.keyCode>=48&&event.keyCode<=57">
                    </label>
                    <label for=""><span>联系人:</span>
                        <input id="contact" name="contact" type="text">
                    </label>
                    <input type="button" id="submitSlaughter" value="提交信息" class="btn">
                </div>
                <div class="right">
                    <form method="post" id="farmingForm" target="nm_iframe" enctype="multipart/form-data" action="${pageContext.request.contextPath}/apply/farming">
                        <p>(养殖单位申请)</p>
                        <label for=""><span>养殖单位名称：</span>
                            <input id="farmingName" name="name" type="text">
                        </label>
                        <label for=""><span>养殖规模:</span>
                            <input id="scale" name="scale" type="text">
                        </label>
                        <label for=""><span>养殖类别:</span>
                            <input id="type" name="type" type="text">
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
                            <input id="farmingTelephoneNumber" name="telephoneNumber" type="text" onkeypress="return event.keyCode>=48&&event.keyCode<=57">
                        </label>
                        <input type="button" value="提交信息" id="submitFarming" class="btn">
                    </form>
                </div>
            </div>
            <div class="I">
                <h2>联系方式</h2>
            </div>
            <div class="text">
                <p>电话： ${phoneNumber}</p>
                <p>地址： 宁夏同心县羊绒工业园区中国伊牧云·牧场</p>
            </div>
            <div class="J">
                <h2>留言反馈</h2>
            </div>
            <div class="text">
                <p>对您给予的帮助和支持，深表感谢！</p>
            </div>

            <div class="liuyan">
                <form method="post" id="messageForm" target="nm_iframe" enctype="multipart/form-data" action="${pageContext.request.contextPath}/apply/message">
                <%--<div class="wenti">--%>
                    <%--<select name="problemType" id="problemType">--%>
                        <%--<option selected placeholder="问题类型">问题类型</option>--%>
                    <%--</select>--%>
                <%--</div>--%>
                <div class="fankui">
                    <textarea name="describe" id="describe" cols="20" rows="5" placeholder="在这里描述您遇到的问题"></textarea>
                </div>
                <div class="feedback-photos">
                    <div class="upload-photos">
                        <input type="file" class="upload" name="bannerUrl"/>
                    </div>
                    <div class="photos"></div>
                </div>
                <div class="lianxi">
                    <input id="messageContact" name="contact" type="text" placeholder="您的联系方式" onkeypress="return event.keyCode>=48&&event.keyCode<=57">
                </div>
                <div class="tijiao">
                    <input type="button" id="submitMessage" value="提交问题">
                </div>
               </form>
            </div>
        </div>

        <!--底部-->
        <div class="footer">
            <div class="top">
                <div class="left">
                    <div class="left-top"><a href="http://www.yimuyhc.com/">活畜交易平台</a> | <a href="http://www.yimuyrl.com/">趣牧投平台</a> | <a href="http://www.xn--nyqp2g2pza885ck6ds6gq7tl68h.com/">杨哈吉健康食品有限公司</a> | <a href="http://www.nxyhj.com/">杨哈吉农牧产业控股有限公司</a></div>
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
    <div class="totop"><div class="return_top"></div></div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/join.js"></script>
<script src="${pageContext.request.contextPath}/event/joinEvent.js"></script>
<script src="${pageContext.request.contextPath}/js/public.js"></script>
</body>
</html>
