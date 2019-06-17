$("#upload").submit(function () {
    var fileDir = $("#file").val();
    if (fileDir === "") {
        alert("请选择文件！");
        return false;
    } else {
        return true;
    }
});