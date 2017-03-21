$(document).ready(function () {

   $("#submitVal").click(function () {
        var studentName = $("#studentName").val();
        if (studentName == '') {
            $("#message").html("姓名不能为空！！！");
            return false;
        } else {
            var identityCard = $("#identityCard").val();
            if (identityCard == '') {
                $("#message").html("身份证号码不能为空！！！");
                return false;
            } else {
                $("#addOneStuData").submit();
            }
        }
    })
});

