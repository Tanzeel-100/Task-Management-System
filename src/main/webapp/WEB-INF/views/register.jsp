<%--
  Created by IntelliJ IDEA.
  User: nmurt
  Date: 07/01/2024
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>

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
    <div class="title" style="text-align: center">Registration Form</div>
    <div class="title" style="text-align: center">${Header}</div>
    <hr>
    <div class="content">
        <!-- Registration form -->
        <p style="text-align: center">${Desc}</p>
        <form action="register-user" method="post">
            <div class="user-details">
                <!-- Input box for userId -->
                <div class="input-box">
                    <span class="details">UserId</span>
                    <input name="userId" type="text" placeholder="Enter your userId" required>
                </div>
                <!-- Input box for username -->
                <div class="input-box">
                    <span class="details">Username</span>
                    <input name="userName" type="text" placeholder="Enter your username" required>
                </div>
                <!-- Input box for email -->
                <div class="input-box">
                    <span class="details">Email</span>
                    <input name="userEmail" type="text" placeholder="Enter your email" required>
                </div>
                <!-- Input box for password -->
                <div class="input-box">
                    <span class="details">Password</span>
                    <input name="userPassword" type="text" placeholder="Enter your password" required>
                </div>
            </div>
            <!-- Button container -->
            <div class="button-container">
                <div class="button">
                    <!-- Submit button -->
                    <input type="submit" value="Register">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
