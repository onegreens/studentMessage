<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% String contexts = request.getContextPath();
        pageContext.setAttribute("ctx", contexts);
    %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/login/result.css">
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${ctx}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/manager/success.js"></script>

    <title>密码修改成功</title>
</head>
<body>
</body>
</html>
