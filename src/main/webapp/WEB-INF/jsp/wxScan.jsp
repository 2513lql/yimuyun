<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>微信扫码</title>>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.png" type="image/x-icon">
</head>
<body>
<input id="timestamp" type="hidden" value="${timestamp}" />
<input id="noncestr" type="hidden" value="${nonceStr}" />
<input id="signature" type="hidden" value="${signature}" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript">
        var timestamp = $("#timestamp").val();//时间戳
        var nonceStr = $("#noncestr").val();//随机串
        var signature = $("#signature").val();//签名
        wx.config({
            debug : false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
            appId : 'wx8209687dfe66ec4f', // 必填，公众号的唯一标识
            timestamp : timestamp, // 必填，生成签名的时间戳
            nonceStr : nonceStr, // 必填，生成签名的随机串
            signature : signature,// 必填，签名，见附录1
            jsApiList : [ 'scanQRCode' ]// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
        });

        wx.error(function (res) {
            alert("error!!!!!!");
        });
        wx.ready(function () {
            wx.scanQRCode({
               needResult:1,
                success:function (res) {
                    var result = res.resultStr;
                    window.location.href = "getPackingInfo?qrCode=" + result;
                }
            });
        });
</script>


</body>
<script src="${pageContext.request.contextPath}/js/setfontsize_log.js"></script>

</html>
