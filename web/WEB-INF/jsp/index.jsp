<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
    <%--<link href="<c:url value="/resources/web/css/style.css" />" rel="stylesheet">--%>
    <%--<script src="<c:url value="/resources/web/js/paginate.js"/>"></script>--%>
    <meta charset="UTF-8">
</head>
<body>
<c:if test="${param.error != null}">
    <div id="errorBlock">
            ${param.error}
    </div>
</c:if>
<h1>Admin panel</h1>

<a class="menuItem" href="<c:url value="admin/carBrandList"/>"> Car Brands </a>
<%--<table>
    <tr>
        <td>id</td>
        <td>Name</td>
        <td></td>
    </tr>

    <c:forEach items="${carBrandList}" var="carBrand">
        <tr>
            <td>${carBrand.id}</td>
            <td>${carBrand.name}</td>
            &lt;%&ndash;<td><a href="<c:url value="/deletePassport/${passport.id}"/>">Delete</a></td>&ndash;%&gt;
        </tr>
    </c:forEach>
</table>--%>
<%--<div id="pagination">--%>
    <%--<c:if test="${pageNumber != 1}">--%>
        <%--<button id="prevPage"><-</button>--%>
    <%--</c:if>--%>
    <%--<select id="pageSize">--%>
        <%--<option value="5">5</option>--%>
        <%--<option value="10">10</option>--%>
        <%--<option value="50">50</option>--%>
    <%--</select>--%>
    <%--<c:if test="${isLastPage != true}">--%>
        <%--<button id="nextPage">-></button>--%>
    <%--</c:if>--%>
<%--</div>--%>
<%--<span id="currentPageNumber">${pageNumber}</span>--%>

<%--<a class="menuItem" href="<c:url value="/add_passport"/>"> Add Passport </a>--%>
<%--<a class="menuItem" href="<c:url value="/students"/>">Show Students</a>--%>
<%--<a class="menuItem" href="<c:url value="/add_student"/>">Add Students</a>--%>


</body>
</html>
