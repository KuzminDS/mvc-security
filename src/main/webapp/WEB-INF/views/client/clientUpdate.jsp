<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Client Update</title>
</head>
<body>
<form action = "update-client" method="POST">

    <label>Id:
        <input type="number" value="${client.id}" name="id"><br />
    </label>

    <label>Name:
        <input type="text" value="${client.fullName}" name="fullName"><br />
    </label>

    <label>Phone number:
        <input type="text" value="${client.phoneNumber}" name="phoneNumber"><br />
    </label>

    <label>Email:
        <input type="text" value="${client.email}"  name="email"><br />
    </label>

    <label>Login:
        <input type="text" value="${client.login}"  name="login"><br />
    </label>

    <label>Password:
        <input type="password" value="${client.password}" name="password"><br />
    </label>

    <button type="submit">Update</button>
</form>
</body>
</html>
