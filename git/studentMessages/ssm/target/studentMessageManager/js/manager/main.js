$(document).ready(function(){
    //当菜单栏被点击时。执行对应的操作
    $("a").click(function(){
        var a=$(this).attr("value");
        $("#workArea").attr("src", ctx+a);
    })
    $("#full").hide();
    $("#full").click(function(){
        window.location.href=ctx+"/login/loginPage";
    })

})

//显示隐藏的div块
function showFull(){
    $("#full").show();
}