<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="cssstyle/template_page.css">
    <title>Tutor</title>
    <style>
        <%@include file="/view/cssstyle/template_page.css"%>
    </style>
</head>
<body>
<header>
    <div class="container">

        <div class="div1">
            <p> Test App</p>
        </div>

        <div class="div2">
            <form action="start" method="post">
                <div>
                    <button type="submit" name="command" value="log_out">
                        Log out
                    </button>
                </div>
            </form>
        </div>
    </div>
</header>


</body>
</html>
