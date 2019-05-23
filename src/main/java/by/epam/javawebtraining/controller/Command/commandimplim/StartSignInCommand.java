package by.epam.javawebtraining.controller.Command.commandimplim;

import by.epam.javawebtraining.configurationclasses.PageAdressManager;
import by.epam.javawebtraining.controller.Command.Command;

import javax.servlet.http.HttpServletRequest;

public class StartSignInCommand implements Command {

    public static final String GO_TO_SIGN_IN_PAGE = PageAdressManager
            .getPageAdress("pageadress.sign_in");


    @Override
    public String execute(HttpServletRequest request) {


        return GO_TO_SIGN_IN_PAGE;
    }
}
