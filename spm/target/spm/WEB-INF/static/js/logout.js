$(".profile").on("click",function(){
if(confirm("确定要退出吗？")){
    location.href=location.href.substr(0,location.href.lastIndexOf("/"));
}
});