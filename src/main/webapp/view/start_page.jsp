<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%-- <link rel="stylesheet" type="text/css"
            href="${pageContext.request.contextPath}/start_page.css">--%>
    <title>Testing</title>

    <%--<script type="text/javascript">
        <%@include file="/WEB-INF/js/knockout-3.3.0.js"%>
    </script>
--%>
    <style>
        <%@include file="/view/cssstyle/start_page.css"%>
    </style>
</head>
<body>
<div class="container">
    <p class="p1">Welcome to questionList web app</p>
    <p>To continue, please log in or sign in.</p>
    <form action="start" method="post">

        <div>

            <input type="text" id="login" name="login"
                   placeholder="login (your e-mail address)" required>

            <input type="password" id="password" name="password"
                   placeholder="password" required>
            <br/>
            <div style="color: red">${errorLoginOrPassword}</div>
        </div>
        <div>
            <button type="submit" name="command" value="log_in"> Log in</button>

            <button type="submit" class="signIn" name="command"
                    value="start_sign_in">Sign in
            </button>
        </div>
    </form>
</div>
</body>
</html>