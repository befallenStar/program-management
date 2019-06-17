//获取单选框选项
$("input[name=radio1]").change(function () {
    var select = $('input[name="radio1"]:checked').val();
    alert(select);
});
//获取多选框数组
$("input[name=chk1]").change(function () {
    var ans=$('input[name="chk1"]:checked');
    var select = [];
    ans.each(function(){
        select.push($(this).val());
    })
    alert(select.length == 0 ? '你还没有选择任何内容！' : select);
});