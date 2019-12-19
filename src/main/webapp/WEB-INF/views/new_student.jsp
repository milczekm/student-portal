<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New Student</title>
</head>
<body>
<div align="center">
    <h2>New Student</h2>
    <%--@elvariable id="student" type=""--%>
    <form:form action="save" method="post" modelAttribute="student">
        <table border="0" cellpadding="5">
            <tr>
                <td>Name: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Second name: </td>
                <td><form:input path="secondName" /></td>
            </tr>
            <tr>
                <td>Last name: </td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td>Birth date: </td>
                <td><form:input path="birthDate" /></td>
            </tr>
            <tr>
                <td>Pesel: </td>
                <td><form:input path="pesel" /></td>
            </tr>
            </table>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
