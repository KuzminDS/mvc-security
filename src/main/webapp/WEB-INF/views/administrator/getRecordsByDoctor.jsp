<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Records</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Doctor</th>
    </tr>
    <c:forEach var="record" items="${records}">
        <tr>
            <td>${record.doctor.fullName}</td>
        </tr>
    </c:forEach>
</table>
<button onclick="location.href='/MvcDataSecurityTask_war_exploded/administrator/doctors'">back</button>
</body>
