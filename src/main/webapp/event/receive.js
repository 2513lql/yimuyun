$("#receive").click(function () {
    var  phone = sessionStorage.getItem("phone");
    var token = sessionStorage.getItem("token");
    var logId = $("#logId").val();
    var packingId = $("#packingId").val();
    $.ajax({
        async: false,
        url: "http://115.28.109.174:8383/yimu/mobile/logisticsReceiver/v1.0.0/receiveSuccess?mobile="
        + phone+"&logId="+logId+"&token="+token+"&packingId="+packingId,
        type: "POST",
        dataType : "jsonp",
        jsonp:"_callback",
        success: function (data) {
            console.log(data['head']['msg'])
            if(data['head']['ret']=="0"){
                window.location.href = "receive";
            }
        }
    });
});