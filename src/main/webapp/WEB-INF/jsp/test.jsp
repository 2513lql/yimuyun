<%--
  Created by IntelliJ IDEA.
  User: katiemi
  Date: 2016/11/7
  Time: 下午8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>文件上传测试</title>>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.png" type="image/x-icon">
</head>
<body>
<%--<p><input type="file" name="viewUrls" value="浏览文件" /></p>--%>
<%--<p><input type="file" name="viewUrls" value="浏览文件" /></p>--%>
<%--<p><input type="text" name="streetStar"  value="3" /></p>--%>
<%--<p><input type="text" name="envirStar"  value="4" /></p>--%>
<%--<p><input type="text" name="safeStar"  value="5" /></p>--%>
<%--<p><input type="text" name="longitude"  value="" /></p>--%>
<%--<p><input type="text" name="latitude"  value="" /></p>--%>
<%--<p><input type="text" name="brief"  value="AAAAA级景区" /></p>--%>
<%--<p><input type="text" name="introduction"  value="very good" /></p>--%>
<%--<p><input type="text" name="remarkPointTags"  value="篮球;美食街" /></p>--%>
<form method="post" action="<%=request.getContextPath()%>/apply/slaughter">

    <p><input type="text" name="enterpriseType"  value="1" /></p>
    <p><input type="text" name="name"  value="双汇屠宰场" /></p>

    <p><input type="text" name="address"  value="河南漯河" /></p>
    <p><input type="text" name="telephoneNumber"  value="18888886666" /></p>
    <p><input type="text" name="contact"  value="万隆" /></p>

    <p><input type="submit" value="上传"/></p>
</form>
</body>
</html>
