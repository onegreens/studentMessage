$(document).ready(function () {
    $("#forget").click(function () {
        window.location.href=ctx+"/jsp/login/writerEmail.jsp";
    });
    $("#submitVal").click(function () {
        var loginAccount = $("#account").val();
        if (loginAccount == '') {
            $("#message").html("账号不能为空！！！");
            return false;
        } else {
            var password = $("#password").val();
            if (password == '') {
                $("#message").html("密码不能为空！！！");
                return false;
            } else {
                $("#login").submit();
            }
        }
    })
});