<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>追溯查询</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fangwei.css">
</head>
<body>
<div class="div">
    <!--头部-->
    <div class="header">
        <div class="left"><img src="${pageContext.request.contextPath}/img/public/1.png" /></div>
        <ul class="center">
            <li><a href="${pageContext.request.contextPath}/home" >首页</a></li>
            <li><a href="${pageContext.request.contextPath}/news/center">新闻中心</a></li>
            <li><a href="${pageContext.request.contextPath}/trace" class="selected">追溯防伪查询</a></li>
            <li><a href="${pageContext.request.contextPath}/muslim">清真文化</a></li>
            <li><a href="${pageContext.request.contextPath}/about">关于我们</a></li>
            <li><a href="${pageContext.request.contextPath}/join">加入我们</a></li>
        </ul>
        <div class="right">
            <div class="top"><img src="${pageContext.request.contextPath}/img/public/2.png" /><span>咨询热线</span></div>
            <div class="bottom">${phoneNumber}</div>
        </div>
    </div>
    <!--主体-->
    <div class="main">
        <div class="main1">
            <div class="I">
                <h2>防伪查询</h2>
            </div>
            <div class="text">
                <p>输入防伪序列号查询真伪</p>
            </div>
            <div class="coa">
                <div class="xuliehao">
                    <input type="text" id="traceNumber1" placeholder="请输入您的防伪序列号"><span id="queryBtn1">查询</span>
                </div>
                <%--您的产品为 <span id="traceQueryResult"></span>--%>
                <div id="queryResult" class="result"></div>
            </div>
            <div class="J">
                <h2>追溯查询</h2>
            </div>
            <div class="text">
                <p>输入追溯序列号即可追溯序列号对应的牛羊追溯信息</p>
            </div>
            <div class="trace">
                <div class="xuliehao">
                    <input id="traceNumber2" type="text" placeholder="请输入您的追溯序列号"><span id="queryBtn2">查询</span>
                </div>
                <!--<div class="xinxi">
                    <textarea name="yj" cols="20" rows="5" placeholder="牛羊追溯信息"></textarea>
                </div>-->
            </div>
        </div>
        <div class="main2">
            <div class="I">
                <h2>追溯查询结果</h2>
            </div>
            <div class="content">
                <div class="left-tab">
                    <ul>
                        <li>履历信息</li>
                        <li>养殖环节</li>
                        <li>屠宰环节</li>
                        <li>加工环节</li>
                        <li>物流环节</li>
                        <li>终端环节</li>
                    </ul>
                </div>
                <div class="right"> <!--履历信息-->
                    <div class="right1">
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                    </div>
                    <div class="right2">
                        <h3>牧场信息</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                        <h3>检疫记录</h3>
                        <table>
                            <tr>
                                <td><img src="${pageContext.request.contextPath}/img/index/7.png" alt=""></td>
                            </tr>
                        </table>
                        <h3>诊疗记录</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                        <h3>免疫记录</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                        <h3>喂养记录</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                        <h3>消毒记录</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                        <h3>环境数据记录</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                    </div>
                    <div class="right3">
                        <h3>牧场信息</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                        <h3>检疫记录</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间： </td>
                                <td><img src="${pageContext.request.contextPath}/img/index/7.png" alt=""></td>
                            </tr>
                        </table>
                        <h3>喂养记录</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                        <h3>消毒记录</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                        <h3>环境数据记录</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间： </td>
                                <td><img src="${pageContext.request.contextPath}/img/index/7.png" alt=""></td>
                            </tr>
                            <tr>
                                <td>装车时间： </td>
                                <td><img src="${pageContext.request.contextPath}/img/index/7.png" alt=""></td>
                            </tr>
                        </table>
                    </div>
                    <div class="right4">
                        <h3>牧场信息</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                        <h3>检疫记录</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                        <h3>喂养记录</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                        <h3>环境数据记录</h3>
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间： </td>
                                <td><img src="${pageContext.request.contextPath}/img/index/7.png" alt=""></td>
                            </tr>
                        </table>
                    </div>
                    <div class="right5">
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                    </div>
                    <div class="right6">
                        <table>
                            <tr>
                                <td>装车时间： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>装车时间：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                    </div>
                    <div class="right7">
                        <h4>产品说明</h4>
                        <table>
                            <tr>
                                <td>产品名称： </td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                            <tr>
                                <td>产品品牌：</td>
                                <td>xxx年xx月xx日</td>
                            </tr>
                        </table>
                        <div>
                            <img src="./img/index/7.png" alt="">
                        </div>
                    </div>
                </div>
            </div>
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
                <div class="right-top">${phoneNumber}</div>
                <div class="right-bottom">
                    <div><img src="${pageContext.request.contextPath}/img/index/3.png" alt=""><span>咨询热线</span></div>
                </div>
            </div>
        </div>
        <div class="bootom"><span>引领科技风尚，护航农牧发展</span></div>
    </div>
    <div class="totop"><div class="return_top"></div></div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fangwei.js"></script>
<script src="${pageContext.request.contextPath}/event/trace.js"></script>
</body>
</html>
