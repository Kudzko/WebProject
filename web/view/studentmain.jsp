
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%--<link rel="stylesheet" type="text/css" href="template_page.css">--%>
    <style>
        <%@include file = "/view/template_page.css"%>
    </style>
    <title>Student</title>
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

<main>
    <div class="container">
        <div class="div3">
            div3
        </div>

        <div class="div4">
            div4
        </div>

        <div class="div5">
            div5
        </div>
    </div>
</main>
<footer>

</footer>
</body>
</html>