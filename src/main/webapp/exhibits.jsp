<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <%@ include file="static/exhibits.css"%>
    </style>
</head>
<body>
<jsp:include page="fragment/header.jsp"/>
<%--<c:forEach var="exhibit" items="${exhibits}">--%>
    <%--<p>${exhibit}</p>--%>
<%--</c:forEach>--%>
<div class="selection">
    <div class="main">
        <div class="header">Exhibits</div>
        <div class="table"></div>
    </div>
    <div class="right-bar">
        <div class="header_filter">Filter By:</div>
        <ol class="filter">
            <li>Hall</li>
            <c:forEach var="hall" items="${halls}">
                <p>${hall.name}</p>
            </c:forEach>
            <li>Author</li>
            <c:forEach var="author" items="${authors}">
                <p>${author.firstName}</p>
            </c:forEach>
            <li>Tour Guide</li>
        </ol>
    </div>
</div>
</body>
</html>
