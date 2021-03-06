<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student Portal</title>
</head>
<body>
<div align="center">
    <h2>Student Portal</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
    <h3><a href="./new">New Student</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Second Name</th>
            <th>Last Name</th>
            <th>Birth Date</th>
            <th>Pesel</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.secondName}</td>
                <td>${student.lastName}</td>
                <td> <fmt:formatDate pattern = "yyyy-MM-dd" value = "${student.birthDate2}" /></td>
                <td>${student.pesel}</td>
                <td>
                    <a href="./edit?id=${student.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="./delete?id=${student.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
