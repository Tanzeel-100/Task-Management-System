<%--
  Created by IntelliJ IDEA.
  User: nmurt
  Date: 07/01/2024
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Success Page</title>
</head>
<body>

<%--With model user--%>
<h1>Your user-name is ${user.userName}</h1>
<h2>Your email is ${user.userEmail}</h2>
</body>
</html>
