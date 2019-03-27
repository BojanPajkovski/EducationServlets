<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.02.2019
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1> All faculties</h1>

<table border="1" cellpadding="5">
  <caption><h2>List of Faculties</h2></caption>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Location</th>
    <th>Description</th>
    <th>Technical</th>
  </tr>
  <c:forEach var="faculty" items="${listFaculty}">
    <tr>
      <td><c:out value="${faculty.id}" /></td>
      <td><c:out value="${faculty.name}" /></td>
      <td><c:out value="${faculty.location}" /></td>
      <td><c:out value="${faculty.description}" /></td>
      <td><c:out value="${faculty.tecnical}" /></td>
      <td>
        <a href="/faculty?action=edit&id=<c:out value='${faculty.id}' />">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/faculty?action=delete&id=<c:out value='${faculty.id}' />">Delete</a>
      </td>
    </tr>
  </c:forEach>
  <button onclick='window.location ="/faculty?action=add"'>Add new</button>
  <input type="text" name="name" id = "name" placeholder="name"/>
  <input type="text" name="desc" id = "desc" placeholder="desc" />
  <button onclick='window.location ="/faculty?action=search&name="+document.getElementById("name").value +"&desc=" + document.getElementById("desc").value'>Search</button>

</table>
</body>
</html>
