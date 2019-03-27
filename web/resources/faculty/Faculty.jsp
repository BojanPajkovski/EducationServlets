<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.02.2019
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> Faculty JSP</title>

  <link rel="stylesheet" type="text/css" href="resources/faculty/Faculty.css">

  <script type="text/javascript" src = "resources/library/jquery-3.3.1.min.js"></script>


  <script type="text/javascript" src = "resources/faculty/Faculty.js"></script>



</head>
<body>

<%--<form action = "/faculty" method="post">
  <c:out value="${faculty.id}" />
  <input type="number" name="id" placeholder="id" id ="id1" hidden="true" value="${faculty.id}"/>
  <input type="text" name="name" placeholder="name" id ="name1" value="${faculty.name}"/>
  <input type="text" name="description" placeholder="description" id = "description1"  value="${faculty.description}"/>
  <label for="tecnical"> tehnichki</label>
  <input type="checkbox" name="tecnical" id="tecnical"  value="${faculty.tecnical}"/>

  <button type = "submit"> Add or Update faculty to Servlet </button>

</form>--%>

<div id="form">
  <input type="number" name="id" placeholder="id" id ="id1" hidden="true" value="${faculty.id}"/>
  <input type="text" name="name" placeholder="name" id ="name1" value="${faculty.name}" onkeyup="facultyValidation()"/>
  <span id = "facultytNameValidation"> Must provide name !!! </span>
  <input type="text" name="description" placeholder="description" id = "description1"  value="${faculty.description}"onkeyup="facultyValidation()"/>
  <span id = "facultyDescriptionValidation"> Must provide description !!! </span>
  <label for="tecnical"> tehnichki</label>
  <input type="checkbox" name="tecnical" id="tecnical"  value="${faculty.tecnical}"/>


  <button type = "submit" onclick="saveAction()" > Save </button>
</div>
<div id="successButton" >
  <label> Successfullyt execute </label>
  <button onclick='window.location ="/faculty?action=listFaculty"' >Ok</button>
</div>

<div id="errorMessage" >
  <label> Error happened</label>
  <button onclick='window.location ="/faculty?action=listFaculty"' >Ok</button>
</div>


</body>
</html>
