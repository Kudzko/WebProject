<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/jsp/signin.css">
    <title>Testing</title>
    <style>
        <%@include file="/view/cssstyle/signin.css"%>
    </style>
</head>
<body>
<div class="container">
    <form action="start" method="post">
        <div>
            <div style="color: red">${loginBooked}</div>
            <input type="text" id="login" name="login"
                   placeholder="login (your e-mail address)" value="<% String login = request.getParameter("login");
                    out.print(login);%>"
                   required>

            <input type="password" id="password" name="password"
                   placeholder="password" value="
                        <% String pass = request.getParameter("password");
                        out.print(pass);%>"
                   required>
            <input type="text" id="name" name="name"
                   placeholder="name" required>
            <input type="text" id="suname" name="surname"
                   placeholder="suname" required>

        </div>
        <br>
        <p class="role">Status</p>
        <div class="select">
            <select name="role" id="">
                <option value="student" selected>student</option>
                <option value="tutor">tutor</option>
            </select>
            <i class="fas fa-chevron-down"></i>
        </div>
        <div>
            <button type="submit" name="command"
                    value="sign_in">Sign in
            </button>
        </div>
    </form>
</div>
</body>
</html>