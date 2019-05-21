package by.epam.javawebtraining.controller.Command.commandimplim;

import by.epam.javawebtraining.bean.Role;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.UserService;


import javax.servlet.http.HttpServletRequest;

public class LogInCommand implements Command {
    public static final String GO_TO_STUDENT_MAIN = "/view/studentmain.jsp";
    public static final String GO_TO_TUTOR_MAIN = "/view/tutormain.jsp";
    public static final String CURRENT_PAGE = "/view/start_page.jsp";
    public static final String DEFAULTERRRORPAGE = "/view/defaulterrrorpage.jsp";

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
