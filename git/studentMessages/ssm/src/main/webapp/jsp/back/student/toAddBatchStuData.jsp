<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String contexts = request.getContextPath();
        pageContext.setAttribute("ctx", contexts);
    %>
    <script type="text/javascript">
        var ctx = '${ctx}';
    </script>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/login/login.css"/>
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="${ctx}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/manager/student/addBatchStuData.js"></script>

    <meta charset="UTF-8">

</head>
<title>请选择文件</title>
</head>
<body>
<form id="addBatchStuData" action="/ssm/student/addBatchStuData.do" role="form" namespace="/" enctype="multipart/form-data" method="POST">
    <div id="div1">
        <div align="center" id="adminName"><h2>选择学生资料文件</h2></div>
        <div class="form-group">
            <label for="exampleInputFile">文件选取</label>
            <input type="file" name="file" id="exampleInputFile">
            <p class="help-block">请选择学生资料对应格式的Excel文件</p>
        </div>
        <div id="message">${message}</div>
        <div class="form-group pad">
            <button type="button" id="submitVal" class="btn btn-info">提交</button>
        </div>
    </div>
</form>
</body>
</html>
