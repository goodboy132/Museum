<%--<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
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
                <div class="row">
                    <div class="button_record">sign up</div>
                </div>
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
                <li>About museum</li>
                <li><a href="${pageContext.request.contextPath}/exhibits">Exhibits</a></li>
                <li>Excursion</li>
                <li><a href="${pageContext.request.contextPath}/employees">Employees</a></li>
                <li>Contacts</li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>

