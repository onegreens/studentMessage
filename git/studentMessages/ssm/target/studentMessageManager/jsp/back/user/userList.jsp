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
    <script type="text/javascript" src="${ctx}/js/manager/student/readBatchStuData.js"></script>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>查看学生资料</title>
</head>
<body>
<div class="listMain" id="listCate">
    <h2 class="page-header">学生资料显示</h2>

    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr><td colspan="4" >
                <button type="button"  class="btn btn-info" onclick="toAddOneUser()">添加用户</button>
            </td>
            </tr>
            <tr>
                <td >ID</td>
                <td >账号</td>
                <td >邮箱</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <c:set value="${page.list}" var="userEntitys"></c:set>
            <c:forEach items="${userEntitys}" var="userEntity">
                <tr>
                    <td>${userEntity.userEntityId}</td>
                    <td>${userEntity.account}</td>
                    <td>${userEntity.email}</td>
                    <td><a href="${ctx }/manager/loadUser?userEntityId=${userEntity.userEntityId}">查看</a> ||
                        <a href="${ctx }/manager/deleteUser?userEntityId=${userEntity.userEntityId}">删除</a></td>
                    <a href="${ctx }/manager/addUserRole?userEntityId=${userEntity.userEntityId}">授权</a></td>

                    </td>

                </tr>
            </c:forEach>
            <tr ><td colspan="4">共有${page.rowCount}条记录</tr>
            </tbody>
        </table>
    </div>
    <nav>
        <form id="pageForm" action="/ssm/manager/userManager" namespace="/">
            <ul class="pagination">
                <c:set value="${page}" var="p"></c:set>
                <li><a href="javascript:void(0)" id="beginPage" onclick="beginPage()">&laquo;首页
                </a></li>

                <c:if test="${p.currentPage ge 3}">
                    <li><a href="javascript:void(0)" id="preTwoPage"
                           onclick="preTwoPage()">${p.currentPage - 2}
                    </a></li>
                </c:if>

                <c:if test="${p.currentPage ge 2}">
                    <li><a href="javascript:void(0)" id="preOnePage"
                           onclick="preOnePage()">${p.currentPage - 1}
                    </a></li>
                </c:if>

                <li class="active"><a href="javascript:void(0)" id="currentPage"
                                      onclick="currentPage()">${p.currentPage}
                    <span class="sr-only">(current)</span>
                    <input type="hidden" value="${p.currentPage}" name="currentPage"></a></li>

                <c:if test="${p.currentPage le p.totalPage -1}">
                    <li><a href="javascript:void(0)" id="nextOnePage"
                           onclick="nextOnePage()">${p.currentPage+1}
                    </a></li>
                </c:if>


                <c:if test="${p.currentPage le p.totalPage -2}">
                    <li><a href="javascript:void(0)" id="nextTwoPage"
                           onclick="nextTwoPage()">${p.currentPage + 2}
                    </a></li>
                </c:if>

                <li><a href="javascript:void(0)" id="endPage" onclick="endPage();">尾页&raquo;
                    <input type="hidden" value="${p.totalPage}" name="totalPage"></a></li>
            </ul>
        </form>
    </nav>
</div>


</body>
</html>
