<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> </title>
    <link rel="stylesheet" href="<c:url value='header.css'/>" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"/>
<c:forEach var="exhibit" items="${exhibits}">
    <p>${exhibit}</p>
</c:forEach>
</body>
</html>
