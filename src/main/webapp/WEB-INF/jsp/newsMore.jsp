<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>新闻中心</title>
      <base href="http://www.yimuyzs.com/yimuyun_web/">
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css">
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public.css">
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/more.css">
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
                       <li><a href="${pageContext.request.contextPath}/news/center" class="selected">新闻中心</a></li>
                       <li><a href="${pageContext.request.contextPath}/trace">追溯防伪查询</a></li>
                       <li><a href="${pageContext.request.contextPath}/muslim">清真文化</a></li>
                       <li><a href="${pageContext.request.contextPath}/about">关于我们</a></li>
                       <li><a href="${pageContext.request.contextPath}/join">加入我们</a></li>
                   </ul>
                   <div class="right">
                       <div class="top"><img src="${pageContext.request.contextPath}/img/public/2.png" /><span>咨询热线</span></div>
                       <div class="bottom"><c:out value="${map['phoneNumber']}"></c:out></div>
                   </div>
               </div>
            <!--主体-->
            <div id="companyNewsContainer" class="main">
                <div class="I">
                    <h2>行业快讯</h2>
                </div>
                <div class="liebiao">
                         <div class="liebai">
                                <ul>
                                    <c:forEach items="${map['zixuanList1']}" var="news">
                                    <li><a href="${pageContext.request.contextPath}/news/${news.id}"><b>${news.title}</b><span>${news.newsTime}</span></a></li>
                                    </c:forEach>
                                </ul>
                            </div>
                            <div class="liebai1">
                                <ul>
                                    <c:forEach items="${map['zixuanList2']}" var="news">
                                        <li><a href="${pageContext.request.contextPath}/news/${news.id}"><b>${news.title}</b><span>${news.newsTime}</span></a></li>
                                    </c:forEach>
                                </ul>
                            </div>
                      </div>
                </div>
                <div class="main" style="padding-bottom: 50px">
                <div class="page">
                                    <div style="display: inline-block" id="callBackPager"></div><i class="totalPage">共<c:out value="${map['totalPage']}"></c:out>页</i>
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
    </div>


</body>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/extendPagination.js"></script>
<script src="${pageContext.request.contextPath}/js/public.js"></script>

<script type="application/javascript">
    var totalCount = $("#totalCount").val();
    var contextPath = $("#contextPath").val();
    var options = {
        totalCount : totalCount,
        showCount : 3,
        limit : 16
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
        console.log(pageNo);
        $.ajax({
            async: false,
            url:  contextPath +"/news/morePage?pageNo="+pageNo,
            type: "get",
            dataType: "json",
            success: function (data) {
                renderNews(data['zixuanList1'],data['zixuanList2']);
            }
        });
    }


    function  renderNews(list1,list2) {
        var news = '<div class="I"><h2>行业快讯</h2></div>';
        news += '<div class="liebiao"><div class="liebai"><ul>';
        for(var index in list1){
            var item = list1[index];
            news += '<li><a href="${pageContext.request.contextPath}/news/' + item.id +'"><b>';
            news += item.title;
            news += '</b><span>'
            news += item.newsTime;
            news += '</span></a></li>';
        }
        news += '</ul></div><div class="liebai1"><ul>';
        for(var index in list2){
            var item = list2[index];
            news += '<li><a href="${pageContext.request.contextPath}/news/' + item.id +'"><b>';
            news += item.title;
            news += '</b><span>'
            news += item.newsTime;
            news += '</span></a></li>';
        }
        news += '</ul></div></div>';
        console.log(news);
        $("#companyNewsContainer").html(news);
        $('body').scrollTop(0);
    }

</script>

</html>
