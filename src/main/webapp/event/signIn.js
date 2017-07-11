/**
 * Created by Xuan on 2017/7/11.
 */

$("#getCode").click(function () {
    var  phone = $("phone").val();
    if(phone == ""){
        return;
    }
    $.ajax({
        async: false,
        url: "http://115.28.109.174:8383/yimu/mobile/logisticsReceiver/v1.0.0/mobile/" + phone,
        type: "GET",
        dataType : "jsonp",
        jsonp:"_callback",
        success: function (data) {
            console.log(data['head']['msg'])
            window.location.href = "signDeta.jsp";
            // if(data['body']['result'] == "true"){
            //     $("#queryResult").html("你的产品为 <span>真</span>");
            // }else {
            //     $("#queryResult").html("你的产品为 <span>假</span>");
            // }
        }
    });
});
