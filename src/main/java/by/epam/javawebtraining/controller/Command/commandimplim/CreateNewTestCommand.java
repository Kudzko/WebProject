package by.epam.javawebtraining.controller.Command.commandimplim;

import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.bean.User;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.TestService;
import by.epam.javawebtraining.utils.PageAdressManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CreateNewTestCommand implements Command {
    public static final String ADD_QUESTION_PAGE = PageAdressManager
            .getPageAdress("pageadress.new_test_add_question");
    public static final String CURRENT_PAGE = PageAdressManager.getPageAdress
            ("pageadress.tutor_main");
    public static final String DEFAULTERRRORPAGE = PageAdressManager.getPageAdress("pageadress.defaulterrrorpage");

    @Override
    public String execute(HttpServletRequest request) {
        String testTheme = request.getParameter("test_theme");
        String testName = request.getParameter("test_name");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        TestService testService = (TestService) ServiceFactory.getService(ServiceType.TEST_SERVICE);
        Test test = testService.createTest(testTheme, testName, user);

        session.setAttribute("currentTest",test);

        return ADD_QUESTION_PAGE;
    }
}
