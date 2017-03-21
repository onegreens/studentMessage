
$(document).ready(function () {
    $("#submitVal").click(function () {
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
                    $("#updatePassword").submit;
                }
            }
    })
});
