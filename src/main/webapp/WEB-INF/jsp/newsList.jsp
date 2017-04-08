<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>新闻中心</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/more.css">

</head>
<head>
    <title>Title</title>
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
            <div class="top"><img src="${pageContext.request.contextPath}/img/public/2.png" /><span>咨询电话</span></div>
            <div class="bottom"><c:out value="${map['phoneNumber']}"></c:out></div>
        </div>
    </div>
    <!--主体-->
    <div id="companyNewsContainer" class="main shadow">
        <div class="I">
            <h2>公司新闻</h2>
        </div>
        <c:forEach items="${map['page']}" var="news" varStatus="status">
            <c:if test="${status.index % 3 == 0}"><div class="phone-text"></c:if>
            <dl>
                 <dt><a href="${pageContext.request.contextPath}/news/${news.id}"><img src="${news.picture}"/></a></dt>
                <dd>
                    <h3>${news.title}</h3>
                    <p>${news.digest}...</p>
                </dd>
            </dl>
           <c:if test="${status.index % 3 == 2}"></div></c:if>
        </c:forEach>
        <c:if test="${map['isThree'] == 0}"></div></c:if>



    </div>
<div class="main" style="padding-bottom: 50px">
<div class="page">
    <div id="callBackPager"></div><i class="totalPage">共<c:out value="${map['totalPage']}"></c:out>页</i>
    <!-- <a href="">
         <</a><a class="current">1</a><a>2</a><a>3</a><span>下一页</span><i>共3页</i>-->
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
                <div class="right-top"><c:out value="${map['phoneNumber']}"></c:out></div>
                <div class="right-bottom">
                    <div><img src="${pageContext.request.contextPath}/img/index/3.png" alt=""><span>咨询热线</span></div>
                </div>
            </div>
        </div>
        <div class="bootom"><span>引领科技风尚，护航农牧发展</span></div>
    </div>
</div>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
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
        console.log(pageNo);
        $.ajax({
            async: false,
            url:  contextPath +"/news/page?pageNo="+pageNo,
            type: "get",
            dataType: "json",
            success: function (data) {
                renderNews(data['page']);
            }
        });
    }


    function  renderNews(page) {
        var news = '<div class="I"><h2>公司新闻</h2></div>';
        var pageLength = page.length;
        for(var index in page){
            var item = page[index];
            if(index % 3 == 0){
                news += '<div class="phone-text">';
            }
//            news += '<dl><dt><a href="';
//            news += contextPath;
//            news += '/news/';
//            news += item.id;
//            news += '"><img src="';
//            news += item.picture;
//            news += '"/></a></dt>';
            news += '<dl><dt><a href="' +contextPath + '/news/'+ item.id + '"><img src="' + item.picture +'"/></a></dt>';
            news += '<dd><h3>' + item.title;
            news += '</h3><p>'+ item.digest + '...</p>';
            news += '</dd></dl>';
            if (index % 3 == 2){
                news += '</div>';
            }
        }
        if(pageLength % 3 != 0){
            news += '</div>';
        }
        console.log(news);
        $("#companyNewsContainer").html(news);
        $('body').scrollTop(0);
    }

</script>
</html>
