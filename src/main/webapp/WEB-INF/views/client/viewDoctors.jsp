<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Doctors</title>
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
        <th>Name</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Speciality</th>
    </tr>
    <c:forEach var="doctor" items="${doctors}">
        <tr>
            <td>${doctor.fullName}</td>
            <td>${doctor.phoneNumber}</td>
            <td>${doctor.email}</td>
            <td>${doctor.speciality}</td>
        </tr>
    </c:forEach>
</table>
<button onclick="location.href='clientMainPage'">back</button>
</body>

