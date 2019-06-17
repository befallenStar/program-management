<<<<<<< HEAD
function clickToIframe(path) {
    var iframe = $(".main");
    var src = iframe.attr("src");
    var arr = src.split('/');
    iframe.attr("src", "/" + arr[1] + path);
}

$("#chooseList").on("click", function () {
    clickToIframe("/course/list");
});
$("#confirm").on("click", function () {
    clickToIframe("/course/confirm_list");
});
$("#score span").on("click", function () {
    $("#score").find("ul").toggleClass("show");
    $("#course").find("ul").toggleClass("show", false);
    clickToIframe("/grade/show");
});
$("#import").on("click", function () {
    clickToIframe("/grade/show_import");
});
$("#analyse").on("click", function () {
    clickToIframe("/grade/analyse");
});
$("#report").on("click", function () {
    clickToIframe("/grade/notice_list");
});

$("#resource").on("click", function () {
    clickToIframe("/resource/show");
});
$("#message").on("click", function () {
    clickToIframe("/message/message_board?page=1");
});

$("#course span").on("click", function () {
    $("#score").find("ul").toggleClass("show", false);
    $("#course").find("ul").toggleClass("show");
});
$("#resource span").on("click", function () {
    $("#score").find("ul").toggleClass("show", false);
    $("#course").find("ul").toggleClass("show", false);
});
$("#message span").on("click", function () {
    $("#score").find("ul").toggleClass("show", false);
    $("#course").find("ul").toggleClass("show", false);
=======
$(".first").mouseenter(function () {
    $(".first").nextAll("li").css({
        'top': '72px'
    });
});
$(".teacher-menu").mouseleave(function () {
    $(".first").nextAll("li").css({
        'top': '0'
    });
});
$(".last").mouseenter(function () {
    $(".first").nextAll("li").css({
        'top': '0'
    });
    $(".sublast").css({
        'top': '0'
    });
}).mouseleave(function () {
    $(".sublast").css({
        'top': '-108px'
    });
});
$("#teacher-main").on("load", function () {
    var height = $(this).contents().find("body").height();
    $("#teacher-main").height(height === 0 ? 500 : height + 30);
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
});