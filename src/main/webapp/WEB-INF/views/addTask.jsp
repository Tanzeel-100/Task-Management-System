<%--
  Created by IntelliJ IDEA.
  User: nmurt
  Date: 07/01/2024
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>

<html>
<head>
  <meta charset="UTF-8">
  <title>Task Form</title>

  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Poppins', sans-serif;
    }

    body {
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      padding: 10px;
      background: linear-gradient(135deg, #71b7e6, #9b59b6);
    }

    .container {
      max-width: 700px;
      width: 100%;
      background-color: #fff;
      padding: 25px 30px;
      border-radius: 5px;
      box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
    }

    .container .title {
      font-size: 25px;
      font-weight: 500;
      position: relative;
    }

    .container .title::before {
      content: "";
      position: absolute;
      left: 0;
      bottom: 0;
      height: 3px;
      width: 30px;
      border-radius: 5px;
      background: linear-gradient(135deg, #71b7e6, #9b59b6);
    }

    .content form .user-details {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      margin: 20px 0 12px 0;
    }

    form .user-details .input-box {
      margin-bottom: 15px;
      width: calc(100% / 2 - 20px);
    }

    form .input-box span.details {
      display: block;
      font-weight: 500;
      margin-bottom: 5px;
    }

    .user-details .input-box input {
      height: 45px;
      width: 100%;
      outline: none;
      font-size: 16px;
      border-radius: 5px;
      padding-left: 15px;
      border: 1px solid #ccc;
      border-bottom-width: 2px;
      transition: all 0.3s ease;
    }

    .user-details .input-box input:focus,
    .user-details .input-box input:valid {
      border-color: #9b59b6;
    }

    form .gender-details .gender-title {
      font-size: 20px;
      font-weight: 500;
    }

    form .category {
      display: flex;
      width: 80%;
      margin: 14px 0;
      justify-content: space-between;
    }

    form .category label {
      display: flex;
      align-items: center;
      cursor: pointer;
    }

    form .button {
      height: 45px;
      margin: 35px 0
    }

    form .button input {
      height: 100%;
      width: 100%;
      border-radius: 5px;
      border: none;
      color: #fff;
      font-size: 18px;
      font-weight: 500;
      letter-spacing: 1px;
      cursor: pointer;
      transition: all 0.3s ease;
      background: linear-gradient(135deg, #71b7e6, #9b59b6);
    }

    form .button input:hover {
      /* transform: scale(0.99); */
      background: linear-gradient(-135deg, #71b7e6, #9b59b6);
    }

    @media (max-width: 584px) {
      .container {
        max-width: 100%;
      }

      form .user-details .input-box {
        margin-bottom: 15px;
        width: 100%;
      }

      form .category {
        width: 100%;
      }

      .content form .user-details {
        max-height: 300px;
        overflow-y: scroll;
      }

      .user-details::-webkit-scrollbar {
        width: 5px;
      }
    }

    @media (max-width: 459px) {
      .container .content .category {
        flex-direction: column;
      }
    }
  </style>
</head>
<body>
<!-- Container for the registration form -->
<div class="container">
  <!-- Title of the form -->
  <div class="title" style="text-align: center">Task Form</div>
  <div class="title" style="text-align: center">${Header}</div>
  <hr>
  <div class="content">
    <!-- Registration form -->
    <p style="text-align: center">${Desc}</p>
    <form action="submit-task-form" method="post">
      <div class="task-details">
        <!-- Input box for id -->
        <div class="input-box">
          <span class="details">Task Id</span>
          <input name="taskId" type="text" placeholder="Enter the Task Id" required>
        </div>
        <!-- Input box for name -->
        <div class="input-box">
          <span class="details">Task Name</span>
          <input name="taskName" type="text" placeholder="Enter your Task Name" required>
        </div>
        <!-- Input box for description -->
        <div class="input-box">
          <span class="details">Task Description</span>
          <input name="taskDescription" type="text" placeholder="Enter the task description" required>
        </div>
        <!-- Input box for state -->
        <div class="input-box">
          <span class="details">State</span>
          <input name="taskStatus" type="text" placeholder="Enter the status" required>
        </div>
        <!-- Input box for user id -->
        <div class="input-box">
          <span class="details">State</span>
          <input name="taskAssignee" type="text" placeholder="Enter the Assignee id" required>
        </div>
      </div>
      <!-- Button container -->
      <div class="button-container">
        <div class="button">
          <!-- Add button -->
          <input type="submit" value="Add">
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>
