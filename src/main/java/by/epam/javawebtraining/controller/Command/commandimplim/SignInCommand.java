package by.epam.javawebtraining.controller.Command.commandimplim;

import by.epam.javawebtraining.configurationclasses.PageAdressManager;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.UserService;

import javax.servlet.http.HttpServletRequest;

public class SignInCommand implements Command {
    public static final String GO_TO_STUDENT_MAIN = PageAdressManager
            .getPageAdress("pageadress.student_main");
    public static final String GO_TO_TUTOR_MAIN = PageAdressManager
            .getPageAdress("pageadress.tutor_main");
    public static final String CURRENT_PAGE = PageAdressManager.getPageAdress
            ("pageadress.sign_in");
    public static final String DEFAULTERRRORPAGE = PageAdressManager.getPageAdress("pageadress.defaulterrrorpage");


    @Override
    public String execute(HttpServletRequest request) {

        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        String role = request.getParameter("role");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String targetPage = DEFAULTERRRORPAGE;
        login.trim();
        pass.trim();
        role.trim();
        name.trim();
        surname.trim();

        UserService userService = (UserService) ServiceFactory.getService
                (ServiceType.USER_SERVICE);
        if (userService.signIn(name, surname, role, login, pass)) {
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
            request.setAttribute("loginBooked", "Login allready booked or " +
                    "invalid or name or surname (must contain [0-9_A-Za-z] " +
                    "and have length at least one letter).");
            targetPage = CURRENT_PAGE;
        }

        return targetPage;
    }
}
