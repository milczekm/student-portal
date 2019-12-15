<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Student</title>
</head>
<body>
<div align="center">
    <h2>Edit Student</h2>
    <%--@elvariable id="student" type=""--%>
    <form:form action="save" method="post" modelAttribute="student">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td><form:input path="id" id="id"/></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><form:input path="name" id="name"/></td>
            </tr>
            <tr>
                <td>Second name: </td>
                <td><form:input path="secondName" id="secondName"/></td>
            </tr>
            <tr>
                <td>Last name: </td>
                <td><form:input path="lastName" id="lastName" /></td>
            </tr>
            <tr>
                <td>Birth date: </td>
                <td><form:input path="birthDate2" id="birthDate2"/></td>
            </tr>
            <tr>
                <td>Pesel: </td>
                <td><form:input path="pesel" id="pesel"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
