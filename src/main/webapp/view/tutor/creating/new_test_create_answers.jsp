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

            <p>Answers:</p>
            ${wrong_number_answers}
            <br>

            <form action="start" method="post">

                <input type="hidden" name="newquestion_id"
                       value="${newquestion_id}">

                <c:forEach var="item" begin="0" end="${answers_amount-1}">

                    <input type="text" name="answer_text"
                           placeholder="enter text of your answer" value=""
                           required>
                    <input type="checkbox" name="right_answer" value="${item}">
                    <br><br>

                </c:forEach>
                <br><br>

                <div>
                    <button type="submit" name="command"
                            value="confirm_answers">Commit answers
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
