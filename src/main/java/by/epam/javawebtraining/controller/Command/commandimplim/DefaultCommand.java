package by.epam.javawebtraining.controller.Command.commandimplim;

import by.epam.javawebtraining.controller.Command.Command;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "DEFAULTERRRORPAGE.jsp";
    }
}
