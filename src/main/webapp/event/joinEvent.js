/**
 * Created by zyczyc on 2017/6/14.
 */
/**
 * 屠宰加工企业申请
 */

var ctx = $("#contextPath").val();

$("#submitSlaughter").click(function(e){
    e.preventDefault();
    var enterpriseType = $("#enterpriseType").val();
    var name = $("#slaughterName").val();
    var address = $("#address").val();
    var telephoneNumber = $("#telephoneNumber").val();
    var contact = $("#contact").val();
    if(enterpriseType == null || enterpriseType == ""){
        alert("企业类型不能为空");
        return;
    }
    if(name == null || name == ""){
        alert("企业名称不能为空");
        return;
    }
    if(address == null || address == ""){
        alert("企业地址不能为空");
        return;
    }
    if(telephoneNumber == null || telephoneNumber == ""){
        alert("联系电话不能为空");
        return;
    }
    if(contact == null || contact == ""){
        alert("联系人不能为空");
        return;
    }


    $.ajax({
        async: false,
        url:  ctx +"/apply/slaughter",
        type: "POST",
        data: {enterpriseType: enterpriseType,
                name: name,
                address: address,
                telephoneNumber:telephoneNumber,
                contact:contact},
        dataType: "json",
        success: function (data) {
            alert("添加成功");
            $("#enterpriseType").val = "";
            $("#slaughterName").val = "";
            $("#address").val = "";
            $("#telephoneNumber").val = "";
            $("#contact").val = "";
        }
    });
});

/**
 * 添加养殖企业
 */
$("#submitFarming").click(function(e){
    e.preventDefault();
    var name = $("#farmingName").val();
    var scale = $("#scale").val();
    var type = $("#type").val();
    var telephoneNumber = $("#farmingTelephoneNumber").val();
    if(name == null || name == ""){
        alert("养殖单位名称不能为空");
        return;
    }
    if(scale == null || scale == ""){
        alert("养殖规模不能为空");
        return;
    }
    if(type == null || type == ""){
        alert("养殖类别不能为空");
        return;
    }
    if(telephoneNumber == null || telephoneNumber == ""){
        alert("联系电话不能为空");
        return;
    }
    $("#farmingForm").submit();
    alert("添加成功");
    $("#farmingName").val = "";
    $("#scale").val = "";
    $("#type").val = "";
    $("#farmingTelephoneNumber").val = "";
});


$("#submitMessage").click(function(e){
    // e.preventDefault();
    var problemType = $("#problemType").val();
    var describe = $("#describe").val();
    var messageContact = $("#messageContact").val();
    if(problemType == null || problemType == ""){
        alert("问题类型不能为空");
        return;
    }
    if(describe == null || describe == ""){
        alert("描述问题不能为空");
        return;
    }
    if(messageContact == null || messageContact == ""){
        alert("联系方式不能为空");
        return;
    }
    $("#messageForm").submit();
    alert("添加成功");
    $("#describe").val = "";
    $("#messageContact").val = "";
});