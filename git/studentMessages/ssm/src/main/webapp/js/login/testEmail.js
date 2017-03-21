$(document).ready(function () {
    $("#submitVal").click(function () {
        var code=$("input[name='code']").val()
        var trueCode=$("input[name='trueCode']").val()
        if (code == ""){
            $("#message").html("验证码不能为空");
        }else{
            if(code == trueCode){
                window.location.href=ctx+"/find/changePassword.do";
            }else{
                $("#message").html("验证码不正确，请重新输入 ");
                return false;
            }
        }

    })
});