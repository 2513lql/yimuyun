$(".banner .num li").hover(function () {
    var index = $(this).index();
    $(".banner .num li").removeClass("on");
    $(".banner .num li").eq(index).addClass("on");
    $(".slider li").hide();
    $(".slider li").eq(index).show();
})