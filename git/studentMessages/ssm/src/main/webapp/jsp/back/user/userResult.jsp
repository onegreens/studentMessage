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
    <script type="text/javascript" src="${ctx}/js/manager/student/OneStuData.js"></script>

    <meta charset="UTF-8">

</head>
<title>用户管理</title>
</head>
<body>
<form id="login" action="/ssm/login/login.do" role="form" namespace="/" method="POST">
    <div id="div1">
        <div id="message">${message}</div>
        <div class="form-group pad">
            <button type="button" class="btn btn-info" onclick="userDataPage()">返回学生资料列表</button>
        </div>
    </div>
</form>
</body>
</html>
