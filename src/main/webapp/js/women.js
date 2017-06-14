$(".nav li").click(function () {
    var index = $(this).index();
    $(".nav li").removeClass("select");
    $(".nav li").eq(index).addClass("select");
    $(".main").hide();
    $(".main").eq(index).show();
})