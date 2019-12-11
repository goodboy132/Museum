<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <%@ include file="static/exhibits.css"%>
        .right-bar{
            margin-left: 5%;
            margin-right: 5%;
            width: 20%;
            height: 100%;
            display: flex;
            flex-direction: column;
        }
        button {
            width: 100%;
            font-size: 16px;
            font-family: sans-serif;
            margin-top: 20px;
        }
    </style>
</head>
<body style="position: relative">
<jsp:include page="fragment/header.jsp"/>
<div class="selection">
    <div class="main">
        <div style=" margin-bottom: 100px;" class="table">
            <div id="header" class="header_table"></div>
            <table id="exhibit01" style="display: none">
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
            <table id="exhibit02" style="display: none">
                <tr>
                    <th width="20%">Technique</th>
                    <th width="20%">Count</th>
                </tr>
                <c:forEach var="technique" items="${statisticByTechnique}">
                    <tr class="hover excursion">
                        <td>${technique.key}</td>
                        <td>${technique.value}</td>
                    </tr>
                </c:forEach>
            </table>
            <table id="exhibit03" style="display: none">
                <tr>
                    <th width="20%">Author</th>
                    <th width="20%">Count</th>
                </tr>
                <c:forEach var="author" items="${statisticByAuthor}">
                    <tr class="hover excursion">
                        <td>${author.key}</td>
                        <td>${author.value}</td>
                    </tr>
                </c:forEach>
            </table>
            <table id="exhibit04" style="display: none; margin-bottom: 20px" class="excursion-table">
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
            <table id="worker01" style="display: none">
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
            <table id="worker02" style="display: none">
                <tr>
                    <th width="20%">Employee</th>
                    <th width="20%">Total hours of work</th>
                </tr>
                <c:forEach var="excursion" items="${statisticByHours}">
                    <tr class="hover excursion">
                        <td>${excursion.key}</td>
                        <td>${excursion.value.getHour()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="right-bar">
        <h2 style="padding-bottom: 10px">Type:</h2>
        <select id="select">
            <option selected value="exhibits">Exhibits Statistic</option>
            <option value="guides">Guide Statistic</option>
        </select>
        <button id="btn">Select</button>
    </div>
</div>
<jsp:include page="fragment/footer.jsp"/>
</body>
<script>
    if (window.location.href === 'http://localhost:8080/statistic') {
        document.getElementById("exhibit01").style.display = 'table';
        document.getElementById("exhibit02").style.display = 'table';
        document.getElementById("exhibit03").style.display = 'table';
        document.getElementById("exhibit04").style.display = 'table';
        document.getElementById("header").textContent = 'Statistic By Exhibits: '
    }
    if (window.location.href === 'http://localhost:8080/statisticForEmployee') {
        document.getElementById("worker01").style.display = 'table';
        document.getElementById("worker02").style.display = 'table';
        document.getElementById("header").textContent = 'Statistic By Guides: '
    }
    document.getElementById("btn").addEventListener('click', change);
    function change() {
        let select = document.getElementById("select");
        let value = select[select.selectedIndex].value;
        if (value === "exhibits") {
            window.location.href = 'http://localhost:8080/statistic';
        }
        if (value === "guides") {
            window.location.href = 'http://localhost:8080/statisticForEmployee';
        }
    }
</script>
</html>
