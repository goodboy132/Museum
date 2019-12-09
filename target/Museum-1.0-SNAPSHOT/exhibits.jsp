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
            <div class="header_table">All Exhibits:</div>
            <table>
                <tr>
                    <th width="20%">Exhibit name</th>
                    <th width="25%">Author</th>
                    <th width="25%">Technique</th>
                    <th width="30%">Material</th>
                </tr>
                <c:forEach var="exhibit" items="${exhibits}">
                    <tr class="hover">
                        <td>${exhibit.name}</td>
                        <td>${exhibit.name}</td>
                        <td>>${exhibit.name}</td>
                        <td>${exhibit.name}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="right-bar">
        <div class="header_filter">Filter By:</div>
        <ol class="filter">
            <li onclick="" id="hall">Hall</li>
            <c:forEach var="hall" items="${halls}">
                <p>${hall.name}</p>
            </c:forEach>
            <li id="author">Author</li>
            <c:forEach var="author" items="${authors}">
                <p>${author.firstName}</p>
            </c:forEach>
            <li id="guide">Tour Guide</li>
        </ol>
    </div>
</div>
<script>
    document.getElementById('author').click()

    })
</script>
</body>
</html>
