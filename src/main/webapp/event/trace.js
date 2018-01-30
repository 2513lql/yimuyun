/**
 * Created by Administrator on 2017/6/17.
 */

$("#queryBtn1").click(function () {
    var  traceNumber1 = $("#traceNumber1").val();
    if(traceNumber1 == ""){
        $("#queryResult").html("请输入防伪码");
        return;
    }
    $.i18n.properties({
        name: 'apiurl',
        path: '/',
        mode: 'map'
    });
    // console.log($.i18n.prop("api.url"));
        $.ajax({
            async: false,
            url: $.i18n.prop("api.url")+"trace/v1.0.0/securityCode/" + traceNumber1,
            type: "GET",
            dataType : "jsonp",
            jsonp:"_callback",
            success: function (data) {
                console.log(data['body']['result'])
                if(data['body']['result'] == "true"){
                    $("#queryResult").html("您的产品为 <span>真</span>");
                }else {
                    $("#queryResult").html("您的产品为 <span>假</span>");
                }
            }
    });
});



