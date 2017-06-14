/**
 * Created by zyczyc on 2017/6/14.
 */
(function ($) {

    var contextPath = $("#contextPath").val();
    $(document).ready(function () {
        $.ajax({
            async: false,
            url: contextPath +"/activity/createActivityNumber",
            type: "POST",
            data: {activityNumber: name_value, activityIntroduce: introduce_value, activityLableId: lable_ids_value},
            dataType: "json",
            success: function (data) {
                if (data.result == "error") {
                    setHiderShow("活动号创建失败");
                    setTimeoutHinderHide();
                } else {
                    var form = document.forms["activityNumForm"];
                    form.submit();
                }
            }
        });
    });


})