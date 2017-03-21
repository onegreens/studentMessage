$(document).ready(function () {
    $("#submitVal").click(function () {
        var email = $("#email").val();
        if (email == '') {
            $("#message").html("邮箱地址不能为空！！！");
            return false;
        }
        else{
            $("#writerEmail").submit();
        }

    })
});