$(document).ready(function () {
    $("#submitVal").click(function () {
        var file = $("#exampleInputFile").val();
        if (file == '') {
            $("#message").html("文件不能为空！！！");
            return false;
        } else {
                $("#addBatchStuData").submit();
        }
    })
});