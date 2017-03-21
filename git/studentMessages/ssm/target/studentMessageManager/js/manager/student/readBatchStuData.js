
function endPage(){
    //获取页面上的值
    var totalPage= $("input[name='totalPage']").val();
    //为当前页面赋值
    $("input[name='currentPage']").val(totalPage);
    //提交
    $("#pageForm").submit();
}

function nextTwoPage(){
    var currentPage=$("input[name='currentPage']").val();

    $("input[name='currentPage']").val(parseInt(currentPage)+parseInt(2));
    //提交
    $("#pageForm").submit();
}

function nextOnePage(){
    var currentPage=$("input[name='currentPage']").val();

    $("input[name='currentPage']").val(parseInt(currentPage)+parseInt(1));
     //提交
    $("#pageForm").submit();
}

function currentPage(){
    //提交
    $("#pageForm").submit();
}

function preOnePage(){
    var currentPage=$("input[name='currentPage']").val();

    $("input[name='currentPage']").val(parseInt(currentPage)-parseInt(1));
   //提交
    $("#pageForm").submit();
}


function preTwoPage(){
    var currentPage=$("input[name='currentPage']").val();

    $("input[name='currentPage']").val(parseInt(currentPage)-parseInt(2));
    //提交
    $("#pageForm").submit();
}

function beginPage(){

    //为当前页面赋值
    $("input[name='currentPage']").val(1);
    //提交
    $("#pageForm").submit();
}

$(document).ready(function () {

    var majorId=$("#majorId").val();
    if(majorId != ""){
        $("#majorEntityId  option[value="+majorId+"]").attr("selected",true);
    }

    var gradeId=$("#gradeId").val();
    if(gradeId != "") {
        $("#gradeEntityId  option[value=" + gradeId + "]").attr("selected", true);
    }

    var sexId=$("#sexId").val();
    if(sexId != "") {
        $("#sexEntityId  option[value="+sexId+"]").attr("selected",true);
    }

    var nationId=$("#nationId").val();
    if(nationId != "") {
        $("#nationEntityId  option[value="+nationId+"]").attr("selected",true);
    }

    var nativePlaceId=$("#nativePlaceId").val();
    if(nationId != "") {
        $("#npEntityId  option[value="+nativePlaceId+"]").attr("selected",true);
    }

    var politicsStatusId=$("#politicsStatusId").val();
    if(nationId != "") {
        $("#psEntityId  option[value="+politicsStatusId+"]").attr("selected",true);
    }

});

function condition(){
    $("#condition").submit();

}

function toAddBatchStuData(){
    window.location.href=ctx+"/student/toAddBatchStuData"
}

function toAddOneStuData(){
    window.location.href=ctx+"/student/toAddOneStuData"
}

function queryOneStudent(){
    var studentId=$("#studentId").val();
    window.location.href=ctx+"/student/queryOneStudent?studentId="+studentId;
}

function queryOneStuByName(){
    var studentName=$("#studentName").val();
    window.location.href=ctx+"/student/queryOneStuByName?studentName="+studentName;
}
function toAddOneUser(){
    window.location.href=ctx+"/manager/toAddOneUser";
}

function deleteBatchStu(){
    var studentId=$("input [name='studentId']").val();
    if (studentId == null || studentId == ""){
        $("#message").html("未选定删除目标！");
        return false;
    }else{
        $("#batchDelete").submit();
    }
}

