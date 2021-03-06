<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../cssstyle/template_page.css">
    <title>Tutor</title>
    <style>
        <%@include file="/view/cssstyle/template_page.css"%>
    </style>
</head>
<body>
<header>
    <%@ include file="../header.jsp" %>
</header>

<main>
    <div class="container">
        <div class="div3">
            div3
        </div>

        <div class="div4">
            <form action="start" method="post">
                <p class="role">Theme</p>

                <div class="select">
                    <select name="test_theme" id="" onchange="submit()">
                        <option value="theme" selected>choose theme</option>
                        <c:forEach items="${testThemeList}" var="option">
                            <option value="${option.id}">${option.theme}</option>
                        </c:forEach>
                    </select>
                </div>

                <input type="hidden" name="command" value="choose_test_theme">

            </form>


            <p>Test names:</p>
            <c:if test="${testList.isEmpty()}">
                <c:out value="There is no tests on this theme."/>
            </c:if>
            <c:forEach var="item" items="${testList}">
                <form action="start" method="post">
                    <div class="box">
                        <a href="start?test_id=${item.id}&command=look_through_test">
                            Test name: <c:out value="${item.testName}"/></a>
                        <c:set var="currentTest" value="${item}"
                               scope="session"/>

                        <div>
                            <button type="submit" name="command"
                                    value="edit_test">Edit
                            </button>
                        </div>
                        <div>
                            <button type="submit" name="command"
                                    value="delete_test">Delete
                            </button>
                        </div>
                        <div>
                            <button type="submit" name="command"
                                    value="see_test_results">See results
                            </button>
                        </div>
                    </div>
                </form>

                <br>
            </c:forEach>


            <form action="start" method="get">
                <div>
                    <button type="submit" name="command"
                            value="go_to_create_test_page">Create test
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
