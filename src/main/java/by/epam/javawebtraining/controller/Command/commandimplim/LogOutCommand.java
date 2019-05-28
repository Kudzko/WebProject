package by.epam.javawebtraining.controller.Command.commandimplim;

import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.utils.PageAdressManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command {
    public static final String START_PAGE = PageAdressManager
            .getPageAdress("pageadress.log_in");
    public static final String DEFAULTERRRORPAGE = PageAdressManager.getPageAdress("pageadress.defaulterrrorpage");


    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return START_PAGE;
    }
}
