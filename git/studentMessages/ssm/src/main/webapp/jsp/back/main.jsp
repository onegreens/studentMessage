<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<% String contexts = request.getContextPath();
    pageContext.setAttribute("ctx", contexts);
%>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <link type="text/css" rel="stylesheet" href="${ctx}/css/manager/main.css">
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript">
        var ctx = '${ctx}';
    </script>
    <script type="text/javascript" src="${ctx}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/manager/main.js"></script>
    <title>管理界面</title>
</head>
<body>
<div class="mean">
    <div class="permission">
        <p>学生信息管理系统</p>
    </div>
    <div class="permission">
        <c:forEach var="permissionE" items="${permissionList}" >
            <div class="permission dropdown">
                <button class="btn btn-default dropdown-toggle" type="button"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    ${permissionE.permission}
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <c:forEach var="operationE" items="${permissionE.operationEntities}" >
                        <li><a href="javascript:void(0)" value="${operationE.method}">${operationE.operation}</a>
                    </c:forEach>
                </ul>
            </div>
        </c:forEach>

    </div>
</div>
<div class="main">
    <iframe class="iframeSon" id="workArea" src=""></iframe>
</div>
<div id="full">
    <h1>  点击任意处退出，重新登录！！！</h1>
</div>
</body>
</html>
