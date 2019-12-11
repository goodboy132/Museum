<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <%@ include file="static/employee.css"%>
    </style>
</head>
<body style="position: relative">
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
        <div class="filter-position">
            <h2 style="padding-bottom: 10px">Positions: </h2>
            <select id="select">
                <option selected value="all">All</option>
                <c:forEach var="position" items="${positions}">
                    <option value="${position.positionName}">${position.positionName}</option>
                </c:forEach>
            </select>
            <button id="btn">Filter</button>
        </div>
        <div class="filter-position">
            <h2 style="padding-top: 30px;">Free guides in current date: </h2>
            <form action="/employees" method="get">
                <div class="inputs">
                    <div style="width: 50%; margin-right:10px">From:</div>
                    <div style="width: 50%">To:</div>
                </div>
                <div class="inputs">
                    <input style="width: 50%; margin-right: 10px;" id="from" name="from" type="date">
                    <input style="width: 50%" id="to" name="to" type="date">
                </div>
                <button>Filter</button>
            </form>
        </div>
    </div>
</div>
</body>
<jsp:include page="fragment/footer.jsp"/>
<script>
    document.getElementById("btn").addEventListener('click', filterEmployees);

    function filterEmployees() {
        let select = document.getElementById("select");
        let value = select[select.selectedIndex].value;
        if (value !== "all") {
            window.location.href = 'http://localhost:8080/employees?filter=' + value;
        }
        else {
            window.location.href = 'http://localhost:8080/employees';
        }
    }
</script>

</html>
