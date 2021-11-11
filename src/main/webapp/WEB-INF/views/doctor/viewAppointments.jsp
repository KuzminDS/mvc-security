<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Appointments</title>
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
        <th>Client's name</th>
        <th>Description</th>
        <th>Update</th>
    </tr>
    <c:forEach var="appointment" items="${appointments}">
        <tr>
            <td>${appointment.record.client.fullName}</td>
            <td>${appointment.description}</td>
            <td><button onclick="location.href='viewAppointments/update/${appointment.id}'">Update</button></td>
        </tr>
    </c:forEach>
</table>
<button onclick="location.href='doctorMainPage'">back</button>

</body>
