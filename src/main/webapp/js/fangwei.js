$(".trace .xuliehao span").click(function () {
    $(".main1").hide();
    $(".main2").show();
});
$(".main .main2 .left-tab ul li").click(function () {
    var index = $(this).index();
    $(".main .main2 .left-tab ul li").removeClass("select");
    $(".main .main2 .left-tab ul li").eq(index).addClass("select");
    $(".main2 .right>div").hide();
    $(".main2 .right>div").eq(index).show();
});