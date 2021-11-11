<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Clients</title>
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
        <th>Delete</th>
        <th>Update</th>
        <th>Records</th>
        <th>Appointments</th>
    </tr>


    <c:forEach var="client" items="${clientList}">
        <tr>
            <td>${client.id}</td>
            <td>${client.fullName}</td>
            <td>${client.phoneNumber}</td>
            <td>${client.email}</td>
            <td>${client.login}</td>
            <td>${client.password}</td>
            <td><button onclick="location.href='clients/delete/${client.id}'">Delete</button></td>
            <td><button onclick="location.href='clients/update/${client.id}'">Update</button></td>
            <td><button onclick="location.href='clients/records/${client.id}'">Records</button></td>
            <td><button onclick="location.href='clients/appointments/${client.id}'">Appointments</button></td>
        </tr>
    </c:forEach>
</table>
<button onclick="location.href='adminMainPage'">back</button>
</body>
</html>
