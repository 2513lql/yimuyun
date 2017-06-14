$(".main h2").click(function () {
    /*var index = $(this).index();
    $(".nav li").removeClass("select");
    $(".nav li").eq(index).addClass("select");
    $(".main").hide();
    $(".main").eq(index).show();*/
    if ($(this).hasClass("select") && $(this).next(".content").hasClass("select")) {
        $(this).removeClass("select");
        $(this).next(".content").removeClass("select");
    } else {
        $(this).addClass("select");
        $(this).next(".content").addClass("select");
    }
})