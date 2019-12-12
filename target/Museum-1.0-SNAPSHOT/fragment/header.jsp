<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <style type="text/css">
        <%@ include file="../static/header.css" %>
    </style>
</head>
<body>
<div class="header">
    <div class="container">
        <div class="first_header">
            <div class="logo"><b style="color: #d64541">MODERN</b><b style="color: snow">MUSEUM</b></div>
            <div class="ordering">
                <div class="contacts">
                    <div class="numbers">
                        <p>+7 495 312-11-22</p>
                        <p style="margin-bottom: 10px">+7 495 312-11-24</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="thecond_header">
            <ul>
                <li><a href="${pageContext.request.contextPath}/">Main</a></li>
                <li><a href="${pageContext.request.contextPath}/exhibits">Exhibits</a></li>
                <li><a href="${pageContext.request.contextPath}/excursions">Excursions</a></li>
                <li><a href="${pageContext.request.contextPath}/employees">Employees</a></li>
                <li><a href="${pageContext.request.contextPath}/statistic">Statistic</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>

