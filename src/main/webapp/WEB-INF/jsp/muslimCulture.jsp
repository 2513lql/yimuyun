<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>清真文化</title>
    <base href="http://139.129.233.104:8056/yimuyun_web/">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wenhua.css">
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
            <li><a href="${pageContext.request.contextPath}/muslim" class="selected">清真文化</a></li>
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
            <%--<h2>伊斯兰教的饮食文化——清真文化</h2>--%>
                <h2>${news.title}</h2>
        </div>
        <div class="text">
            <p>${news.newsTime} ${news.author}</p>
        </div>
        <div class="main1">
            <%--<p> 内清外洁，清真所宗，爱清洁、讲卫生是伊斯兰教的优良传统之一。所谓“内清外洁”，指的是“净身之污垢，净心之邪恶”。伊斯兰教的清洁卫生观的特点是防患病于先，这对穆斯林的身心健康影响很大。</p>--%>
            <p>${news.body}</p>
        </div>
        <%--<div class="main1">--%>
            <%--<p> 内清外洁，清真所宗，爱清洁、讲卫生是伊斯兰教的优良传统之一。所谓“内清外洁”，指的是“净身之污垢，净心之邪恶”。伊斯兰教的清洁卫生观的特点是防患病于先，这对穆斯林的身心健康影响很大。</p>--%>
        <%--</div>--%>
        <%--<div class="main2">--%>
            <%--<p> 伊斯兰教倡导穆斯林有所食有所不食，食用那些性善的动物，均为阿訇严格按照伊斯兰教法规定的屠宰方式供应的。这些动物体态俊美、肉质鲜美，且性情温顺，食之对人大有裨益。</p>--%>
        <%--</div>--%>
        <%--<div class="phone">--%>
            <%--<div class="phone1"><img src="wenhuaimg/1.png" /></div>--%>
            <%--<div class="phone1"><img src="wenhuaimg/2.png" /></div>--%>
            <%--<div class="phone1"><img src="wenhuaimg/3.png" /></div>--%>
        <%--</div>--%>
        <%--<div class="main1">--%>
            <%--<p> 伊斯兰教教法规定只吃伊斯兰教教法许可的有益于人体健康的食品，对一些有损人们身心健康的食物形成了一定的饮食禁忌。总的来说：禽类，凡吃谷、有胃、口似鸡嘴的禽可以吃，如鸡、鸭、鹅、鸽、鹌鹑等有嗉囊的禽类，似鹰嘴而食肉的禽不吃。畜类，凡吃草、反刍、有四蹄、蹄分两瓣、性情温驯的畜类可食，如牛、羊、兔、驼、鹿、獐等反刍的食草类动物，反之不能食。</p>--%>
        <%--</div>--%>
        <%--<div class="main1">--%>
            <%--<p> 伊斯兰教规定，禁食猪肉、自死物、血液。穆斯林在饮食方面，还禁食一切野兽。因为伊斯兰教认为，猪是不洁物，认为吃猪肉是引起许多疾病的根源，要求每一个穆斯林必须遵守这一戒律。自死物，是因疾病或有害物质，或衰老而死的。其肉不仅因衰老而失去营养价值，而且有可能含有病菌有害物质。伊斯兰教认为自死物是淫秽的不洁净的，食之会给身体带来了不同程度的损害，单从医学和卫生角度也是不可食的。。</p>--%>
        <%--</div>--%>
        <%--<div class="main1">--%>
            <%--<p> 伊斯兰教禁止穆斯林食用带獠牙的猛兽、肮脏丑陋的畜类。因此，穆斯林饮食文化的特点完全基于“择善、择美而食”的原则，即《古兰经》提到的要吃“佳美的”食物。清真饮食品种之多，花样之新，味道之香，形色之美，技艺之精，无不显示了回族、维吾尔族等穆斯林群众的聪明才智。</p>--%>
        <%--</div>--%>
        <%--<div class="phone">--%>
            <%--<div class="phone1"><img src="wenhuaimg/4.png" /></div>--%>
            <%--<div class="phone1"><img src="wenhuaimg/5.png" /></div>--%>
            <%--<div class="phone1"><img src="wenhuaimg/6.png" /></div>--%>
        <%--</div>--%>
        <%--<div class="main1">--%>
            <%--<p> 清真是一种文化，清真是一种文明，清真是一种行之有效的健康与长寿之路。穆斯林严守清真关，谨防病从口入，因而成为人类历史上伊斯兰饮食文化的直接受益者。在1983年人口普查中，宁夏的22位百岁老人中，21位是回族。中国首届十大寿星排行榜，2008年10月6日在江苏省如皋市揭晓，十大寿星之冠是来自新疆的伊斯兰教萨迪克萨伍提，是年121岁，穆斯林占7位。</p>--%>
        <%--</div>--%>
        <%--<div class="main1">--%>
            <%--<p> 　 “清真文化”作为穆斯林的核心文化，涵盖了中国穆斯林的精神层面、行为规范层面、物质层面三个层次。“清真文化”的精神层面体现了穆斯林特有的宗教信仰观，表现在对伊斯兰教和清真言的认知中。“清真文化”的行为规范层面体现着穆斯林以清真的精神理念对个人行为的一种理想期待和规范。“清真文化”的物质层面，包括清真寺、伊斯兰教经学院、清真饮食，对于中国穆斯林，既是精神文化的载体，也是物质文化创造的结晶。千百年来，由伊斯兰教的饮食戒律而逐步发展和形成的穆斯林饮食禁忌，作为一种共同的风俗习惯和反映共同文化上的共同心理素质，对世界各地信仰伊斯兰教的各民族的形成和发展，产生了深远的影响。</p>--%>
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
