<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 30/11/2022
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>User Registration Form</h2>
<form action="register/agent" method="post">
    <label>User Name : </label> <input type="text" name="username"><br>
    <br> <label>Password : </label> <input type="password" name="password"><br>
    <br> <label>Email : </label> <input type="text" name="email"><br>
    <br> <input type="submit" value="Register">
</form>
</body>
</html>
