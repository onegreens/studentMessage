<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<% String contexts = request.getContextPath();
    pageContext.setAttribute("ctx", contexts);
%>
<head>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/manager/student/oneStuData.css">
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript">
        var ctx = '${ctx}';
    </script>
    <script type="text/javascript" src="${ctx}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/manager/student/OneStuData.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>用户资料</title>
</head>
<body>

  <div id="userDataVO">
        <h2 class="page-header">用户资料</h2>
        <div >
            <table id="loadTable">
                <tbody>
                <tr >
                    <td >ID:</td>
                    <input  type="hidden" value="${userEntity.userEntityId}" id="userEntityId" />
                    <td>${userEntity.userEntityId}</td>
                </tr>
                <tr >
                    <td >账号:</td>
                    <td>${userEntity.account}</td>
                </tr>
                <tr >
                    <td >邮箱:</td>
                    <td >${userEntity.email }</td>
                </tr>
                <tr >
                    <td >角色</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${userEntity.roleEntityList}" var="role">
                    <tr >
                        <td >${role.roleName }</td>
                        <td><a href="${ctx }/manager/loadRole?roleEntityId=${role.roleEntityId}">查看</a> ||
                            <a href="${ctx }/manager/deleteRole?roleEntityId=${role.roleEntityId}">删除</a></td>
                        </td>
                    </tr>
                </c:forEach>

                <tr >
                    <td >
                        <div class="form-group pad">
                            <span>

                                <button type="button" class="btn btn-info" onclick="addUserRole()">授权</button>
                            <button type="button" id="submitVal" class="btn btn-info" onclick="returnPage()">返回上一页</button>
                            <button type="button" class="btn btn-info" onclick="deleteStudent()">删除</button>
                            <button type="button" class="btn btn-info" onclick="userDataPage()">资料列表</button>
                       </span> </div>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>



</body>
</html>
