<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee manager app</title>
</head>
<body>
<h2>Add employee</h2><br>
<form:form action="/create-or-update" modelAttribute="employee" method="post">
    <form:hidden path="id"/>
    Name: <form:input path="name"/> <form:errors path="name"/><br><br>
    <br><br>
    Surname: <form:input path="surname"/> <form:errors path="surname"/><br><br>
    <br><br>
    Department:
    <form:select path="department">
        <form:option value="Backend" label="Backend"/>
        <form:option value="Frontend" label="Frontend"/>
        <form:option value="Devops" label="Devops"/>
    </form:select>
    <br><br>
    Salary: <form:input path="salary"/> <form:errors path="salary"/><br><br>
    <br><br>
    <input type="submit" value="Create">
</form:form>
</body>
</html>