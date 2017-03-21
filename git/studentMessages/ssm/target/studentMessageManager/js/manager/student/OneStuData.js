function returnPage(){
    window.history.back(-1);
}
function studentDataPage(){
    window.location.href=ctx+"/student/QueryBatchStuByData";
}
function userDataPage(){
    window.location.href=ctx+"/manager/userManager";
}

function editStudent(){
    var studentId=$("#studentId").val();
    window.location.href=ctx+"/student/editOneStudent?studentId="+studentId;
}
function deleteStudent(){
    var studentId=$("#studentId").val();
    window.location.href=ctx+"/student/deleteOneStudent?studentId="+studentId;
}

function deleteUser(){
    var userEntityId=$("#userEntityId").val();
    window.location.href=ctx+"/student/deleteUser?userId="+userEntityId;
}
function addUserRole(){
    var userEntityId=$("#userEntityId").val();
    window.location.href=ctx+"/student/addUserRole?userId="+userEntityId;
}
