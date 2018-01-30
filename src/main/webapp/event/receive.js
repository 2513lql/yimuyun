$("#receive").click(function () {
    var  phone = sessionStorage.getItem("phone");
    var token = sessionStorage.getItem("token");
    var logId = $("#logId").val();
    var packingId = $("#packingId").val();
    $.i18n.properties({
        name: 'apiurl',
        path: '/yimuyun/',
        mode: 'map'
    });
    $.ajax({
        async: false,
        url: $.i18n.prop("api.url")+"mobile/logisticsReceiver/v1.0.0/receiveSuccess?mobile="
        + phone+"&token="+token+"&packingId="+packingId,
        type: "POST",
        dataType : "jsonp",
        jsonp:"_callback",
        success: function (data) {
            console.log(data['head']['msg'])
            if(data['head']['ret']=="0"){
                window.location.href = "receiv";
            }
        }
    });
});