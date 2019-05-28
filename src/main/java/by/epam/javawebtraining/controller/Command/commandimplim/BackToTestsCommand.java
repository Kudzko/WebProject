package by.epam.javawebtraining.controller.Command.commandimplim;

import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.bean.TestTheme;
import by.epam.javawebtraining.utils.PageAdressManager;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BackToTestsCommand  implements Command {
    public static final String GO_TO_TUTOR_MAIN = PageAdressManager
            .getPageAdress("pageadress.tutor_main");
    public static final String DEFAULTERRRORPAGE = PageAdressManager.getPageAdress("pageadress.defaulterrrorpage");



    @Override
    public String execute(HttpServletRequest request) {
        TestService testService = (TestService) ServiceFactory.getService
                (ServiceType.TEST_SERVICE);
        List<TestTheme> themes = testService.getTestThemes();
        request.setAttribute("testThemeList", themes);

        HttpSession session = request.getSession();
        session.removeAttribute("currentTest");
        return GO_TO_TUTOR_MAIN;
    }
}
