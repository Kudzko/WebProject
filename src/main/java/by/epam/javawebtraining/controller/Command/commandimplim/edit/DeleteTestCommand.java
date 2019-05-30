package by.epam.javawebtraining.controller.Command.commandimplim.edit;

import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.bean.TestTheme;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.TestService;
import by.epam.javawebtraining.utils.PageAdressManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class DeleteTestCommand implements Command {
    public static final String CURRENT_PAGE = PageAdressManager
            .getPageAdress("pageadress.tutor_main");
    public static final String DEFAULTERRRORPAGE = PageAdressManager.getPageAdress("pageadress.defaulterrrorpage");


    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Test currentTest = (Test) session.getAttribute("currentTest");
        TestService testService = (TestService) ServiceFactory.getService(ServiceType.TEST_SERVICE);

        testService.deleteTest(currentTest);

        session.removeAttribute("currentTest");

        List<TestTheme> themes = testService.getTestThemes();
        request.setAttribute("testThemeList", themes);

        return CURRENT_PAGE;
    }
}
