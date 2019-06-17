<<<<<<< HEAD
function clickToIframe(path) {
    var iframe = $(".main");
    var src = iframe.attr("src");
    var arr = src.split('/');
    iframe.attr("src", "/" + arr[1] + path);
}

$("#info span").on("click", function () {
    clickToIframe("/class/class_info");
});
$("#content").on("click", function () {
    clickToIframe("/class/class_content");
});
$("#practice").on("click", function () {
    clickToIframe("/class/class_practice");
});
$("#team").on("click", function () {
    clickToIframe("/class/class_team");
});

$("#test").on("click", function () {
    clickToIframe("/student/test");
});
$("#grade").on("click", function () {
    clickToIframe("/student/grade");
});
$("#resource").on("click", function () {
    clickToIframe("/resource/show");
});
$("#message").on("click", function () {
    clickToIframe("/message/message_board?page=1");
});
$("#work").on("click", function () {
    clickToIframe("/class/class_work");
});
$("#contact").on("click", function () {
    clickToIframe("/class/class_contact");
});
$("#info span").on("click",function(){
    $(this).next("ul").toggleClass("show");
});
$("#test span").on("click", function () {
    $("#info").find("ul").toggleClass("show", false);
});
$("#grade span").on("click", function () {
    $("#info").find("ul").toggleClass("show", false);
});
$("#resource span").on("click", function () {
    $("#info").find("ul").toggleClass("show", false);
});
$("#message span").on("click", function () {
    $("#info").find("ul").toggleClass("show", false);
});
$("#work span").on("click", function () {
    $("#info").find("ul").toggleClass("show", false);
});
$("#contact span").on("click", function () {
    $("#info").find("ul").toggleClass("show", false);
=======
$("#info").on("click", function () {
    var iframe = $("#student-main");
    var src = iframe.attr("src");
    var arr = src.split('/');
    iframe.attr("src", "/" + arr[1] + "/class/class_info");
});
$("#content").on("click", function () {
    var iframe = $("#student-main");
    var src = iframe.attr("src");
    var arr = src.split('/');
    iframe.attr("src", "/" + arr[1] + "/class/class_content");
});
$("#practice").on("click", function () {
    var iframe = $("#student-main");
    var src = iframe.attr("src");
    var arr = src.split('/');
    iframe.attr("src", "/" + arr[1] + "/class/class_practice");
});
$("#team").on("click", function () {
    var iframe = $("#student-main");
    var src = iframe.attr("src");
    var arr = src.split('/');
    iframe.attr("src", "/" + arr[1] + "/class/class_team");
});

$("#test").on("click", function () {
    var iframe = $("#student-main");
    var src = iframe.attr("src");
    var arr = src.split('/');
    iframe.attr("src", "/" + arr[1] + "/student/test");
});
$("#resource").on("click", function () {
    var iframe = $("#student-main");
    var src = iframe.attr("src");
    var arr = src.split('/');
    iframe.attr("src", "/" + arr[1] + "/resource");
});

$("#work").on("click", function () {
    var iframe = $("#student-main");
    var src = iframe.attr("src");
    var arr = src.split('/');
    iframe.attr("src", "/" + arr[1] + "/class/class_work");
});
$("#contact").on("click", function () {
    var iframe = $("#student-main");
    var src = iframe.attr("src");
    var arr = src.split('/');
    iframe.attr("src", "/" + arr[1] + "/class/class_contact");
});

$(".first").mouseenter(function () {
    $(".first").nextAll("li").css({
                                      'top': '108px'
                                  });
});
$(".student-menu").mouseleave(function () {
    $(".first").nextAll("li").css({
                                      'top': '0'
                                  });
});
$("#student-main").on("load", function () {
    var height = $(this).contents().find("body").height();
    $("#student-main").height(height === 0 ? 500 : height + 30);
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
});
