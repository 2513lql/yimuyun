/**
 * Created by Xuan on 2017/7/11.
 */

var status = 0;
$("#signIn").click(function () {
    // console.log(status);
    if(status==1) {
        $("#noPhone").hide();
        $("#wrong").hide();
        status = 0;
    }
});
$("#getCode").click(function (e) {

    var  phone = $("#phone").val();
    if(phone == ""){
        $("#noPhone").show();
        status = 1;
        e.preventDefault();
        e.stopPropagation();
        return;
    }
    $.i18n.properties({
        name: 'apiurl',
        path: '/yimuyun/',
        mode: 'map'
    });
    $.ajax({
        async: false,
        url: $.i18n.prop("api.url")+"mobile/logisticsReceiver/v1.0.0/mobile/" + phone,
        // url: "http://localhost:8081/mobile/logisticsReceiver/v1.0.0/mobile/" + phone,
        type: "GET",
        dataType : "jsonp",
        jsonp:"_callback",
        success: function (data) {
            console.log(data['head']['msg'])
            if(data['head']['ret']=="-1"){
                window.location.href = "noUser";
            }else{
                $("#getCode").hide();
                $("#countDown").show();
                var seconds=60;
                var timer = null;
                timer=setInterval(function () {
                    seconds-=1;
                    if(seconds>0) {
                        $("#seconds").html(seconds);
                    }else {
                        clearInterval(timer);
                        $("#getCode").show();
                        $("#countDown").hide();
                    }
                },1000);
            }
        }
    });
});

$("#verify").click(function (e) {
    var  phone = $("#phone").val();
    var code = $("#code").val();
    if(phone==""){
        $("#noPhone").show();
        status = 1;
        e.preventDefault();
        e.stopPropagation();
        return;
    }
    if(code==""){
        $("#wrong").show();
        status = 1;
        e.preventDefault();
        e.stopPropagation();
        return;
    }
    // var url = window.location.href.split('#')[0];
    // window.location.href = "wxScan?url=" + url;
    $.i18n.properties({
        name: 'apiurl',
        path: '/yimuyun/',
        mode: 'map'
    });
    $.ajax({
        async: false,
        url: $.i18n.prop("api.url")+"mobile/logisticsReceiver/v1.0.0/mobile/" + phone+"/code/"+code,
        // url: "http://localhost:8081/mobile/logisticsReceiver/v1.0.0/mobile/" + phone+"/code/"+code,
        type: "GET",
        dataType : "jsonp",
        jsonp:"_callback",
        success: function (data) {
            if(data['head']['ret']=="1"){
                $("#wrong").show();
            }else {
                var token = data['body'];
                sessionStorage.setItem("token", token);
                sessionStorage.setItem("phone", phone);
                var url = window.location.href.split('#')[0];
                window.location.href = "wxScan?url=" + url;
            }
        }
    });
});
