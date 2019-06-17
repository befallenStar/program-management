function multiOp(id, des, alt) {
    var href = $(id).attr("href");
    if (2 === $("table").find("tr").length) {
        alert("当前列表不支持此操作");
        href += alt;
    } else {
        href += des;
        $("input[name='chk']:checked").each(function () {
            href += "id=" + $(this).val() + "&";
        });
        href = href.substr(0, href.length - 1);
    }
    $(id).attr("href", href);
}

$("#confirm").on("click", function () {
    multiOp("#confirm", "/course/confirm?", "/course/confirm_list");
});
$("#delete").on("click", function () {
    multiOp("#delete", "/course/delete?", "/course/confirm_list");
});