<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.Calendar"%>

<html>
<head>
    <title>Make Appointment</title>
</head>
<body>
    <h1>Make appointment</h1>
    <form action="get-timetable" method="GET">
        <label> Select doctor:
            <select id = "doctor_drop" name ="id">
                <c:forEach items="${doctors}" var="doctor">
                    <option value="${doctor.id}">${doctor.fullName}</option>
                </c:forEach>
            </select>
            <button type="submit">Select</button>
        </label>
    </form>
    <br>
    <form method="POST" action="add-record" id="addRecord" onsubmit='updateHiddenField();'>
        <input id="doctorId" value="" type="hidden" name="doctorId"/>
        <input id="clientId" value="${client.id}" type="hidden" name="clientId"/>
        <label> Select date and time:
            <select id="gaps_drop" name = "gap">
                <c:forEach items="${gaps}" var="gap">
                    <option value="${gap.key}">${gap.value}</option>
                </c:forEach>
            </select>
        </label>
        <br>
        <button type="submit">Contract</button>
    </form>

    <script type='text/javascript'>
        function updateHiddenField() {
            var value = document.getElementById('doctor_drop').value;
            document.getElementById('doctorId').value = value;
            document.getElementById('addRecord').submit();
            return false;
        }
    </script>
    <button onclick="location.href='clientMainPage'">back</button>
</body>
</html>
