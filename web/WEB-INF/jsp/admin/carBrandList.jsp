<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car brands list</title>
    <link href="<c:url value="/classes/css/style.css" />" rel="stylesheet">
</head>
<body>
<h1>Car Brands</h1>
<table>
    <tr>
        <td>id</td>
        <td>Name</td>
        <td></td>
    </tr>

    <c:forEach items="${carBrandList}" var="carBrand">
        <tr>
            <td>${carBrand.id}</td>
            <td>${carBrand.name}</td>
            <td><a href="<c:url value="editCarBrand/${carBrand.id}"/>">Edit</a></td>
            <td><a href="<c:url value="deleteCarBrand/${carBrand.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>

    <a class="menuItem" href="<c:url value="/addBrand"/>"> Add brand </a>
</table>
</body>
</html>
