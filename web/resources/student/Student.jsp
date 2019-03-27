<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.02.2019
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> Student JSP</title>

  <link rel="stylesheet" type="text/css" href="resources/student/Student.css">

    <script type="text/javascript" src = "resources/library/jquery-3.3.1.min.js"></script>

  <script type="text/javascript" src = "resources/student/Student.js"></script>



</head>
<body>

<div id="form">

    <input type="number" name="id" id="id" placeholder="id" hidden="true" value="${student.id}" >
    <input type="text" name="name" id = "name" placeholder="name" value="${student.name}" onkeyup="validation()" />
    <span id="nameValidation"> Must provide name!!</span>
    <input type="text" name="surName" id = "surName" placeholder="surName" value="${student.surname}"onkeyup="validation()" />
    <div id = surNameValidation> Must provide surname !!!</div>
    <input type="number" name="age" id = "age" placeholder="age" value="${student.age}"onkeyup="validation()" />
    <div id = ageValidation> Must provide age !!!</div>

    <button type = "submit" onclick="saveStudentAction()" > Save </button>
</div>

<p id = "demo"></p>

<div id="successStudentButton" >
    <label> Successfully execute </label>
    <button onclick='window.location ="/student?action=listStudent"' >Ok</button>
</div>

<div id="errorStudentMessage" >
    <label> Error happened</label>
    <button onclick='window.location ="/student?action=listStudent"' >Ok</button>
</div>
  <%--<form action = "/student" method="post">
      <c:out value="${student.id}" />
      <input type="number" name="id" id="id" placeholder="id" hidden="true" value="${student.id}">
      <input type="text" name="name" id = "name" placeholder="name" value="${student.name}" />
      <input type="text" name="surName" id = "surName" placeholder="surName" value="${student.surname}" />
      <input type="number" name="age" id = "age" placeholder="age" value="${student.age}" />

    <button type = "submit"> Add or Update student to Servlet </button>

      </form>



  <button onclick = "deleteStudent('${id}')"> Delete Student</button>--%>

      <%--<form action = "/faculty" method="post">
          <c:out value="${faculty.id}" />
          <input type="number" name="id" placeholder="id" id ="id1" hidden="true" value="${faculty.id}"/>
          <input type="text" name="name" placeholder="name" id ="name1" value="${name}"/>
          <input type="text" name="description" placeholder="description" id = "description1"  value="${description}"/>
          <label for="tecnical"> tehnichki</label>
          <input type="checkbox" name="tecnical" id="tecnical"  value="${tecnical}"/>

          <button type = "submit"> Add or Update faculty to Servlet </button>

      </form>

      <button onclick = "deleteFaculty('${id}')"> Delete Faculty</button>


      <button onclick = "testAjax()"> Test Ajax</button>
--%>

 <%-- </form>

  <form action = "/student" method="post">

      <input type="number" name="id" id="id1" placeholder="id" required="true">
      <input type="text" name="name" id = "name1" placeholder="name" />
      <input type="text" name="surName" id = "surName1" placeholder="surName" />
      <input type="number" name="age" id = "age1" placeholder="age" />

      <button type = "submit"> Update student to Servlet </button>

  </form>--%>
</body>
</html>
