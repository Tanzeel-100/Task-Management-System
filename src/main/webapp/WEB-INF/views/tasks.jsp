<%--
  Created by IntelliJ IDEA.
  User: nmurt
  Date: 01/02/2024
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tasks</title>
</head>
<body>
<div>
    <c:if test="${not empty msg}">
        <h4>${msg}</h4>
        <c:remove var="msg"/>
    </c:if>
</div>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Task Id</th>
            <th scope="col">Task Name</th>
            <th scope="col">Task Description</th>
            <th scope="col">Task State</th>
        </tr>
    </thead>
    <tbody class="table-group-divider">
    <c:forEach items="${taskList}" var="task">
        <tr>
            <th scope="row">${task.taskId}</th>
            <td>${task.taskName}</td>
            <td>${task.taskDescription}</td>
            <td>${task.taskStatus}</td>
            <td>${task.taskAssignee}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
