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
    <script type="text/javascript" src="${ctx}/js/login/login.js"></script>

    <meta charset="UTF-8">

</head>
<title>学生信息管理系統</title>
</head>
<body>
<form id="login" action="/ssm/login/login.do" role="form" namespace="/" method="POST">
    <div id="div1">
        <div align="center" id="adminName"><h2>后台管理登录</h2></div>
        <div class="form-group pad">
            <label for="account" class="col-sm-2 control-label">账号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="account" id="account" placeholder="请输入你的账号">
            </div>
        </div>
        <div class="form-group pad">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="password" id="password" placeholder="请输入你的密码">
            </div>
        </div>

        <div class="form-group pad" id="div_editContent">
            <label class="col-sm-2 control-label">角色</label>

            <div class="col-sm-10">
                <select name="roleId" id="roleId" required="required" >
                    <c:forEach var="roleEntity" items="${roleEntityList}">
                        <option value="${roleEntity.roleEntityId}">${roleEntity.roleName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div id="message">${message}</div>
        <div class="form-group pad">
            <button type="button" id="submitVal" class="btn btn-info">登录</button>
            <button type="button" id="forget" class="btn btn-info">忘记密码？</button>
        </div>
    </div>
</form>
</body>
</html>
