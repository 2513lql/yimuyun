<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>关于我们</title>
    <base href="http://139.129.233.104/yimuyun_web/">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/women.css">
</head>
<body>
<input type="hidden" value="" id="currPage"/>
<input type="hidden" value="<c:out value="${map['totalCount']}"></c:out>" id="totalCount"/>
<input type="hidden" value="${pageContext.request.contextPath}" id="contextPath"/>
<div class="div">
    <!--头部-->
    <div class="header">
        <div class="left"><img src="${pageContext.request.contextPath}/img/public/1.png" /></div>
        <ul class="center">
            <li><a href="${pageContext.request.contextPath}/home" >首页</a></li>
            <li><a href="${pageContext.request.contextPath}/news/center">新闻中心</a></li>
            <li><a href="${pageContext.request.contextPath}/trace">追溯防伪查询</a></li>
            <li><a href="${pageContext.request.contextPath}/muslim">清真文化</a></li>
            <li><a href="${pageContext.request.contextPath}/about" class="selected">关于我们</a></li>
            <li><a href="${pageContext.request.contextPath}/join">加入我们</a></li>
        </ul>
        <div class="right">
            <div class="top"><img src="${pageContext.request.contextPath}/img/public/2.png" /><span>咨询热线</span></div>
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

        <div  class="main2">

        </div>
        <div class="main2">
            <p> 宁夏伊牧云农林牧科技开发有限公司成立于2016年，是一家集电子商务、软件开发、数字智能化平台运营服务为一体的物联网科技公司。公司本着“谋求长远合作，携手共同发展”的经营理念与畜牧行业精英企业、规模合作社建立了联盟体，并成立了产业商会和产业基金。运用物联网技术搭建的伊牧云平台，通过手机APP和PC网页两大客户端，把传统农牧业和互联网平台有机结合，开通牛羊肉质量追溯、互联网活畜交易、趣牧投个性认领、伊牧鲜电子商务和互联网金融桥等公共服务窗口，将牛羊肉一二三全产业链无缝融合。
            </p>
            <p>实现三大目标：<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;消费者吃到安全放心的高品质牛羊肉！<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;牛羊供需双方足不出户便可直接交易！<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;投资者可获得清晰透明、稳定的收益！<br>
            </p>
        </div>
    </div>
    <div class="main" style="display:none;">
        <div class="I">
            <h2>发展历程</h2>
        </div>
        <div>
            <p>
                ${map['companyNews'].body}
            </p>
        </div>
        <%--<div class="phone1">--%>
            <%--<c:forEach items="${map['companyTopNews']}" var="companyNew">--%>
                <%--<img src="${companyNew.picture}" />--%>
            <%--</c:forEach>--%>
            <%--&lt;%&ndash;<img src="${pageContext.request.contextPath}/wenhuaimg/2c.png" />&ndash;%&gt;--%>
            <%--&lt;%&ndash;<img src="${pageContext.request.contextPath}/wenhuaimg/3c.png" />&ndash;%&gt;--%>
            <%--&lt;%&ndash;<img src="${pageContext.request.contextPath}/wenhuaimg/4c.png" />&ndash;%&gt;--%>
        <%--</div>--%>
        <%--<div class="li">--%>
            <%--<c:forEach items="${map['companyNews']}" var="companyNew">--%>
                <%--<li>${companyNew.body}</li>--%>
            <%--</c:forEach>--%>
            <%--&lt;%&ndash;<li> 2016年4月 宁夏伊牧云农林牧科技开发有限公司成立</li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li> 2016年4月 宁夏伊牧云农林牧科技开发有限公司成立</li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li> 2016年4月 宁夏伊牧云农林牧科技开发有限公司成立</li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li> 2016年4月 宁夏伊牧云农林牧科技开发有限公司成立</li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li> 2016年4月 宁夏伊牧云农林牧科技开发有限公司成立</li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li> 2016年4月 宁夏伊牧云农林牧科技开发有限公司成立</li>&ndash;%&gt;--%>
        <%--</div>--%>
    </div>
    <div class="main" style="display:none;">
        <div id="companyHonors">
        <div class="I">
            <h2>公司荣誉</h2>
        </div>
        <c:forEach items="${map['page']}" var="news" varStatus="status">
            <c:if test="${status.index % 3 == 0}"><div class="phone-text"></c:if>
            <dl>
                <dt><img src="${news.picture}"/></dt>
                <dd>
                    <p>${news.name}</p>
                </dd>
            </dl>
            <c:if test="${status.index % 3 == 2}"></div></c:if>
        </c:forEach>
        <c:if test="${map['isThree'] == 0}"></div></c:if>
        </div>
        <div class="page">
            <div style="display: inline-block" id="callBackPager"></div><i class="totalPage">共<c:out value="${map['totalPage']}"></c:out>页</i>
    </div>
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
</body>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/women.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/extendPagination.js"></script>
<script type="application/javascript">
    var totalCount = $("#totalCount").val();
    var contextPath = $("#contextPath").val();
    var options = {
        totalCount : totalCount, //
        showCount : 3,
        limit : 9
    };
    function callBackPagination() {
        $('#callBackPager').extendPagination({
            totalCount: options.totalCount,
            showCount: options.showCount,
            limit: options.limit,
            callback: function (curr, limit, totalCount) {
                getNewsList(curr);
            }
        });
    }
    callBackPagination();

    function getNewsList(pageNo) {
        $.ajax({
            async: false,
            url:  contextPath +"/honor/page?pageNo="+pageNo,
            type: "get",
            dataType: "json",
            success: function (data) {
                renderNews(data['page']);
            }
        });
    }


    function  renderNews(page) {
        var news = '<div class="I"><h2>公司荣誉</h2></div>';
        var pageLength = page.length;
        for(var index in page){
            var item = page[index];
            if(index % 3 == 0){
                news += '<div class="phone-text">';
            }
            news += '<dl><dt><img src="' + contextPath +'/img/index/6.png"/></dt>';
            news += '<dd><p>'+ item.name + '</p>';
            news += '</dd></dl>';
            if (index % 3 == 2){
                news += '</div>';
            }
        }
        if(pageLength % 3 != 0){
            news += '</div>';
        }
        $("#companyHonors").html(news);
        $('body').scrollTop(0);
    }

</script>
</html>
