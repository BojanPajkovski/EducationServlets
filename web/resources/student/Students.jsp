<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.02.2019
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All students</title>
</head>
<body>

<h1> All students</h1>

<table border="1" cellpadding="5">
  <caption><h2>List of Students</h2></caption>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Surname</th>
    <th>Age</th>
  </tr>
  <c:forEach var="student" items="${listStudent}">
    <tr>
      <td><c:out value="${student.id}" /></td>
      <td><c:out value="${student.name}" /></td>
      <td><c:out value="${student.surname}" /></td>
      <td><c:out value="${student.age}" /></td>
      <td>
        <a href="/student?action=edit&id=<c:out value='${student.id}' />">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/student?action=delete&id=<c:out value='${student.id}' />">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>

<button onclick='window.location ="/student?action=listStudentByAge"' >List Students by Age</button>



</body>
</html>
