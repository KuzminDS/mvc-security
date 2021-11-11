<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Update client</title>
</head>
<body>
<form action = "update-client" method="POST">

    <input value="${client.id}" type="hidden" name="id"/>
    <label>Name:
        <input type="text" name="fullName" value="${client.fullName}"><br />
    </label>

    <label>Phone number:
        <input type="text" name="phoneNumber" value="${client.phoneNumber}"><br />
    </label>

    <label>Email:
        <input type="text" name="email" value="${client.email}"><br />
    </label>

    <label>Login:
        <input type="text" name="login" value="${client.login}" disabled="true"><br />
    </label>

    <label>Password:
        <input type="password" name="password" value="${client.password}" disabled="true"><br />
    </label>

    <button type="submit">Update</button>
</form>
</body>
</html>
