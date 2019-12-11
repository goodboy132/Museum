
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<jsp:include page="fragment/header.jsp"/>
<div style="width: 50%;margin: 0 auto; height: 100%;padding-top: 50px" class="container">
    <div style="font-size: 25px;font-family: sans-serif;font-weight: 600; text-align: center">
        Ooops you got an error</div>
    <div style="margin-top: 30px;font-size: 18px;color: red;text-align: center">${error}</div>
</div>
</body>
</html>
