
$(document).ready(function () {
    $("#submitVal").click(function () {
        var password1 = $("#password1").val();
        if (password1 == '') {
            $("#message").html("原密码不能为空");
            return false;
        } else {
            var password2 = $("#password2").val();
            if (password2 == '') {
                $("#message").html("密码不能为空");
                return false;
            } else {
                var password3 = $("#password3").val();
                if (password3 == '') {
                    $("#message").html("密码不能为空");
                    return false;
                } else {
                    if (password3 != password2){
                        $("#message").html("两次密码输入不一致");
                        return false;
                    }
                    $(this).submit;
                }
            }
        }
    })
});
