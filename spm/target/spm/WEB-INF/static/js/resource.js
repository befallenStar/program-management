<<<<<<< HEAD
$("#upload").submit(function () {
    var fileDir = $("#file").val();
    if (fileDir === "") {
        alert("请选择文件！");
        return false;
    } else {
        return true;
    }
=======
$("#all").change(function (e) {
    if ($(this).is(':checked'))
        $('input[name="choose"]').each(function () {
            $(this).prop("checked", true);
        });
    else
        $('input[name="choose"]').each(function () {
            $(this).prop("checked", false);
        });
});
$('input[name="choose"]').change(function () {
    var all = true;
    $('input[name="choose"]').each(function () {
        if ($(this).not(':checked'))
            all = false;
    });
    $("#all").prop("checked", all);
})
// //表格动态添加
// $(document).ready(
// function(){
//     var th=$("#resource").html();
//     //根据身份判断操作的种类
//     //如果是学生
//     var action='<input type="button" name="download" value="下载" />';
//     //如果是教师
//     var action='<input type="button" id="upload" value="上传" />'+'<input type="button" id="download" value="下载" />'+'<input type="button" id="delete" value="删除" />';
//     //根据资源长度循环
//     //$.each(资源数组,function(index,item){})
//     $("#resource").html(th+
//         '<tr><td><input type="checkbox" name="choose" id="resource'+i+'" value="'+i+'" /></td>'+
//         '<td>'+'资源名'+'</td>'+
//         '<td>'+'资源大小'+'</td>'+
//         '<td>'+action+'</td>'+
//         '</tr>'
//         );
// })
$("#resource").on("click", "#delete", function () {
    var name = $(this).closest("tr").find("td:eq(1)").text(); //获取删除行名字
    alert(name);
})
//添加表格背景
$('tr:even:gt(0)').addClass('tr_even');
$('tr:odd').addClass('tr_odd');
$('tr:gt(0)').mouseover(function () {
    $(this).addClass('tr_hover');
}).mouseout(function () {
    $(this).removeClass('tr_hover');
>>>>>>> 7a68c4967cfca7fcbd1f189730fe163faf1a889d
});