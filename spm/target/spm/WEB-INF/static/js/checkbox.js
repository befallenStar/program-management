$(".all").on("change",function(){
    if($(".all").prop("checked"))
        $("input[name='chk']").each(function(){
            $(this).prop("checked",true);
        });
    else
        $("input[name='chk']").each(function(){
            $(this).prop("checked",false);
        });
});
$(".chk").on("change",function(){
    var all=true;
    $("input[name='chk']").each(function(){
        if(!$(this).prop("checked"))
            all=false;
    });
    $(".all").prop("checked",all);
});