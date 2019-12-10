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
                    <th width="25%">Description</th>
                    <th width="25%">Author</th>
                </tr>
                <c:forEach var="exhibit" items="${exhibits}">
                    <tr onclick="ref(${exhibit.id})" class="hover exhibit">
                        <td>${exhibit.exhibitName}</td>
                        <td>${exhibit.description}</td>
                        <td>${exhibit.authorDto.authorName}${exhibit.authorDto.authorSurname}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="right-bar">
        <div class="header_filter">Filter By:</div>
        <ol class="filter">
            <li id="hall">Hall<b onclick="show('halls',event.target)" class="icon"> +</b></li>
            <c:forEach var="hall" items="${halls}">
                <p class="hidden halls" style="margin-left: 20px">
                    <a href="${pageContext.request.contextPath}/exhibits?hall=${hall.id}"> ${hall.name}</a>
                </p>
            </c:forEach>
            <li id="author">Author <b onclick="show('authors',event.target)" class="icon"> +</b></li>
            <c:forEach var="author" items="${authors}">
                <p class="hidden authors" style="margin-left: 20px">
                    <a href="${pageContext.request.contextPath}/exhibits?author=${author.id}">${author.authorName}
                            ${author.authorSurname}</a>
                </p>
            </c:forEach>
            <li id="guide">Tour Guide <b onclick="show('guides',event.target)" class="icon"> +</b></li>
            <c:forEach var="guide" items="${guides}">
                <p class="hidden guides" style="margin-left: 20px">
                    <a href="${pageContext.request.contextPath}/exhibits?guide=${guide.id}">
                            ${guide.firstName} ${guide.lastName}</a>
                </p>
            </c:forEach>
        </ol>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script>

    function ref(param) {
        window.location.href = 'http://localhost:8080/exhibit?id=' + param;
    }

    function show(type, el) {
        let elementsByClassName = document.getElementsByClassName(type);
        for (let i = 0; i <= elementsByClassName.length; i++) {
            if (elementsByClassName[i].style.display === 'block') {
                elementsByClassName[i].style.display = 'none';
                el.textContent = ' +';
            } else {
                elementsByClassName[i].style.display = 'block';
                el.textContent = ' -';
            }
        }
    }
</script>
</body>
</html>
