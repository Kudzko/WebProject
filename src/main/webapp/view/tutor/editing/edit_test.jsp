<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../../cssstyle/template_page.css">
    <title>Tutor</title>
    <style>
        <%@include file="/view/cssstyle/template_page.css"%>
    </style>
</head>
<body>
<header>
    <%@ include file="../../header.jsp" %>
</header>

<main>
    <div class="container">
        <div class="div3">
            div3
        </div>

        <div class="div4">
            <form action="start" method="post">
                <input type="text" id="test_theme" name="test_theme"
                       placeholder="enter theme of test"  value="${test_theme}"
                       required>
                <br>
                <input type="text" id="test_name" name="test_name"
                       placeholder="enter test name"  value="${test_name}" required>

                <div>
                    <button type="submit" name="command"
                            value="update_test">Continue
                    </button>
                </div>
            </form>

        </div>

        <div class="div5">
            div5
        </div>
    </div>
</main>
<footer>
    <p>Kudzko</p>
    <p2>java web trainig 2019</p2>
</footer>
</body>
</html>
