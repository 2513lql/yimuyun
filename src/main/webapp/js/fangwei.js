$(".trace .xuliehao span").click(function () {
   var traceNumber2 = $("#traceNumber2").val();
    if (traceNumber2 == ""){
        alert("请输入追溯序列号");
        return;
    }
    $.ajax({
        async: false,
        url: "http://115.28.109.174:8383/yimu/trace/v1.0.0/traceCode/" + traceNumber2,
        type: "GET",
        dataType : "jsonp",
        jsonp:"_callback",
        success: function (data) {
            if(data['head']['ret'] == 0){
                $(".main1").hide();
                $(".main2").show();
                renderTrace(data['body']);
            }else {
                alert("无此追溯序列号");
            }
        }
    });
});
$(".main .main2 .left-tab ul li").click(function () {
    var index = $(this).index();
    $(".main .main2 .left-tab ul li").removeClass("selected");
    $(".main .main2 .left-tab ul li").eq(index).addClass("selected");
    $(".main2 .right>div").hide();
    $(".main2 .right>div").eq(index).show();
});


function renderTrace(body) {

    var product = " <h4>产品说明</h4>";
    product += "<table><tr><td>产品名称: " +  body['productName'] +"</td></tr>";
    product += "<tr><td>产品品牌: 伊牧云</td></tr></table>";
    if (body['homePicture'] != ''){
        product += "<div>";
        product += "<img src='" + body['homePicture'] + "' alt=''></div>";
    }
    $(".right .right7").html(product);


    var lvli = "<tr><td>身份证号: " +  body['livestock']['idNumber'] +"</td></tr>";
    lvli += "<tr><td>出生日期: " + body['livestock']['birthday'] + "</td></tr>";
    lvli += "<tr><td>出生重量: " + body['livestock']['birthWeight']+"kg</td></tr>";
    lvli += "<tr><td>品种: " + body['livestock']['variety'] +"</td></tr>";
    lvli += "<tr><td>性别: " + body['livestock']['sex'] +"</td></tr>";
    lvli += "<tr><td>出生地: " + body['livestock']['birthplace'] +"</td></tr>";
    $(".right .right1 table").html(lvli);

    var farming = "";

    if(body['farming']['farms'] != ""){
        farming += "<h3>牧场信息</h3>";

        for (var i in body['farming']['farms']){
             var item = body['farming']['farms'][i];
             farming += "<table>";
             farming += "<tr><td>养殖单位名称: " +  item['farmName'] +"</td></tr>";
             farming += "<tr><td>执照编号: " +  item['number'] +"</td></tr>";
             farming += "<tr><td>养殖地点: " +  item['address'] +"</td></tr>";
             farming += "<tr><td>负责人: " +  item['master'] +"</td></tr>";
            farming += "</table>";
        }
    }
    if (body['farming']['quarantinePicture'] != ""){
        farming += "<h3>检疫记录</h3>";
        farming += "<table><tr><td><img src='" + body['farming']['quarantinePicture'] + "'"
        farming += " alt=''></td></tr></table>";
    }
    if(body['farming']['immuneRecord'] != ""){
        var item = body['farming']['immuneRecord'];
        farming += "<h3>免疫记录</h3>";
        farming += "<table>";
        farming += "<tr><td>免疫时间: " + item['immuneTime'] + "</td></tr>";
        farming += "<tr><td>疫苗品种: " + item['vaccineType'] + "</td></tr>";
        farming += "<tr><td>免疫方法: " + item['immuneWay'] + "</td></tr>";
        farming += "<tr><td>免疫人员: " + item['immunePerson'] + "</td></tr>";
        farming += "</table>";
    }
    if(body['farming']['diagnosis'] != ""){
        var item = body['farming']['diagnosis'];
        farming += "<h3>诊疗记录</h3>";
        farming += "<table>";
        farming += "<tr><td>诊疗时间: " + item['diagnosisTime'] + "</td></tr>";
        farming += "<tr><td>诊疗结果: " + item['diagnosisResult'] + "</td></tr>";
        farming += "<tr><td>诊疗方案: " + item['treatmentPlan'] + "</td></tr>";
        farming += "<tr><td>用药名称: " + item['drug'] + "</td></tr>";
        farming += "<tr><td>诊疗人员: " + item['person'] + "</td></tr>";
        farming += "</table>";
    }

    if(body['farming']['feedingRecord'] != ""){
        var item = body['farming']['feedingRecord'];
        farming += "<h3>喂养记录</h3>";
        farming += "<table>";
        farming += "<tr><td>喂养时间: " + item['feedingTime'] + "</td></tr>";
        farming += "<tr><td>喂养饲料: " + item['feed'] + "</td></tr>";
        farming += "<tr><td>喂养牧草: " + item['grass'] + "</td></tr>";
        farming += "</table>";
    }

    if(body['farming']['disinfectionRecord'] != ""){
        var item = body['farming']['disinfectionRecord'];
        farming += "<h3>消毒记录</h3>";
        farming += "<table>";
        farming += "<tr><td>消毒时间: " + item['disinfectionTime'] + "</td></tr>";
        farming += "<tr><td>药品名称: " + item['disinfectant'] + "</td></tr>";
        farming += "<tr><td>消毒方法: " + item['disinfectionWay'] + "</td></tr>";
        farming += "<tr><td>消毒人员: " + item['person'] + "</td></tr>";
        farming += "</table>";
    }
    if(body['farming']['environment'] != ""){
        var item = body['farming']['environment'];
        farming += "<h3>环境数据记录</h3>";
        farming += "<table>";
        farming += "<tr><td>记录时间: " + item['time'] + "</td></tr>";
        farming += "<tr><td>温度: " + item['temperature'] + "</td></tr>";
        farming += "<tr><td>湿度: " + item['humidity'] + "</td></tr>";
        farming += "<tr><td>光照: " + item['beam'] + "</td></tr>";
        farming += "</table>";
    }
    $(".right .right2").html(farming);

    var slaughter = '';

    if (body['slaughter'] != undefined && body['slaughter'] != ''){
        if (body['slaughter']['acquisition'] != ''){
            var item = body['slaughter']['acquisition'];
            slaughter += "<h3>收购</h3>";
            slaughter += "<table>";
            slaughter += "<tr><td>休药期检验: " + item['qualityCheck'] + "</td></tr>";
            slaughter += "<tr><td>收购时间: " + item['acquisitionTime'] + "</td></tr>";
            slaughter += "<tr><td>收购单位: " + item['enterprise'] + "</td></tr>";
            slaughter += "<tr><td>收购人员: " + item['person'] + "</td></tr>";
            slaughter += "</table>";
        }
        if (body['slaughter']['slaughterRecord'] != ''){
            var item = body['slaughter']['slaughterRecord'];
            slaughter += "<h3>屠宰记录</h3>";
            slaughter += "<table>";
            slaughter += "<tr><td>屠宰时间: " + item['slaughterTime'] + "</td></tr>";
            slaughter += "<tr><td>屠宰阿訇: " + item['imam'] + "</td></tr>";
            if(item['imamPhoto'] != '') {
            slaughter += "<tr><td>阿訇证照片: </td>";
            slaughter += "<td><img src='" + item['imamPhoto'] + "' alt=''></td></tr>";}
            slaughter += "</table>";
        }

        if (body['slaughter']['quarantineRecord'] != ''){
            var item = body['slaughter']['quarantineRecord'];
            slaughter += "<h3>屠宰检疫记录</h3>";
            slaughter += "<table>";
            slaughter += "<tr><td>检疫时间: " + item['quarantineTime'] + "</td></tr>";
            slaughter += "<tr><td>检疫人员: " + item['person'] + "</td></tr>";
            // slaughter += "<tr><td>检疫证号码: " + item['quarantineNumber'] + "</td></tr>";
            // slaughter += "<tr><td>出具检疫证单位: " + item['enterprise'] + "</td></tr>";
            slaughter += "<tr><td>检疫方法: " + item['quarantineMethod'] + "</td></tr>";
            slaughter += "<tr><td>活体检疫结果: " + item['result'] + "</td></tr>";
            slaughter += "</table>";
        }

        if(body['slaughter']['disinfection'] != ""){
            var item = body['slaughter']['disinfection'];
            slaughter += "<h3>消毒记录</h3>";
            slaughter += "<table>";
            slaughter += "<tr><td>消毒时间: " + item['disinfectionTime'] + "</td></tr>";
            slaughter += "<tr><td>药品名称: " + item['disinfectant'] + "</td></tr>";
            slaughter += "<tr><td>消毒方法: " + item['disinfectionWay'] + "</td></tr>";
            slaughter += "<tr><td>消毒人员: " + item['person'] + "</td></tr>";
            slaughter += "</table>";
        }

        if(body['slaughter']['enterpriseInfo'] != ""){
            var item = body['slaughter']['enterpriseInfo'];
            slaughter += "<h3>企业信息</h3>";
            slaughter += "<table>";
            slaughter += "<tr><td>单位名称: " + item['enterpriseName'] + "</td></tr>";
            slaughter += "<tr><td>单位地址: " + item['enterpriseAddress'] + "</td></tr>";
            slaughter += "<tr><td>负责人: " + item['master'] + "</td></tr>";
            if(item['slaugherPhoto'] != '') {
                slaughter += "<tr><td>屠宰证照: </td>";
                slaughter += "<td><img src='" + item['slaugherPhoto'] + "' alt=''></td></tr>";
            }
            if (item['muslimPhoto'] != ''){
                slaughter += "<tr><td>清真证照: </td>";
                slaughter += "<td><img src='" + item['muslimPhoto'] + "' alt=''></td></tr>";
            }
                slaughter += "</table>";
        }
    }
    $(".right .right3").html(slaughter);

    var process = "";
    if(body['process']['acidDischarge'] != ''){
        var item = body['process']['acidDischarge'];
        process += "<h3>排酸记录</h3>";
        process += "<table>";
        process += "<tr><td>排酸日期: " + item['date'] + "</td></tr>";
        process += "<tr><td>温度: " + item['temperature'] + "</td></tr>";
        process += "<tr><td>时间: " + item['time'] + "</td></tr>";
        process += "</table>";
    }
    if(body['process']['processRecord'] != ''){
        var item = body['process']['processRecord'];
        process += "<h3>加工记录</h3>";
        process += "<table>";
        process += "<tr><td>加工时间: " + item['processTime'] + "</td></tr>";
        process += "<tr><td>产品部位: " + item['productPart'] + "</td></tr>";
        process += "<tr><td>重量: " + item['weight'] + " kg</td></tr>";
        process += "<tr><td>加工人员: " + item['person'] + "</td></tr>";
        process += "</table>";
    }

    if(body['process']['disinfectionRecord'] != ''){
        var item = body['process']['disinfectionRecord'];
        process += "<h3>消毒记录</h3>";
        process += "<table>";
        process += "<tr><td>消毒时间: " + item['disinfectionTime'] + "</td></tr>";
        process += "<tr><td>消毒方法: " + item['disinfectionWay'] + "</td></tr>";
        process += "<tr><td>药品名称: " + item['disinfectant'] + " </td></tr>";
        process += "<tr><td>消毒人员: " + item['person'] + "</td></tr>";
        process += "</table>";
    }

    if(body['process']['enterpriseInfo'] != ""){
        var item = body['process']['enterpriseInfo'];
        process += "<h3>企业信息</h3>";
        process += "<table>";
        process += "<tr><td>单位名称: " + item['enterpriseName'] + "</td></tr>";
        process += "<tr><td>单位地址: " + item['enterpriseAddress'] + "</td></tr>";
        process += "<tr><td>负责人: " + item['master'] + "</td></tr>";
        process += "<tr><td>执照编号: " + item['licenseNumber'] + "</td></tr>";
        if (item['muslimPhoto'] != ''){
            process += "<tr><td>清真证照: </td>";
            process += "<td><img src='" + item['muslimPhoto'] + "' alt=''></td></tr>";
        }
        process += "</table>";
    }

    $(".right .right4").html(process);

    var logistics = "";
    if(body['logistics'] != ""){
        var item = body['logistics'];
        logistics += "<table>";
        logistics += "<tr><td>装车时间: " + item['loadingTime'] + "</td></tr>";
        logistics += "<tr><td>出发时间: " + item['startTime'] + "</td></tr>";
        logistics += "<tr><td>出发地址: " + item['startAddress'] + "</td></tr>";
        logistics += "<tr><td>到达地址: " + item['arrivalAddress'] + "</td></tr>";
        logistics += "<tr><td>司机姓名: " + item['driver'] + "</td></tr>";
        logistics += "<tr><td>车牌: " + item['carNumber'] + "</td></tr>";
        logistics += "</table>";
    }
    $(".right .right5").html(logistics);

    var merchant = "";
    if(body['merchant'] != ""){
        var item = body['merchant'];
        merchant += "<table>";
        merchant += "<tr><td>收货时间: " + item['receivalTime'] + "</td></tr>";
        merchant += "<tr><td>收货单位: " + item['enterprise'] + "</td></tr>";
        merchant += "<tr><td>收货人员: " + item['receiver'] + "</td></tr>";
        merchant += "</table>";
    }
    $(".right .right6").html(merchant);


}