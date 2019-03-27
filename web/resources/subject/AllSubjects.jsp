<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.02.2019
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> All subjects</title>
</head>
<body>

<h1> All subjects</h1>

<table border="1" cellpadding="5">
  <caption><h2>List of Subjects</h2></caption>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Credits</th>
    <th>Semestar</th>

  </tr>
  <c:forEach var="subject" items="${listAllSubjects}">
    <tr>
      <td><c:out value="${subject.id}" /></td>
      <td><c:out value="${subject.name}" /></td>
      <td><c:out value="${subject.credits}" /></td>
      <td><c:out value="${subject.semestar}" /></td>
      <td>
        <a href="/subject?action=edit&id=<c:out value='${subject.id}' />">Edit Subject</a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/subject?action=delete&id=<c:out value='${subject.id}' />">Delete Subject</a>
      </td>
    </tr>
  </c:forEach>
</table>


<button onclick='window.location ="/subject?action=listSubjectByCredits"' >List Subjects by Credits</button>

</body>
</html>
