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
    <title>学生个人资料</title>
</head>
<body>

  <div id="userDataVO">
        <h2 class="page-header">学生个人资料</h2>
        <div >
            <table id="loadTable">
                <tbody>
                <tr >
                    <td class="td">专业:</td>
                    <td>${studentEntity.majorEntity.major}</td>
                </tr>
                <tr >
                    <td class="td">年级:</td>
                    <td>${studentEntity.gradeEntity.grade}届</td>
                </tr>
                <tr >
                    <td class="td">学号:</td>
                    <input  type="hidden" value="${studentEntity.studentId}" id="studentId" />
                    <td >${studentEntity.studentId }</td>
                </tr>
                <tr >
                    <td class="td">姓名:</td>
                    <td>${studentEntity.studentName }</td>
                </tr>
                <tr >
                    <td class="td">住址:</td>
                    <td>${studentEntity.address }</td>
                </tr>
                <tr >
                    <td class="td">邮箱:</td>
                    <td>${studentEntity.email }</td>
                </tr>
                <tr >
                    <td class="td">籍贯:</td>
                    <td>${studentEntity.nativePlaceEntity.nativePlace}</td>
                </tr>
                <tr >
                    <td class="td">出生日期:</td>
                    <td>${studentEntity.birth }</td>
                </tr>
                <tr >
                    <td class="td">性别:</td>
                    <td>${studentEntity.sexEntity.sex}</td>
                </tr>
                <tr >
                    <td class="td">民族:</td>
                    <td>${studentEntity.nationEntity.nationName}</td>
                </tr>
                <tr >
                    <td class="td">政治面貌:</td>
                    <td>${studentEntity.politicsStatusEntity.politicsStatus}</td>
                </tr>
                <tr >
                    <td >
                        <div class="form-group pad">
                            <span>
                            <button type="button" id="submitVal" class="btn btn-info" onclick="returnPage()">返回上一页</button>
                            <button type="button" class="btn btn-info" onclick="editStudent()">编辑</button>
                            <button type="button" class="btn btn-info" onclick="deleteStudent()">删除</button>
                            <button type="button" class="btn btn-info" onclick="dataPage()">资料列表</button>
                       </span> </div>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>



</body>
</html>
