<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <%@ include file="static/excursion.css"%>
    </style>
</head>
<body style="position: relative">
<jsp:include page="fragment/header.jsp"/>
<div class="selection">
    <div class="main">
            <div class="header_table">All Excursions:</div>
            <table style="margin-bottom: 100px;">
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
                                ${time_table.startTime.getYear()}/${time_table.startTime.getMonthValue()}/${time_table.startTime.getDayOfMonth()} ${time_table.startTime.getHour()}:${time_table.startTime.getMinute()} -
                                ${time_table.endTime.getYear()}/${time_table.endTime.getMonthValue()}/${time_table.endTime.getDayOfMonth()} ${time_table.endTime.getHour()}:${time_table.endTime.getMinute()}
                                <br>
                            </c:forEach>
                        </td>

                    </tr>
                </c:forEach>
            </table>
    </div>
    <div class="filter-position">
        <h2 style="padding-top: 30px;">Free excursions in current date: </h2>
        <form action="/excursions" method="get">
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

</body>
<jsp:include page="fragment/footer.jsp"/>
</html>
