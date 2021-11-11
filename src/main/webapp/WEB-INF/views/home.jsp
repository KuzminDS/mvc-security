 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<div>
    <h1>Hospital mvc</h1>
</div>
<p>Register or login</p>
<div>
    <div>
        <button onclick="location.href='register/client'">Client registration</button>
        <button onclick="location.href='register/doctor'">Doctor registration</button>
        <button onclick="location.href='register/administrator'">Admin registration</button>
        <button onclick="location.href='administrator/adminMainPage'">Admin page</button>
        <button onclick="location.href='client/clientMainPage'">Client page</button>
        <button onclick="location.href='doctor/doctorMainPage'">Doctor page</button>
        <button onclick="location.href='login'">Login</button>
    </div>
</div>
</body>
</html>
