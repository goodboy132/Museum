<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <%@ include file="static/exhibits.css"%>
    </style>
</head>
<body>
<jsp:include page="fragment/header.jsp"/>
<div class="selection">
    <div class="main">
        <div class="table">
            <div class="header_table">All Excursions:</div>
            <table>
                <tr>
                    <th width="20%">Excursion name</th>
                    <th width="20%">Program</th>
                    <th width="20%">Tour Guide</th>
                    <th width="40%">Time Table</th>
                </tr>
                <c:forEach var="excursion" items="${excursions}">
                    <tr class="hover excursion">
                        <td>${excursion.name}</td>
                        <td>${excursion.program}</td>
                        <td>${excursion.worker.firstName} ${excursion.worker.lastName}</td>
                        <td>
                            <c:forEach var="time_table" items="${excursion.timeTables}">
                                ${time_table.startTime} - ${time_table.endTime}
                                <br>
                            </c:forEach>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="right-bar">
        <p>Start date: <input type="datetime-local" name="calendar">
        <p>End date: <input type="datetime-local" name="calendar">
    </div>
</div>

</body>
</html>
