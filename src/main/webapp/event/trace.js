/**
 * Created by Administrator on 2017/6/17.
 */

$("#queryBtn1").click(function () {
    var  traceNumber1 = $("#traceNumber1").val();
    if(traceNumber1 == ""){
        $("#queryResult").html("请输入追溯码");
        return;
    }
        $.ajax({
            async: false,
            url: "http://115.28.109.174:8383/yimu/trace/v1.0.0/securityCode/" + traceNumber1,
            type: "GET",
            dataType : "jsonp",
            jsonp:"_callback",
            success: function (data) {
                console.log(data['body']['result'])
                if(data['body']['result'] == "true"){
                    $("#queryResult").html("你的产品为 <span>真</span>");
                }else {
                    $("#queryResult").html("你的产品为 <span>假</span>");
                }
            }
    });
});



