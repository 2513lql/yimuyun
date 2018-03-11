<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>留言</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/liuyan.css">
</head>
<body>
<div class="box">
    <div class="header">
        <img src="./img/index/5.png" alt="">
        <div>中国伊牧云 · 牧场公共溯源监管平台</div>
    </div>
    <div class="main">
        <div class="liuyan">
            <form method="post" id="messageForm" target="nm_iframe" enctype="multipart/form-data" action="${pageContext.request.contextPath}/mobile/message">
                <div class="fankui">
                    <textarea name="describe" id="describe" cols="20" rows="5" placeholder="在这里描述您遇到的问题"></textarea>
                </div>
                <div class="feedback-photos">
                    <div class="upload-photos">
                        <input type="file" class="upload" name="bannerUrl">
                    </div>
                    <div class="photos"></div>
                </div>
                <div class="lianxi">
                    <input id="messageContact" name="contact" type="text" placeholder="您的联系方式" onkeypress="return event.keyCode>=48&amp;&amp;event.keyCode<=57">
                </div>
                <div class="tijiao">
                    <input type="button" id="submitMessage" value="提交问题">
                </div>
            </form>
        </div>
        <div class="fenxiang">
            <div class="top">
                <div class="left"><a href="http://www.yimuyhc.com">购活畜</a></div>
                <div class="right">伊牧鲜</div>
            </div>
            <div class="bottom">
                <div class="left"><a href="http://www.yimuyrl.com/">趣牧投</a></div>
                <div class="right"><a href="${pageContext.request.contextPath}/leaveComments">留言</a></div>
            </div>
        </div>
        <div class="join">
            <p>加入我们</p>
            <div>400-666-8858</div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/setFontsize.js"></script>
<script src="${pageContext.request.contextPath}/js/join.js"></script>
<script src="${pageContext.request.contextPath}/event/joinEvent.js"></script>

</body>
</html>
