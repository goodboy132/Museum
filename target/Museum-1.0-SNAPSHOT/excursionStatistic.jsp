<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <%@ include file="static/exhibits.css"%>
        table {
            display: none;
        }
        table.open{display: block}
    </style>
</head>
<body>
<jsp:include page="fragment/header.jsp"/>
<div class="selection">
    <div class="main">
        <div class="table">
            <div class="header_table">Excursion statistic:</div>
            <table class="excursion-table">
                <tr>
                    <th width="20%">Material</th>
                    <th width="20%">Count</th>
                </tr>
                <c:forEach var="material" items="${statisticByMaterial}">
                    <tr class="hover excursion">
                        <td>${material.key}</td>
                        <td>${material.value}</td>
                    </tr>
                </c:forEach>
            </table>
            <table class="excursion-table">
                <tr>
                    <th width="20%">Technique</th>
                    <th width="20%">Count</th>
                    >
                </tr>
                <c:forEach var="technique" items="${statisticByTechnique}">
                    <tr class="hover excursion">
                        <td>${technique.key}</td>
                        <td>${technique.value}</td>
                    </tr>
                </c:forEach>
            </table>
            <table class="excursion-table">
                <tr>
                    <th width="20%">Author</th>
                    <th width="20%">Count</th>
                    >
                </tr>
                <c:forEach var="author" items="${statisticByAuthor}">
                    <tr class="hover excursion">
                        <td>${author.key}</td>
                        <td>${author.value}</td>
                    </tr>
                </c:forEach>
            </table>
            <table class="excursion-table">
                <tr>
                    <th width="20%">Hall</th>
                    <th width="20%">Count</th>
                </tr>
                <c:forEach var="hall" items="${statisticByHall}">
                    <tr class="hover excursion">
                        <td>${hall.key}</td>
                        <td>${hall.value}</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="header_table">Employee statistic:</div>
            <table>
                <tr>
                    <th width="20%">Employee</th>
                    <th width="20%">Count of Excursion</th>
                </tr>
                <c:forEach var="excursion" items="${statisticByExcursion}">
                    <tr class="hover excursion">
                        <td>${excursion.key}</td>
                        <td>${excursion.value}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="right-bar">
        <a id="statistic-for-employee" href="${pageContext.request.contextPath}/statisticForEmployee">statistic for
            employee</a>
        <a href="${pageContext.request.contextPath}/statistic">statistic for excursions</a>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script>
    $( "#statistic-for-employee" ).on( "click", function() {
        $( ".excursion-table" ).toggleClass("open");
    });
</script>

</body>
</html>
