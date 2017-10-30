<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>追溯查询</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mobile.css">

</head>

<body>
<div class="box">
    <div class="header">
        <img src="./img/index/5.png" alt="">
        <div>中国伊牧 · 云牧场公共溯源监管平台</div>
    </div>
    <div class="coa">
        <div class="xuliehao">
            <input type="text" id="traceNumber1" placeholder="请输入防伪序列号"><span id="queryBtn1">防伪验证</span>
        </div>
        <%--<div class="result">您的产品为<span>真</span></div>--%>

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
                <td>${result.get("counts")}次</td>
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
                        <td>耳标编号：</td>
                        <td>${result.getJSONObject("livestock").get("equipmentNumber")}</td>
                    </tr>
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
                        <td>${result.getJSONObject("livestock").get("birthWeight")}</td>
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
                        <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px;>
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
                    <h3 style=margin-top:10px>检疫记录：</h3>
                    <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px >
                        <tr>
                            <td colspan="2"><img src="${result['farming']['quarantinePicture']}" alt=""></td>
                        </tr>
                    </table>
                </c:if>

                <c:if test="${result['farming']['immuneRecord'] != ''}">
                    <h3 style=margin-top:10px >免疫记录：</h3>
                    <c:forEach var="item" items="${result['farming']['immuneRecord']}">
                        <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px;>
                            <tr>
                                <td>免疫日期：</td>
                                <td>${item.get("immuneTime")}</td>
                            </tr>
                            <tr>
                                <td>疫苗品种：</td>
                                <td>${item.get("vaccineType")}</td>
                            </tr>
                            <tr>
                                <td>免疫方法：</td>
                                <td>${item.get("immuneWay")}</td>
                            </tr>
                            <tr>
                                <td>免疫人员：</td>
                                <td>${item.get("immunePerson")}</td>
                            </tr>
                        </table>
                    </c:forEach>
                </c:if>

                <c:if test="${result['farming']['diagnosis'] != ''}">
                    <h3 style=margin-top:10px>诊疗记录：</h3>
                    <c:forEach var="item" items="${result['farming']['diagnosis']}">
                        <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px>
                            <tr>
                                <td>诊疗日期：</td>
                                <td>${item.get("diagnosisTime")}</td>
                            </tr>
                            <tr>
                                <td>诊疗结果：</td>
                                <td>${item.get("diagnosisResult")}</td>
                            </tr>
                            <tr>
                                <td>治疗方案：</td>
                                <td>${item.get("treatmentPlan")}</td>
                            </tr>
                            <tr>
                                <td>用药名称：</td>
                                <td>${item.get("drug")}</td>
                            </tr>
                            <tr>
                                <td>治疗人员：</td>
                                <td>${item.get("person")}</td>
                            </tr>
                        </table>
                    </c:forEach>
                </c:if>

                <c:if test="${result['farming']['feedingRecord'] != ''}">
                    <h3 style=margin-top:10px>喂养记录：</h3>
                    <c:forEach var="item" items="${result['farming']['feedingRecord']}">
                        <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px>
                            <tr>
                                <td>喂养时间：</td>
                                <td>${item.get("feedingTime") }</td>
                            </tr>
                            <tr>
                                <td>喂养饲料：</td>
                                <td>${item.get("feed")}</td>
                            </tr>
                            <tr>
                                <td>喂养牧草：</td>
                                <td>${item.get("grass")}</td>
                            </tr>
                        </table>
                    </c:forEach>
                </c:if>

                <c:if test="${result['farming']['disinfectionRecord'] != ''}">
                <h3 style=margin-top:10px>消毒记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px>
                    <tr>
                        <td>消毒日期：</td>
                        <td>${result['farming']['disinfectionRecord']['disinfectionTime']}</td>
                    </tr>
                    <tr>
                        <td>药品名称：</td>
                        <td>${result['farming']['disinfectionRecord'] ['disinfectant']}</td>
                    </tr>
                    <tr>
                        <td>消毒方法：</td>
                        <td>${result['farming']['disinfectionRecord'] ['disinfectionWay']}</td>
                    </tr>
                    <tr>
                        <td>消毒人员：</td>
                        <td>${result['farming']['disinfectionRecord']['person'] }</td>
                    </tr>
                </table>
                </c:if>

                <c:if test="${result['farming']['environment'] != ''}">
                    <h3 style=margin-top:10px>环境数据记录：</h3>
                    <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px>
                        <tr>
                            <td>记录时间：</td>
                            <td>${result['farming']['environment']['time']}</td>
                        </tr>
                        <tr>
                            <td>温度：</td>
                            <td>${result['farming']['environment'] ['temperature']}</td>
                        </tr>
                        <tr>
                            <td>湿度：</td>
                            <td>${result['farming']['environment'] ['humidity']}</td>
                        </tr>
                        <tr>
                            <td>光照：</td>
                            <td>${result['farming']['environment']['beam'] }</td>
                        </tr>
                        <tr>
                            <td>二氧化碳浓度：</td>
                            <td>${result['farming']['environment']['co2']}</td>
                        </tr>
                        <tr>
                            <td>甲烷浓度：</td>
                            <td>${result['farming']['environment']['ch4']}</td>
                        </tr>
                        <tr>
                            <td>二氧化硫浓度：</td>
                            <td>${result['farming']['environment']['so2']}</td>
                        </tr>
                        <tr>
                            <td>硫化氢浓度：</td>
                            <td>${result['farming']['environment']['h2s']}</td>
                        </tr>
                        <tr>
                            <td>氮气浓度：</td>
                            <td>${result['farming']['environment']['nh3']}</td>
                        </tr>
                    </table>
                </c:if>
            </div>
        </div>
        <div class="ba"></div>
        <div class="main1">
            <h2>-屠宰环节-</h2>
            <div class="content">
            <c:if test="${result['slaughter']['acquisition'] != ''}">
                <h3>收购记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px>
                    <tr>
                        <td>休药期检验：</td>
                        <td>${result['slaughter']['acquisition']['qualityCheck'] }</td>
                    </tr>
                    <tr>
                        <td>收购日期：</td>
                        <td>${result['slaughter']['acquisition'] ['acquisitionTime'] }</td>
                    </tr>
                    <tr>
                        <td>收购单位：</td>
                        <td>${result['slaughter']['acquisition'] ['enterprise']}</td>
                    </tr>
                    <tr>
                        <td>收购人员：</td>
                        <td>${result['slaughter']['acquisition'] ['person'] }</td>
                    </tr>
                </table>
            </c:if>

            <c:if test="${result['slaughter']['slaughterRecord'] != ''}">
                <h3 style=margin-top:10px>屠宰记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px>
                    <tr>
                        <td>屠宰日期：</td>
                        <td>${result['slaughter']['slaughterRecord'] ['slaughterTime']}</td>
                    </tr>
                    <tr>
                        <td>屠宰阿訇：</td>
                        <td>${result['slaughter']['slaughterRecord'] ['imam']}</td>
                    </tr>
                    <tr>
                        <td>阿訇证照片：</td>
                    </tr>
                <c:if test="${result['slaughter']['slaughterRecord']['imamPhoto'] != ''}">
                    <tr>
                        <td colspan="2"><img src="${result['slaughter']['slaughterRecord']['imamPhoto'] }" alt=""></td>
                    </tr>
                </c:if>
                </table>
            </c:if>

            <c:if test="${result['slaughter']['quarantineRecord'] != ''}">
                <h3 style=margin-top:10px>屠宰检疫记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px>
                    <tr>
                        <td>检疫日期：</td>
                        <td>${result['slaughter']['quarantineRecord'] ['quarantineTime'] }</td>
                    </tr>
                    <tr>
                        <td>检疫人员：</td>
                        <td>${result['slaughter']['quarantineRecord']['person']}</td>
                    </tr>
                    <%--<tr>--%>
                        <%--<td>检疫证号码：</td>--%>
                        <%--<td>${result['slaughter']['quarantineRecord']['quarantineNumber']}</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td>出具检疫证单位：</td>--%>
                        <%--<td>${result['slaughter']['quarantineRecord']['enterprise'] }</td>--%>
                    <%--</tr>--%>
                    <tr>
                        <td>检疫方法：</td>
                            <%--<td>${result['slaughter']['quarantineRecord']['quarantineMethod'] }</td>--%>
                        <td>全检</td>
                    </tr>
                    <tr>
                        <td>活体检疫结果：</td>
                        <td>${result['slaughter']['quarantineRecord'] ['result']}</td>
                    </tr>
                    <tr>
                        <td>胴体检疫项目：</td>
                        <td>实验室检疫 头部检疫 内脏检疫</td>
                    </tr>
                    <tr>
                        <td>胴体检疫结果：</td>
                        <td>合格</td>
                    </tr>
                </table>
            </c:if>

            <c:if test="${result['slaughter']['disinfection'] != ''}">
                <h3 style=margin-top:10px>消毒记录：</h3>
                <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px>
                    <tr>
                        <td>消毒日期：</td>
                        <td>${result['slaughter']['disinfection']['disinfectionTime']}</td>
                    </tr>
                    <tr>
                        <td>药品名称：</td>
                        <td>${result['slaughter']['disinfection']['disinfectant']}</td>
                    </tr>
                    <tr>
                        <td>消毒方法：</td>
                        <td>${result['slaughter']['disinfection'] ['disinfectionWay']}</td>
                    </tr>
                    <tr>
                        <td>消毒人员：</td>
                        <td>${result['slaughter']['disinfection'] ['person']}</td>
                    </tr>
                </table>
            </c:if>

            <c:if test="${result['slaughter']['enterpriseInfo'] != ''}">
                <h3 style=margin-top:10px>企业信息：</h3>
                <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px>
                    <tr>
                        <td>单位名称：</td>
                        <td>${result['slaughter']['enterpriseInfo'] ['enterpriseName']}</td>
                    </tr>
                    <tr>
                        <td>单位地址：</td>
                        <td>${result['slaughter']['enterpriseInfo']['enterpriseAddress']}</td>
                    </tr>
                    <tr>
                        <td>负责人：</td>
                        <td>${result['slaughter']['enterpriseInfo'] ['master']}</td>
                    </tr>
                    <tr>
                        <td>屠宰证照：</td>
                    </tr>
                <c:if test="${result['slaughter']['enterpriseInfo']['slaugherPhoto'] != ''}">
                    <tr>
                        <td colspan="2"><img src="${result['slaughter']['enterpriseInfo']['slaugherPhoto']}" alt=""></td>
                    </tr>
                </c:if>
                    <tr>
                        <td>清真证照：</td>
                    </tr>
                <c:if test="${result['slaughter']['enterpriseInfo']['muslimPhoto'] != ''}">
                    <tr>
                        <td colspan="2"><img src="${result['slaughter']['enterpriseInfo']['muslimPhoto'] }" alt=""></td>
                    </tr>
                </c:if>
                </table>
            </c:if>
            </div>
        </div>
        <div class="ba"></div>
        <div class="main1">
            <h2>-加工环节-</h2>
            <div class="content">

                <c:if test="${result['process']['acidDischarge'] != ''}">
                    <h3>排酸记录：</h3>
                    <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px>
                        <tr>
                            <td>排酸日期：</td>
                            <td>${result['process']['acidDischarge'] ['date']}</td>
                        </tr>
                        <tr>
                            <td>温度：</td>
                            <td>${result['process']['acidDischarge']['temperature'] }</td>
                        </tr>
                        <tr>
                            <td>湿度：</td>
                            <td>${result['process']['acidDischarge'] ['humidity']}</td>
                        </tr>
                    </table>
                </c:if>

                <c:if test="${result['process']['processRecord'] != ''}">
                    <h3 style=margin-top:10px>加工记录：</h3>
                    <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px>
                        <tr>
                            <td>加工日期：</td>
                            <td>${result['process']['processRecord'] ['processTime']}</td>
                        </tr>
                        <tr>
                            <td>产品部位：</td>
                            <td>${result['process']['processRecord']['productPart'] }</td>
                        </tr>
                        <tr>
                            <td>重量：</td>
                            <td>${result['process']['processRecord']['weight']}kg</td>
                        </tr>
                        <tr>
                            <td>加工人员：</td>
                            <td>${result['process']['processRecord'] ['person'] }</td>
                        </tr>
                    </table>
                </c:if>

                <c:if test="${result['process']['disinfectionRecord'] != ''}">
                    <h3 style=margin-top:10px>消毒记录：</h3>
                    <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px>
                        <tr>
                            <td>消毒时间：</td>
                            <td>${result['process']['disinfectionRecord']['disinfectionTime']}</td>
                        </tr>
                        <tr>
                            <td>消毒方法：</td>
                            <td>${result['process']['disinfectionRecord']['disinfectionWay']}</td>
                        </tr>
                        <tr>
                            <td>药品名称：</td>
                            <td>${result['process']['disinfectionRecord']['disinfectant']}</td>
                        </tr>
                        <tr>
                            <td>消毒人员：</td>
                            <td>${result['process']['disinfectionRecord'] ['person']}</td>
                        </tr>
                    </table>
                </c:if>

                <c:if test="${result['process']['enterpriseInfo'] != ''}">
                    <h3 style=margin-top:10px>企业信息：</h3>
                    <table border="0" cellspacing="0" cellpadding="0" style=margin-top:10px>
                        <tr>
                            <td>单位名称：</td>
                            <td>${result['process']['enterpriseInfo'] ['enterpriseName'] }</td>
                        </tr>
                        <tr>
                            <td>执照编号：</td>
                            <td>${result['process']['enterpriseInfo'] ['licenseNumber']}</td>
                        </tr>
                        <tr>
                            <td>负责人：</td>
                            <td>${result['process']['enterpriseInfo'] ['master']}</td>
                        </tr>
                        <tr>
                            <td>单位地址：</td>
                            <td>${result['process']['enterpriseInfo']['enterpriseAddress']}</td>
                        </tr>
                        <tr>
                            <td>清真证照：</td>
                        </tr>
                        <c:if test="${result['process']['enterpriseInfo']['muslimPhoto'] != ''}">
                            <tr>
                                <td colspan="2"><img src="${result['process']['enterpriseInfo']['muslimPhoto'] }" alt=""></td>
                            </tr>
                        </c:if>
                    </table>
                </c:if>

            </div>
        </div>
        <div class="ba"></div>
        <div class="main1">
            <h2>-物流环节-</h2>
            <div class="content">
                <c:if test="${result['logistics'] != ''}">
                    <table border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td>装车时间：</td>
                            <td>${result['logistics']['loadingTime']}</td>
                        </tr>
                        <tr>
                            <td>出发时间：</td>
                            <td>${result['logistics'] ['startTime'] }</td>
                        </tr>
                        <tr>
                            <td>出发地址：</td>
                            <td>${result['logistics']['startAddress'] }</td>
                        </tr>
                        <tr>
                            <td>到达地址：</td>
                            <td>${result['logistics']['arrivalAddress'] }</td>
                        </tr>
                        <tr>
                            <td>司机姓名：</td>
                            <td>${result['logistics'] ['driver'] }</td>
                        </tr>
                        <tr>
                            <td>车牌：</td>
                            <td>${result['logistics'] ['carNumber']}</td>
                        </tr>
                    </table>
                </c:if>

            </div>
        </div>
        <div class="ba"></div>
        <div class="main1">
            <h2>-终端环节-</h2>
            <div class="content">
                <c:if test="${result['merchant'] != ''}">
                    <table border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td>收货日期：</td>
                            <td>${result['merchant'] ['receivalTime'] }</td>
                        </tr>
                        <tr>
                            <td>收货单位：</td>
                            <td>${result['merchant'] ['enterprise']}</td>
                        </tr>
                        <tr>
                            <td>收货人员：</td>
                            <td>${result['merchant'] ['receiver'] }</td>
                        </tr>
                    </table>
                </c:if>

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
            <div>400-666-8858</div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/setFontsize.js"></script>
<script src="${pageContext.request.contextPath}/js/mobile.js"></script>
<script src="${pageContext.request.contextPath}/event/trace.js"></script>
</body>
</html>
