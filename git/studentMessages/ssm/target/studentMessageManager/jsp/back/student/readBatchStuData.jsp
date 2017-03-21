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
            <tr><td colspan="7" >
                <button type="button"  class="btn btn-info" onclick="toAddBatchStuData()">批量添加学生资料</button>
                <button type="button"  class="btn btn-info" onclick="toAddOneStuData()">添加单个学生资料</button>
            </td>
            </tr>
            <tr><td colspan="7"><span>
                    <input type="text" name="studentId" id="studentId" placeholder="根据学号查询学生资料">
                    <button type="button"  class="btn btn-info" onclick="queryOneStudent()">查询</button>
             <input type="text" name="studentName" id="studentName" placeholder="根据姓名查询学生资料">
                    <button type="button"  class="btn btn-info" onclick="queryOneStuByName()">查询</button>

            </span></td></tr>
            <tr>
            <td colspan="7">
                <form id="condition" action="/ssm/student/QueryBatchStuByData" namespace="/">
                    查询条件：
                        <input type="hidden" id="majorId" value="${majorId}">
                        <select name="majorId" id="majorEntityId" required="required" >
                            <c:forEach var="major" items="${majorEntities}">
                                <option value="${major.majorEntityId}">${major.major}</option>
                            </c:forEach>
                        </select>

                        <input type="hidden" id="gradeId" value="${gradeId}">
                        <select name="gradeId" id="gradeEntityId" required="required" >
                            <c:forEach var="grades" items="${gradeEntities}">
                                <option value="${grades.gradeEntityId}">${grades.grade}</option>
                            </c:forEach>
                        </select>

                        <input type="hidden" id="sexId" value="${sexId}">
                        <select name="sexId" id="sexEntityId" required="required" >
                            <c:forEach var="sexEn" items="${sexEntities}">
                                <option value="${sexEn.sexEntityId}">${sexEn.sex}</option>
                            </c:forEach>
                        </select>

                        <input type="hidden" id="nationId" value="${nationId}">
                        <select name="nationId" id="nationEntityId" required="required" >
                            <c:forEach var="NationEntity" items="${nationEntities}">
                                <option value="${NationEntity.nationEntityId}">${NationEntity.nationName}</option>
                            </c:forEach>
                        </select>

                        <input type="hidden" id="nativePlaceId" value="${nativePlaceId}">
                        <select name="nativePlaceId" id="npEntityId" required="required" >
                            <c:forEach var="nativePlaceEntity" items="${nativePlaceEntities}">
                                <option value="${nativePlaceEntity.npEntityId}">${nativePlaceEntity.nativePlace}</option>
                            </c:forEach>
                        </select>

                        <input type="hidden" id="politicsStatusId" value="${politicsStatusId}">
                        <select name="politicsStatusId" id="psEntityId" required="required" >
                            <c:forEach var="pSEntity" items="${politicsStatusEntities}">
                                <option value="${pSEntity.psEntityId}">${pSEntity.politicsStatus}</option>
                            </c:forEach>
                        </select>
                    <span>
                        <input type="radio" name="flag" value="${flag}">倒序</input>
                        <button type="button"  class="btn btn-info" onclick="condition()">提交</button>
                        <button type="button"  class="btn btn-info" onclick="deleteBatchStu()">批量删除</button>
                </span>
                  </form>
                </td>
            </tr>
            <tr>
                <td ></td>
                <td >学号</td>
                <td >姓名</td>
                <td >住址</td>
                <td >邮箱</td>
                <td >身份证号</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <form id="batchDelete" action="/ssm/student/deleteBatchStu" namespace="/">
            <c:set value="${page}" var="page"></c:set>
            <c:set value="${page.list}" var="studentEntitys"></c:set>
            <c:forEach items="${studentEntitys}" var="studentEntity">
                <tr>
                    <td class="delete"><input name="studentId" type="checkbox" value="${studentEntity.studentId}"></td>
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
                    <td colspan="7"><span>共有${page.rowCount}条记录。<p class="message" id="message"></p></span></td></tr>

            </form>
            </tbody>
        </table>
    </div>
    <nav>
        <form id="pageForm" action="/ssm/student/QueryBatchStuByData" namespace="/">
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
