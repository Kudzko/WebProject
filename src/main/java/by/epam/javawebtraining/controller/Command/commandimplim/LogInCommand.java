package by.epam.javawebtraining.controller.Command.commandimplim;

import by.epam.javawebtraining.bean.Role;
import by.epam.javawebtraining.bean.TestTheme;
import by.epam.javawebtraining.configurationclasses.PageAdressManager;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.TestService;
import by.epam.javawebtraining.service.impementations.UserService;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LogInCommand implements Command {
    public static final String GO_TO_STUDENT_MAIN = PageAdressManager
            .getPageAdress("pageadress.student_main");
    public static final String GO_TO_TUTOR_MAIN = PageAdressManager
            .getPageAdress("pageadress.tutor_main");
    public static final String CURRENT_PAGE = PageAdressManager.getPageAdress("pageadress.log_in");
    public static final String DEFAULTERRRORPAGE = PageAdressManager.getPageAdress("pageadress.defaulterrrorpage");

    @Override
    public String execute(HttpServletRequest request) {
        String targetPage;
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        UserService userService = (UserService) ServiceFactory.getService(ServiceType.USER_SERVICE);

        if (userService.logIn(login, pass)) {
            switch (userService.getRole(login)) {
                case TUTOR:
                    targetPage = GO_TO_TUTOR_MAIN;

                    TestService testService = (TestService) ServiceFactory.getService
                            (ServiceType.TEST_SERVICE);
                    List<TestTheme> themes = testService.getTestThemes();
                    request.setAttribute("testThemeList", themes);
                    break;
                case STUDENT:
                    targetPage = GO_TO_STUDENT_MAIN;
                    break;
                default:
                    targetPage = DEFAULTERRRORPAGE;
                    break;
            }

        } else {
            request.setAttribute("errorLoginOrPassword", "Error login or password!");
            targetPage = CURRENT_PAGE;
        }


        return targetPage;
    }
}
