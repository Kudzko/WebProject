package by.epam.javawebtraining.controller.Command.commandimplim;

import by.epam.javawebtraining.controller.Command.Command;

import javax.servlet.http.HttpServletRequest;

public class SignInCommand implements Command {

    public static final String GO_TO_SIGN_IN_PAGE = "/view/signIn.jsp";


    @Override
    public String execute(HttpServletRequest request) {


        return GO_TO_SIGN_IN_PAGE;
    }
}
