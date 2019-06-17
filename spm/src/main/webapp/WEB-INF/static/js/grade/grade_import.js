$("#import").submit(function () {
    var fileDir = $("#file").val();
    if (fileDir === "") {
        alert("选择需要导入的Excel文件");
        return false;
    } else {
        var suffix = fileDir.substr(fileDir.lastIndexOf("."));
        if (".xls" !== suffix && ".xlsx" !== suffix) {
            alert("选择Excel格式的文件导入");
            return false;
        }else
            return true;
    }
});
$("#confirm").on("click", function () {
    if (2 === $("table").find("tr").length) {
        alert("当前列表不支持此操作");
    } else {
        $(this).attr("href", "${pageContext.request.contextPath}/grade/submit_import");
    }
});