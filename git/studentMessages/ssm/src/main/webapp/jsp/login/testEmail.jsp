
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回密码</title>
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
    <script type="text/javascript" src="${ctx}/js/login/testEmail.js"></script>

    <meta charset="UTF-8">
</head>
<body>
    <div id="div1">
        <div align="center" id="adminName"><h2>请输入你邮箱验证码</h2></div>
        <div class="form-group pad">
            <label for="code" class="width col-sm-2 control-label">验证码</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="code" id="code">
            </div>
        </div>
        <input type="hidden" name="trueCode" value="${code}">
        <input type="hidden" name="userId" value="${userId}">
        <p id="message">${message}</p>
        <button type="submit" class="pad btn btn-info" id="submitVal">提交</button>
    </div>
</body>
</html>
