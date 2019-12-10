<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style type="text/css">
        <%@ include file="static/exhibit.css"%>
    </style>
</head>
<body>
<jsp:include page="fragment/header.jsp"/>
<div class="container-exhibit">
    <div class="exhibit-picture">
        <img src="http://www.prostir.museum/static/images/_publications/EOM1301-01S.JPG">
    </div>
    <div class="exhibit-info">
        <div class="exhibit-header">${item.name}</div>
        <div class="exhibit-about"><b>Author:</b> ${item.author.firstName} ${item.author.lastName}</div>
        <div class="exhibit-about"><b>Description:</b> ${item.description}</div>
        <div class="exhibit-about"><b>Hall:</b>${item.hall.name}</div>
        <div class="exhibit-about"><b>Additional Information:</b></div>
        <div style="margin-left: 20px" class="exhibit-about"><b>Techniques:</b>
            <c:forEach var="t" items="${item.techniques}">
                ${t.name};
            </c:forEach>
        </div>
        <div style="margin-left: 20px" class="exhibit-about"><b>Materials:</b>
            <c:forEach var="m" items="${item.materials}">
                ${m.name};
            </c:forEach>
        </div>
        <div class="exhibit-about"><b>Receipt Date:</b>
            ${item.receiptDate}
        </div>
    </div>
</div>
</body>
</html>
