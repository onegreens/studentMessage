<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String contexts = request.getContextPath();
        pageContext.setAttribute("ctx", contexts);
    %>
    <script type="text/javascript">
        var ctx = '${ctx}';
    </script>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/manager/student/addOneStuData.css"/>
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="${ctx}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/manager/student/editOneStuData.js"></script>

    <meta charset="UTF-8">

</head>
    <title>修改单个学生资料</title>
</head>
<body>
<form id="updateOneStuData" action="/ssm/student/updateOneStuData" role="form" namespace="/" method="POST">
    <div id="div1">

        <div align="center" id="adminName"><h2>修改学生信息</h2></div>

        <div class="form-group pad">
            <label class="col-sm-2 control-label">专业</label>
            <div class="col-sm-10">
                <input type="hidden" id="majorId" value="${studentEntity.majorEntity.majorEntityId}">
                <select name="majorEntityId" id="majorEntityId" required="required" >
                    <c:forEach var="major" items="${majorEntities}">
                        <option value="${major.majorEntityId}">${major.major}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group pad">
            <label class="col-sm-2 control-label">年级</label>
            <div class="col-sm-10">
                <input type="hidden" id="gradeId" value="${studentEntity.gradeEntity.gradeEntityId}">

                <select name="gradeEntityId" id="gradeEntityId"  required="required" >
                    <c:forEach var="grades" items="${gradeEntities}">
                        <option value="${grades.gradeEntityId}">${grades.grade}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group pad">
            <label for="studentName" class="col-sm-2 control-label">学号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="studentId" id="studentId" readOnly="true" value="${studentEntity.studentId}">
            </div>
        </div>

        <div class="form-group pad">
            <label for="studentName" class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="studentName" id="studentName"  value="${studentEntity.studentName}">
            </div>
        </div>

        <div class="form-group pad">
            <label for="identityCard" class="col-sm-2 control-label">身份证</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="identityCard" id="identityCard"  value="${studentEntity.identityCard}">
            </div>
        </div>

        <div class="form-group pad">
            <label for="birth" class="col-sm-2 control-label">出生日期</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="birth" id="birth" value="${studentEntity.birth}">
            </div>
        </div>

        <div class="form-group pad">
            <label for="address" class="col-sm-2 control-label">家庭地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="address" id="address" value="${studentEntity.address}">
            </div>
        </div>

        <div class="form-group pad">
            <label for="address" class="col-sm-2 control-label">邮箱</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="email" id="email" value="${studentEntity.email}">
            </div>
        </div>

        <div class="form-group pad">
            <label class="col-sm-2 control-label">性别</label>
            <div class="col-sm-10">
                <input type="hidden" id="sexId" value="${studentEntity.sexEntity.sexEntityId}">
                <select name="sexEntityId" id="sexEntityId" required="required" >
                    <c:forEach var="sexEntity" items="${sexEntities}">
                        <option value="${sexEntity.sexEntityId}">${sexEntity.sex}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group pad" >
        <label class="col-sm-2 control-label">民族</label>
        <div class="col-sm-10">
            <input type="hidden" id="nationId" value="${studentEntity.nationEntity.nationEntityId}">

            <select name="nationEntityId" id="nationEntityId" required="required" >
                <c:forEach var="NationEntity" items="${nationEntities}">
                    <option value="${NationEntity.nationEntityId}">${NationEntity.nationName}</option>
                </c:forEach>
            </select>
        </div>
    </div>

        <div class="form-group pad" >
            <label class="col-sm-2 control-label">籍贯</label>
            <div class="col-sm-10">
                <input type="hidden" id="nativePlaceId" value="${studentEntity.nativePlaceEntity.npEntityId}">

                <select name="npEntityId" id="npEntityId" required="required" >
                    <c:forEach var="nativePlaceEntity" items="${nativePlaceEntities}">
                        <option value="${nativePlaceEntity.npEntityId}">${nativePlaceEntity.nativePlace}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group pad" >
            <label class="col-sm-2 control-label">政治面貌</label>
            <div class="col-sm-10">
                <input type="hidden" id="politicsStatusId" value="${studentEntity.politicsStatusEntity.psEntityId}">

                <select name="psEntityId" id="psEntityId" required="required" >
                    <c:forEach var="pSEntity" items="${politicsStatusEntities}">
                        <option value="${pSEntity.psEntityId}">${pSEntity.politicsStatus}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div id="message">${message}</div>
        <div class="form-group pad">
            <button type="button" id="submitVal" class="btn btn-info">提交</button>
            <button type="button"  class="btn btn-info" onclick="returnPage()">返回</button>
        </div>
    </div>
</form>
</body>
</html>
