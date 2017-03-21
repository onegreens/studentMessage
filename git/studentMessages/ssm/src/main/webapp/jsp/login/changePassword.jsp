<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <% String contexts = request.getContextPath();
        pageContext.setAttribute("ctx", contexts);
    %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/login/login.css"/>
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${ctx}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/login/changePassword.js"></script>

    <meta charset="UTF-8">

</head>
<title>修改密码</title>
</head>
<body>

<form id="updatePassword" action="/ssm/find/updatePassword.do" namespace="/" method="POST">
    <div id="div1">
        <div align="center" id="adminName"><h2>重设密码</h2></div>
            <div class="form-group">
            <label for="password2">请输入密码 :</label>
            <input type="password" class="form-control" name="first" id="password2" >
            </div>
            <div class="form-group">
            <label for="password3">请再次输入密码 :</label>
            <input type="password" class="form-control" name="password" id="password3" >
            </div>
            <p id="message">${message}</p>
            <button type="submit" class="btn btn-info" id="submitVal">提交</button>
        </div>
    </div>

</form>

</body>

</html>