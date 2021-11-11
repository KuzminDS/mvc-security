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
        <th>Id</th>
        <th>Name</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Login</th>
        <th>Password</th>
        <th>Speciality</th>
        <th>Delete</th>
        <th>Update</th>
        <th>Records</th>
        <th>Appointments</th>
    </tr>
    <c:forEach var="doctor" items="${doctorList}">
        <tr>
            <td>${doctor.id}</td>
            <td>${doctor.fullName}</td>
            <td>${doctor.phoneNumber}</td>
            <td>${doctor.email}</td>
            <td>${doctor.login}</td>
            <td>${doctor.password}</td>
            <td>${doctor.speciality}</td>
            <td><button onclick="location.href='doctors/delete/${doctor.id}'">Delete</button></td>
            <td><button onclick="location.href='doctors/update/${doctor.id}'">Update</button></td>
            <td><button onclick="location.href='doctors/records/${doctor.id}'">Records</button></td>
            <td><button onclick="location.href='doctors/appointments/${doctor.id}'">Appointments</button></td>
        </tr>
    </c:forEach>
</table>
<button onclick="location.href='adminMainPage'">back</button>
</body>
</html>
