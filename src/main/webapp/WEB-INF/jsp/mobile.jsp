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
        <div>中国伊牧云 · 牧场公共溯源监管平台</div>
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
                <ul>
                    <li>
                        <span>耳标编号：</span>
                        <span>${result.getJSONObject("livestock").get("equipmentNumber")}</span>
                    </li>
                    <li>
                        <span>身份证号：</span>
                        <span>${result.getJSONObject("livestock").get("idNumber")}</span>
                    </li>
                    <c:if test="${result['livestock']['birthday'] != ''}">
                        <li>
                            <span>出生日期：</span>
                            <span>${result.getJSONObject("livestock").get("birthday")}</span>
                        </li>
                    </c:if>
                    <c:if test="${result['livestock']['birthWeight'] !='0kg'}&&${result['livestock']['birthWeight'] != ''}">
                        <li>
                            <span>出生重量：</span>
                            <span>${result.getJSONObject("livestock").get("birthWeight")}</span>
                        </li>
                    </c:if>
                    <li>
                        <span>品种：</span>
                        <span>${result.getJSONObject("livestock").get("variety")}</span>
                    </li>
                    <li>
                        <span>性别：</span>
                        <span>${result.getJSONObject("livestock").get("sex")}</span>
                    </li>
                    <li>
                        <span>出生地：</span>
                        <span>${result.getJSONObject("livestock").get("birthplace")}</span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="ba"></div>
        <div class="main2">
            <h2>-养殖环节-</h2>
            <div class="content">
                <c:if test="${result['farming']['farms'] != ''}">
                    <h3>牧场信息</h3>
                    <c:forEach var="item" items="${result['farming']['farms']}">
                        <ul style=margin-top:10px;>
                            <li>
                                <span>牧场名称：</span>
                                <span>${item.get("farmName")}</span>
                            </li>
                            <li>
                                <span>养殖地点：</span>
                                <span>${item.get("address")}</span>
                            </li>
                            <li>
                                <span>执照编号：</span>
                                <span>${item.get("number")}</span>
                            </li>
                            <li>
                                <span>负责人：</span>
                                <span>${item.get("master")}</span>
                            </li>
                        </ul>
                    </c:forEach>
                </c:if>
                <c:if test="${result['farming']['quarantinePicture'] != ''}">
                    <h3 style=margin-top:10px>检疫记录：</h3>
                    <ul style=margin-top:10px>
                        <li>
                            <span colspan="2"><img src="${result['farming']['quarantinePicture']}" alt=""></span>
                        </li>
                    </ul>
                </c:if>

                <c:if test="${result['farming']['immuneRecord'] != ''}">
                    <h3 style=margin-top:10px>免疫记录：</h3>
                    <c:forEach var="item" items="${result['farming']['immuneRecord']}">
                        <ul style=margin-top:10px;>
                            <li>
                                <span>免疫日期：</span>
                                <span>${item.get("immuneTime")}</span>
                            </li>
                            <li>
                                <span>疫苗品种：</span>
                                <span>${item.get("vaccineType")}</span>
                            </li>
                            <li>
                                <span>免疫方法：</span>
                                <span>${item.get("immuneWay")}</span>
                            </li>
                            <li>
                                <span>免疫人员：</span>
                                <span>${item.get("immunePerson")}</span>
                            </li>
                        </ul>
                    </c:forEach>
                </c:if>

                <c:if test="${result['farming']['diagnosis'] != ''}">
                    <h3 style=margin-top:10px>诊疗记录：</h3>
                    <c:forEach var="item" items="${result['farming']['diagnosis']}">
                        <ul style=margin-top:10px>
                            <li>
                                <span>诊疗日期：</span>
                                <span>${item.get("diagnosisTime")}</span>
                            </li>
                            <li>
                                <span>诊疗结果：</span>
                                <span>${item.get("diagnosisResult")}</span>
                            </li>
                            <li>
                                <span>治疗方案：</span>
                                <span>${item.get("treatmentPlan")}</span>
                            </li>
                            <li>
                                <span>用药名称：</span>
                                <span>${item.get("drug")}</span>
                            </li>
                            <li>
                                <span>治疗人员：</span>
                                <span>${item.get("person")}</span>
                            </li>
                        </ul>
                    </c:forEach>
                </c:if>

                <c:if test="${result['farming']['feedingRecord'] != ''}">
                    <h3 style=margin-top:10px>喂养记录：</h3>
                    <c:forEach var="item" items="${result['farming']['feedingRecord']}">
                        <ul style=margin-top:10px>
                            <li>
                                <span>喂养时间：</span>
                                <span>${item.get("feedingTime") }</span>
                            </li>
                            <li>
                                <span>喂养饲料：</span>
                                <span>${item.get("feed")}</span>
                            </li>
                            <li>
                                <span>喂养牧草：</span>
                                <span>${item.get("grass")}</span>
                            </li>
                        </ul>
                    </c:forEach>
                </c:if>

                <c:if test="${result['farming']['disinfectionRecord'] != ''}">
                    <h3 style=margin-top:10px>消毒记录：</h3>
                    <ul style=margin-top:10px>
                        <li>
                            <span>消毒日期：</span>
                            <span>${result['farming']['disinfectionRecord']['disinfectionTime']}</span>
                        </li>
                        <li>
                            <span>药品名称：</span>
                            <span>${result['farming']['disinfectionRecord'] ['disinfectant']}</span>
                        </li>
                        <li>
                            <span>消毒方法：</span>
                            <span>${result['farming']['disinfectionRecord'] ['disinfectionWay']}</span>
                        </li>
                        <li>
                            <span>消毒人员：</span>
                            <span>${result['farming']['disinfectionRecord']['person'] }</span>
                        </li>
                    </ul>
                </c:if>

                <c:if test="${result['farming']['environment'] != ''}">
                    <h3 style=margin-top:10px>环境数据记录：</h3>
                    <ul style=margin-top:10px>
                        <li>
                            <span>记录时间：</span>
                            <span>${result['farming']['environment']['time']}</span>
                        </li>
                        <li>
                            <span>温度：</span>
                            <span>${result['farming']['environment'] ['temperature']}</span>
                        </li>
                        <li>
                            <span>湿度：</span>
                            <span>${result['farming']['environment'] ['humidity']}</span>
                        </li>
                        <li>
                            <span>光照：</span>
                            <span>${result['farming']['environment']['beam'] }</span>
                        </li>
                        <li>
                            <span>二氧化碳浓度：</span>
                            <span>${result['farming']['environment']['co2']}</span>
                        </li>
                        <li>
                            <span>甲烷浓度：</span>
                            <span>${result['farming']['environment']['ch4']}</span>
                        </li>
                        <li>
                            <span>二氧化硫浓度：</span>
                            <span>${result['farming']['environment']['so2']}</span>
                        </li>
                        <li>
                            <span>硫化氢浓度：</span>
                            <span>${result['farming']['environment']['h2s']}</span>
                        </li>
                        <li>
                            <span>氮气浓度：</span>
                            <span>${result['farming']['environment']['nh3']}</span>
                        </li>
                    </ul>
                </c:if>
            </div>
        </div>
        <div class="ba"></div>
        <div class="main1">
            <h2>-屠宰环节-</h2>
            <div class="content">
                <c:if test="${result['slaughter']['acquisition'] != ''}">
                    <h3>收购记录：</h3>
                    <ul style=margin-top:10px>
                        <li>
                            <span>休药期检验：</span>
                            <span>${result['slaughter']['acquisition']['qualityCheck'] }</span>
                        </li>
                        <li>
                            <span>收购日期：</span>
                            <span>${result['slaughter']['acquisition'] ['acquisitionTime'] }</span>
                        </li>
                        <li>
                            <span>收购单位：</span>
                            <span>${result['slaughter']['acquisition'] ['enterprise']}</span>
                        </li>
                        <li>
                            <span>收购人员：</span>
                            <span>${result['slaughter']['acquisition'] ['person'] }</span>
                        </li>
                    </ul>
                </c:if>

                <c:if test="${result['slaughter']['slaughterRecord'] != ''}">
                    <h3 style=margin-top:10px>屠宰记录：</h3>
                    <ul style=margin-top:10px>
                        <li>
                            <span>屠宰日期：</span>
                            <span>${result['slaughter']['slaughterRecord'] ['slaughterTime']}</span>
                        </li>
                        <li>
                            <span>屠宰阿訇：</span>
                            <span>${result['slaughter']['slaughterRecord'] ['imam']}</span>
                        </li>
                        <c:if test="${result['slaughter']['slaughterRecord']['imamPhoto'] != ''}">
                            <li>
                                <span>阿訇证照片：</span>
                            </li>
                            <li>
                                <span colspan="2"><img src="${result['slaughter']['slaughterRecord']['imamPhoto'] }"
                                                       alt=""></span>
                            </li>
                        </c:if>
                    </ul>
                </c:if>

                <c:if test="${result['slaughter']['quarantineRecord'] != ''}">
                    <h3 style=margin-top:10px>屠宰检疫记录：</h3>
                    <ul style=margin-top:10px>
                        <li>
                            <span>检疫日期：</span>
                            <span>${result['slaughter']['quarantineRecord'] ['quarantineTime'] }</span>
                        </li>
                        <li>
                            <span>检疫人员：</span>
                            <span>${result['slaughter']['quarantineRecord']['person']}</span>
                        </li>
                            <%--<li>--%>
                            <%--<span>检疫证号码：</span>--%>
                            <%--<span>${result['slaughter']['quarantineRecord']['quarantineNumber']}</span>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                            <%--<span>出具检疫证单位：</span>--%>
                            <%--<span>${result['slaughter']['quarantineRecord']['enterprise'] }</span>--%>
                            <%--</li>--%>
                        <li>
                            <span>检疫方法：</span>
                                <%--<span>${result['slaughter']['quarantineRecord']['quarantineMethod'] }</span>--%>
                            <span>全检</span>
                        </li>
                        <li>
                            <span>活体检疫结果：</span>
                            <span>${result['slaughter']['quarantineRecord'] ['result']}</span>
                        </li>
                        <li>
                            <span>胴体检疫项目：</span>
                            <span>实验室检疫 头部检疫 内脏检疫</span>
                        </li>
                        <li>
                            <span>胴体检疫结果：</span>
                            <span>合格</span>
                        </li>
                    </ul>
                </c:if>

                <c:if test="${result['slaughter']['disinfection'] != ''}">
                    <h3 style=margin-top:10px>消毒记录：</h3>
                    <ul style=margin-top:10px>
                        <li>
                            <span>消毒日期：</span>
                            <span>${result['slaughter']['disinfection']['disinfectionTime']}</span>
                        </li>
                        <li>
                            <span>药品名称：</span>
                            <span>${result['slaughter']['disinfection']['disinfectant']}</span>
                        </li>
                        <li>
                            <span>消毒方法：</span>
                            <span>${result['slaughter']['disinfection'] ['disinfectionWay']}</span>
                        </li>
                        <li>
                            <span>消毒人员：</span>
                            <span>${result['slaughter']['disinfection'] ['person']}</span>
                        </li>
                    </ul>
                </c:if>

                <c:if test="${result['slaughter']['enterpriseInfo'] != ''}">
                    <h3 style=margin-top:10px>企业信息：</h3>
                    <ul style=margin-top:10px>
                        <li>
                            <span>单位名称：</span>
                            <span>${result['slaughter']['enterpriseInfo'] ['enterpriseName']}</span>
                        </li>
                        <li>
                            <span>单位地址：</span>
                            <span>${result['slaughter']['enterpriseInfo']['enterpriseAddress']}</span>
                        </li>
                        <li>
                            <span>负责人：</span>
                            <span>${result['slaughter']['enterpriseInfo'] ['master']}</span>
                        </li>
                        <c:if test="${result['slaughter']['enterpriseInfo']['slaugherPhoto'] != ''}">
                            <li>
                                <span>屠宰证照：</span>
                            </li>
                            <li>
                                <span colspan="2"><img src="${result['slaughter']['enterpriseInfo']['slaugherPhoto']}"
                                                       alt=""></span>
                            </li>
                        </c:if>
                        <c:if test="${result['slaughter']['enterpriseInfo']['muslimPhoto'] != ''}">
                            <li>
                                <span>清真证照：</span>
                            </li>
                            <li>
                                <span colspan="2"><img src="${result['slaughter']['enterpriseInfo']['muslimPhoto'] }"
                                                       alt=""></span>
                            </li>
                        </c:if>
                    </ul>
                </c:if>
            </div>
        </div>
        <div class="ba"></div>
        <div class="main1">
            <h2>-加工环节-</h2>
            <div class="content">

                <c:if test="${result['process']['acidDischarge'] != ''}">
                    <h3>排酸记录：</h3>
                    <ul style=margin-top:10px>
                        <li>
                            <span>排酸日期：</span>
                            <span>${result['process']['acidDischarge'] ['date']}</span>
                        </li>
                        <li>
                            <span>温度：</span>
                            <span>${result['process']['acidDischarge']['temperature'] }</span>
                        </li>
                        <li>
                            <span>湿度：</span>
                            <span>${result['process']['acidDischarge'] ['humidity']}</span>
                        </li>
                    </ul>
                </c:if>

                <c:if test="${result['process']['processRecord'] != ''}">
                    <h3 style=margin-top:10px>加工记录：</h3>
                    <ul style=margin-top:10px>
                        <li>
                            <span>加工日期：</span>
                            <span>${result['process']['processRecord'] ['processTime']}</span>
                        </li>
                        <li>
                            <span>产品部位：</span>
                            <span>${result['process']['processRecord']['productPart'] }</span>
                        </li>
                        <li>
                            <span>重量：</span>
                            <span>${result['process']['processRecord']['weight']}kg</span>
                        </li>
                        <li>
                            <span>加工人员：</span>
                            <span>${result['process']['processRecord'] ['person'] }</span>
                        </li>
                    </ul>
                </c:if>

                <c:if test="${result['process']['disinfectionRecord'] != ''}">
                    <h3 style=margin-top:10px>消毒记录：</h3>
                    <ul style=margin-top:10px>
                        <li>
                            <span>消毒时间：</span>
                            <span>${result['process']['disinfectionRecord']['disinfectionTime']}</span>
                        </li>
                        <li>
                            <span>消毒方法：</span>
                            <span>${result['process']['disinfectionRecord']['disinfectionWay']}</span>
                        </li>
                        <li>
                            <span>药品名称：</span>
                            <span>${result['process']['disinfectionRecord']['disinfectant']}</span>
                        </li>
                        <li>
                            <span>消毒人员：</span>
                            <span>${result['process']['disinfectionRecord'] ['person']}</span>
                        </li>
                    </ul>
                </c:if>

                <c:if test="${result['process']['enterpriseInfo'] != ''}">
                    <h3 style=margin-top:10px>企业信息：</h3>
                    <ul style=margin-top:10px>
                        <li>
                            <span>单位名称：</span>
                            <span>${result['process']['enterpriseInfo'] ['enterpriseName'] }</span>
                        </li>
                        <li>
                            <span>执照编号：</span>
                            <span>${result['process']['enterpriseInfo'] ['licenseNumber']}</span>
                        </li>
                        <li>
                            <span>负责人：</span>
                            <span>${result['process']['enterpriseInfo'] ['master']}</span>
                        </li>
                        <li>
                            <span>单位地址：</span>
                            <span>${result['process']['enterpriseInfo']['enterpriseAddress']}</span>
                        </li>
                        <c:if test="${result['process']['enterpriseInfo']['muslimPhoto'] != ''}">
                            <li>
                                <span>清真证照：</span>
                            </li>
                            <li>
                                <span colspan="2"><img src="${result['process']['enterpriseInfo']['muslimPhoto'] }"
                                                       alt=""></span>
                            </li>
                        </c:if>
                    </ul>
                </c:if>

            </div>
        </div>
        <div class="ba"></div>
        <div class="main1">
            <h2>-物流环节-</h2>
            <div class="content">
                <c:if test="${result['logistics'] != ''}">
                    <ul>
                        <li>
                            <span>装车时间：</span>
                            <span>${result['logistics']['loadingTime']}</span>
                        </li>
                        <li>
                            <span>出发时间：</span>
                            <span>${result['logistics'] ['startTime'] }</span>
                        </li>
                        <li>
                            <span>出发地址：</span>
                            <span>${result['logistics']['startAddress'] }</span>
                        </li>
                        <li>
                            <span>到达地址：</span>
                            <span>${result['logistics']['arrivalAddress'] }</span>
                        </li>
                        <li>
                            <span>司机姓名：</span>
                            <span>${result['logistics'] ['driver'] }</span>
                        </li>
                        <li>
                            <span>车牌：</span>
                            <span>${result['logistics'] ['carNumber']}</span>
                        </li>
                    </ul>
                </c:if>

            </div>
        </div>
        <div class="ba"></div>
        <div class="main1">
            <h2>-终端环节-</h2>
            <div class="content">
                <c:if test="${result['merchant'] != ''}">
                    <ul>
                        <li>
                            <span>收货日期：</span>
                            <span>${result['merchant'] ['receivalTime'] }</span>
                        </li>
                        <li>
                            <span>收货单位：</span>
                            <span>${result['merchant'] ['enterprise']}</span>
                        </li>
                        <li>
                            <span>收货人员：</span>
                            <span>${result['merchant'] ['receiver'] }</span>
                        </li>
                    </ul>
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
                <div class="right"><a href="${pageContext.request.contextPath}/leaveComments">留言</a></div>
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