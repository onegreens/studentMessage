$(document).ready(function () {

    var majorId=$("#majorId").val();
    $("#majorEntityId  option[value="+majorId+"]").attr("selected",true);

    var gradeId=$("#gradeId").val();
    $("#gradeEntityId  option[value="+gradeId+"]").attr("selected",true);

    var sexId=$("#sexId").val();
    $("#sexEntityId  option[value="+sexId+"]").attr("selected",true);

    var nationId=$("#nationId").val();
    $("#nationEntityId  option[value="+nationId+"]").attr("selected",true);

    var nativePlaceId=$("#nativePlaceId").val();
    $("#npEntityId  option[value="+nativePlaceId+"]").attr("selected",true);

    var politicsStatusId=$("#politicsStatusId").val();
    $("#psEntityId  option[value="+politicsStatusId+"]").attr("selected",true);

    function returnPage(){
        window.history.back(-1);
    }

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
                $("#updateOneStuData").submit();
            }
        }
    })
});

