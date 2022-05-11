<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee manager app</title>
</head>
<body>
<h2>All employees</h2><br>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <c:url var="updateButton" value="/update">
            <c:param name="employeeId" value="${employee.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/delete">
            <c:param name="employeeId" value="${employee.id}"/>
        </c:url>
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.department}</td>
            <td>${employee.salary}</td>
            <td>
                <input type="button" value="Update"
                onclick="window.location.href = '${updateButton}'">
                <input type="button" value="Delete"
                onclick="window.location.href = '${deleteButton}'">
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add employee" onclick="window.location.href = '/create'">
</body>
</html>