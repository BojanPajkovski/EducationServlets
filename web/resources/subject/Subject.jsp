<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.02.2019
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Subject JSP</title>

  <link rel="stylesheet" type="text/css" href="resources/subject/Subject.css">

  <script type="text/javascript" src = "resources/library/jquery-3.3.1.min.js"></script>

  <script type="text/javascript" src = "resources/subject/Subject.js"></script>


</head>
<body>


  <div id = "form">
  <input type="number" name="id" placeholder="id" hidden="true" value="${subject.id}">
  <input type="text" name="name" placeholder="name" id ="name" value="${subject.name}"/>
  <input type="number" name="credits" placeholder="credits" id = "credits" value="${subject.credits}"/>
  <label for="semestar"> semestar</label>
  <input type="text" name="semestar" id="semestar"value="${subject.semestar}"/>

  <button type = "submit" onclick ="saveSubjectAction()" > Save </button>

  </div>

  <div id="successButton" >
    <label> Successfullyt execute </label>
    <button onclick='window.location ="/subject?action=listSubject"' >Ok</button>
  </div>

  <div id="errorMessage" >
    <label> Error happened</label>
    <button onclick='window.location ="/subject?action=listSubject"' >Ok</button>
  </div>






<%--<form action = "/subject" method="post">

  <input type="number" name="id" placeholder="id" required="true" >
  <input type="text" name="name" placeholder="name" id ="name1"/>
  <input type="number" name="credits" placeholder="credits" id = "credits1"/>
  <label for="semestar"> semestar</label>
  <input type="text" name="semestar" id="semestar1"/>

  <button type = "submit"> Update subject to Servlet by ID </button>

</form>--%>

</body>
</html>
