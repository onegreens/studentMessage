<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<% String contexts = request.getContextPath();
    pageContext.setAttribute("ctx", contexts);
%>
<head>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/manager/student/studentPage.css">
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="${ctx}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        var ctx = '${ctx}';
    </script>
    <script type="text/javascript" src="${ctx}/js/manager/student/OneStuData.js"></script>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>查看学生资料</title>
</head>
<body>
<div class="listMain" id="listCate">
    <h2 class="page-header">学生资料显示</h2>

    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <td >学号</td>
                <td >姓名</td>
                <td >住址</td>
                <td >邮箱</td>
                <td >身份证号</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${studentEntityList}" var="studentEntity">
                <tr>
                    <td>${studentEntity.studentId}</td>
                    <td>${studentEntity.studentName}</td>
                    <td>${studentEntity.address}</td>
                    <td>${studentEntity.email}</td>
                    <td>${studentEntity.identityCard}</td>
                    <td><a href="${ctx }/student/queryOneStudent?studentId=${studentEntity.studentId}">查看</a> ||
                        <a href="${ctx }/student/editOneStudent?studentId=${studentEntity.studentId}">编辑</a> ||
                        <a href="${ctx }/student/deleteOneStudent?studentId=${studentEntity.studentId}">删除</a></td>
                    </td>
                </tr>
            </c:forEach>
            <tr >
                <td >
                    <div class="form-group pad">
                        <button type="button" id="submitVal" class="btn btn-info" onclick="returnPage()">返回上一页</button>
                        <button type="button" class="btn btn-info" onclick="dataPage()">资料列表</button>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

</div>


</body>
</html>
