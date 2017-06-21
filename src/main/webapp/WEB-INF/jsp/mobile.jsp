<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>追溯查询</title>
    <meta content="width=device-width,initial-scale=1,minimum-scale=1;maximum-scale=1,user-scalable=no" name="viewport"
          id="viewport"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mobile.css">

</head>

<body>
<div class="box">
    <div class="header">
        <img src="./img/index/5.png" alt="">
        <div>中国伊牧 云牧场牛羊肉食品追溯平台</div>
    </div>
    <div class="coa">
        <div class="xuliehao">
            <input type="text" id="traceNumber1" placeholder="请输入你的防伪序列号"><span id="queryBtn1">防伪验证</span>
        </div>
        <%--<div class="result">你的产品为<span>真</span></div>--%>
        <div id="queryResult" class="result"></div>
    </div>
    <div class="ba"></div>
    <div class="xinxi">
        <table border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>产品名称：</td>
                <td>${result.get("productName")}</td>
            </tr>
            <tr>
                <td>产品品牌：</td>
                <td>伊牧云</td>
            </tr>
            <tr>
                <td>查询次数：</td>
                <td>xx次</td>
            </tr>
        </table>
        <table border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td colspan="2"><img src="${result.get("homePicture")}" alt=""></td>
            </tr>
        </table>
    </div>
    <div class="ba"></div>
    <div class="main">
        <div class="main1">
            <h2>-履历信息-</h2>
            <div class="content">
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>身份证号：</td>
                        <td>${result.getJSONObject("livestock").get("idNumber")}</td>
                    </tr>
                    <tr>
                        <td>出生日期：</td>
                        <td>${result.getJSONObject("livestock").get("birthday")}</td>
                    </tr>
                    <tr>
                        <td>出生重量：</td>
                        <td>${result.getJSONObject("livestock").get("birthWeight")}kg</td>
                    </tr>
                    <tr>
                        <td>品种：</td>
                        <td>${result.getJSONObject("livestock").get("variety")}</td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td>${result.getJSONObject("livestock").get("sex")}</td>
                    </tr>
                    <tr>
                        <td>出生地：</td>
                        <td>${result.getJSONObject("livestock").get("birthplace")}</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="ba"></div>
        <div class="main2">
            <h2>-养殖环节-</h2>
            <div class="content">
                <c:if test="${result['farming']['farms'] != ''}">
                    <h3>牧场信息</h3>
                    <c:forEach var="item" items="${result['farming']['farms']}">
                        <table border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td>牧场名称：</td>
                                <td>${item.get("farmName")}</td>
                            </tr>
                            <tr>
                                <td>养殖地点：</td>
                                <td>${item.get("address")}</td>
                            </tr>
                            <tr>
                                <td>执照编号：</td>
                                <td>${item.get("number")}</td>
                            </tr>
                            <tr>
                                <td>负责人：</td>
                                <td>${item.get("master")}</td>
                            </tr>
                        </table>
                    </c:forEach>
                </c:if>
                <c:if test="${result['farming']['quarantinePicture'] != ''}">
                    <h3>检疫记录：</h3>
                    <table border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td colspan="2"><img src="${result['farming']['quarantinePicture']}" alt=""></td>
                        </tr>
                    </table>
                </c:if>

                <h3>免疫记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>免疫日期：</td>
                        <td>20170501</td>
                    </tr>
                    <tr>
                        <td>疫苗品种：</td>
                        <td>三联四防疫苗</td>
                    </tr>
                    <tr>
                        <td>免疫方法：</td>
                        <td>注射</td>
                    </tr>
                    <tr>
                        <td>免疫人员：</td>
                        <td>马泽宝</td>
                    </tr>
                </table>
                <h3>诊疗记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>诊疗日期：</td>
                        <td>20170520</td>
                    </tr>
                    <tr>
                        <td>诊疗结果：</td>
                        <td>感冒</td>
                    </tr>
                    <tr>
                        <td>治疗方案：</td>
                        <td>肌肉注射复方氨基比林5～10毫升</td>
                    </tr>
                    <tr>
                        <td>用药名称：</td>
                        <td>复方氨基比林</td>
                    </tr>
                    <tr>
                        <td>治疗人员：</td>
                        <td>马泽宝</td>
                    </tr>
                </table>
                <h3>喂养记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>喂养时间：</td>
                        <td>20170510</td>
                    </tr>
                    <tr>
                        <td>喂养饲料：</td>
                        <td>杨哈吉612A羔羊料</td>
                    </tr>
                    <tr>
                        <td>喂养牧草：</td>
                        <td>玉米、紫花苜蓿、稻草</td>
                    </tr>
                </table>
                <h3>消毒记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>消毒日期：</td>
                        <td>20160420</td>
                    </tr>
                    <tr>
                        <td>药品名称：</td>
                        <td>氟化钠</td>
                    </tr>
                    <tr>
                        <td>消毒方法：</td>
                        <td>喷洒</td>
                    </tr>
                    <tr>
                        <td>消毒人员：</td>
                        <td>马泽宝</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="ba"></div>
        <div class="main1">
            <h2>-屠宰环节-</h2>
            <div class="content"> 阿訇证照片：中午1点左右发过来
                <h3>收购：</h3>
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>休药期检验：</td>
                        <td>合格</td>
                    </tr>
                    <tr>
                        <td>收购日期：</td>
                        <td>20170601</td>
                    </tr>
                    <tr>
                        <td>收购单位：</td>
                        <td>宁夏同心回达清真牛羊肉食品有限公司</td>
                    </tr>
                    <tr>
                        <td>收购人员：</td>
                        <td>马小平</td>
                    </tr>
                </table>
                <h3>屠宰记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>屠宰日期：</td>
                        <td>20170601</td>
                    </tr>
                    <tr>
                        <td>屠宰阿訇：</td>
                        <td>中午1点左右发过来</td>
                    </tr>
                    <tr>
                        <td>阿訇证照片：</td>
                        <td>中午1点左右发过来</td>
                    </tr>
                </table>
                <h3>屠宰检疫记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>检疫日期：</td>
                        <td>20170601</td>
                    </tr>
                    <tr>
                        <td>检疫人员：</td>
                        <td>马腾</td>
                    </tr>
                    <tr>
                        <td>检疫证号码：</td>
                        <td>1147123071301795</td>
                    </tr>
                    <tr>
                        <td>出具检疫证单位：</td>
                        <td>同心县农牧局</td>
                    </tr>
                    <tr>
                        <td>检疫方法：</td>
                        <td>全检</td>
                    </tr>
                    <tr>
                        <td>活体检疫：</td>
                        <td>合格</td>
                    </tr>
                    <tr>
                        <td>头部检查：</td>
                        <td>合格</td>
                    </tr>
                    <tr>
                        <td>内脏检查：</td>
                        <td>合格</td>
                    </tr>
                    <tr>
                        <td>胴体检查：</td>
                        <td>合格</td>
                    </tr>
                    <tr>
                        <td>实验室检查：</td>
                        <td>合格</td>
                    </tr>
                </table>
                <h3>消毒记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>消毒日期：</td>
                        <td>20170602</td>
                    </tr>
                    <tr>
                        <td>药品名称：</td>
                        <td>氯化钠</td>
                    </tr>
                    <tr>
                        <td>消毒方法：</td>
                        <td>喷洒</td>
                    </tr>
                    <tr>
                        <td>消毒人员：</td>
                        <td>马三</td>
                    </tr>
                </table>
                <h3>企业信息：</h3>
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>单位名称：</td>
                        <td>宁夏同心回达清真牛羊肉食品有限公司</td>
                    </tr>
                    <tr>
                        <td>单位地址：</td>
                        <td>xxx年xx月xx日</td>
                    </tr>
                    <tr>
                        <td>负责人：</td>
                        <td>马如杰</td>
                    </tr>
                    <tr>
                        <td>屠宰证照：</td>
                    </tr>
                    <tr>
                        <td colspan="2"><img src="./img/mobile/6.png" alt=""></td>
                    </tr>
                    <tr>
                        <td>清真证照：</td>
                    </tr>
                    <tr>
                        <td colspan="2"><img src="./img/mobile/7.png" alt=""></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="ba"></div>
        <div class="main1">
            <h2>-加工环节-</h2>
            <div class="content">
                <h3>排酸记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>排酸日期：</td>
                        <td>20170603</td>
                    </tr>
                    <tr>
                        <td>温度：</td>
                        <td>0—4摄氏度</td>
                    </tr>
                    <tr>
                        <td>时间：</td>
                        <td>24h</td>
                    </tr>
                </table>
                <h3>加工记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>加工日期：</td>
                        <td>20170604</td>
                    </tr>
                    <tr>
                        <td>产品部位：</td>
                        <td>羊脖</td>
                    </tr>
                    <tr>
                        <td>重量：</td>
                        <td>2.5kg</td>
                    </tr>
                    <tr>
                        <td>加工人员：</td>
                        <td>赵丰</td>
                    </tr>
                </table>
                <h3>消毒记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>消毒时间：</td>
                        <td>20170602</td>
                    </tr>
                    <tr>
                        <td>消毒方法：</td>
                        <td>喷洒</td>
                    </tr>
                    <tr>
                        <td>药品名称：</td>
                        <td>氯化钠</td>
                    </tr>
                    <tr>
                        <td>消毒人员：</td>
                        <td>赵龙</td>
                    </tr>
                </table>
                <h3>企业信息：</h3>
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>单位名称：</td>
                        <td>宁夏杨哈吉健康食品有限公司</td>
                    </tr>
                    <tr>
                        <td>执照编号：</td>
                        <td>91640324MA75X28274</td>
                    </tr>
                    <tr>
                        <td>单位地址：</td>
                        <td>宁夏同心同德慈善产业孵化园：</td>
                    </tr>
                    <tr>
                        <td>清真证照：</td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="ba"></div>
        <div class="main1">
            <h2>-物流环节-</h2>
            <div class="content">
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>装车时间：</td>
                        <td>20170604</td>
                    </tr>
                    <tr>
                        <td>出发时间：</td>
                        <td>20170604</td>
                    </tr>
                    <tr>
                        <td>出发地址：</td>
                        <td>宁夏同心</td>
                    </tr>
                    <tr>
                        <td>到达地址：</td>
                        <td>宁夏同心</td>
                    </tr>
                    <tr>
                        <td>司机姓名：</td>
                        <td>侯亮平</td>
                    </tr>
                    <tr>
                        <td>车牌：</td>
                        <td>宁C88168</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="ba"></div>
        <div class="main1">
            <h2>-终端环节-</h2>
            <div class="content">
                <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>收货日期：</td>
                        <td>20170604</td>
                    </tr>
                    <tr>
                        <td>收货单位：</td>
                        <td>同庆丰餐馆</td>
                    </tr>
                    <tr>
                        <td>收货人员：</td>
                        <td>杨军</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="ba"></div>
        <div class="fenxiang">
            <div class="top">
                <div class="left">购活畜</div>
                <div class="right">伊牧鲜</div>
            </div>
            <div class="bottom">
                <div class="left">趣牧投</div>
                <div class="right">留言</div>
            </div>
        </div>
        <div class="join">
            <p>加入我们</p>
            <div>0620-5820820</div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/setFontsize.js"></script>
<script src="${pageContext.request.contextPath}/js/mobile.js"></script>
<script src="${pageContext.request.contextPath}/event/trace.js"></script>
</body>
</html>
