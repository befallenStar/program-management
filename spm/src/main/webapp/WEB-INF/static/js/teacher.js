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
});