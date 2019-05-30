package by.epam.javawebtraining.controller.Command.commandimplim.edit;

import by.epam.javawebtraining.bean.Question;
import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.QuestionService;
import by.epam.javawebtraining.service.impementations.TestService;
import by.epam.javawebtraining.utils.PageAdressManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UpdateTestCommand implements Command {
    public static final String EDIT_PAGE = PageAdressManager
            .getPageAdress("pageadress.edit_test_question_list");

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String testTheme = request.getParameter("test_theme");
        String testName = request.getParameter("test_name");

        Test currentTest = (Test) session.getAttribute("currentTest");
        currentTest.setTestTheme(testTheme);
        currentTest.setTestName(testName);

        TestService testService = (TestService) ServiceFactory.getService(ServiceType.TEST_SERVICE);
        testService.updateTest(currentTest);

        session.setAttribute("currentTest",currentTest);

        QuestionService questionService = (QuestionService) ServiceFactory.getService(ServiceType
                .QUESTION_SERVICE);
        List<Question> questionList = questionService.getTestQuestionList
                (currentTest.getId());
        session.setAttribute("questionList", questionList);
        request.setAttribute("questionList", questionList);

        return EDIT_PAGE;
    }
}
