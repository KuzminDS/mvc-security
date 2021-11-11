<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action = "register-new-doctor" method="POST">
    <label>Name:
        <input type="text" name="fullName"><br />
    </label>

    <label>Phone number:
        <input type="text" name="phoneNumber"><br />
    </label>

    <label>Email:
        <input type="text" name="email"><br />
    </label>

    <label>Login:
        <input type="text" name="login"><br />
    </label>

    <label>Password:
        <input type="password" name="password"><br />
    </label>

    <label> Speciality
    <select name = "speciality">
        <option>THERAPIST</option>
        <option>DENTIST</option>
        <option>SURGEON</option>
    </select>
    </label>

    <button type="submit">Register</button>
</form>
</body>
</html>
