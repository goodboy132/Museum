<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<jsp:include page="fragment/header.jsp"/>
<c:forEach var="exhibit" items="${exhibits}">
    <p>${exhibit}</p>
</c:forEach>
</body>
</html>
