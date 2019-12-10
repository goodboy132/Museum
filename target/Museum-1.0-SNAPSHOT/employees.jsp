<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <%@ include file="static/employee.css"%>
    </style>
</head>
<body>
<jsp:include page="fragment/header.jsp"/>
<div class="container-employee">
<table>
    <tr>
        <th width="20%">FirstName</th>
        <th width="25%">SecondName</th>
        <th width="25%">Guide Hall</th>
        <th width="25%">Guide Excursions</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr class="hover exhibit">
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>
                <c:forEach var="hall" items="${employee.halls}">
                    ${hall.name};
                </c:forEach>
            </td>
            <td>
                <c:forEach var="excursion" items="${employee.excursions}">
                    ${excursion.name};
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
    <div class="selection-employee">
        <input type="date">
    </div>
</div>
</body>
</html>
