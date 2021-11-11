<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Update doctor</title>
</head>
<body>
<form action = "update-doctor" method="POST">

    <input name="id" value="${doctor.id}" type="hidden"><br />

    <label>Name:
        <input type="text" name="fullName" value="${doctor.fullName}" ><br />
    </label>

    <label>Phone number:
        <input type="text" name="phoneNumber" value="${doctor.phoneNumber}" ><br />
    </label>

    <label>Email:
        <input type="text" name="email" value="${doctor.email}"><br />
    </label>

    <label>Login:
        <input type="text" name="login" value="${doctor.login}" disabled="true" ><br />
    </label>

    <label>Password:
        <input type="password" name="password" value="${doctor.password}" disabled="true"><br />
    </label>

    <label> Speciality
        <select name = "speciality">
            <option>THERAPIST</option>
            <option>DENTIST</option>
            <option>SURGEON</option>
        </select>
    </label>

    <button type="submit">Update</button>
</form>
</body>
</html>
