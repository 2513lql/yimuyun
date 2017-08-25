var img_index = 1;

function setInter() {
    if (img_index >= $(".banner .num li").length) {
        img_index = 0;
    }
    $(".banner .num li").removeClass("on");
    $(".banner .num li").eq(img_index).addClass("on");
    $(".slider li").hide();
    $(".slider li").eq(img_index).show();
    img_index++
}
var timer = setInterval(setInter, 3000);
$(".banner .num li").mouseover(function () {
    var index = $(this).index();
    img_index = index + 1;
    $(".banner .num li").removeClass("on");
    $(".banner .num li").eq(index).addClass("on");
    $(".slider li").hide();
    $(".slider li").eq(index).show();
    clearInterval(timer);
}).mouseout(function () {
    timer = setInterval(setInter, 3000);
});