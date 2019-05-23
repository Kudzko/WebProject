<%@ page import="java.util.List" %>
<%@ page import="by.epam.javawebtraining.bean.TestTheme" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="goods" class="by.epam.javawebtraining.bean.GoodsBean"
             scope="page"/>

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
            div3
        </div>

        <div class="div4">
             <form action="start" method="post" >
             <p class="role">Theme</p>
             <div class="select">
                 <select name="test_theme" id="" onchange="submit()">
                     <option value="theme" selected>choose theme</option>
                     <c:forEach items="${testThemeList}" var="option">
                         <option value="${option.id}" >${option.theme}</option>
                     </c:forEach>
                 </select>

             </div>
                 <input type="hidden" name="command" value="choose_test_theme">
             </form>


            <p>Test names:</p>
            <c:forEach var="item" items="${testList}">
                <form action="start" method="post">
                    Test name:  <c:out value="${item.testName}"/>
                    <div>
                        <button type="submit" name="command"
                                value="edit_test">Edit test
                        </button>
                    </div>
                    <div>
                        <button type="submit" name="command"
                                value="delete_test">Delete test
                        </button>
                    </div>
                    <div>
                        <button type="submit" name="command"
                                value="see_test_results">See test results
                        </button>
                    </div>
                </form>

                <br>
            </c:forEach>

            <div>
                <button type="submit" name="command"
                        value="create_test">Create test
                </button>
            </div>
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
