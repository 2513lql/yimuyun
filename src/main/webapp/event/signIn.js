/**
 * Created by Xuan on 2017/7/11.
 */

$("#getCode").click(function () {
    var  phone = $("#phone").val();
    if(phone == ""){
        $("#noPhone").show();
        return;
    }
    $.ajax({
        async: false,
        // url: "http://115.28.109.174:8383/yimu/mobile/logisticsReceiver/v1.0.0/mobile/" + phone,
        url: "http://localhost:8081/mobile/logisticsReceiver/v1.0.0/mobile/" + phone,
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

$("#verify").click(function () {
    var  phone = $("#phone").val();
    var code = $("#code").val();
    if(phone==""){
        $("#noPhone").show();
        return;
    }
    if(code==""){
        $("#wrong").show();
        return;
    }
    $.ajax({
        async: false,
        // url: "http://115.28.109.174:8383/yimu/mobile/logisticsReceiver/v1.0.0/mobile/" + phone,
        url: "http://localhost:8081/mobile/logisticsReceiver/v1.0.0/mobile/" + phone+"/code/"+code,
        type: "GET",
        dataType : "jsonp",
        jsonp:"_callback",
        success: function (data) {
            if(data['head']['ret']=="1"){
                $("#wrong").show();
            }else {
                var token = data['body'];
                sessionStorage.setItem("token", token);
                var url = window.location.href.split('#')[0];
                window.location.href = "wxScan?url=" + url;
            }
        }
    });
});
