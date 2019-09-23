<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css"
          href="../../cssstyle/template_page.css">
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


                <c:forEach var="item" items="${answerList}">

                    <input type="text" name="answer_text"
                           placeholder="enter text of your answer"
                           value="${item.getAnswerText()}"
                           required>
                    <input type="checkbox" name="right_answer"
                           value="${item.isRight() ? "": "checked"}">
                    <br><br>

                </c:forEach>
                <input type="hidden" name="question_id"
                       value="${question_id}">
                <br><br>

                <div>
                    <button type="submit" name="command"
                            value="update_answers">confirm changes
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
