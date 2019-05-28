<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="template_page.css">
    <title>Tutor</title>
    <style>
        <%@include file="/view/template_page.css"%>
    </style>
</head>
<body>
<header>
    <div class="container">

        <div class="div1">
            <p> Test App</p>
        </div>

        <div class="div2">
            <div>
                <button type="submit" name="command" value="log_out">
                    Log out
                </button>
            </div>

        </div>
    </div>
</header>

<main>
    <div class="container">
        <div class="div3">
            <form action="start" method="post">
                <div>
                    <button type="submit" name="command"
                            value="back_to_tests">Back to tests
                    </button>
                </div>
            </form>
        </div>

        <div class="div4">

            <form action="start" method="post">
                <input type="text" id="question_text" name="question_text"
                       placeholder="enter your question" value=""
                       required>
                <input type="hidden" name="newtest_id" value="${newtest_id}" >
                <br><br>
                <input type="text" id="answers_amount" name="answers_amount"
                       placeholder="enter amount of answers"  value=""
                       pattern="\d"
                       required>

                <div>
                    <button type="submit" name="command"
                            value="create_question">Continue
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
