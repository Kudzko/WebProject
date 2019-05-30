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

            Theme:

            <c:out value="${sessionScope.currentTest.testTheme}"/>
            <br>
            <br>
            Test name:<c:out value="${sessionScope.currentTest.testName}"/>

            <p>List of Questions</p>
            <c:if test="${questionlist.isEmpty() || questionlist == null}">
                <c:out value="There is no questions in this test."/>
            </c:if>
            <c:forEach var="item" items="${questionlist}">
                <c:out value="${item.questionText}"
                       default="Empty Test or Something wrong"/>
                <br>
            </c:forEach>


            <form action="start" method="post">
                <input type="hidden" name="newtest_id"
                       value="${sessionScope.get("currentTest").id}">
                <div>
                    <button type="submit" name="command"
                            value="add_question">Add question
                    </button>
                </div>

                <div>
                    <button type="submit" name="command"
                            value="back_to_tests">Finish creating of test
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
