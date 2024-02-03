<%--
  Created by IntelliJ IDEA.
  User: nmurt
  Date: 07/01/2024
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="login" method="post">
    Username: <input type="text" name="userName"><br>
    Password: <input type="password" name="userPassword"><br>
    <input type="submit" value="Login">
</form>
<%--<a href="forgotPassword.jsp">Forgot Password?</a><br>--%>
<a href="register">Not a member? Signup</a>
</body>
</html>