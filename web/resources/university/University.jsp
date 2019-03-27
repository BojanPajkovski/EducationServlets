<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.02.2019
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> University JSP</title>

  <link rel="stylesheet" type="text/css" href="resources/university/University.css">

  <script type="text/javascript" src = "resources/university/University.js"></script>

  <script type="text/javascript" src = "resources/library/jquery-3.3.1.min.js"></script>

</head>
<body>

<form action = "/university" method="post">

  <input type="number" name="id" placeholder="id" id ="id" hidden="true" value="${id}"/>
  <input type="text" name="name" placeholder="name" id ="name" value="${name}"/>
  <input type="text" name="description" placeholder="description" id = "description" value="${description}"/>
  <label for="location"> location</label>
  <input type="text" placeholder="location" name="location" id="location"value="${location}"/>

  <button type = "submit"> Add university to Servlet </button>
  <button onclick = "deleteUniversity('${id}')"> Delete University</button>


</form>

</body>
</html>
